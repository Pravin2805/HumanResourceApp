package com.example.HumanResourceApp.Entity;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.misc.NotNull;

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
import jakarta.validation.constraints.*;

@Entity
@Table(name="countries")
public class Countries {
	@Id
	@Column(name="country_id",length = 4)
	private String country_id;
	
	@Column(name="country_name",length = 60)
	private String country_name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="region_id",referencedColumnName = "region_id")
	private Regions regions;
	
	public Countries() {
	
	}

	public Countries(String country_id, String country_name, Regions regions) {
		super();
		this.country_id = country_id;
		this.country_name = country_name;
		this.regions = regions;
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public Regions getRegions() {
		return regions;
	}

	public void setRegions(Regions regions) {
		this.regions = regions;
	}

	@Override
	public String toString() {
		return "Countries [country_id=" + country_id + ", country_name=" + country_name + ", regions=" + regions + "]";
	}
	
	
}
