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

import ch.so.agi.oereb.web.domains.EgridParcel;
import ch.so.agi.oereb.web.types.GetEGRIDResponseType;
import ch.so.agi.oereb.web.types.ObjectFactory;
import ch.so.agi.oereb.web.repositories.EgridParcelRepository;

@Service
public class EgridServiceImpl implements EgridService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private final static int CRS_LV95 = 2056;  
	private final static int CRS_WGS84 = 4326;  

    @Autowired
    private EgridParcelRepository egridParcelRepository;
    
    @Override
    public GetEGRIDResponseType getEgridByGNSS(double latitude, double longitude) {
		GeometryFactory factory = new GeometryFactory();
		Point p = factory.createPoint(new Coordinate(longitude, latitude));
		p.setSRID(CRS_WGS84);
	
		List<EgridParcel> egridParcelList = egridParcelRepository.findByGNSS(p);
				
		return createGetEGRIDResponseType(egridParcelList);
    }
    
    @Override
    public GetEGRIDResponseType getEgridByXY(double easting, double northing) {
    		GeometryFactory factory = new GeometryFactory();
    		Point p = factory.createPoint(new Coordinate(easting, northing));
    		p.setSRID(CRS_LV95);
    		    		
    		List<EgridParcel> egridParcelList = egridParcelRepository.findByXY(p);
    		    		
    		return createGetEGRIDResponseType(egridParcelList);
    }
    
    @Override
    public GetEGRIDResponseType getEgridByNumberAndIdentDN(String number, String identdn) {
    		List<EgridParcel> egridParcelList = egridParcelRepository.findByNumberAndIdentdn(number, identdn);
    		
    		return createGetEGRIDResponseType(egridParcelList);
    }
    
    private GetEGRIDResponseType createGetEGRIDResponseType(List<EgridParcel> egridParcelList) {
		ObjectFactory objectFactory = new ObjectFactory();
		GetEGRIDResponseType getEGRIDResponseType = objectFactory.createGetEGRIDResponseType();

		for (Iterator<EgridParcel> it = egridParcelList.iterator(); it.hasNext(); ) {
			EgridParcel egridParcel = it.next();
			
	    		JAXBElement<String> egridEl = objectFactory.createGetEGRIDResponseTypeEgrid(egridParcel.getEgrid());
	    		getEGRIDResponseType.getEgridAndNumberAndIdentDN().add(egridEl);
	
	    		JAXBElement<String> numberEl = objectFactory.createGetEGRIDResponseTypeNumber(egridParcel.getNumber());
	    		getEGRIDResponseType.getEgridAndNumberAndIdentDN().add(numberEl);
	    		
	    		JAXBElement<String> identdnEl = objectFactory.createGetEGRIDResponseTypeIdentDN(egridParcel.getIdentdn());
	    		getEGRIDResponseType.getEgridAndNumberAndIdentDN().add(identdnEl);
		}
		return getEGRIDResponseType;
    }
    
    // TODO: delete, just a dummy
    @Override
    public GetEGRIDResponseType getEgrids() {		
    		ObjectFactory objectFactory = new ObjectFactory();
    		
    		GetEGRIDResponseType getEGRIDResponseType = objectFactory.createGetEGRIDResponseType();

    		JAXBElement<String> egridEl = objectFactory.createGetEGRIDResponseTypeEgrid("egrid123");
    		getEGRIDResponseType.getEgridAndNumberAndIdentDN().add(egridEl);

    		JAXBElement<String> numberEl = objectFactory.createGetEGRIDResponseTypeNumber("number123");
    		getEGRIDResponseType.getEgridAndNumberAndIdentDN().add(numberEl);
    		
    		JAXBElement<String> identdnEl = objectFactory.createGetEGRIDResponseTypeIdentDN("nbident123");
    		getEGRIDResponseType.getEgridAndNumberAndIdentDN().add(identdnEl);
    		
    		
    		JAXBElement<String> egridEl2 = objectFactory.createGetEGRIDResponseTypeEgrid("2egrid123");
    		getEGRIDResponseType.getEgridAndNumberAndIdentDN().add(egridEl2);

    		JAXBElement<String> numberEl2 = objectFactory.createGetEGRIDResponseTypeNumber("2number123");
    		getEGRIDResponseType.getEgridAndNumberAndIdentDN().add(numberEl2);
    		
    		JAXBElement<String> identdnEl2 = objectFactory.createGetEGRIDResponseTypeIdentDN("2nbident123");
    		getEGRIDResponseType.getEgridAndNumberAndIdentDN().add(identdnEl2);

    		return getEGRIDResponseType;
    }
}
