package org.hr.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hr.entity.JobHistory;
import org.hr.entity.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JobsRepository {
	@Autowired
	private SessionFactory  _sessionFactory;
	
	private Session getSession(){
		return _sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Jobs> getAll(){
		return getSession().createQuery("from Jobs").list();
	}
	
	public Jobs getJobsByID(String jobID){
		return (Jobs) getSession().createQuery("from Jobs where jobID = :jobID ").
				setParameter("jobID", jobID).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Jobs> getJobsWithSalaryGreaterThan(Double minSalary){
		return getSession().createQuery("from Jobs where minSalary <= :minSalary").
				setParameter("minSalary", minSalary).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Jobs> getJobsWithSalaryLessThan(Double maxSalary){
		return getSession().createQuery("from Jobs where maxSalary >= :maxSalary").
				setParameter("maxSalary", maxSalary).list();
	}
	
	
}
