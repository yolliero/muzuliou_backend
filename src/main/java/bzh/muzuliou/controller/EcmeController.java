package bzh.muzuliou.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bzh.muzuliou.entity.Ecme;
import bzh.muzuliou.service.interf.EcmeServiceInterface;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@CrossOrigin
public class EcmeController {
	
	@Autowired
	private EcmeServiceInterface ecmeService;
	  
	private static final Logger logger = LogManager.getLogger(EcmeController.class);
	
	  @RequestMapping(value = "/addEcme", method = RequestMethod.POST)
	  String createEcme( @Validated @RequestBody Ecme ecme, HttpServletResponse response,
				final BindingResult bindingResult ) throws MethodArgumentNotValidException {
		logger.info("call ws createEcme with parametres "+ ecme.toString() );
		
		
		if (bindingResult.hasErrors()) {

			response.setStatus(400);
			return "{ \"code\" : \"INVALID_REQUEST\" ,\"message\" : \"erreur de BindingResult\"}";

		} else {

			response.setStatus(201);

			return ecmeService.addEcme(ecme);

		}
		  
	  }
	  
	  @ExceptionHandler(MethodArgumentNotValidException.class)
		public @ResponseBody ResponseEntity<String> conflict(MethodArgumentNotValidException ex) {
			logger.debug("Debug :" + ex);
			return new ResponseEntity<>(
					"{ \"code\" : \"INVALID_REQUEST\" ,\"message\" : \"Le JSON expédié n'est pas au bon format"
							+ ex.getMessage().getBytes() + "\"}",
					HttpStatus.BAD_REQUEST);
		} 

}
