
package DB;
//Amisha

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.util.ArrayList;
        import java.util.List;

public class DealerAuth {
    String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;"
            + "databaseName=Car_Inventory";
    String USER = "INFO6210";
    String PASS = "NEUHusky!";


    public boolean isValidDealer(String dealerid) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            PreparedStatement statement = conn.prepareStatement("SELECT DISTINCT Dealerid from  dbo.Inventory where Dealerid=?");
            statement.setString(1, dealerid);

            ResultSet rs = statement.executeQuery();

            if (rs.getString(1).length()!=0) {
                return true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }}
