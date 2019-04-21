
package DB;


        import java.io.FileInputStream;
        import java.io.InputStream;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Properties;

public class DealerAuth {
    String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;"
            + "databaseName=Car_Inventory";
    String USER = "";
    String PASS = "";


    public boolean isValidDealer(String dealerid) {

        try {
            InputStream input = new FileInputStream("DB.properties");
            Properties prop=new Properties();
            prop.load(input);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, prop.getProperty("USER"), prop.getProperty("PASS"));

            PreparedStatement statement = conn.prepareStatement("SELECT DISTINCT Dealerid from  dbo.Inventory where Dealerid=?");
            statement.setString(1, dealerid);

            ResultSet rs = statement.executeQuery();

            return  rs.next();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }}
