/**
 * @(#)Skil2_honn Nov 6, 2010 Thordur Arnarson
 *
 * Copyright (c) Thordur Arnarson
 */
package is.ru.honn.rusquare.service;

import is.ru.honn.rusquare.data.content.CheckinDTO;
import is.ru.honn.rusquare.data.content.CheckinGateway;
import is.ru.honn.rusquare.data.content.DataGateway;
import is.ru.honn.rusquare.domain.Checkin;

import java.util.List;

/**
 * @author Thordur Arnarson
 * @version 1.0 Nov 6, 2010
 */
public class CheckinServiceImpl implements CheckinService{
	
	DataGateway dataGateway = new CheckinGateway();
	
	/* (non-Javadoc)
	 * @see is.ru.honn.rusquare.service.CheckinService#checkin(java.lang.String, java.lang.String)
	 */
	@Override
	public Checkin checkin(String username, String venuename) {
		
		return null;
	}
	
	public void add(CheckinDTO checkin){
		dataGateway.add(checkin);
	}
	public List<CheckinDTO> getCheckins(){
		return dataGateway.getContent();
	}

}
