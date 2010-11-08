/**
 * @(#)Skil2_honn Nov 7, 2010 Thordur Arnarson
 *
 * Copyright (c) Thordur Arnarson
 */
package is.ru.honn.rusquare.client;

import is.ru.honn.rusquare.service.CheckinService;

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
		//Logger log = Logger.getLogger(this.getClass().getName());
		//log.info("before process");
		
		ApplicationContext appCon = new FileSystemXmlApplicationContext("app.xml");
		CheckinService checkinService = (CheckinService) appCon.getBean("checkinService");
		
		
		
	}
}
