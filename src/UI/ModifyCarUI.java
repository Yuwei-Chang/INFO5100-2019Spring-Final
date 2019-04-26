package UI;

import database.DatabaseConnection;
import dto.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ModifyCarUI extends JFrame {
    private JPanel top;
    private JPanel main;
    private JPanel bottom;
    private JLabel VehicleidLabel, ModelLabel, PriceLabel, YearLabel, CategoryLabel;
    private JButton submitButton;
    private JTextField VehicleidText, ModelText, PriceText, YearText, CategoryText;

    DatabaseConnection dbobj=new DatabaseConnection();
    String vid;
    public ModifyCarUI(String vid) {
        this.vid=vid;
        createComponents();
        addComponents();
        addListeners();
        makeItVisible();
    }


    void createComponents() {
        top = new JPanel(new GridLayout(2, 1, 30, 30));
        top.setBounds(50, 70, 300, 80);
        top.setLocation(350, 120);
        main = new JPanel(new GridLayout(2, 1, 30, 30));
        main.setBounds(180, 70, 300, 80);
        main.setLocation(350, 230);
        bottom = new JPanel(new GridLayout(2, 1, 30, 30));
        bottom.setBounds(100, 70, 300, 200);
        bottom.setLocation(350, 340);
        Vehicle v=dbobj.getVehicle(vid) ;
        //Brand
        VehicleidLabel = new JLabel("VehicleID:");
        VehicleidText = new JTextField(v.getVehicleId());
        VehicleidText.setEditable(false);
        //Model
        ModelLabel = new JLabel("Model:");
        ModelText = new JTextField(v.getModel());
        //Price
        PriceLabel = new JLabel("Price:");
        PriceText = new JTextField(v.getPrice());
        //Year
        YearLabel = new JLabel("Year:");
        YearText = new JTextField(Integer.toString(v.getYear()));
        //Category
        CategoryLabel = new JLabel("Category:");
        CategoryText = new JTextField(v.getCategory());

        //Submit
        submitButton = new JButton("Modify");
        submitButton.setFocusPainted(false);
        submitButton.setBounds(150, 200, 90, 30);
        submitButton.setLocation(440, 590);

    }

    void addComponents() {
        Container container = getContentPane();
        container.setLayout(null);
        top.add(VehicleidLabel);
        top.add(VehicleidText);
        top.add(ModelLabel);
        top.add(ModelText);
        main.add(PriceLabel);
        main.add(PriceText);
        main.add(YearLabel);
        main.add(YearText);
        bottom.add(CategoryLabel);
        bottom.add(CategoryText);

        container.add(top);
        container.add(main);
        container.add(bottom);
        container.add(submitButton);
    }

    void makeItVisible() {
        setSize(1000, 800);
        setTitle("Modify Page");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void addListeners(){

        submitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dispose();

                String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;databaseName=Car_Inventory";
                String USER = "";
                String PASS = "";

                try {
                    InputStream input = new FileInputStream("src/database/connection.properties");
                    Properties prop = new Properties();
                    prop.load(input);
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection conn = DriverManager.getConnection(URL, prop.getProperty("username"), prop.getProperty("password"));

                    PreparedStatement p = conn.prepareStatement("select * from  dbo.Vehicle WHERE Vehicleid ='"+VehicleidText.getText()+"'");
                    ResultSet r=p.executeQuery();

                    if(r.next()==true) {
                        PreparedStatement ps = conn.prepareStatement("select Model,Price, Category, Year from Vehicle where Vehicleid='"+VehicleidText.getText()+"';\n"
                                +"update dbo.Vehicle set Model='"+ModelText.getText()
                                +"',Price='"+PriceText.getText()+"',Category='"+CategoryText.getText()
                                +"',Year='"+YearText.getText()+"' where Vehicleid='"+VehicleidText.getText()+"'");

                        ResultSet rs=ps.executeQuery();
                        JOptionPane.showMessageDialog(null, "Vehicle is Successfully Modified");
                    }

                    else {
                        JOptionPane.showMessageDialog(null,"Vehicle not found");
                    }

                } catch (ClassNotFoundException c) {
                    c.printStackTrace();
                } catch (SQLException s) {
                    s.printStackTrace();
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
        });


    }
}