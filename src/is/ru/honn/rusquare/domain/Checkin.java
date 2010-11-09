/**
 * @Skilaverkefni2 Nov 5, 2010 Arn—r Barkarson
 *
 * Copyright (c) Arn—r Barkarson
 */
package is.ru.honn.rusquare.domain;

import is.ru.honn.rusquare.data.content.CheckinDTO;
import is.ru.honn.rusquare.data.content.VenueDTO;

import java.util.Date;

/**
 * @author Arn—r Barkarson
 *
 * @version 1.0, Nov 5, 2010
 */
public class Checkin {
	private int id;
	private String title;
	private Date date;
	private String username;
	private int venueId;
	
	
	public Checkin(){
		
	}
	
	
	/**
	 * @param id
	 * @param title
	 * @param date
	 * @param username
	 * @param venueId
	 */
	public Checkin(String title, Date date, String username, int venueId) {
		super();
		this.title = title;
		this.date = date;
		this.username = username;
		this.venueId = venueId;
	}
	
	public Checkin doCheckin(CheckinDTO checkinDTO) {
		this.title = checkinDTO.getTitle();
		
		this.date = checkinDTO.getCheckinDate();
		this.username = checkinDTO.getUsername();
		this.venueId = checkinDTO.getVenueId();
		
		return this; 
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the venueId
	 */
	public int getVenueId() {
		return venueId;
	}
	/**
	 * @param venueId the venueId to set
	 */
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Checkin [id=" + id + ", title=" + title + ", date=" + date
				+ ", username=" + username + ", venueId=" + venueId + "]";
	}
}
