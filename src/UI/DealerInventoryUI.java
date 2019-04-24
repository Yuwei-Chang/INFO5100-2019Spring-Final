package UI;

import DB.DealerAuth;
import DB.VehiclesSearchResult;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DealerInventoryUI {
    DealerLogin login= new DealerLogin();
}

class DealerLogin extends JFrame {
    private DealerAuth dAuth=new DealerAuth();
    private Container container = getContentPane();
    JTextField DealerIDText, DealerNameText;
    private String DealerID;
    private JButton LoginButton;
    private Color RegularText = new Color(36, 33, 28),
            Button = new Color(172, 81, 24),
            Back = new Color(159, 125, 80),
            ErrorText = Color.RED;
    private JLabel InvalidDealer;


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
        JLabel DealerIDLabel = new JLabel("DealerID:");
        JLabel DealerNameLabel = new JLabel("DealerName:");
        DealerIDLabel.setFont(new Font("Arial", Font.BOLD, 16));
        DealerNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        DealerIDLabel.setForeground(RegularText);
        DealerNameLabel.setForeground(RegularText);
        Left.add(DealerIDLabel);
        Left.add(DealerNameLabel);
        Left.setBounds(70, 70, 120, 80);
        Left.setOpaque(false);
        container.add(Left);
    }

    //Create input part UI
    private void CreateTextFieldPanel() {
        JPanel Right = new JPanel(new GridLayout(2, 1, 30, 30));
        DealerIDText = new JTextField();
        DealerNameText = new JTextField();
        Right.add(DealerIDText);
        Right.add(DealerNameText);
        Right.setBounds(190, 70, 150, 80);
        Right.setOpaque(false);
        container.add(Right);
    }

    //Create button
    private void CreateButtonPanel() {
        JPanel b = new JPanel(new GridLayout(1, 1, 30, 30));
        LoginButton = new JButton("Login");
        LoginButton.setFocusPainted(false);
        LoginButton.setBounds(150, 200, 100, 30);
        LoginButton.setFont(new Font("Arial", Font.BOLD, 16));
        LoginButton.setFocusPainted(false);
        LoginButton.setBackground(Button);;
        LoginButton.setForeground(RegularText);
        b.setBounds(150, 200, 100, 30);
        b.add(LoginButton);
        b.setOpaque(false);
        container.add(b);
    }

    private void CreateErrorPanel() {

        JPanel c = new JPanel(null);
        c.setLayout(null);
        InvalidDealer=new JLabel("Dealer not found!!!");
        InvalidDealer.setBounds(120, 240, 270, 30);
        InvalidDealer.setFont(new Font("Arial", Font.BOLD, 16));
        InvalidDealer.setForeground(ErrorText);
        InvalidDealer.setVisible(false);

        c.add(InvalidDealer);
        c.setBounds(120, 70, 70, 70);
        c.setOpaque(false);
        container.add(c);
    }

    //Write button logic here
    private void SetAction() {
        LoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DealerID = DealerIDText.getText();
                if(dAuth.isValidDealer(DealerID)){
                    SearchFrame frame = new SearchFrame(DealerID);
                    setVisible(false);
                }else{
                    InvalidDealer.setVisible(true);
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
        container.setBackground(Back);
        //setUndecorated(true);
        //AWTUtilities.setWindowOpacity(this, (float)(0.86));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class SearchFrame extends JFrame {
    VehiclesSearchResult vehicleObj =new VehiclesSearchResult();
    DealerAuth dAuth=new DealerAuth();

    Container container = getContentPane();
    String DealerName;
    JPanel LeftPanel, RightPanel;
    JRadioButton New, Used, All;
    JButton SearchButton, AddButton, ModifyButton, DeleteButton;
    //String vehicleId;      //need for ModifyCarUI

    //Constructor
    public SearchFrame(String DealerName) {
        container.setLayout(null);
        this.DealerName = DealerName;
        CreateLeftPanel();
        CreateRightPanel();
        ButtonAction();
        SetBackground();
        SetWindow();
    }


    //Create left part panel
    private void CreateLeftPanel() {
        LeftPanel = new JPanel();
        LeftPanel.setLayout(null);

        JPanel LabelPanel = new JPanel();
        LabelPanel.setOpaque(false);
        JLabel CurrentDealerName = new JLabel(DealerName, JLabel.CENTER);
        CurrentDealerName.setFont(new Font("Arial", Font.BOLD, 32));;
        LabelPanel.add(CurrentDealerName);
        LabelPanel.setBounds(0, 120, 640, 60);
        LeftPanel.add(LabelPanel);

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setOpaque(false);
        ButtonPanel.setLayout(null);
        SearchButton = new JButton("Search");
        SearchButton.setFont(new Font("Arial", Font.PLAIN, 20));
        SearchButton.setBounds(260, 0, 120, 40);
        SearchButton.setFocusPainted(false);
        ButtonPanel.add(SearchButton);
        ButtonPanel.setBounds(0, 680, 640, 40);
        LeftPanel.add(ButtonPanel);

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

        JComboBox modelCB = new JComboBox(vehicleObj.getModel().toArray());
        JComboBox makeCB = new JComboBox(vehicleObj.getMake().toArray());
        modelCB.setFocusable(false);
        makeCB.setFocusable(false);
        FilterPanelRight.add(modelCB);
        FilterPanelRight.add(makeCB);
        FilterPanelLeft.setBounds(150, 32, 100, 200);
        FilterPanelRight.setBounds(300, 56, 200, 150);
        FilterPanel.add(FilterPanelLeft);
        FilterPanel.add(FilterPanelRight);
        FilterPanel.setBounds(0, 240, 640, 300);
        LeftPanel.add(FilterPanel);


        JPanel SelectPanel = new JPanel();
        SelectPanel.setOpaque(false);
        SelectPanel.setLayout(new BoxLayout(SelectPanel, BoxLayout.X_AXIS));
        New = new JRadioButton("New");
        Used = new JRadioButton("Used");
        All = new JRadioButton("All");
        New.setFont(new Font("Arial", Font.PLAIN, 16));
        Used.setFont(new Font("Arial", Font.PLAIN, 16));
        All.setFont(new Font("Arial", Font.PLAIN, 16));
        New.setFocusPainted(false);
        Used.setFocusPainted(false);
        All.setFocusPainted(false);
        New.setOpaque(false);
        Used.setOpaque(false);
        All.setOpaque(false);
        ButtonGroup group = new ButtonGroup();
        group.add(New); group.add(Used); group.add(All);
        SelectPanel.add(Box.createHorizontalStrut(117)); SelectPanel.add(New);
        SelectPanel.add(Box.createHorizontalStrut(117)); SelectPanel.add(Used);
        SelectPanel.add(Box.createHorizontalStrut(117)); SelectPanel.add(All);
        SelectPanel.setBounds(0, 560, 640, 60);
        LeftPanel.add(SelectPanel);

        LeftPanel.setBounds(0, 0, 640, 900);
        LeftPanel.setOpaque(false);
        container.add(LeftPanel);
    }


    //Create right part panel
    private void CreateRightPanel() {
        RightPanel = new JPanel();
        RightPanel.setOpaque(false);
        RightPanel.setLayout(null);

        JPanel TopList = new JPanel(null);
        TopList.setOpaque(false);
        JPanel List = new JPanel(null);
        List.setLayout(new BoxLayout(List, BoxLayout.Y_AXIS));
        ButtonGroup ListGroup = new ButtonGroup();
        for(int i=1 ; i<16 ; i++){
            ListPanel resultPanel = new ListPanel();
            ListGroup.add(resultPanel.select);
            List.add(resultPanel);
        }
        List.setFont(new Font("Courier New", Font.BOLD ,24));
        JScrollPane ListPane = new JScrollPane(List);
        ListPane.setBounds(50, 20, 800, 600);
        TopList.add(ListPane);

        JPanel Buttons = new JPanel(new GridLayout(1,3, 100, 20));
        Buttons.setOpaque(false);
        AddButton = new JButton("Add");
        AddButton.setFont(new Font("Arial", Font.PLAIN, 16));
        ModifyButton = new JButton("Modify");
        ModifyButton.setFont(new Font("Arial", Font.PLAIN, 16));
        DeleteButton = new JButton("Delete");
        DeleteButton.setFont(new Font("Arial", Font.PLAIN, 16));
        AddButton.setFocusPainted(false);
        ModifyButton.setFocusPainted(false);
        DeleteButton.setFocusPainted(false);
        Buttons.add(AddButton);
        Buttons.add(ModifyButton);
        Buttons.add(DeleteButton);

        TopList.setBounds(30, 60, 900, 640);
        Buttons.setBounds(200, 720, 560, 50);

        RightPanel.add(TopList);
        RightPanel.add(Buttons);
        RightPanel.setBounds(640, 0, 960, 900);
        container.add(RightPanel);
    }

    //Write search button logic here
    private void ButtonAction() {
        SearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
          });

//        AddButton.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                System.out.println("add button");
//
//            }
//        });
        DeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new DeleteCarUI();
                //dispose();
            }

        });

        AddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new AddCarUI();
                //dispose();
            }

        });
        
        
        /*
         * need a parameter(String vehicleId) for ModifyCarUI's constructer.
           We can create an attribute in SearchFrame, to store the vehicleId which user click on,
           Once they click on another vehicle, reset the attribute,
           when they click on ModifyButton, pass it to this method as an attribute
        **/
        ModifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new ModifyCarUI("V1");  
                //dispose();
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
    JLabel resultVehicleID, resultPrice, resultLocation, resultMake, resultYear, resultMileage, resultCondition;
    JRadioButton select;

    public ListPanel() {
        setBorder(BorderFactory.createEmptyBorder(20,10,20,20));
        createComponents();
        addComponents();
    }

    private void createComponents(){
        select = new JRadioButton();
        select.setOpaque(false);
        resultVehicleID = new JLabel("VehicleId: ");
        resultCondition = new JLabel("Condition: ");
        resultLocation = new JLabel("Location: ");
        resultMake = new JLabel("Make: ");
        resultMileage = new JLabel("Mileage: ");
        resultYear = new JLabel("Year: ");
        resultPrice = new JLabel("Price: ");
        select.setPreferredSize(new Dimension(50, 50));
        resultVehicleID.setPreferredSize(new Dimension(100,50));
        resultPrice.setPreferredSize(new Dimension(100,50));
        resultLocation.setPreferredSize(new Dimension(150,50));
        resultMileage.setPreferredSize(new Dimension(150,50));
        resultCondition.setPreferredSize(new Dimension(150,50));
        resultYear.setPreferredSize(new Dimension(100,50));
        resultMake.setPreferredSize(new Dimension(100,50));
    }
    private void addComponents(){
        add(select);
        add(resultVehicleID);
        add(resultPrice);
        add(resultCondition);
        add(resultMake);
        add(resultYear);
        add(resultMileage);
        add(resultLocation);
    }
}

class ModifyCarDetails extends JDialog {
    public ModifyCarDetails() {
        new CarDetailUI();
    }
}