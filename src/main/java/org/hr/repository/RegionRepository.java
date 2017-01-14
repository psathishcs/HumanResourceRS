package org.hr.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hr.entity.Regions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RegionRepository {
	
	@Autowired
	private SessionFactory _sessionFactory;
	
	public Session getSession(){
		return  _sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Regions> getAllRegions(){
		return getSession().createQuery("From Regions").list();
	}
	
	public Regions getRegionsByID(Integer regionID){
		return (Regions) getSession().createQuery("From Regions where regionID = :regionID").
				setParameter("regionID", regionID).uniqueResult();
	}
	
}
