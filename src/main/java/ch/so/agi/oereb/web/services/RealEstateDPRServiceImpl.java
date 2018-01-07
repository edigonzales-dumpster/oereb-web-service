package ch.so.agi.oereb.web.services;

import java.util.List;
import java.util.UUID;

import org.jvnet.ogc.gml.v_3_2_1.jts.JTSToGML321GeometryConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.CantonCode;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Map;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RealEstateDPR;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RealEstateType;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RestrictionOnLandownership;
import ch.so.agi.oereb.web.domains.RealEstateDPREntity;
import ch.so.agi.oereb.web.repositories.RealEstateDPREntityRepository;
import ch.so.agi.oereb.web.utils.WMSImage;
import ch.so.agi.oereb.web.utils.WMSServiceImpl;
import ch.so.agi.oereb.web.utils.WMSServiceException;
import net.opengis.gml.v_3_2_1.MultiSurfacePropertyType;
import net.opengis.gml.v_3_2_1.MultiSurfaceType;
import net.opengis.gml.v_3_2_1.PointPropertyType;
import net.opengis.gml.v_3_2_1.PointType;

@Service
public class RealEstateDPRServiceImpl implements RealEstateDPRService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment env;

	@Autowired
	private RealEstateDPREntityRepository realEstateDPREntityRepository;

	@Autowired
	private WMSServiceImpl wmsService;
	
	@Autowired
	private RestrictionOnLandownershipService restrictionService;

	@Override
	public RealEstateDPR getRealEstateDPRByEgrid(String egrid, boolean withGeometry) throws WMSServiceException {		
		ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory objectFactoryExtractData =
				new ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory();
		
		net.opengis.gml.v_3_2_1.ObjectFactory objectFactoryGml = new net.opengis.gml.v_3_2_1.ObjectFactory();
				
		GeometryFactory geometryFactory = new GeometryFactory();

		JTSToGML321GeometryConverter converter = new JTSToGML321GeometryConverter();

		RealEstateDPREntity realEstateDPREntity = realEstateDPREntityRepository.getRealEstateDPREntityByEgrid(egrid);

		RealEstateDPR realEstateDPR = objectFactoryExtractData.createRealEstateDPR();
		realEstateDPR.setNumber(realEstateDPREntity.getNumber());
		realEstateDPR.setIdentDN(realEstateDPREntity.getIdentdn());
		realEstateDPR.setEGRID(realEstateDPREntity.getEgrid());
		realEstateDPR.setType(RealEstateType.valueOf(realEstateDPREntity.getType()));
		realEstateDPR.setCanton(CantonCode.valueOf(realEstateDPREntity.getCanton()));
		realEstateDPR.setMunicipality(realEstateDPREntity.getMunicipality());
		realEstateDPR.setFosNr(Integer.valueOf(realEstateDPREntity.getFosnr()));
		realEstateDPR.setMetadataOfGeographicalBaseData(realEstateDPREntity.getMetadataOfGeographicalBasedata());
		realEstateDPR.setLandRegistryArea(realEstateDPREntity.getLandRegistryArea());

		// Not sure about the encoding...
		// http://erouault.blogspot.ch/2014/04/gml-madness.html		
		if (withGeometry) {
			Polygon limit = realEstateDPREntity.getGeometry();
			Polygon[] polygons = {limit};
			MultiPolygon multiLimit = geometryFactory.createMultiPolygon(polygons);
			multiLimit.setSRID(2056); // TODO
			MultiSurfaceType limitMultiSurfaceType = (MultiSurfaceType) converter.createGeometryType(multiLimit);
			limitMultiSurfaceType.setId(UUID.randomUUID().toString());
			MultiSurfacePropertyType limitMultiSurfacePropertyType = objectFactoryGml.createMultiSurfacePropertyType();
			limitMultiSurfacePropertyType.setMultiSurface(limitMultiSurfaceType);		
			
			realEstateDPR.setLimit(limitMultiSurfacePropertyType);
		}

		// TODO: This is for testing wms requests and base64Binary stuff.
		// This is the url we can get from the data (Transferstruktur).
		// String wmsUrl = "https://wms.geo.admin.ch/?SERVICE=WMS&REQUEST=GetMap&VERSION=1.1.1&STYLES=default&SRS=EPSG:21781&BBOX=475000,60000,845000,310000&WIDTH=740&HEIGHT=500&FORMAT=image/png&LAYERS=ch.bazl.kataster-belasteter-standorte-zivilflugplaetze.oereb";
		String wmsUrl = env.getProperty("oereb.wms.plan-for-land-register");
		
		if (wmsUrl == null) {
			throw new WMSServiceException("oereb.wms.plan-for-land-register property not found.");
		}
		
		WMSImage wmsImage = null;
		wmsImage = wmsService.getImage(wmsUrl, realEstateDPREntity.getGeometry().getEnvelopeInternal());
		
		/* <PlanForLandRegisterMainPage> */
		// Verified base64 string with https://codebeautify.org/base64-to-image-converter -> There is really an image :-)
		Map map = objectFactoryExtractData.createMap();
		map.setImage(wmsImage.getImage());
		
		// Set extent of image.
		// Converters from https://github.com/bjornharrtell/ogc-tools	
		if (withGeometry) {
			Point minPnt = geometryFactory.createPoint(new Coordinate(wmsImage.getEnvelope().getMinX(), wmsImage.getEnvelope().getMinY()));
			minPnt.setSRID(2056); // TODO
			PointType minPointType = (PointType) converter.createGeometryType(minPnt);
			minPointType.setId(UUID.randomUUID().toString());
			PointPropertyType minPointPropertyType = objectFactoryGml.createPointPropertyType();
			minPointPropertyType.setPoint(minPointType);
			map.setMinNS95(minPointPropertyType);

			Point maxPnt = geometryFactory.createPoint(new Coordinate(wmsImage.getEnvelope().getMaxX(), wmsImage.getEnvelope().getMaxY()));
			maxPnt.setSRID(2056); // TODO
			PointType maxPointType = (PointType) converter.createGeometryType(maxPnt);
			maxPointType.setId(UUID.randomUUID().toString());
			PointPropertyType maxPointPropertyType = objectFactoryGml.createPointPropertyType();
			maxPointPropertyType.setPoint(maxPointType);
			map.setMaxNS95(maxPointPropertyType);
			
			realEstateDPR.setPlanForLandRegisterMainPage(map);		
		}
		/* </PlanForLandRegisterMainPage> */

		
		/* <RestrictionOnLandownership> */
		List<RestrictionOnLandownership> restrictionOnLandownershipList = restrictionService.getAreaRestrictionsByRealEstateDPREntity(realEstateDPREntity, withGeometry);
		for (RestrictionOnLandownership restriction : restrictionOnLandownershipList) {
			realEstateDPR.getRestrictionOnLandownership().add(restriction);			
		}	
		/* </RestrictionOnLandownership> */

		return realEstateDPR;
	}
}
