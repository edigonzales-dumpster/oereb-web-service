package ch.so.agi.oereb.web.services;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import org.jvnet.ogc.gml.v_3_2_1.jts.JTSToGML321GeometryConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Polygon;

import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.LanguageCode;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Lawstatus;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.LawstatusCode;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.LocalisedMText;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Map;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.MultilingualMText;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RestrictionOnLandownership;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Theme;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Geometry;
import ch.so.agi.oereb.web.domains.RealEstateDPREntity;
import ch.so.agi.oereb.web.domains.RestrictionOnLandownershipAreaEntity;
import ch.so.agi.oereb.web.repositories.RestrictionOnLandownershipAreaEntityRepository;
import ch.so.agi.oereb.web.utils.WMSServiceException;
import net.opengis.gml.v_3_2_1.PolygonType;
import net.opengis.gml.v_3_2_1.SurfacePropertyType;

@Service 
public class RestrictionOnLandownershipServiceImpl implements RestrictionOnLandownershipService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ThemeService themeService;
	
	@Autowired
	private MapService mapService;
	
	@Autowired
	private RestrictionOnLandownershipAreaEntityRepository restrictionAreaEntityRepository;

	@Override
	public List<RestrictionOnLandownership> getAreaRestrictionsByRealEstateDPREntity(RealEstateDPREntity realEstateDPREntity, boolean withGeometry) throws WMSServiceException {

		List<RestrictionOnLandownership> restrictionOnLandownershipList = new ArrayList<RestrictionOnLandownership>();
		
		ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory objectFactoryExtractData = new ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory();
		
		net.opengis.gml.v_3_2_1.ObjectFactory objectFactoryGml = new net.opengis.gml.v_3_2_1.ObjectFactory();
		
		List<RestrictionOnLandownershipAreaEntity> restrictionAreaEntityList = restrictionAreaEntityRepository.getRestrictionOnLandownershipAreaEntityByGeometry(realEstateDPREntity.getGeometry(), realEstateDPREntity.getLandRegistryArea());
		for (RestrictionOnLandownershipAreaEntity restrictionEntity : restrictionAreaEntityList) {
			RestrictionOnLandownership restrictionOnLandownership = objectFactoryExtractData.createRestrictionOnLandownership();
			
			// Information
			LocalisedMText localisedMText = objectFactoryExtractData.createLocalisedMText();
			localisedMText.setLanguage(LanguageCode.fromValue("de")); // TODO
			localisedMText.setText(restrictionEntity.getInformation());
			MultilingualMText multilingualMText = objectFactoryExtractData.createMultilingualMText();
			multilingualMText.getLocalisedText().add(localisedMText);
			restrictionOnLandownership.setInformation(multilingualMText);
			
			// AreaShare
			restrictionOnLandownership.setAreaShare(restrictionEntity.getAreaShare());
			
			// Part in Percent
			BigDecimal b = new BigDecimal(restrictionEntity.getPartInPercent(), MathContext.DECIMAL32);
			restrictionOnLandownership.setPartInPercent(b);
			
		    // Law Status
			Lawstatus lawStatus = objectFactoryExtractData.createLawstatus();
			lawStatus.setCode(LawstatusCode.fromValue(restrictionEntity.getLawStatus()));
			restrictionOnLandownership.setLawstatus(lawStatus);
						
			// Theme
			Theme theme = themeService.getThemeByIliCode(restrictionEntity.getTheme());
			restrictionOnLandownership.setTheme(theme);

			// Geometry
			if (withGeometry) {
				JTSToGML321GeometryConverter converter = new JTSToGML321GeometryConverter();
				Geometry geometry = objectFactoryExtractData.createGeometry();

				Polygon polygon = restrictionEntity.getGeometry();	
				
				// Debugging
//				if (restrictionEntity.getT_id() == 364) {
//					log.info("***********");
//					log.info(polygon.toString());
//				}
								
				JAXBElement<PolygonType> jaxbPolygonType = (JAXBElement<PolygonType>) converter.createElement(polygon);
				jaxbPolygonType.getValue().setId(UUID.randomUUID().toString());
				
				SurfacePropertyType surfacePropertyType = objectFactoryGml.createSurfacePropertyType();
				surfacePropertyType.setAbstractSurface(jaxbPolygonType);
						
				geometry.setSurface(surfacePropertyType);
				restrictionOnLandownership.getGeometry().add(geometry);
			}
			
			// Map
			Map map = mapService.getMapByRestrictionEntityAndRealEstateDPREntity(restrictionEntity, realEstateDPREntity, withGeometry);
			
			
			restrictionOnLandownership.setMap(map);
			
			
			// TODO: Legende für *die* Eigentumsbeschränkung und restliche Legenden.
			// GetMap URL
			// BBox (real estate geometry)
			// -> getMapByRestrictionEntityId(int t_id)
			
			
			/////// Documents...
			//log.info("foreign key: " + String.valueOf(restrictionEntity.getRestriction_t_id()));
			
			// Zuerst alle Vorschriften, anschliessend Gesetze und Hinweise. Kommt aber auch wieder darauf an, WIE es im
			// XML strukturiert sein muss.
			// Btw: woher kennt man den Unterschied zwischen "Hint" und "Law". Attribuiv ja nicht, sondern wie sie
			// verknüpft sind?
			
			// Angedacht: Die Queries suchen mit der rekursiven Methode alles ab:
			// - Verknüpfung via "HinweisVorschrift" auf ein Dokument.
			// - Anschliessend von Dokument auf Dokument via HinweisWeitere.
			// Es können bereits mehrere Einträge in "HinweisVorschrift" für eine Eigentumsbeschränkung vorhanden sein.
			
			
			
			restrictionOnLandownershipList.add(restrictionOnLandownership);
		}

		
			
		return restrictionOnLandownershipList;
	}
}

