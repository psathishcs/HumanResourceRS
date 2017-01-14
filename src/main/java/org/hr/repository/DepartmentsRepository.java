package org.hr.repository;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hr.entity.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DepartmentsRepository {
	@Autowired
	private SessionFactory _sessionFactory;
	
	private Session getSession(){
		return _sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Departments> getAll(){
		return getSession().createQuery("from Departments").list();
	}
	
	public Departments getByID(Integer departmentID) {
		return (Departments) getSession().createQuery("from Departments where departmentID = :departmentID").
				setParameter("departmentID", departmentID).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Departments> getByLocationID(Integer locationID){
		return getSession().createQuery("from Departments where locationID = :locationID").
				setParameter("locationID", locationID).list();
	}

}
