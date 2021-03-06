/**
 * @Skilaverkefni2 Nov 6, 2010 Arn�r Barkarson
 *
 * Copyright (c) Arn�r Barkarson
 */
package is.ru.honn.rusquare.data.content;

import java.util.Date;

/**
 * @author Arn�r Barkarson
 *
 * @version 1.0, Nov 6, 2010
 */
public class CheckinDTO extends ContentDTO{
	private int id;
	private String Title;
	private Date checkinDate;
	private String username;
	private int venueId;
	
	
	public CheckinDTO(){
		
	}
	/**
	 * @param id
	 * @param title
	 * @param checkinDate
	 * @param username
	 * @param venueId
	 */
	public CheckinDTO(int id, String title, Date checkinDate, String username,
			int venueId) {
		super();
		this.id = id;
		Title = title;
		this.checkinDate = checkinDate;
		this.username = username;
		this.venueId = venueId;
	}
	public CheckinDTO( String title, Date checkinDate, String username,
			int venueId) {
		super();
		this.id = id;
		Title = title;
		this.checkinDate = checkinDate;
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
		return Title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}
	/**
	 * @return the checkinDate
	 */
	public Date getCheckinDate() {
		return checkinDate;
	}
	/**
	 * @param checkinDate the checkinDate to set
	 */
	public void setDate(Date checkinDate) {
		this.checkinDate = checkinDate;
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
		return "CheckinDTO [id=" + id + ", Title=" + Title + ", checkinDate="
				+ checkinDate + ", username=" + username + ", venueId="
				+ venueId + "]";
	}
}
