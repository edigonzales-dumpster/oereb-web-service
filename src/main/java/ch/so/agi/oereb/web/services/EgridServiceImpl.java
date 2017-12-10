package ch.so.agi.oereb.web.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.so.agi.oereb.web.domains.Egrid;
import ch.so.agi.oereb.web.repositories.EgridRepository;

@Service
public class EgridServiceImpl implements EgridService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EgridRepository egridRepository;

	@Override
	public List<Egrid> getEgridByXY() {

		List<Egrid> egridList = egridRepository.findByEgrid("CH870672603279");
		
		log.info(egridList.get(0).getNumber());
		log.info(egridList.get(0).getIdentnd());
		
		return egridList;
	}

}
