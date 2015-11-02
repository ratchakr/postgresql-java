package com.carrental.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect
public class RentalDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String plan;
	
	private PickUpInfo pickup;

	private VehicleDetail vehicle;
	
	@Override
	public String toString() {
		return "RentalDetail [plan=" + plan + ", pickup=" + pickup + ", vehicle=" + vehicle + "]";
	}

	@JsonSerialize
	public PickUpInfo getPickup() {
		return pickup;
	}

	public void setPickup(PickUpInfo pickup) {
		this.pickup = pickup;
	}

	@JsonSerialize
	public VehicleDetail getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDetail vehicle) {
		this.vehicle = vehicle;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}
	
}
