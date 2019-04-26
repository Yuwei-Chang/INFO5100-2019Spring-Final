package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import javax.swing.*;
import java.io.FileNotFoundException;
public class DeleteCarUI extends JFrame{
    Container delcontainer= getContentPane();
    JPanel panel=new JPanel(new GridBagLayout());
    JPanel panel2=new JPanel(new GridBagLayout());
    GridBagConstraints c= new GridBagConstraints();
    Font f=new Font("Arial", Font.BOLD, 20);
    JButton OkayButton=new JButton("OK");
    JButton CancelButton=new JButton("Cancel");
    JLabel label=new JLabel("Vehicleid:");
    JLabel label2;
    String vid;
    public DeleteCarUI(String vid){
        this.vid=vid;
        CreateAddComponent(vid);
        AddButton();
        SetWindow();
        ButtonListener();
    }

    void CreateAddComponent(String vid) {

        delcontainer.setLayout(new BorderLayout());
        delcontainer.setBackground(new Color(244, 167, 66));
        delcontainer.add(panel,BorderLayout.CENTER);
        label2 = new JLabel(vid);
        label.setFont(f);
        label2.setFont(f);
        c.insets= new Insets(10,10,10,10);
        c.gridx=5;
        c.gridy=7;
        panel.add(label, c);
        c.gridx=6;
        c.gridy=7;
        panel.add(label2, c);
        panel.setOpaque(false);

    }

    void AddButton() {

        OkayButton.setFont(f);
        CancelButton.setFont(f);
        Color cl= new Color(244, 103, 65);
        OkayButton.setBackground(cl);
        CancelButton.setBackground(cl);
        OkayButton.setFocusPainted(false);
        OkayButton.setFocusPainted(false);
        c.insets= new Insets(10,10,10,10);
        c.gridx=4;
        c.gridy=8;
        panel2.add(OkayButton,c);
        c.gridx=5;
        c.gridy=8;
        panel2.add(CancelButton,c);

        panel2.setOpaque(false);
        delcontainer.add(panel2,BorderLayout.SOUTH);

    }

    void SetWindow(){

        setSize(400, 200);
        setResizable(false);
        setUndecorated(true);
        int windowWidth = this.getWidth();
        int windowHeight = this.getHeight();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);

        setTitle("Confirm Delete");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    void ButtonListener() {

        OkayButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent d) {

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

                    PreparedStatement p = conn.prepareStatement("select * from  dbo.Inventory WHERE Vehicleid =" + "'" + label2.getText() + "'");
                    ResultSet r = p.executeQuery();

                    if (r.next() == true) {
                        PreparedStatement ps = conn.prepareStatement("Delete from  dbo.Inventory WHERE Vehicleid ="
                                + "'" + label2.getText() + "';\n" + "Delete from dbo.Vehicle where Vehicleid=" + "'" + label2.getText() + "';");

                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Vehicle Successfully Deleted from Inventory");
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Vehicle not available in Inventory");
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            });

        CancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent c) {
                dispose();
            }

        });

    }

}
