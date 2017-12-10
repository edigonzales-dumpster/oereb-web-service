package ch.so.agi.oereb.web.services;

import javax.xml.bind.JAXBContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.so.agi.oereb.web.domains.Egrid;
import ch.so.agi.oereb.web.types.GetEGRIDResponseType;
import ch.so.agi.oereb.web.types.ObjectFactory;
import ch.so.agi.oereb.web.repositories.EgridRepository;

@Service
public class EgridServiceImpl implements EgridService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EgridRepository egridRepository;

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
    
    
    
//    @Override
//    public GetEGRIDResponseListType getEgrids() {
//    	
//    	
//    	GetEGRIDResponseListType egridListType = new GetEGRIDResponseListType();
//    	
//	Egrid myEgrid = new Egrid();
//	myEgrid.setT_id(123L);
//	myEgrid.setEgrid("CH12355");
//	myEgrid.setIdentnd("Fubarxxx");
//	myEgrid.setNumber("654");
//
//	GetEGRIDResponseType egridType = new GetEGRIDResponseType();
//	egridType.setEgrid(myEgrid.getEgrid());
//	egridType.setNumber(myEgrid.getNumber());
//	egridType.setIdentnd(myEgrid.getIdentnd());
//	
//	egridListType.getEgridType().add(egridType);
//	
//	return egridListType;
//
//    	 /*
//        // iterate and set the values and return list
//        for(Player player : lstPlayer) {
//            // add player info
//            PlayerType playerType = new PlayerType();
//            playerType.setPlayerId(player.getPlayerId());
//            playerType.setName(player.getName());
//            playerType.setAge(player.getAge());
//            playerType.setMatches(player.getMatches());
//            playerListType.getPlayerType().add(playerType); // add to playerListType
//        }
//        return playerListType
//        */
//    }

   
    
//	@Override
//	public GetEGRIDResponseType getEgridByXY() {
//
//		//List<Egrid> egridList = egridRepository.findByEgrid("CH870672603279");
//		
//		
//        //Player player = (Player) sessionFactory.getCurrentSession().get(Player.class, playerId);
//        
//		Egrid myEgrid = new Egrid();
//		myEgrid.setT_id(123L);
//		myEgrid.setEgrid("CH12355");
//		myEgrid.setIdentnd("Fubarxxx");
//		myEgrid.setNumber("654");
//
//        // set values and return
//		GetEGRIDResponseType egridType = new GetEGRIDResponseType();
//		egridType.setEgrid(myEgrid.getEgrid());
//		egridType.setNumber(myEgrid.getNumber());
//		egridType.setIdentnd(myEgrid.getIdentnd());
//        
//		return egridType;
//		
//        /*
//        List<Egrid> egridList = new ArrayList<Egrid>();
//		
//		Egrid myEgrid = new Egrid();
//		myEgrid.setT_id(123L);
//		myEgrid.setEgrid("CH12355");
//		myEgrid.setIdentnd("Fubarxxx");
//		myEgrid.setNumber("654");
//		
//		egridList.add(myEgrid);
//		egridList.add(myEgrid);
//
//		log.info(egridList.get(0).getNumber());
//		log.info(egridList.get(0).getIdentnd());
//		
//		return egridList;
//		*/
//	}

}
