package com.carrental.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class PickUpInfo implements Serializable {

	@Override
	public String toString() {
		return "PickUpInfo [zipCode=" + zipCode + ", city=" + city + ", storeLocation=" + storeLocation
				+ ", pickUpTime=" + pickUpTime + ", retunTime=" + retunTime + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long zipCode;
	
	private String city;
	
	private String storeLocation;
	
	private String pickUpTime;
	
	private String retunTime;

	public Long getZipCode() {
		return zipCode;
	}

	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStoreLocation() {
		return storeLocation;
	}

	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}

	public String getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public String getRetunTime() {
		return retunTime;
	}

	public void setRetunTime(String retunTime) {
		this.retunTime = retunTime;
	}
}
