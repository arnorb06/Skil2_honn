/**
 * @Skilaverkefni2 Nov 5, 2010 Arn—r Barkarson
 *
 * Copyright (c) Arn—r Barkarson
 */
package is.ru.honn.rusquare.domain;

import java.util.Date;

/**
 * @author Arn—r Barkarson
 *
 * @version 1.0, Nov 5, 2010
 */
public class Checkin {
	int id;
	String title;
	Date date;
	String username;
	int venueId;
	/**
	 * @param id
	 * @param title
	 * @param date
	 * @param username
	 * @param venueId
	 */
	public Checkin(int id, String title, Date date, String username, int venueId) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.username = username;
		this.venueId = venueId;
	}
	
	public void doCheckin(String title, Date date, String username, int venueId) {
		this.title = title;
		this.date = date;
		this.username = username;
		this.venueId = venueId;
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
	public void doCheckin(){
		
	}
}
