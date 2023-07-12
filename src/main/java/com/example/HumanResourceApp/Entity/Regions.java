package com.example.HumanResourceApp.Entity;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="regions")
public class Regions {
	
	@Id
	@Column(name="region_id", precision = 10,scale = 0)
	private BigDecimal region_id;
	
	@Column(name="region_name",length = 25)
	private String region_name;
	
	public Regions(){
		
	}
	
	public Regions(BigDecimal region_id, String region_name) {
		super();
		this.region_id = region_id;
		this.region_name = region_name;
	}

	public BigDecimal getRegion_id() {
		return region_id;
	}

	public void setRegion_id(BigDecimal region_id) {
		this.region_id = region_id;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	@Override
	public String toString() {
		return "Regions [region_id=" + region_id + ", region_name=" + region_name + "]";
	}
	
	
	
}
