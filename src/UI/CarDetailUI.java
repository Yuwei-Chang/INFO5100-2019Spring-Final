package cn.itcast.accounting.view;

import javax.swing.*;
import java.awt.*;

public class CarDetailUI {
    private JFrame detailFrame;
    private JPanel imagePanel;
    private JLabel imageLabel;
    private JPanel details;
    private JLabel detail, brand, model, year, category, price;

    public static void main(String[] args) {
        CarDetailUI carDetailUI = new CarDetailUI();
        carDetailUI.carDetailFrame();
    }

    public void carDetailFrame() {
        createComponents();
        addDetailComponents();
    }

    void createComponents() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        detailFrame = new JFrame("Car Detail");
        detailFrame.setSize(700, 400);
        detailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imagePanel = new JPanel();
        imageLabel = new JLabel("Picture");
        details = new JPanel();

        detailFrame.setLayout(new GridLayout(1, 2));
        details.setLayout(new GridLayout(6, 2));
        imageLabel = new JLabel(new ImageIcon("/Users/WUUUT-/Documents/workspace/day31 AccountingAPP/src/cn/itcast/accounting/view/img/jaguar.png"));
        detail = new JLabel("Detail: ");
        brand = new JLabel("Brand: ");
        model = new JLabel("Model: ");
        year = new JLabel("Year: ");
        category = new JLabel("Category: ");
        price = new JLabel("Price: ");
    }

    void addDetailComponents() {
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
