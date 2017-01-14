package org.hr.repository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hr.entity.JobHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JobHistoryRepository {
	@Autowired
	private SessionFactory  _sessionFactory;
	
	private Session getSession(){
		return _sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<JobHistory> getAll(){
		return getSession().createQuery("from JobHistory").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<JobHistory> getJobHistoryByEmployeeID(Long employeeID){
		return getSession().createQuery("from JobHistory where jobHistoryPK.employeeID = :employeeID").
				setParameter("employeeID", employeeID) .list();
	}
	
	@SuppressWarnings("unchecked")
	public List<JobHistory> getJobHistoryByDepartmentID(Integer departmentID){
		return getSession().createQuery("from JobHistory where departmentID = :departmentID").
				setParameter("departmentID", departmentID) .list();
	}
	
	@SuppressWarnings("unchecked")
	public List<JobHistory> getJobHistoryByJobID(String jobID){
		return getSession().createQuery("from JobHistory where jobID = :jobID").
				setParameter("jobID", jobID) .list();
	}



}
