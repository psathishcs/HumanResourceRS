package org.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOCATIONS")
public class Locations {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOCATION_ID")
	private Integer locationID;
	
	@Column(name="STREET_ADDRESS")
	private String streetAddress;
	
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE_PROVINCE")
	private String stateProvince;
	
	@Column(name="COUNTRY_ID")
	private String countryID;
	
	public Integer getLocationID() {
		return locationID;
	}
	public void setLocationID(Integer locationID) {
		this.locationID = locationID;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	public String getCountryID() {
		return countryID;
	}
	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}
	
	
}
