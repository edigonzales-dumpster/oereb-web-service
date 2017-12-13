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

import ch.so.agi.oereb.web.domains.Egrid;
import ch.so.agi.oereb.web.domains.EgridAddress;
import ch.so.agi.oereb.web.domains.EgridParcel;
import ch.so.agi.oereb.web.types.GetEGRIDResponseType;
import ch.so.agi.oereb.web.types.ObjectFactory;
import ch.so.agi.oereb.web.repositories.EgridAddressRepository;
import ch.so.agi.oereb.web.repositories.EgridParcelRepository;

@Service
public class EgridServiceImpl implements EgridService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private final static int SRID_LV95 = 2056;  
	private final static int SRID_WGS84 = 4326;  

    @Autowired
    private EgridParcelRepository egridParcelRepository;
    
    @Autowired 
    private EgridAddressRepository egridAddressRepository;
    
    @Override
	public GetEGRIDResponseType getEgridByPostalcodeAndLocalisationAndNumber(String postalcode, String localisation, String number) {
    		List<EgridAddress> egridAddressList;
    	
    		if (number == null) {
        		egridAddressList = egridAddressRepository.getEgridByPostalcodeAndLocalisation(Integer.valueOf(postalcode), localisation);
    		} else {
        		egridAddressList = egridAddressRepository.getEgridByPostalcodeAndLocalisationAndHousingNumber(Integer.valueOf(postalcode), localisation, number);
    		}
    		
    		return createGetEGRIDResponseType(egridAddressList);
    }

    
    @Override
    public GetEGRIDResponseType getEgridByGNSS(double latitude, double longitude) {
		GeometryFactory factory = new GeometryFactory();
		Point p = factory.createPoint(new Coordinate(longitude, latitude));
		p.setSRID(SRID_WGS84);
	
		List<EgridParcel> egridParcelList = egridParcelRepository.findByGNSS(p);
				
		return createGetEGRIDResponseType(egridParcelList);
    }
    
    @Override
    public GetEGRIDResponseType getEgridByXY(double easting, double northing) {
    		GeometryFactory factory = new GeometryFactory();
    		Point p = factory.createPoint(new Coordinate(easting, northing));
    		p.setSRID(SRID_LV95);
    		    		
    		List<EgridParcel> egridParcelList = egridParcelRepository.findByXY(p);
    		    		
    		return createGetEGRIDResponseType(egridParcelList);
    }
    
    @Override
    public GetEGRIDResponseType getEgridByNumberAndIdentDN(String number, String identdn) {
    		List<EgridParcel> egridParcelList = egridParcelRepository.findByNumberAndIdentdn(number, identdn);
    		
    		return createGetEGRIDResponseType(egridParcelList);
    }
    
    private GetEGRIDResponseType createGetEGRIDResponseType(List<?> egridList) {
		ObjectFactory objectFactory = new ObjectFactory();
		GetEGRIDResponseType getEGRIDResponseType = objectFactory.createGetEGRIDResponseType();

		for (Iterator it = egridList.iterator(); it.hasNext(); ) {
			Egrid egridObj = (Egrid) it.next();
			
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
