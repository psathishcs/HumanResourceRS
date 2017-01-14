package org.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOBS")
public class Jobs {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="JOB_ID")
	private String jobID;
	
	@Column(name="JOB_TITLE")
	private String jobTitle;
	
	@Column(name="MIN_SALARY")
	private Double minSalary;
	
	@Column(name="MAX_SALARY")
	private Double maxSalary;
	
	
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Double getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}
	public Double getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	
		
}
