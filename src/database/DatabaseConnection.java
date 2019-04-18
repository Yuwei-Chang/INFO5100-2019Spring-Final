package database;
import dto.Dealer;
import dto.Vehicle;
import persist.DealersManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DatabaseConnection implements DealersManager {

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

	@Override
	public ArrayList<Dealer> getAllDealers() {
		ArrayList<Dealer> dealerObjList = new ArrayList<>();
		//Dealer dealer = new Dealer();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement statement =conn.prepareStatement("SELECT * from  dbo.Dealer");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				dealerObjList.add( new Dealer(rs.getString(2),rs.getString(3),rs.getString(1),rs.getInt(4),rs.getInt(5)));


			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return dealerObjList;
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
