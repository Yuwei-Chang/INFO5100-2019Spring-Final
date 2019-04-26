package UI;
import database.DatabaseConnection;
import database.DealerAuth;
import database.VehiclesSearchResult;
import dto.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class DealerInventoryUI {
    DealerLogin login= new DealerLogin();
}

class DealerLogin extends JFrame {
    public JTextField dealerIDText;
    DatabaseConnection dbobj=new DatabaseConnection();
   // private DealerAuth dAuth=new DealerAuth();
    private Container container = getContentPane();
    JTextField dealerNameText;
    private String dealerID;
    private JButton loginButton;
    private Color regularText = new Color(36, 33, 28),
            button = new Color(172, 81, 24),
            back = new Color(159, 125, 80),
            errorText = Color.RED;
    private JLabel invalidDealer;


    //Constructor
    public DealerLogin() {
        CreateLabelPanel();
        CreateTextFieldPanel();
        CreateButtonPanel();
        CreateErrorPanel();
        SetAction();
        SetWindow();
    }

    //Create label panel
    private void CreateLabelPanel() {
        JPanel Left = new JPanel(new GridLayout(2, 1, 30, 30));
        JLabel DealerIDLabel = new JLabel("dealerID:");
        JLabel DealerNameLabel = new JLabel("dealerName:");
        DealerIDLabel.setFont(new Font("Arial", Font.BOLD, 16));
        DealerNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        DealerIDLabel.setForeground(regularText);
        DealerNameLabel.setForeground(regularText);
        Left.add(DealerIDLabel);
        Left.add(DealerNameLabel);
        Left.setBounds(70, 70, 120, 80);
        Left.setOpaque(false);
        container.add(Left);
    }

    //Create input part UI
    private void CreateTextFieldPanel() {
        JPanel Right = new JPanel(new GridLayout(2, 1, 30, 30));
        dealerIDText = new JTextField();
        dealerNameText = new JTextField();
        Right.add(dealerIDText);
        Right.add(dealerNameText);
        Right.setBounds(190, 70, 150, 80);
        Right.setOpaque(false);
        container.add(Right);
    }

    //Create button
    private void CreateButtonPanel() {
        JPanel b = new JPanel(new GridLayout(1, 1, 30, 30));
        loginButton = new JButton("Login");
        loginButton.setFocusPainted(false);
        loginButton.setBounds(150, 200, 100, 30);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setFocusPainted(false);
        loginButton.setBackground(button);;
        loginButton.setForeground(regularText);
        b.setBounds(150, 200, 100, 30);
        b.add(loginButton);
        b.setOpaque(false);
        container.add(b);
    }

    private void CreateErrorPanel() {

        JPanel c = new JPanel(null);
        c.setLayout(null);
        invalidDealer =new JLabel("Dealer not found!!!");
        invalidDealer.setBounds(120, 240, 270, 30);
        invalidDealer.setFont(new Font("Arial", Font.BOLD, 16));
        invalidDealer.setForeground(errorText);
        invalidDealer.setVisible(false);

        c.add(invalidDealer);
        c.setBounds(120, 70, 70, 70);
        c.setOpaque(false);
        container.add(c);
    }

    //Write button logic here
    private void SetAction() {
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dealerID = dealerIDText.getText();
                if(dbobj.isValidDealer(dealerID)){
                   new SearchFrame(dealerID);
                    setVisible(false);
                }else{
                    invalidDealer.setVisible(true);
                    //  System.out.println("Dealer not found");
                }

            }
        });
    }


    //Set window performance
    private void SetWindow() {
        setSize(400, 340);
        setResizable(false);
        int windowWidth = this.getWidth();
        int windowHeight = this.getHeight();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
        setTitle("Login");
        container.setBackground(back);
        //setUndecorated(true);
        //AWTUtilities.setWindowOpacity(this, (float)(0.86));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class SearchFrame extends JFrame {
    VehiclesSearchResult vehicleObj =new VehiclesSearchResult();
    DatabaseConnection dbobj=new DatabaseConnection();
    DealerAuth dAuth=new DealerAuth();
    //DealerLogin dealerobj=new DealerLogin();
    private Container container = getContentPane();
    private String dealerid;
    private JPanel leftPanel, rightPanel;
    private JRadioButton New, used, all;
    private JButton searchButton, addButton, modifyButton, deleteButton;
    private JComboBox modelCB,makeCB;
    private String selectedCategory="";
    //DealerLogin dObj;

    //Constructor
//    public SearchFrame(){
//
//    }
    public SearchFrame(String dealerid) {
        container.setLayout(null);
        this.dealerid = dealerid;
        CreateLeftPanel();
        ButtonAction();
        SetBackground();
        SetWindow();
    }

    //Create left part panel
    private void CreateLeftPanel() {
        leftPanel = new JPanel();
        leftPanel.setLayout(null);
        JPanel LabelPanel = new JPanel();
        LabelPanel.setOpaque(false);
        JLabel CurrentDealerName = new JLabel(dealerid, JLabel.CENTER);
        CurrentDealerName.setFont(new Font("Arial", Font.BOLD, 32));;
        LabelPanel.add(CurrentDealerName);
        LabelPanel.setBounds(0, 120, 640, 60);
        leftPanel.add(LabelPanel);

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setOpaque(false);
        ButtonPanel.setLayout(null);
        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.PLAIN, 20));
        searchButton.setBounds(260, 0, 120, 40);
        searchButton.setFocusPainted(false);
        ButtonPanel.add(searchButton);
        ButtonPanel.setBounds(0, 680, 640, 40);
        leftPanel.add(ButtonPanel);

        JPanel FilterPanel = new JPanel();
        FilterPanel.setOpaque(false);
        FilterPanel.setLayout(null);
        JPanel FilterPanelLeft = new JPanel();
        FilterPanelLeft.setOpaque(false);
        JPanel FilterPanelRight = new JPanel();
        FilterPanelRight.setOpaque(false);
        FilterPanelLeft.setLayout(new GridLayout(2, 1, 80, 30));
        FilterPanelRight.setLayout(new GridLayout(2, 1, 80, 80));
        JLabel Model = new JLabel("Model");
        Model.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel Make = new JLabel("Make");
        Make.setFont(new Font("Arial", Font.PLAIN, 20));
        FilterPanelLeft.add(Model);
        FilterPanelLeft.add(Make);
//        String[] modelList = {"SUV", "Sedan", "HatchBack", "CrossOver"};
//        String[] makeList = {"Honda", "Subaru", "Tesla", "Toyota"};
       // List modelList= (vehicleObj.getModel().toArray();
      //  String[] makeList= (String[])vehicleObj.getMake().toArray();

         modelCB = new JComboBox(vehicleObj.getModel().toArray());
         makeCB = new JComboBox(vehicleObj.getMake().toArray());

        modelCB.setFocusable(false);
        makeCB.setFocusable(false);
        FilterPanelRight.add(modelCB);
        FilterPanelRight.add(makeCB);
        FilterPanelLeft.setBounds(150, 32, 100, 200);
        FilterPanelRight.setBounds(300, 56, 200, 150);
        FilterPanel.add(FilterPanelLeft);
        FilterPanel.add(FilterPanelRight);
        FilterPanel.setBounds(0, 240, 640, 300);
        leftPanel.add(FilterPanel);


        JPanel SelectPanel = new JPanel();
        SelectPanel.setOpaque(false);
        SelectPanel.setLayout(new BoxLayout(SelectPanel, BoxLayout.X_AXIS));
        New = new JRadioButton("New");
        used = new JRadioButton("used");
        all = new JRadioButton("all");
        New.setEnabled(true);
        New.setFont(new Font("Arial", Font.PLAIN, 16));
        used.setFont(new Font("Arial", Font.PLAIN, 16));
        all.setFont(new Font("Arial", Font.PLAIN, 16));
        New.setFocusPainted(false);
        used.setFocusPainted(false);
        all.setFocusPainted(false);
        New.setOpaque(false);
        used.setOpaque(false);
        all.setOpaque(false);
        New.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(New); group.add(used); group.add(all);

        SelectPanel.add(Box.createHorizontalStrut(117)); SelectPanel.add(New);
        SelectPanel.add(Box.createHorizontalStrut(117)); SelectPanel.add(used);
        SelectPanel.add(Box.createHorizontalStrut(117)); SelectPanel.add(all);
        SelectPanel.setBounds(0, 560, 640, 60);
        leftPanel.add(SelectPanel);
        leftPanel.setBounds(0, 0, 640, 900);
        leftPanel.setOpaque(false);
        container.add(leftPanel);
    }


    //Create right part panel
    private void CreateRightPanel(ArrayList<Vehicle> vl) {
        if(rightPanel!=null){
            Component[] comp = rightPanel.getComponents();
            for(Component c:comp){
                rightPanel.remove(c);
            }
        }

        rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setLayout(null);


        JPanel topList = new JPanel(null);
        topList.setOpaque(false);
        JPanel list = new JPanel(null);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.setFont(new Font("Courier New", Font.BOLD, 24));
        JScrollPane listPane = new JScrollPane(list);
        listPane.setBounds(50, 20, 800, 600);
        topList.add(listPane);
        topList.setBounds(30, 60, 900, 640);
        rightPanel.add(topList);

        if(vl.size()>0) {
            ArrayList<JRadioButton> rbList = new ArrayList<JRadioButton>();
            for (Vehicle v : vl) {
                ListPanel resultPanel = new ListPanel(v);
                rbList.add(resultPanel.select);
                list.add(resultPanel);
            }
            JPanel buttons = new JPanel(new GridLayout(1, 3, 100, 20));
            buttons.setOpaque(false);
            addButton = new JButton("Add");
            addButton.setFont(new Font("Arial", Font.PLAIN, 16));
            modifyButton = new JButton("Modify");
            modifyButton.setFont(new Font("Arial", Font.PLAIN, 16));
            deleteButton = new JButton("Delete");
            deleteButton.setFont(new Font("Arial", Font.PLAIN, 16));
            addButton.setFocusPainted(false);
            modifyButton.setFocusPainted(false);
            deleteButton.setFocusPainted(false);
            buttons.add(addButton);
            buttons.add(modifyButton);
            buttons.add(deleteButton);
            buttons.setBounds(200, 720, 560, 50);
            rightPanel.add(buttons);

            deleteButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    for(JRadioButton jrb: rbList){
                        if(jrb.isSelected()) {
                            new DeleteCarUI(jrb.getText());
                            break;
                        }
                    }
                }

            });

            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    new AddCarUI(dealerid);
                }
            });

            modifyButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    for(JRadioButton jrb: rbList){
                        if(jrb.isSelected()) {
                            new ModifyCarUI(jrb.getText());
                            break;
                        }
                    }
                }
            });
        }
        else{
            JLabel info=new JLabel("No cars found with given filters!!!!");
            info.setPreferredSize(new Dimension(300,150));
            info.setForeground(Color.RED);
            list.add(info);
        }

        rightPanel.setBounds(640, 0, 960, 900);
        container.add(rightPanel);
        setVisible(true);
    }

    //Write search button logic here
    private void ButtonAction() {
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("search button");
                //get filters
                //String dealerid= dealerid;
                String model= modelCB.getSelectedItem().toString();
                String make= makeCB.getSelectedItem().toString();
                System.out.println("make "+make);
                if(New.isSelected()){
                    selectedCategory=New.getText();
                }else
                if(used.isSelected()){
                    selectedCategory= used.getText();
                }else
                if(all.isSelected()){
                    selectedCategory= all.getText();
                }

                //System.out.println("category "+ selectedCategory);

                ArrayList<Vehicle> vl = dbobj.getVehicleForMakeMOdelCategory(dealerid,make, model, selectedCategory);

          // ArrayList<Vehicle> vl = dbobj.getVehicleForMakeMOdelCategory("D18", "Audi", "A4" , "New");
//                Vehicle testvehicle= vl.get(0);

              CreateRightPanel(vl);
            }
          });
    }

    //Set window background
    private void SetBackground() {
        File file = new File("background.png");
        String direction = file.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\");
        direction = direction.replaceAll("/background.png", "/src/UI/background.png");
        System.out.println(direction);
        JLabel backImage = new JLabel(new ImageIcon(direction));
        backImage.setBounds(0, 0, 1600, 900);
        container.add(backImage);
    }

    //Set window performance
    private void SetWindow() {
        setSize(1600, 900);
        setResizable(false);
        int windowWidth = this.getWidth();
        int windowHeight = this.getHeight();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class ListPanel extends JPanel{
    JLabel resultPrice, resultLocation, resultMake, resultYear, resultMileage, resultCondition;
    JRadioButton select;


    public ListPanel() {
        setBorder(BorderFactory.createEmptyBorder(20,10,20,20));
        createComponents();
        addComponents();
    }
    public ListPanel(Vehicle v) {
        setBorder(BorderFactory.createEmptyBorder(20,10,20,20));
        createComponents(v);
        addComponents();
    }

    private void createComponents(){
        select = new JRadioButton();
        select.setOpaque(false);
//        resultVehicleID = new JLabel("VehicleId: ");
        resultCondition = new JLabel("Condition: ");
        resultLocation = new JLabel("Location: ");
        resultMake = new JLabel("Make: ");
        resultMileage = new JLabel("Mileage: ");
        resultYear = new JLabel("Year: ");
        resultPrice = new JLabel("Price: ");
        select.setPreferredSize(new Dimension(50, 50));
//        resultVehicleID.setPreferredSize(new Dimension(100,50));
        resultPrice.setPreferredSize(new Dimension(100,50));
        resultLocation.setPreferredSize(new Dimension(150,50));
        resultMileage.setPreferredSize(new Dimension(150,50));
        resultCondition.setPreferredSize(new Dimension(150,50));
        resultYear.setPreferredSize(new Dimension(100,50));
        resultMake.setPreferredSize(new Dimension(100,50));
    }
    private void createComponents(Vehicle v){
        select = new JRadioButton(v.getVehicleId());
        select.setOpaque(false);
//        resultVehicleID = new JLabel(v.getVehicleId());
        resultCondition = new JLabel(v.getType());
        resultLocation = new JLabel(v.getCategory());
        resultMake = new JLabel(v.getMake());
        resultMileage = new JLabel(v.getModel());
        resultYear = new JLabel(Integer.toString(v.getYear()));
        resultPrice = new JLabel(v.getPrice());
        select.setPreferredSize(new Dimension(100, 50));
//        resultVehicleID.setPreferredSize(new Dimension(100,50));
        resultPrice.setPreferredSize(new Dimension(100,50));
        resultLocation.setPreferredSize(new Dimension(150,50));
        resultMileage.setPreferredSize(new Dimension(150,50));
        resultCondition.setPreferredSize(new Dimension(150,50));
        resultYear.setPreferredSize(new Dimension(100,50));
        resultMake.setPreferredSize(new Dimension(100,50));
    }
    private void addComponents(){
        add(select);
//        add(resultVehicleID);
        add(resultPrice);
        add(resultCondition);
        add(resultMake);
        add(resultYear);
        add(resultMileage);
        add(resultLocation);
    }
}

//class ModifyCarDetails extends JDialog {
//    public ModifyCarDetails() {
//        new CarDetailUI();
//    }
//}