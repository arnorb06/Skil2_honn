/**
 * @Skilaverkefni2 Nov 7, 2010 Arn—r Barkarson
 *
 * Copyright (c) Arn—r Barkarson
 */
package is.ru.honn.rusquare.process;

import is.ru.honn.rusquare.service.VenueServiceImpl;
import is.ruframework.feeds.RuFeedReader;
import is.ruframework.process.RuAbstractProcess;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Arn—r Barkarson
 *
 * @version 1.0, Nov 7, 2010
 */
public class ImportVenues extends RuAbstractProcess {
	
	Logger log = Logger.getLogger(this.getClass().getName());
	VenueServiceImpl venueService;
	RuFeedReader reader;
	
	
	public void beforeProsess(){
		log.info("before prosess");
		ApplicationContext appCtx = new FileSystemXmlApplicationContext("app.xml");
		
		reader =  
		//ApplicationContext venueCtx = new FileSystemXmlApplicationContext("venues.xml");
		
		venueService = (VenueServiceImpl)appCtx.getBean("VenueServiceImpl");
	}
	
	/* (non-Javadoc)
	 * @see is.ruframework.process.RuAbstractProcess#startProcess()
	 */
	@Override
	public void startProcess() {
		log.info("start prosess");
	}
	
	public void afterProsess(){
		log.info("after process");
	}

}
