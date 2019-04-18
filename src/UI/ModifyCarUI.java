package UI;

import javax.swing.*;
import java.awt.*;

public class ModifyCarUI extends JFrame{
    public ModifyCarUI() {
        Container container = getContentPane();
        container.setLayout(null);


        JPanel top = new JPanel(new GridLayout(2, 1, 30, 30));
        top.setBounds(50, 70, 300, 80);
        top.setLocation(350, 120);
        JPanel main = new JPanel(new GridLayout(2, 1, 30, 30));
        main.setBounds(180, 70, 300, 80);
        main.setLocation(350, 230);
        JPanel bottom = new JPanel(new GridLayout(2, 1, 30, 30));
        bottom.setBounds(100, 70, 300, 200);
        bottom.setLocation(350, 340);

        //Brand
        JLabel BrandLabel = new JLabel("Brand:");
        JTextField BrandText = new JTextField();
        //Model
        JLabel ModelLabel = new JLabel("Model:");
        JTextField ModelText = new JTextField();
        //Price
        JLabel PriceLabel = new JLabel("Price:");
        JTextField PriceText = new JTextField();
        //Year
        JLabel YearLabel = new JLabel("Year:");
        JTextField YearText = new JTextField();
        //Category
        JLabel CategoryLabel = new JLabel("Category:");
        JTextField CategoryText = new JTextField();
        //Detail
        JLabel DetailLabel = new JLabel("Detail:");
        JTextField DetailText = new JTextField();

        //Submit
        JButton submitButton = new JButton("Modify");
        submitButton.setFocusPainted(false);
        submitButton.setBounds(150, 200, 90, 30);
        submitButton.setLocation(440, 590);

        top.add(BrandLabel);
        top.add(BrandText);
        top.add(ModelLabel);
        top.add(ModelText);
        main.add(PriceLabel);
        main.add(PriceText);
        main.add(YearLabel);
        main.add(YearText);
        bottom.add(CategoryLabel);
        bottom.add(CategoryText);
        bottom.add(DetailLabel);
        bottom.add(DetailText);


        container.add(top);
        container.add(main);
        container.add(bottom);
        container.add(submitButton);


        setSize(1000, 800);
        setTitle("Modify Page");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}