/**
 * @Skilaverkefni2 Nov 6, 2010 Arn—r Barkarson
 *
 * Copyright (c) Arn—r Barkarson
 */
package is.ru.honn.rusquare.data.content;

/**
 * @author Arn—r Barkarson
 *
 * @version 1.0, Nov 6, 2010
 */
public class VenueDTO extends ContentDTO{
	private int id;
	private String name;
	private String street;
	private String city;
	private String country;
	private String postalCode;
	private String venueType;
	private int totalCheckins;
	
	public VenueDTO(){
		
	}
	/**
	 * @param id
	 * @param name
	 * @param street
	 * @param city
	 * @param country
	 * @param postalCode
	 * @param venueType
	 * @param totalCheckins
	 */
	public VenueDTO(int id, String name, String street, String city,
			String country, String postalCode, String venueType,
			int totalCheckins) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
		this.venueType = venueType;
		this.totalCheckins = totalCheckins;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * @return the venueType
	 */
	public String getVenueType() {
		return venueType;
	}
	/**
	 * @param venueType the venueType to set
	 */
	public void setVenueType(String venueType) {
		this.venueType = venueType;
	}
	/**
	 * @return the totalCheckins
	 */
	public int getTotalCheckins() {
		return totalCheckins;
	}
	/**
	 * @param totalCheckins the totalCheckins to set
	 */
	public void setTotalCheckins(int totalCheckins) {
		this.totalCheckins = totalCheckins;
	}
}
