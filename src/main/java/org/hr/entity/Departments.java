package org.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
public class Departments{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEPARTMENT_ID")
	private Integer departmentID;
	
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name="MANAGER_ID")
	private Integer managerID;
	
	@Column(name="LOCATION_ID")
	private Integer locationID;
	
	public Integer getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Integer getManagerID() {
		return managerID;
	}
	public void setManagerID(Integer managerID) {
		this.managerID = managerID;
	}
	public Integer getLocationID() {
		return locationID;
	}
	public void setLocationID(Integer locationID) {
		this.locationID = locationID;
	}
}
