package DB;
//Amisha

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VehiclesSearchResult {
    String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;"
            + "databaseName=Car_Inventory";
    String USER = "INFO6210";
    String PASS = "NEUHusky!";


    public List getMake() {
        List makeList=new ArrayList<String>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            PreparedStatement statement =conn.prepareStatement("SELECT DISTINCT Make from  dbo.vehicle" );
            // statement.setString(1, dealerId);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                makeList.add(rs.getString(1));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return makeList;
    }

    public List getModel() {
        List modelList=new ArrayList<String>();

        // GetMakeandModel makeandModel = new GetMakeandModel();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            PreparedStatement statement =conn.prepareStatement("SELECT DISTINCT Model from  dbo.vehicle" );
            // statement.setString(1, dealerId);

            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                modelList.add(rs.getString(1));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return modelList;
    }
}
