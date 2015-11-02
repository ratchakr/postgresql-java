package com.carrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.dto.RentalInformation;
import com.carrental.service.CarRentalService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "Rental Service", description = "Operations pertaining to Car Rental Service Online")
@RestController
@Qualifier("jackson2SchemaDescriptor") 
@RequestMapping("/service/rental")
public class RentalAppController {
	
	@Autowired
	private CarRentalService rentalService;	

	@ApiOperation(value = "View the Specific Name of the Renter")
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String print(@PathVariable String name) {
		System.out.println("**********     Inside print HTTP GET     ************");
		String result="Hello "+name;		
		return result;
	}	
	
	@ApiOperation(value = "Create a Car Rental Record in the database")
	@RequestMapping(value = "/create", method = RequestMethod.POST, headers="Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Integer create(@RequestBody RentalInformation request) {
		System.out.println("**********     Inside create HTTP POST     ************"+request);
		
/*		if (request.getContentLength() > 0) {
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				rentalInfo = objectMapper.readValue(request.getInputStream(), RentalInformation.class);
			} catch (Exception e) {
				//logger.error("Unable to parse request parameters for add subscriber", exception);
				//throw new SubscriberServicesException(SubscriberServicesErrorCodesEnum.BAD_REQUEST.getErrorCode(),
						//SubscriberServicesErrorCodesEnum.BAD_REQUEST.getErrorMessage());
				e.printStackTrace();
			}
		} else {
			throw new SubscriberServicesException(SubscriberServicesErrorCodesEnum.BAD_REQUEST.getErrorCode(),
					SubscriberServicesErrorCodesEnum.BAD_REQUEST.getErrorMessage());
		}*/		
		
		return rentalService.create(request);
	}	
	
}
