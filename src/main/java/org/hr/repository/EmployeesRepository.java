package org.hr.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hr.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeesRepository {
	@Autowired
	private SessionFactory  _sessionFactory;
	
	private Session getSession(){
		return _sessionFactory.getCurrentSession();
	}
	
	public void save(Employees employees){
		getSession().save(employees);
	}
	
	public void delete(Employees employees){
		getSession().delete(employees);
	}
	
	@SuppressWarnings("unchecked")
	public List<Employees> getAll(){
		return getSession().createQuery("from Employees").list();
	}
	
	public Employees getByID(Long employeeID){
		return (Employees) getSession().createQuery("from Employees where employeeID = :employeeID").
				setParameter("employeeID", employeeID).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employees> getByFirstName(String firstName){
		return getSession().createQuery("from Employees where firstName = :firstName").
				setParameter("firstName", firstName).list();
	}
	
	public Employees getByEmail(String email){
		return (Employees) getSession().createQuery("from Employees where email = :email").
				setParameter("email", email).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employees> getByDepartmentID(Long departmentID){
		return getSession().createQuery("from Employees where departmentID = :departmentID").
				setParameter("departmentID", departmentID).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employees> getByManagerID(Long managerID){
		return getSession().createQuery("from Employees where managerID = :managerID").
				setParameter("managerID", managerID).list();
	}
	
}
