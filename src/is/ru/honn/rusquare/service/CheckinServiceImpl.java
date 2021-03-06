/**
 * @(#)Skil2_honn Nov 6, 2010 Thordur Arnarson
 *
 * Copyright (c) Thordur Arnarson
 */
package is.ru.honn.rusquare.service;

import is.ru.honn.rusquare.data.content.CheckinDTO;
import is.ru.honn.rusquare.data.content.CheckinGateway;
import is.ru.honn.rusquare.data.content.DataGateway;
import is.ru.honn.rusquare.data.content.VenueDTO;
import is.ru.honn.rusquare.domain.Checkin;

import java.util.Date;
import java.util.List;

/**
 * @author Thordur Arnarson
 * @version 1.0 Nov 6, 2010
 */
public class CheckinServiceImpl implements CheckinService{
	
	DataGateway dataGateway = new CheckinGateway();
	VenueServiceImpl venueServiceImpl;
	Checkin checkin;
	
	/* (non-Javadoc)
	 * @see is.ru.honn.rusquare.service.CheckinService#checkin(java.lang.String, java.lang.String)
	 */
	@Override
	public Checkin checkin(String username, String venueName) {
		
		VenueDTO venueDTO = venueServiceImpl.getVenueByName(venueName);
		int venueId = venueDTO.getId(); 
		
		venueDTO.setTotalCheckins(venueDTO.getTotalCheckins() + 1); 
		venueServiceImpl.updateTotalCheckins(venueDTO);
		
		CheckinDTO checkinDTO = new CheckinDTO(venueName, new Date(), username, venueId);
		dataGateway.add(checkinDTO);
		
		checkin = new Checkin();
		
		return checkin.doCheckin(checkinDTO);
	}
	
	public void add(CheckinDTO checkin){
		dataGateway.add(checkin);
	}
	public List<CheckinDTO> getCheckins(){
		return dataGateway.getContent();
	}

	/**
	 * @return the dataGateway
	 */
	public DataGateway getDataGateway() {
		return dataGateway;
	}
	
	/**
	 * @param dataGateway the dataGateway to set
	 */
	public void setDataGateway(DataGateway dataGateway) {
		this.dataGateway = dataGateway;
	}

	/**
	 * @param venueServiceImpl the venueServiceImpl to set
	 */
	public void setVenueServiceImpl(VenueServiceImpl venueServiceImpl) {
		this.venueServiceImpl = venueServiceImpl;
	}
	
	public VenueDTO getVenueById(int id) {
		
		return venueServiceImpl.getContentById(id);
	}
	public List getUsersByVenueId(int id){
		return this.dataGateway.getUsersByVenueId(id);
	}
}
