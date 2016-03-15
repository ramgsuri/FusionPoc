package com.poc.services;
//----------------------------------------------------------
import java.util.List;

import com.poc.model.City;
import com.poc.model.Country;
/**
 * Service Layer to retrieve the data
 *  
 * @author ramgsuri
 *
 */
public interface DataServices {

	List<City> getListOfCityByCountryId(long id) throws Exception;
	List<Country> getCountryList() throws Exception;
}
 