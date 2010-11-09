/**
 * @(#)Skil2_honn Nov 7, 2010 Thordur Arnarson
 *
 * Copyright (c) Thordur Arnarson
 */
package is.ru.honn.rusquare.client;

import is.ru.honn.rusquare.data.content.CheckinGateway;
import is.ru.honn.rusquare.data.content.DataGateway;
import is.ru.honn.rusquare.data.content.VenueGateway;
import is.ru.honn.rusquare.service.CheckinServiceImpl;
import is.ru.honn.rusquare.service.VenueServiceImpl;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.factory.RuException;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Thordur Arnarson
 * @version 1.0 Nov 7, 2010
 */
public class RuSqureClient {
	
	//TODO change function name
	public static void main(String args[]) {
		Logger log = Logger.getLogger("RuSquareClient");
		log.info("in main");

		RuDataAccessFactory factory = null;
		try {
			factory = RuDataAccessFactory.getInstance("data.xml");
		} catch (RuException e) {
			log.severe("Unable to load data specification in data.xml" + e.getMessage());
		}
		
		DataGateway checkinDataGateway = (CheckinGateway)factory.getDataAccess("checkinDataAccsess");
		DataGateway venueDataGateway = (VenueGateway)factory.getDataAccess("venueDataAccsess");
		
		ApplicationContext appCon = new FileSystemXmlApplicationContext("app.xml");
		CheckinServiceImpl checkinServiceImpl = (CheckinServiceImpl) appCon.getBean("checkinServiceImpl");
		VenueServiceImpl venueServiceImpl = (VenueServiceImpl) appCon.getBean("venueServiceImpl");
		
		checkinServiceImpl.setDataGateway(checkinDataGateway);
		venueServiceImpl.setDatagateway(venueDataGateway);
		checkinServiceImpl.setVenueServiceImpl(venueServiceImpl);
		
		checkinServiceImpl.checkin(args[0], args[1]);
		
		System.out.println("You have logged into: ");
	}
}
