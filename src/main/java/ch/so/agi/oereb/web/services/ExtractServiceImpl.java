package ch.so.agi.oereb.web.services;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Polygon;

import ch.admin.geo.schemas.v_d.oereb._1_0.extract.GetExtractByIdResponseType;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.CantonCode;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Extract;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.LanguageCode;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.LocalisedText;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RealEstateDPR;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RealEstateType;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Theme;
import ch.so.agi.oereb.web.domains.Egrid;
import ch.so.agi.oereb.web.repositories.RealEstateDPRRepository;
import ch.so.agi.oereb.web.repositories.ThemeRepository;

// TODO: Exception handling!!!

@Service 
public class ExtractServiceImpl implements ExtractService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
		
	@Autowired
	private RealEstateDPRRepository realEstateDPRRepository;
	
	@Autowired
	private ThemeRepository themeRepository;

	@Override
	public GetExtractByIdResponseType getDummy(String egrid, boolean isReduced) throws DatatypeConfigurationException {
		ch.admin.geo.schemas.v_d.oereb._1_0.extract.ObjectFactory objectFactoryExtract = 
				new ch.admin.geo.schemas.v_d.oereb._1_0.extract.ObjectFactory();
		
		ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory objectFactoryExtractData =
				new ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory();
		
		GetExtractByIdResponseType extractByIdResponseType = objectFactoryExtract.createGetExtractByIdResponseType();
		
		/*
		 * <Extract> 
		 */
		Extract extract = objectFactoryExtractData.createExtract();
		
		/*
		 * <Extract.RealEstate_DPR>
		 */
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
		//realEstateDPR.setLimit(value);
		
		extract.setRealEstate(realEstateDPR);

		// TODO: use ObjectFactory
		/*
		 * <Extract.CreationDate>
		 */
		GregorianCalendar cal = new GregorianCalendar();
		DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		XMLGregorianCalendar creationDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		extract.setCreationDate(creationDate);
		log.info("CreationDate: " + creationDate);
		
		/* 
		 * <Extract.(Not)ConcerncedTheme>
		 */
		Polygon geometry = realEstateDPREntity.getGeometry();
		List<ch.so.agi.oereb.web.domains.Theme> themeEntityList = themeRepository.findThemesByGeometry(geometry);
		
		for (Iterator<ch.so.agi.oereb.web.domains.Theme> it = themeEntityList.iterator(); it.hasNext(); ) {
			ch.so.agi.oereb.web.domains.Theme themeObj = it.next();
			boolean concerned = themeObj.isConcerned();
			
			ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Theme theme = objectFactoryExtractData.createTheme();
			LocalisedText localisedText = objectFactoryExtractData.createLocalisedText();
			
			theme.setCode(themeObj.getTheme());
			
			// TODO: woher stammt das?
			localisedText.setLanguage(LanguageCode.fromValue("de"));
			localisedText.setText("Woher nehmen, wenn nicht stehlen?");
			theme.setText(localisedText);

			if (concerned) {
				extract.getConcernedTheme().add(theme);
			} else {
				extract.getNotConcernedTheme().add(theme);
			}
		}
		
		/* 
		 * <Extract.isReduced>
		 */
		extract.setIsReduced(isReduced);
		
		
		
		
		extractByIdResponseType.setExtract(extract);
		
		return extractByIdResponseType;
	}
}
