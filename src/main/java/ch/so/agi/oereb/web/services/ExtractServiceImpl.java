package ch.so.agi.oereb.web.services;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.jvnet.ogc.gml.v_3_2_1.jts.JTSToGML321GeometryConverter;
import org.jvnet.ogc.gml.v_3_2_1.jts.JTSToGML321PointConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import ch.admin.geo.schemas.v_d.oereb._1_0.extract.GetExtractByIdResponseType;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.CantonCode;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Extract;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.LanguageCode;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.LocalisedText;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Map;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RealEstateDPR;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RealEstateType;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RestrictionOnLandownership;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Theme;
import ch.so.agi.oereb.web.domains.Egrid;
import ch.so.agi.oereb.web.repositories.RealEstateDPRRepository;
import ch.so.agi.oereb.web.repositories.ThemeRepository;
import ch.so.agi.oereb.web.utils.WMSImage;
import ch.so.agi.oereb.web.utils.WebMapService;
import ch.so.agi.oereb.web.utils.WebMapServiceException;
import net.opengis.gml.v_3_2_1.AbstractGeometryType;
import net.opengis.gml.v_3_2_1.GeometryPropertyType;
import net.opengis.gml.v_3_2_1.MultiSurfacePropertyType;
import net.opengis.gml.v_3_2_1.MultiSurfaceType;
import net.opengis.gml.v_3_2_1.PointPropertyType;
import net.opengis.gml.v_3_2_1.PointType;
import net.opengis.gml.v_3_2_1.PolygonType;
import net.opengis.gml.v_3_2_1.SurfacePropertyType;
import net.opengis.gml.v_3_2_1.SurfaceType;


// TODO: Exception handling!!!

@Service 
public class ExtractServiceImpl implements ExtractService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
		
	@Autowired
	private RealEstateDPRRepository realEstateDPRRepository;
	
	@Autowired
	private ThemeRepository themeRepository;
	
	@Autowired
	private Environment env;

	@Override
	public GetExtractByIdResponseType getDummy(String egrid, boolean isReduced) throws DatatypeConfigurationException, WebMapServiceException {		
		ch.admin.geo.schemas.v_d.oereb._1_0.extract.ObjectFactory objectFactoryExtract = 
				new ch.admin.geo.schemas.v_d.oereb._1_0.extract.ObjectFactory();
		
		ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory objectFactoryExtractData =
				new ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory();
		
		net.opengis.gml.v_3_2_1.ObjectFactory objectFactoryGml = new net.opengis.gml.v_3_2_1.ObjectFactory();
		
		GetExtractByIdResponseType extractByIdResponseType = objectFactoryExtract.createGetExtractByIdResponseType();
		
		GeometryFactory geometryFactory = new GeometryFactory();

		JTSToGML321GeometryConverter converter = new JTSToGML321GeometryConverter();

		/* <Extract> */
		Extract extract = objectFactoryExtractData.createExtract();
		
		/* <Extract.RealEstate_DPR> */
		RealEstateDPR realEstateDPR = objectFactoryExtractData.createRealEstateDPR();

		ch.so.agi.oereb.web.domains.RealEstateDPR realEstateDPREntity = realEstateDPRRepository.findOneByEgrid(egrid);
		
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
		Polygon limit = realEstateDPREntity.getGeometry();
		Polygon[] polygons = {limit};
		MultiPolygon multiLimit = geometryFactory.createMultiPolygon(polygons);
		multiLimit.setSRID(2056); // TODO
		MultiSurfaceType limitMultiSurfaceType = (MultiSurfaceType) converter.createGeometryType(multiLimit);
		limitMultiSurfaceType.setId(UUID.randomUUID().toString());
		MultiSurfacePropertyType limitMultiSurfacePropertyType = objectFactoryGml.createMultiSurfacePropertyType();
		limitMultiSurfacePropertyType.setMultiSurface(limitMultiSurfaceType);		
		realEstateDPR.setLimit(limitMultiSurfacePropertyType);
		
		// TODO: This is for testing wms requests and base64Binary stuff.
		// This is the url we can get from the data (Transferstruktur).
		// String wmsUrl = "https://wms.geo.admin.ch/?SERVICE=WMS&REQUEST=GetMap&VERSION=1.1.1&STYLES=default&SRS=EPSG:21781&BBOX=475000,60000,845000,310000&WIDTH=740&HEIGHT=500&FORMAT=image/png&LAYERS=ch.bazl.kataster-belasteter-standorte-zivilflugplaetze.oereb";
		String wmsUrl = env.getProperty("oereb.wms.plan-for-land-register");
		
		if (wmsUrl == null) {
			throw new WebMapServiceException("oereb.wms.plan-for-land-register property not found.");
		}
		
		WebMapService wms = new WebMapService();		
		WMSImage wmsImage = null;
		wmsImage = wms.getImage(wmsUrl, realEstateDPREntity.getGeometry().getEnvelopeInternal());
		
		// Verified base64 string with https://codebeautify.org/base64-to-image-converter -> There is really an image :-)
		Map map = objectFactoryExtractData.createMap();
		map.setImage(wmsImage.getImage());
		
		// Set extent of image.
		// Converters from https://github.com/bjornharrtell/ogc-tools		
		Point minPnt = geometryFactory.createPoint(new Coordinate(wmsImage.getMinX(), wmsImage.getMinY()));
		minPnt.setSRID(2056); // TODO
		PointType minPointType = (PointType) converter.createGeometryType(minPnt);
		minPointType.setId(UUID.randomUUID().toString());
		PointPropertyType minPointPropertyType = objectFactoryGml.createPointPropertyType();
		minPointPropertyType.setPoint(minPointType);
		map.setMinNS95(minPointPropertyType);

		Point maxPnt = geometryFactory.createPoint(new Coordinate(wmsImage.getMaxX(), wmsImage.getMaxY()));
		maxPnt.setSRID(2056); // TODO
		PointType maxPointType = (PointType) converter.createGeometryType(maxPnt);
		maxPointType.setId(UUID.randomUUID().toString());
		PointPropertyType maxPointPropertyType = objectFactoryGml.createPointPropertyType();
		maxPointPropertyType.setPoint(maxPointType);
		map.setMaxNS95(maxPointPropertyType);
		
		realEstateDPR.setPlanForLandRegisterMainPage(map);
		
		/* <Extract.RealEstate_DPR.RestrictionOnLandownership> */
		RestrictionOnLandownership restriction = objectFactoryExtractData.createRestrictionOnLandownership();
		
		
		
		/* </Extract.RealEstate_DPR.RestrictionOnLandownership> */

		
		extract.setRealEstate(realEstateDPR);
		/* </Extract.RealEstate_DPR> */
		
		/* <Extract.CreationDate> */		
		GregorianCalendar cal = new GregorianCalendar();
		DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		XMLGregorianCalendar creationDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		extract.setCreationDate(creationDate);
		/* </Extract.CreationDate> */		

		/*  <Extract.(Not)ConcernedTheme> */
		Polygon geometry = realEstateDPREntity.getGeometry();
		List<ch.so.agi.oereb.web.domains.Theme> themeEntityList = themeRepository.findThemesByGeometry(geometry);
		
		for (Iterator<ch.so.agi.oereb.web.domains.Theme> it = themeEntityList.iterator(); it.hasNext(); ) {
			ch.so.agi.oereb.web.domains.Theme themeObj = it.next();
			boolean concerned = themeObj.isConcerned();
			
			ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Theme theme = objectFactoryExtractData.createTheme();			
			theme.setCode(themeObj.getTheme());
			
			LocalisedText localisedText = objectFactoryExtractData.createLocalisedText();
			localisedText.setLanguage(LanguageCode.fromValue("de")); // TODO
			localisedText.setText(themeObj.getTitle());
			theme.setText(localisedText);

			if (concerned) {
				extract.getConcernedTheme().add(theme);
			} else {
				extract.getNotConcernedTheme().add(theme);
			}
		}
		/* </Extract.(Not)ConcernedTheme> */

		/* <Extract.isReduced> */
		extract.setIsReduced(isReduced);
		/* </Extract.isReduced> */

		extractByIdResponseType.setExtract(extract);
		/* </Extract> */

		return extractByIdResponseType;
	}
}
