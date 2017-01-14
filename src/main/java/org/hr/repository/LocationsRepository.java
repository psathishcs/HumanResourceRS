package org.hr.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hr.entity.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LocationsRepository {
	
	@Autowired
	private SessionFactory _sessionFactory;
	
	public Session getSession(){
		return  _sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public List<Locations> getAllLocations(){
		return getSession().createQuery("From Locations").list();
	}
	
	public Locations getLocationsByID(Integer locationID){
		return (Locations) getSession().createQuery("From Locations where locationID = :locationID").
				setParameter("locationID", locationID).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Locations> getLocationsByCountryID(String countryID){
		return getSession().createQuery("From Locations where countryID = :countryID").
				setParameter("countryID", countryID).list();
	}

	
	
}
