package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class AddCarUI extends JFrame {
    private JPanel top, main, bottom;
    private JLabel VehicleIdLabel, ModelLabel, MakeLabel, TypeLabel, SeatCountLabel, MileageLabel, PriceLabel, YearLabel, CategoryLabel;
    private JTextField VehicleIdText, ModelText,MakeText, TypeText, SeatCountText, MileageText, PriceText, YearText, CategoryText;
    private JButton submitButton;

    public AddCarUI() {
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
        bottom = new JPanel(new GridLayout(5, 1, 30, 30));
        bottom.setBounds(100, 70, 300, 250);
        bottom.setLocation(350, 340);

        //Brand
        VehicleIdLabel = new JLabel("VehicleID:");
        VehicleIdText = new JTextField();
        //Model
        ModelLabel = new JLabel("Model:");
        ModelText = new JTextField();
        //Make
        MakeLabel = new JLabel("Make:");
        MakeText = new JTextField();
        //Type
        TypeLabel = new JLabel("Type:");
        TypeText = new JTextField();
        //SeatCount
        SeatCountLabel = new JLabel("SeatCount:");
        SeatCountText = new JTextField();
        //Mileage
        MileageLabel = new JLabel("Mileage:");
        MileageText = new JTextField();
        //Price
        PriceLabel = new JLabel("Price:");
        PriceText = new JTextField();
        //Year
        YearLabel = new JLabel("Year:");
        YearText = new JTextField();
        //Category
        CategoryLabel = new JLabel("Category:");
        CategoryText = new JTextField();

        //Submit
        submitButton = new JButton("Add");
        submitButton.setFocusPainted(false);
        submitButton.setBounds(150, 200, 90, 30);
        submitButton.setLocation(440, 590);
    }
    void addComponents() {
        Container container = getContentPane();
        container.setLayout(null);
        top.add(VehicleIdLabel);
        top.add(VehicleIdText);
        top.add(ModelLabel);
        top.add(ModelText);
        main.add(PriceLabel);
        main.add(PriceText);
        main.add(YearLabel);
        main.add(YearText);
        bottom.add(CategoryLabel);
        bottom.add(CategoryText);
        bottom.add(SeatCountLabel);
        bottom.add(SeatCountText);
        bottom.add(MakeLabel);
        bottom.add(MakeText);
        bottom.add(MileageLabel);
        bottom.add(MileageText);
        bottom.add(TypeLabel);
        bottom.add(TypeText);
        container.add(top);
        container.add(main);
        container.add(bottom);
        container.add(submitButton);

    }
    void makeItVisible()
    {
        setSize(900, 1800);
        setTitle("Add Page");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void addListeners(){
        submitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

               // dispose();

                String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;databaseName=Car_Inventory";
                String USER = "";
                String PASS = "";
                try {
                    InputStream input = new FileInputStream("DB.properties");
                    Properties prop = new Properties();
                    prop.load(input);
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection conn = DriverManager.getConnection(URL, prop.getProperty("USER"), prop.getProperty("PASS"));

                    PreparedStatement p = conn.prepareStatement("select * from  dbo.Vehicle WHERE Vehicleid ="+"'"+VehicleIdText.getText()+"'");
                    ResultSet r=p.executeQuery();

                    if(r.next()==false) {
                        PreparedStatement ps = conn.prepareStatement("Insert into dbo.Vehicle values('"
                                +VehicleIdText.getText()+"','"+CategoryText.getText()+"','"+YearText.getText()
                                +"','"+MakeText.getText()+"','"+ModelText.getText()+"','"+TypeText.getText()
                                +"','"+SeatCountText.getText()+"','"+MileageText.getText()+"','"+PriceText.getText()+"');");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Vehicle is Successfully Added");

                    }

                } catch (ClassNotFoundException c) {
                    c.printStackTrace();
                } catch (Exception s) {
                    JOptionPane.showMessageDialog(null, "Vehicle already exists");
                }
            }
        });
    }




}
