package database;
import dto.Vehicle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;databaseName=Car_Inventory";
	String USER = "INFO6210";
	String PASS = "NEUHusky!";

	public Vehicle retriveVehicleFromDatabase(String vehicleId) {
		Vehicle vehicle = new Vehicle();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			
			PreparedStatement statement =conn.prepareStatement("SELECT * from  dbo.Vehicle WHERE  Vehicleid = ?");
			statement.setString(1, vehicleId);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
			vehicle.setVehicleId(rs.getString("Vehicleid"));
			vehicle.setCategory(rs.getString("Category"));
			vehicle.setYear(String.valueOf(rs.getInt("Year")));
			vehicle.setMake(rs.getString("Make"));
			vehicle.setModel(rs.getString("Model"));
			vehicle.setType(rs.getString("Type"));
			vehicle.setSeatCount(String.valueOf(rs.getInt("SeatCount")));
			vehicle.setMilaege(rs.getString("Mileage"));
			vehicle.setPrice(rs.getString("Price"));
			vehicle.setZipCode(rs.getString("ZipCode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicle;
	}
	
	/*
	 * public Dealer getDealer(String dealerId) {
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	
	
	
	
}
