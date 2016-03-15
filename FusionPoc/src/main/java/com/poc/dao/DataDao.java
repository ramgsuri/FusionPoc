package com.poc.dao;
//------------------------------------------------------------------
import java.util.List;
import com.poc.model.City;
import com.poc.model.Country;
//------------------------------------------------------------------
/**
 * Dao Layer to retrieve the data.
 * <ul>
 *  <li>Retrieve the list of cities by countryId.</li>
 *  <li>Retrieve the list of countries</li>
 *  </ul>
 * 
 * @author ramgsuri
 *
 */
public interface DataDao {

	 List<City> getListOfCityByCountryId(long id) throws Exception;
	 List<Country> getCountryList() throws Exception;

}
