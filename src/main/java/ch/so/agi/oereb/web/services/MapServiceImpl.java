package ch.so.agi.oereb.web.services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.jvnet.ogc.gml.v_3_2_1.jts.JTSToGML321GeometryConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.LegendEntry;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Map;
import ch.so.agi.oereb.web.domains.LegendEntryEntity;
import ch.so.agi.oereb.web.domains.RealEstateDPREntity;
import ch.so.agi.oereb.web.domains.RestrictionOnLandownershipEntity;
import ch.so.agi.oereb.web.repositories.LegendEntryEntityRepository;
import ch.so.agi.oereb.web.utils.WMSImage;
import ch.so.agi.oereb.web.utils.WMSService;
import ch.so.agi.oereb.web.utils.WMSServiceException;
import net.opengis.gml.v_3_2_1.PointPropertyType;
import net.opengis.gml.v_3_2_1.PointType;

@Service
public class MapServiceImpl implements MapService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	WMSService wmsService;
	
	@Autowired
	LegendEntryEntityRepository legendEntryEntityRepository;
	
	@Override
	public Map getMapByRestrictionEntityAndRealEstateDPREntity(RestrictionOnLandownershipEntity restrictionEntity, RealEstateDPREntity realEstateDPREntity, boolean withGeometry) throws WMSServiceException {		
		ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory objectFactoryExtractData =
				new ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory();
		
		net.opengis.gml.v_3_2_1.ObjectFactory objectFactoryGml = new net.opengis.gml.v_3_2_1.ObjectFactory();
				
		GeometryFactory geometryFactory = new GeometryFactory();

		JTSToGML321GeometryConverter converter = new JTSToGML321GeometryConverter();

		Map map = objectFactoryExtractData.createMap();

		// 1) create image
		
		log.info(restrictionEntity.getReferenceWMS());
		log.info(realEstateDPREntity.getGeometry().toString());
				
		WMSImage wmsImage = null;
		wmsImage = wmsService.getImage(restrictionEntity.getReferenceWMS(), realEstateDPREntity.getGeometry().getEnvelopeInternal());
		map.setImage(wmsImage.getImage());
		
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
		}

		// 2) create Legend (needs 
		List<LegendEntryEntity> legendEntryEntityList = legendEntryEntityRepository.getLegendEntryEntityByRestrictionEntityId(restrictionEntity.getT_id(), "de");
		for(LegendEntryEntity legendEntryEntity : legendEntryEntityList) {
			LegendEntry legendEntry = objectFactoryExtractData.createLegendEntry();
			
			legendEntry.setTypeCode(legendEntryEntity.getTypeCode());
			legendEntry.setSymbol(legendEntryEntity.getSymbol());
			
			// Debugging
//			try {
//				InputStream in = new ByteArrayInputStream(legendEntryEntity.getSymbol());
//				BufferedImage bImageFromConvert = ImageIO.read(in);
//
//				Path tmpDirectory = Files.createTempDirectory(Paths.get(System.getProperty("java.io.tmpdir")), "oereb");
//				Path outputfilePath = Paths.get(tmpDirectory.toString(), "image.png");
//
//				ImageIO.write(bImageFromConvert, "png", outputfilePath.toFile());
//				log.info(outputfilePath.toString());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}

			map.getOtherLegend().add(legendEntry);
		}
			
		return map;
	}
}
