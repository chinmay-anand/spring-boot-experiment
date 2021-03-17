package com.chinmay.springbootexperiment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyLoggingController {
	private Log log = LogFactory.getLog(MyLoggingController.class);
	
	@RequestMapping("/mylog")
	public String log() {
		log.trace("This is a TRACE message.");
		log.debug("This is a DEBUG message.");
		log.info("This is a INFO message.");
		log.warn("This is a WARN message.");
		log.error("This is a ERROR message.");
		return "See the log details at console";
	}
}
