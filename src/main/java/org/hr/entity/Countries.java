package org.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRIES")
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COUNTRY_ID")
	private String countryID;
    
    @Column(name="COUNTRY_NAME")
	private String countryName;
    
    @Column(name="REGION_ID")
	private Integer regionID;
    
	public String getCountryID() {
		return countryID;
	}
	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Integer getRegionID() {
		return regionID;
	}
	public void setRegionID(Integer regionID) {
		this.regionID = regionID;
	}
	
}
