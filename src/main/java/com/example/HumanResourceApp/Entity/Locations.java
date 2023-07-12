package com.example.HumanResourceApp.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="locations")
public class Locations {
 
	@Id
	@Column(name="location_id",precision = 4,scale = 0,nullable = false)
	private BigDecimal location_id;
	
	@Column(name="street_address",length = 40)
	private String street_address;
	
	@Column(name="postal_code",length = 12)
	private String postal_code;
	
	@Column(name="city",length=30,nullable = false)
	private String city;
	
	@Column(name="state_province",length = 25)
	private String state_province;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="country_id",referencedColumnName = "country_id")
	private Countries countries;
		
	Locations(){}

	public Locations(BigDecimal location_id, String street_address, String postal_code, String city,
			String state_province, Countries countries) {
		super();
		this.location_id = location_id;
		this.street_address = street_address;
		this.postal_code = postal_code;
		this.city = city;
		this.state_province = state_province;
		this.countries = countries;
	}

	public BigDecimal getLocation_id() {
		return location_id;
	}

	public void setLocation_id(BigDecimal location_id) {
		this.location_id = location_id;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState_province() {
		return state_province;
	}

	public void setState_province(String state_province) {
		this.state_province = state_province;
	}

	public Countries getCountries() {
		return countries;
	}

	public void setCountries(Countries countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "Locations [location_id=" + location_id + ", street_address=" + street_address + ", postal_code="
				+ postal_code + ", city=" + city + ", state_province=" + state_province + ", countries=" + countries
				+ "]";
	}
	
	
}
