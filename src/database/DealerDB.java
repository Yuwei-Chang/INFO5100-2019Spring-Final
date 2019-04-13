//import dto.Dealer;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class DealerDB extends Dealer {
//	String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;"
//			+ "databaseName=Car_Inventory";
//	String USER = "INFO6210";
//	String PASS = "NEUHusky!";
//
//	public DealerDB retrivedealerFromDatabase(String dealerId) {
//		DealerDB dealer = new DealerDB();
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			Connection conn = DriverManager.getConnection(URL, USER, PASS);
//
//			PreparedStatement statement =conn.prepareStatement("SELECT * from  dbo.dealer WHERE  dealerId = ? and dealerName=?");
//			statement.setString(1, dealerId);
//
//			ResultSet rs = statement.executeQuery();
//
//			if (rs.next()) {
//			dealer.setdealerId(rs.getString("dealerId"));
//			dealer.setdealerName(rs.getString("dealerName"));
//			dealer.setdealerAddress(rs.getString("dealerAddress"));
//			dealer.setzipCode(rs.getString("zipCode"));
//			dealer.setPhoneNo(rs.getString("PhoneNo"));
//			}
//		}
//			catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dealer;
//	}
//}
