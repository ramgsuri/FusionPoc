package com.poc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.poc.model.City;
import com.poc.model.Country;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	private static final String HQL_QUERY_FETCH_CITIES = "from City where countryId = ?";

	public List<City> getListOfCityByCountryId(long id) throws Exception {
		session = sessionFactory.openSession();
		
		tx = session.getTransaction();
		session.beginTransaction();
		List<City> listOfCities = session.createQuery(HQL_QUERY_FETCH_CITIES).setParameter(0, id).list();
		
		tx.commit();
		return listOfCities;
	}

	@SuppressWarnings("unchecked")
	public List<Country> getCountryList() throws Exception {
		List<Country> countryList = null;
				
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		try {
		 countryList = session.createCriteria(Country.class)
				 		.list();
		tx.commit();
		} finally {
			session.close();	
		}
		
		return countryList;
	}

}
 