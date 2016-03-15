package com.poc.controller;
//---------------------------------------------------------------------------------
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.poc.model.City;
import com.poc.model.Country;
import com.poc.services.DataServices;
//--------------------------------------------------------------------------------
/**
 * RestController acting as a controller for REST Web Service Calls
 * 
 * @author ramgsuri
 *
 */
@Controller
@RequestMapping("/country")
public class RestController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);
	/**
	 * 
	 * Rest Endpoint to fetch list of cities by country Id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers="Accept=application/json", produces="application/json")
	public @ResponseBody
	List<City> getListOfCityByCountryId(@PathVariable("id") long id) {
		List<City> listOfCities = null;
		try {
			listOfCities = dataServices.getListOfCityByCountryId(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfCities;
	}
	
	/**
	 * 
	 * Rest Endpoint to fetch list of countries.
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers="Accept=application/json", produces="application/json")
	public @ResponseBody
	List<Country> getCountryList() {

		List<Country> countryList = null;
		try {
			countryList = dataServices.getCountryList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return countryList;
	}
   
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET, headers="Accept=application/json", produces="application/json")
	public  ModelAndView getView(@PathVariable("id") long id) {
		List<City> listOfCities = null;
		
		ModelAndView modelAndView = new ModelAndView("renderCity");
		modelAndView.addObject("countryId", id);
		System.out.println("--ID--"+id);
		return modelAndView;
	}
	
	
	
	
}
