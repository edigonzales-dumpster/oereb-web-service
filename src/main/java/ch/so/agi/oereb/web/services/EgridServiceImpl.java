package ch.so.agi.oereb.web.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import ch.so.agi.oereb.web.domains.EgridEntity;
import ch.so.agi.oereb.web.types.GetEGRIDResponseType;
import ch.so.agi.oereb.web.types.ObjectFactory;
import ch.so.agi.oereb.web.repositories.EgridEntityRepository;

@Service
public class EgridServiceImpl implements EgridService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private final static int SRID_LV95 = 2056;  
	private final static int SRID_WGS84 = 4326;  
        
    @Autowired 
    private EgridEntityRepository egridEntityRepository;
        
    @Override
	public GetEGRIDResponseType getEgridByPostalcodeAndLocalisationAndNumber(String postalcode, String localisation, String number) {
    		List<EgridEntity> egridEntityList;
    	
    		if (number == null) {
        		egridEntityList = egridEntityRepository.getEgridByPostalcodeAndLocalisation(Integer.valueOf(postalcode), localisation);
    		} else {
        		egridEntityList = egridEntityRepository.getEgridByPostalcodeAndLocalisationAndHousingNumber(Integer.valueOf(postalcode), localisation, number);
    		}

    		return createGetEGRIDResponseType(egridEntityList);
    }
    
    @Override
    public GetEGRIDResponseType getEgridByGNSS(double latitude, double longitude) {
		GeometryFactory factory = new GeometryFactory();
		Point p = factory.createPoint(new Coordinate(longitude, latitude));
		p.setSRID(SRID_WGS84);
	
		List<EgridEntity> egridEntityList = egridEntityRepository.findByGNSS(p);
				
		return createGetEGRIDResponseType(egridEntityList);
    }
    
    @Override
    public GetEGRIDResponseType getEgridByXY(double easting, double northing) {
		GeometryFactory factory = new GeometryFactory();
		Point p = factory.createPoint(new Coordinate(easting, northing));
		p.setSRID(SRID_LV95);

    		List<EgridEntity> egridEntityList = egridEntityRepository.findByXY(p);
    		    		
    		return createGetEGRIDResponseType(egridEntityList);
    }
    
    @Override
    public GetEGRIDResponseType getEgridByNumberAndIdentDN(String number, String identdn) {
    		List<EgridEntity> egridEntityList = egridEntityRepository.findByNumberAndIdentdn(number, identdn);
    		
    		return createGetEGRIDResponseType(egridEntityList);
    }
    
    private GetEGRIDResponseType createGetEGRIDResponseType(List<EgridEntity> egridList) {
		ObjectFactory objectFactory = new ObjectFactory();
		GetEGRIDResponseType getEGRIDResponseType = objectFactory.createGetEGRIDResponseType();

		for (Iterator<EgridEntity> it = egridList.iterator(); it.hasNext(); ) {
			EgridEntity egridObj = it.next();
			
	    		JAXBElement<String> egridEl = objectFactory.createGetEGRIDResponseTypeEgrid(egridObj.getEgrid());
	    		getEGRIDResponseType.getEgridAndNumberAndIdentDN().add(egridEl);
	
	    		JAXBElement<String> numberEl = objectFactory.createGetEGRIDResponseTypeNumber(egridObj.getNumber());
	    		getEGRIDResponseType.getEgridAndNumberAndIdentDN().add(numberEl);
	    		
	    		JAXBElement<String> identdnEl = objectFactory.createGetEGRIDResponseTypeIdentDN(egridObj.getIdentdn());
	    		getEGRIDResponseType.getEgridAndNumberAndIdentDN().add(identdnEl);
		}
		return getEGRIDResponseType;
    }
}
