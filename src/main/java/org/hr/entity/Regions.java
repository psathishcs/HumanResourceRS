package org.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGIONS")
public class Regions {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REGION_ID")
	private Integer regionID;
	
	@Column(name="REGION_NAME")
	private String regionName;
	
	public Integer getRegionID() {
		return regionID;
	}
	public void setRegionID(Integer regionID) {
		this.regionID = regionID;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
