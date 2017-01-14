package org.hr.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hr.entity.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CountriesRepository {
	@Autowired
	private SessionFactory _sessionFactory;
	
	private Session getSession(){
		return _sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Countries> getAll(){
		return getSession().createQuery("from Countries").list();
	}
	
	public Countries getByCountriesByID(String countryID) {
		return (Countries) getSession().createQuery("from Countries where countryID = :countryID").
				setParameter("countryID", countryID).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Countries> getByCountriesByRegionID(Integer regionID) {
		return  getSession().createQuery("from Countries where regionID = :regionID").
				setParameter("regionID", regionID).list();
	}
	

}
