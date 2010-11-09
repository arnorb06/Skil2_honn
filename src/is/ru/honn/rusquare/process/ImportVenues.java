/**
 * @Skilaverkefni2 Nov 7, 2010 Arn—r Barkarson
 *
 * Copyright (c) Arn—r Barkarson
 */
package is.ru.honn.rusquare.process;

import is.ru.honn.rusquare.data.content.DataGateway;
import is.ru.honn.rusquare.data.content.VenueDTO;
import is.ru.honn.rusquare.data.content.VenueGateway;
import is.ru.honn.rusquare.feeds.XMLFeedReader;
import is.ru.honn.rusquare.service.VenueServiceImpl;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.factory.RuException;
import is.ruframework.feeds.RuFeedException;
import is.ruframework.feeds.RuFeedHandler;
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
public class ImportVenues extends RuAbstractProcess implements RuFeedHandler{
	
	Logger log = Logger.getLogger(this.getClass().getName());
	VenueServiceImpl venueService;
	RuFeedReader reader;
	VenueDTO dto;
	String file;
	RuDataAccessFactory factory;
	DataGateway venueDataGateway;
	
	public void beforeProcess(){
		log.info("before prosess");
		try {
			factory = RuDataAccessFactory.getInstance("data.xml");
		} catch (RuException e) {
			log.severe("Unable to load data specification in data.xml" + e.getMessage());
		}
		
		venueDataGateway = (VenueGateway)factory.getDataAccess("venueDataAccsess");
		ApplicationContext appCtx = new FileSystemXmlApplicationContext("app.xml");
		venueService = (VenueServiceImpl)appCtx.getBean("venueServiceImpl");
		reader = new XMLFeedReader();
		reader.setFeedHandler(this);
		venueService.setDatagateway(venueDataGateway);
		
	}
	
	/* (non-Javadoc)
	 * @see is.ruframework.process.RuAbstractProcess#startProcess()
	 */
	@Override
	public void startProcess(){
		
		log.info("start prosess");
		try {
			reader.read("venues.xml");
		} catch (RuFeedException e) {
			log.info(e.getMessage() + " in startProcess. ");
			e.printStackTrace();
		}
		
	}
	
	public void afterProcess(){
		log.info("after process");
	}

	/* (non-Javadoc)
	 * @see is.ruframework.feeds.RuFeedHandler#processContent(java.lang.Object)
	 */
	@Override
	public void processContent(Object object) {
		
		venueService.addNewVenue((VenueDTO) object, "SomeName");
	}

}
