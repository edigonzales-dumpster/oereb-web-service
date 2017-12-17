package ch.so.agi.oereb.web.services;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import ch.admin.geo.schemas.v_d.oereb._1_0.extract.GetExtractByIdResponseType;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.CantonCode;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Extract;
import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RealEstateDPR;

// TODO: Exception handling!!!

@Service 
public class ExtractServiceImpl implements ExtractService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Environment env;

	@Override
	public GetExtractByIdResponseType getDummy(String egrid) throws DatatypeConfigurationException {
		ch.admin.geo.schemas.v_d.oereb._1_0.extract.ObjectFactory objectFactoryExtract = 
				new ch.admin.geo.schemas.v_d.oereb._1_0.extract.ObjectFactory();
		
		ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory objectFactoryExtractData =
				new ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.ObjectFactory();
		
		GetExtractByIdResponseType extractByIdResponseType = objectFactoryExtract.createGetExtractByIdResponseType();
		
		Extract extract = objectFactoryExtractData.createExtract();
		
		// Extract.CreationDate
		GregorianCalendar cal = new GregorianCalendar();
		DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		XMLGregorianCalendar creationDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		extract.setCreationDate(creationDate);
		log.info("CreationDate: " + creationDate);
		
		// Extract.RealEstate_DPR
		RealEstateDPR realEstateDPR = objectFactoryExtractData.createRealEstateDPR();

		// TODO: wie hole ich das aus den Daten? Steht das irgendwo?
		// Oder in der Abfrage-Query hardcodieren, da die Query ja 
		// sowieso eine Abstraktionsschicht bilden darf/muss/soll/kann (?).
		String cantonCode = "SO";
		if (env.containsProperty("oereb.canton")) {
			cantonCode = env.getProperty("oereb.canton");
		}
		
		realEstateDPR.setCanton(CantonCode.fromValue(cantonCode));
		
		extract.setRealEstate(realEstateDPR);
		
		
		
		extractByIdResponseType.setExtract(extract);
		
		return extractByIdResponseType;
	}
}
