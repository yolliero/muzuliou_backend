package bzh.muzuliou.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bzh.muzuliou.entity.Ecme;
import bzh.muzuliou.reprository.EcmeReprository;
import bzh.muzuliou.service.interf.EcmeServiceInterface;

@Service
public class EcmeService implements EcmeServiceInterface {
	
	private static final Logger logger = LogManager.getLogger(EcmeService.class);
	
	@Autowired
	private EcmeReprository ecmeReprository;

	@Override
	public String addEcme(Ecme ecme) {
		
		logger.info("call service addEcme with parametres "+ ecme.toString());
		
		ecmeReprository.save(ecme);
		
		return "{\"Ecme\":\"" + ecme.getInventoryNumbre() + "\"}";
		
	}

}
