package com.carrental.service;

import com.carrental.dto.RentalInformation;

public interface CarRentalService {

	public Integer create (RentalInformation rentalInfo) ;
	
	public RentalInformation view (String reservationNumer) ;
	
	public void update (RentalInformation rentalInfo, String reservationNumer);
	
	public void delete (String reservationNumer);
	
}
