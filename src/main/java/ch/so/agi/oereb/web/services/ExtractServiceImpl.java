package ch.so.agi.oereb.web.services;

import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


import ch.admin.geo.schemas.v_d.oereb._1_0.extract.GetExtractByIdResponseType;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Extract;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RealEstateDPR;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Theme;
import ch.so.agi.oereb.web.utils.WMSServiceException;

// TODO: Exception handling!!!

@Service 
public class ExtractServiceImpl implements ExtractService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
				
	@Autowired
	private RealEstateDPRService realEstateDPRService;
	
	@Autowired
	private ThemeService themeService;

	@Override
	public GetExtractByIdResponseType getDummy(String egrid, boolean isReduced, boolean withGeometry, boolean withImages) throws DatatypeConfigurationException, WMSServiceException {		
		ch.admin.geo.schemas.v_d.oereb._1_0.extract.ObjectFactory objectFactoryExtract = 
				new ch.admin.geo.schemas.v_d.oereb._1_0.extract.ObjectFactory();
		
		ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory objectFactoryExtractData =
				new ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory();
		
		GetExtractByIdResponseType extractByIdResponseType = objectFactoryExtract.createGetExtractByIdResponseType();

		
		/* <Extract> */
		Extract extract = objectFactoryExtractData.createExtract();
		
		/* <Extract.RealEstate_DPR> */
		RealEstateDPR realEstateDPR = realEstateDPRService.getRealEstateDPRByEgrid(egrid, withGeometry);		
		extract.setRealEstate(realEstateDPR);
		/* </Extract.RealEstate_DPR> */
		
		/* <Extract.CreationDate> */		
		GregorianCalendar cal = new GregorianCalendar();
		DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		XMLGregorianCalendar creationDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		extract.setCreationDate(creationDate);
		/* </Extract.CreationDate> */		

		/*  <Extract.(Not)ConcernedTheme> */
		List<Theme> concernedThemeList = themeService.getThemeByEgrid(egrid, true);
		for(Theme theme : concernedThemeList) {
			extract.getConcernedTheme().add(theme);
		}
		
		List<Theme> notConcernedThemeList = themeService.getThemeByEgrid(egrid, false);
		for(Theme theme : notConcernedThemeList) {
			extract.getNotConcernedTheme().add(theme);
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
