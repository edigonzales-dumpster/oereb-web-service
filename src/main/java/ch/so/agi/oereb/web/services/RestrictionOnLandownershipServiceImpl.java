package ch.so.agi.oereb.web.services;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
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
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.MultilingualMText;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RestrictionOnLandownership;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Theme;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Geometry;
import ch.so.agi.oereb.web.domains.RestrictionOnLandownershipAreaEntity;
import ch.so.agi.oereb.web.repositories.RestrictionOnLandownershipAreaEntityRepository;
import net.opengis.gml.v_3_2_1.PolygonType;
import net.opengis.gml.v_3_2_1.SurfacePropertyType;

@Service 
public class RestrictionOnLandownershipServiceImpl implements RestrictionOnLandownershipService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ThemeService themeService;
	
	@Autowired
	private RestrictionOnLandownershipAreaEntityRepository restrictionAreaEntityRepository;

	@Override
	public List<RestrictionOnLandownership> getAreaRestrictionsByGeometry(Polygon limit, int landRegistryArea) {

		List<RestrictionOnLandownership> restrictionOnLandownershipList = new ArrayList<RestrictionOnLandownership>();
		
		ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory objectFactoryExtractData = new ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory();
		
		net.opengis.gml.v_3_2_1.ObjectFactory objectFactoryGml = new net.opengis.gml.v_3_2_1.ObjectFactory();

		List<RestrictionOnLandownershipAreaEntity> restrictionAreaEntityList = restrictionAreaEntityRepository.getRestrictionsByGeometry(limit, landRegistryArea);
		restrictionAreaEntityList.forEach((restrictionEntity) -> {
			RestrictionOnLandownership restrictionOnLandownership = objectFactoryExtractData.createRestrictionOnLandownership();
			
			LocalisedMText localisedMText = objectFactoryExtractData.createLocalisedMText();
			localisedMText.setLanguage(LanguageCode.fromValue("de")); // TODO
			localisedMText.setText(restrictionEntity.getInformation());
			MultilingualMText multilingualMText = objectFactoryExtractData.createMultilingualMText();
			multilingualMText.getLocalisedText().add(localisedMText);
			restrictionOnLandownership.setInformation(multilingualMText);
			
			restrictionOnLandownership.setAreaShare(restrictionEntity.getAreaShare());
			
			BigDecimal b = new BigDecimal(restrictionEntity.getPartInPercent(), MathContext.DECIMAL32);
			restrictionOnLandownership.setPartInPercent(b);
			
			Lawstatus lawStatus = objectFactoryExtractData.createLawstatus();
			lawStatus.setCode(LawstatusCode.fromValue(restrictionEntity.getLawStatus()));
			restrictionOnLandownership.setLawstatus(lawStatus);
						
			Theme theme = themeService.getThemeObjectByIliCode(restrictionEntity.getTheme());
			restrictionOnLandownership.setTheme(theme);

			JTSToGML321GeometryConverter converter = new JTSToGML321GeometryConverter();
			Geometry geometry = objectFactoryExtractData.createGeometry();

			Polygon polygon = restrictionEntity.getGeometry();			
			JAXBElement<PolygonType> jaxbPolygonType = (JAXBElement<PolygonType>) converter.createElement(polygon);
			jaxbPolygonType.getValue().setId(UUID.randomUUID().toString());
			
			SurfacePropertyType surfacePropertyType = objectFactoryGml.createSurfacePropertyType();
			surfacePropertyType.setAbstractSurface(jaxbPolygonType);
					
			geometry.setSurface(surfacePropertyType);
			restrictionOnLandownership.getGeometry().add(geometry);
			
			restrictionOnLandownershipList.add(restrictionOnLandownership);
		});
			
		return restrictionOnLandownershipList;
	}
}

