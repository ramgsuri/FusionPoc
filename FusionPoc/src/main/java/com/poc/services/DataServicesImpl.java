package com.poc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.poc.dao.DataDao;
import com.poc.model.City;
import com.poc.model.Country;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	public List<City> getListOfCityByCountryId(long id) throws Exception {
		return dataDao.getListOfCityByCountryId(id);
	}

	public List<Country> getCountryList() throws Exception {
		return dataDao.getCountryList();
	}


}
