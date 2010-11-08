/**
 * @Skilaverkefni2 Nov 8, 2010 Arn—r Barkarson
 *
 * Copyright (c) Arn—r Barkarson
 */
package is.ru.honn.rusquare.feeds;

import is.ru.honn.rusquare.data.content.VenueDTO;
import is.ruframework.feeds.RuAbstractFeedReader;
import is.ruframework.feeds.RuFeedException;
import is.ruframework.feeds.RuFeedHandler;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * @author Arn—r Barkarson
 *
 * @version 1.0, Nov 8, 2010
 */
public class XMLFeedReader extends RuAbstractFeedReader {
	Logger log =  Logger.getLogger(this.getClass().getName());
	Document doc;
	
	public void setFeedHandler(RuFeedHandler handler) {
		this.handler = handler;
		
	}
	
	public void read(String url) throws RuFeedException {
		log.info("start read");
		SAXBuilder builder = new SAXBuilder(false);
		try {
			 doc = builder.build(url);
		} catch (JDOMException e) {
			log.info(e.getMessage() + "in JDOM build.");
			e.printStackTrace();
		} catch (IOException e) {
			log.info(e.getMessage() + " in IOEX. ");
			e.printStackTrace();
		}
		Element elem = doc.getRootElement();
		VenueDTO dto;
		
		List list = elem.getChildren();
		Iterator it = list.iterator();
		while(it.hasNext()){
			dto = new VenueDTO();
			elem = (Element)it.next();
			dto.setCity(elem.getChildText("city"));
			dto.setCountry(elem.getChildText("country"));
			dto.setName(elem.getChildText("name"));
			dto.setPostalCode(elem.getChildText("postalCode"));
			dto.setStreet(elem.getChildText("street"));
			dto.setVenueType(elem.getChildText("venueType"));
	
			handler.processContent(dto);
		}
		

	}
	

}
