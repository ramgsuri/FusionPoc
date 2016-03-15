package com.poc.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "city")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cityId")
	private long cityId;

	@Column(name = "countryId")
	private long countryId;
	
	@Column(name = "cityName")
	private String cityName;

	@Column(name = "population")
	private String population;
	
	@Column(name = "geoLocation")
	private String geoLocation;

	public long getCityId() {
		return cityId;
	}

	public void setId(long cityId) {
		this.cityId = cityId;
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

}
