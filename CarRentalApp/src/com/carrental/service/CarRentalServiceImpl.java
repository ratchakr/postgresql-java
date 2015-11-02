package com.carrental.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.util.PGobject;
import org.springframework.stereotype.Component;

import com.carrental.db.util.DBUtility;
import com.carrental.dto.RentalInformation;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CarRentalServiceImpl implements CarRentalService {
	

	
	public CarRentalServiceImpl() {
		System.out.println(" CarRentalServiceImpl Dflt Constructor Called ");
		
	}

	private Connection connection = DBUtility.getConnection();
	
	

	public CarRentalServiceImpl(Connection connection) {
		System.out.println(" CarRentalServiceImpl Constructor Called ");
		this.connection = DBUtility.getConnection();
	}



	@Override
	public Integer create(RentalInformation rentalInfo) {
		String insertSQL = "insert into carrental.\"rentalinformation\" values (?,?,?,?)";
	    try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			
			Integer refID = getNextSequenceValue();
			preparedStatement.setInt(1, refID);
			preparedStatement.setString(2, rentalInfo.getRentersName());
			preparedStatement.setInt(3, rentalInfo.getRentersAge());
			String jsonRentalDetail = convertObjectToJsonString(rentalInfo.getRentalDetail());
			


			PGobject jsonObject = new PGobject();
			jsonObject.setType("json");
			jsonObject.setValue(jsonRentalDetail);
			preparedStatement.setObject(4, jsonObject);
			System.out.println("preparedStatement := "+preparedStatement);
			preparedStatement .executeUpdate();
			return refID;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return null;
	}

	private Integer getNextSequenceValue() {
		String selectSeqStr = "select nextval('carrental.carrentalsequence')";
		Integer seqID = -9;
		ResultSet rs = null;
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(selectSeqStr);
			while (rs.next()) {
				seqID = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seqID;
	}

	/**
	 * Convert object to json string.
	 * 
	 * @param obj
	 *            the obj
	 * @return the string
	 */
	public static String convertObjectToJsonString(final Object obj) {
		String jsonString = null;
		if (obj != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				jsonString = objectMapper.writeValueAsString(obj);
				System.out.println(jsonString);
			} catch (Exception exception) {
				//logger.error("Unable to read user account settings", exception);
			}
		}

		
		return jsonString;
	}

	@Override
	public RentalInformation view(String reservationNumer) {
		return null;
	}

	@Override
	public void update(RentalInformation rentalInfo, String reservationNumer) {

	}

	@Override
	public void delete(String reservationNumer) {

	}

}
