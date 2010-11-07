/**
 * @(#)Skil2_honn Nov 7, 2010 Thordur Arnarson
 *
 * Copyright (c) Thordur Arnarson
 */
package is.ru.honn.rusquare.service;

import java.util.Collection;

import is.ru.honn.rusquare.data.content.DataGateway;
import is.ru.honn.rusquare.data.content.VenueDTO;
import is.ru.honn.rusquare.data.content.VenueGateway;

/**
 * @author Thordur Arnarson
 * @version 1.0 Nov 7, 2010
 */
public class VenueServiceImpl implements VenueService{
	DataGateway datagateway = new VenueGateway();

	/* (non-Javadoc)
	 * @see is.ru.honn.rusquare.service.VenueService#addNewVenue(is.ru.honn.rusquare.data.content.VenueDTO, java.lang.String)
	 */
	@Override
	public void addNewVenue(VenueDTO venue, String username) {
		datagateway.add(venue);
		
	}

	/**
	 * @see is.ru.honn.rusquare.service.VenueService#getVenues()
	 * @return a list of venues
	 */
	@Override
	public Collection getVenues() {
		return datagateway.getContent();

	}

	/**
	 * @see is.ru.honn.rusquare.service.VenueService#getVenue(java.lang.String)
	 * @return an instance of Venue by name 
	 */
	@Override
	public VenueDTO getVenue(String name) {
		return (VenueDTO) datagateway.getContentByName();
	}
	
}
