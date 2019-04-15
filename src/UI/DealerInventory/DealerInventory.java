package DealerInventory;//Seearch done by Dealer itself on Vehicle inventory

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class  DealerInventory extends JFrame{
    //  private JMenuBar menu;
    private JLabel  makelb, modellb;
    private JCheckBox newckb, usedckb, certifiedckb;
    //private JTextField searchText;
    private JComboBox modelcb, makecb;
    private JButton searchbtn;

    public DealerInventory() {
        createComponents();
        addComponents();
        addListeners();
        makeItVisible();
    }

    void createComponents() {

        // JFrame dealerFrame= new JFrame("Dealer Inventory");
        //  menu = new JMenuBar();
        //    searchlb = new JLabel("Search"); //general search on menuBar
        modellb = new JLabel("Model");
        makelb = new JLabel("Make");
        newckb = new JCheckBox("New");
        usedckb = new JCheckBox("Used");
        certifiedckb = new JCheckBox("Certified");
        // searchText = new JTextField(15);
        searchbtn = new JButton("Search");

        String[] modelList = {"SUV", "Sedan", "HatchBack", "CrossOver"};
        String[] makeList = {"Honda", "Subaru", "Tesla", "Toyota"};
        modelcb = new JComboBox(modelList);
        makecb = new JComboBox(makeList);

    }

    public void addComponents() {
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());

//        menu.add(new JSeparator());
//        menu.add(new JButton("Search"));
//        menu.add(new JTextField());

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();

        // panel.add(menu);
        // panel.add(searchlb);
        //panel.add(searchText);
        c.insets=new Insets(50,50,50,50);

        c.gridx=0;
        c.gridy=1;
        panel.add(modellb,c);
        c.gridx=1;
        c.gridy=1;
        panel.add(modelcb,c);
        //c.insets=new Insets(50,50,50,50);


        c.gridx=0;
        c.gridy=2;
        panel.add(makelb,c);
        c.gridx=1;
        c.gridy=2;
        panel.add(makecb,c);
        // c.insets=new Insets(50,50,50,50);


        c.gridx=0;
        c.gridy=3;
        panel.add(newckb,c);

        c.gridx=1;
        c.gridy=3;
        panel.add(usedckb,c);

        c.gridx=2;
        c.gridy=3;
        panel.add(certifiedckb,c);
        //   c.insets=new Insets(50,50,50,50);

        c.gridx=1;
        c.gridy=4;
        panel.add(searchbtn,c);

        con.add(panel, "West");
    }

    void addListeners() {
        searchbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //  System.out.println(searchText.getText());
                System.out.println(Arrays.toString(modelcb.getSelectedObjects()));
                System.out.println(Arrays.toString(makecb.getSelectedObjects()));
                System.out.println(newckb.isSelected());
                System.out.println(usedckb.isSelected());
                System.out.println(certifiedckb.isSelected());

            }
        });
    }

    private void makeItVisible() {
        this.setName("Dealer Inventory" );
        this.setTitle("Dealer Inventory" );
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.pack();

    }



}
