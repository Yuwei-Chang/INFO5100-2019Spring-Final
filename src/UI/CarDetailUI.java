//package cn.itcast.accounting.view;

import javax.swing.*;
import java.awt.*;

public class CarDetailUI {
    
    
    public static void main(String[] args) {
        carDetailGUI();
    }

    public static void carDetailGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame detailFrame = new JFrame("Car Detail");
        detailFrame.setSize(700, 400);
        detailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel("Picture");
        JPanel details = new JPanel();
        
        detailFrame.setLayout(new GridLayout(1, 2));
        details.setLayout(new GridLayout(6, 2));
        imageLabel = new JLabel(new ImageIcon("/Users/WUUUT-/Documents/workspace/day31 AccountingAPP/src/cn/itcast/accounting/view/img/jaguar.png"));
        JLabel detail = new JLabel("Detail: ");
        JLabel brand = new JLabel("Brand: ");
        JLabel model = new JLabel("Model: ");
        JLabel year = new JLabel("Year: ");
        JLabel category = new JLabel("Category: ");
        JLabel price = new JLabel("Price: ");
        
        GridBagConstraints gbc = new GridBagConstraints();
        detailFrame.getContentPane();
        imagePanel.setLayout(new BorderLayout());
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        detailFrame.add(imagePanel);
        detailFrame.add(details);
        gbc.gridx = 0;
        gbc.gridy = 0;
        details.add(detail, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        details.add(brand, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        details.add(model, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        details.add(year, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        details.add(category, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        details.add(price, gbc);
        details.setVisible(true);
        imagePanel.setVisible(true);
        detailFrame.setVisible(true);
    }
}
