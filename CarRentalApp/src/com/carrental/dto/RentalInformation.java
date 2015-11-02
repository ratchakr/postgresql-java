package com.carrental.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect
public class RentalInformation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "RentalInformation [rentersName=" + rentersName + ", rentersAge=" + rentersAge + ", rentalDetail="
				+ 
				rentalDetail + 
				"]";
	}

	private String rentersName;
	
	private Integer rentersAge;
	
	@JsonRawValue
	private RentalDetail rentalDetail;

	public String getRentersName() {
		return rentersName;
	}

	public void setRentersName(String rentersName) {
		this.rentersName = rentersName;
	}

	public Integer getRentersAge() {
		return rentersAge;
	}

	public void setRentersAge(Integer rentersAge) {
		this.rentersAge = rentersAge;
	}
	@JsonSerialize
	public RentalDetail getRentalDetail() {
		return rentalDetail;
	}

	@JsonRawValue
	public void setRentalDetail(RentalDetail rentalDetail) {
		this.rentalDetail = rentalDetail;
	}

}
