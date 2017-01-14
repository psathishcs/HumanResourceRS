package org.hr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JobHistoryPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="EMPLOYEE_ID")
	private Long employeeID;
	
	@Column(name="START_DATE")
	private Date startDate;
	public JobHistoryPK(Long employeeID, Date startDate) {
		this.employeeID = employeeID;
		this.startDate = startDate;
	}
	public JobHistoryPK() {
		// TODO Auto-generated constructor stub
	}
	public Long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
