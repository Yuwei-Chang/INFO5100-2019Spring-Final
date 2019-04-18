package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DeleteCarUI extends JFrame{

    public DeleteCarUI(){

        Container delcontainer= getContentPane();
        delcontainer.setLayout(new BorderLayout());
//		JPanel panel=new JPanel();
//		panel..setLayout(new GridBagLayout());
        JLabel label=new JLabel("Vehicleid:");
        JLabel label2 = new JLabel("CarA");
        JButton OkayButton=new JButton("ok");
        label.setBounds(10, 10, 20, 20);
        delcontainer.add(label,BorderLayout.WEST);
        label.setBounds(20,30,10,20);
        delcontainer.add(label2,BorderLayout.CENTER);
        label2.setBounds(40,40,30,30);
        delcontainer.add(OkayButton,BorderLayout.SOUTH);

        setSize(400, 400);
       // setResizable(false);
        int windowWidth = this.getWidth();
        int windowHeight = this.getHeight();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
        setTitle("Confirm Delete");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //OkayButton.addActionListener(new ActionListener(){

//			public void actionPerformed(ActionEvent d) {
//
//				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				Connection conn = DriverManager.getConnection(URL, USER, PASS);
//
//				PreparedStatement statement =conn.prepareStatement("Delete from  dbo.dealer WHERE  dealerId = ? and dealerName=?");
//				statement.setString(1, label2);
//
//				ResultSet rs = statement.executeQuery();
//			}
//
//		});

    }

}