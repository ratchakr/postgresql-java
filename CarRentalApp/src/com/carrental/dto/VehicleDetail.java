package com.carrental.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class VehicleDetail implements Serializable {

	@Override
	public String toString() {
		return "VehicleDetail [category=" + category + ", make=" + make + ", year=" + year + ", mile=" + mile + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String category;
	
	private String make;
	
	private Integer year;
	
	private Long mile;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Long getMile() {
		return mile;
	}

	public void setMile(Long mile) {
		this.mile = mile;
	}
	
}
