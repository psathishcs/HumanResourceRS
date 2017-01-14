package org.hr.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="JOB_HISTORY")
public class JobHistory {
	
	@EmbeddedId
	private JobHistoryPK jobHistoryPK;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="JOB_ID")
	private String jobID;
	
	@Column(name="DEPARTMENT_ID")
	private Integer departmentID;
	
	public JobHistoryPK getJobHistoryPK() {
		return jobHistoryPK;
	}
	public void setJobHistoryPK(JobHistoryPK jobHistoryPK) {
		this.jobHistoryPK = jobHistoryPK;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public Integer getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}
	
}
