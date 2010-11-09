/**
 * @Skilaverkefni2 Nov 6, 2010 Arn—r Barkarson
 *
 * Copyright (c) Arn—r Barkarson
 */
package is.ru.honn.rusquare.test;

import is.ru.honn.rusquare.data.content.CheckinDTO;
import is.ru.honn.rusquare.data.content.CheckinGateway;
import is.ru.honn.rusquare.data.content.DataGateway;
import is.ru.honn.rusquare.data.content.VenueDTO;
import is.ru.honn.rusquare.data.content.VenueGateway;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.factory.RuException;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Arn—r Barkarson
 *
 * @version 1.0, Nov 6, 2010
 */
public class test_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Logger log = Logger.getLogger("Test"); 
		RuDataAccessFactory factory = null;
		
		try {
			factory = RuDataAccessFactory.getInstance("data.xml");
		} catch (RuException e) {
			log.severe("Unable to load data specification in data.xml" + e.getMessage());
		}
		
		DataGateway checkinDataGateway = (CheckinGateway)factory.getDataAccess("checkinDataAccsess");
		
		//check for .add() into chenkin table
		checkinDataGateway.add(new CheckinDTO("title!", new Date(), "name", 1));
		
		//test for .getContent() from checkin table
		List clist = checkinDataGateway.getContent();
		for (Object cDTO: clist)
			System.out.println(cDTO);	
		
		DataGateway venueDataGateway = (VenueGateway)factory.getDataAccess("venueDataAccsess");
		
		//test for .add() into venues table
		venueDataGateway.add(new VenueDTO(1, "nafn", "gata", "borg", "land", "101!", "BAR", 1));
		
		//test for .getContent() from venues table
		List vlist = venueDataGateway.getContent();
		for(Object o: vlist)
			System.out.println(o);
		
		//test for .getContentByName() from venues table
		VenueDTO vDTO = (VenueDTO) venueDataGateway.getContentByName("nafn");
		System.out.println("Test: venueDTO.getContentByName " + vDTO);
	}

}
