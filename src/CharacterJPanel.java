
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.border.*;

public class CharacterJPanel extends JPanel implements Accessible, ActionListener {

    HomeJPanel hjp;
    MapJPanel mjp;
    JLabel mainLabel, nextLabel, bannerLabel, char1Label, char2Label,
            char3Label, chosenChar, chosenTheme;
    JButton returnButton, char1Button, char2Button, char3Button, startButton,
            undoButton;
    JLabel engineerLabel, pirateLabel, farmerLabel;
    ImageIcon goImage = new ImageIcon("images/go.png");
    ImageIcon returnImage = new ImageIcon("images/return.png");
    ImageIcon bannerImage = new ImageIcon("images/lion.jpg");
    ImageIcon pirateImage = new ImageIcon("images/pirate1.png");
    ImageIcon engineerImage = new ImageIcon("images/engineer1.png");
    ImageIcon farmerImage = new ImageIcon("images/farmer1.png");
    ImageIcon undoImage = new ImageIcon("images/undo.png");

    String[] themeStrings = new String[]{"Choose One", "PSU Football", "PSU Math Club",
        "PSU Travellers Club"};
    JComboBox<String> themeList = new JComboBox<>(themeStrings);
    String myThemeChoice, x;
    JLabel themeChoice = new JLabel();
    JLabel welcomeMsg = new JLabel();

    public CharacterJPanel(HomeJPanel importedHomeJPanel) {
        super();

        hjp = importedHomeJPanel;

        setLayout(null);

//=====================================
// Sets up the panel       
//=====================================  
        setLayout(null);
        this.setBackground(new Color(242, 242, 242));
//=====================================
// Establishes font for main label and dev labels      
//===================================== 
        Font mainLabelFont = new Font("Audrey", Font.BOLD, 28);
        Font charLabelFont = new Font("Audrey", Font.BOLD, 15);
        Font devLabelFont = new Font("Courier", Font.PLAIN, 12);
        Border raisedBevel = BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(95, 116, 226), new Color(95, 116, 226));

//=====================================
// Creates the label heading     
//=====================================         
        mainLabel = new JLabel();
        mainLabel.setText("First: Choose your character wisely!");
        mainLabel.setFont(mainLabelFont);
        mainLabel.setForeground(new Color(95, 116, 226));
        Dimension size = mainLabel.getPreferredSize();
        mainLabel.setBounds(100, 70, size.width, size.height);
        add(mainLabel);
        mainLabel.setVisible(true);

        welcomeMsg = new JLabel();
        welcomeMsg.setText("                            ");
        welcomeMsg.setFont(mainLabelFont);
        welcomeMsg.setForeground(new Color(95, 116, 226));
        add(welcomeMsg);
        welcomeMsg.setVisible(true);
//=====================================
// Creates the character choice labels 
//===================================== 
        engineerLabel = new JLabel();
        engineerLabel.setText("<html><center>You chose the engineer.<br>She"
                + " represents the year (1882) in which Penn State<br>expanded "
                + "into engineering programs.<br>"
                + "She may give you hints along the way.</center></html>");
        engineerLabel.setFont(charLabelFont);
        engineerLabel.setForeground(Color.BLACK);
        Dimension engLabSize = engineerLabel.getPreferredSize();
        engineerLabel.setBounds(200, 145, engLabSize.width, engLabSize.height);
        add(engineerLabel);
        engineerLabel.setVisible(false);

        farmerLabel = new JLabel();
        farmerLabel.setText("<html><center>You chose the farmer.<br>He"
                + " is representative of Penn State's early beginnings.</center>"
                + "</html>");
        farmerLabel.setFont(charLabelFont);
        farmerLabel.setForeground(Color.BLACK);
        Dimension farmLabSize = farmerLabel.getPreferredSize();
        farmerLabel.setBounds(200, 145, farmLabSize.width, farmLabSize.height);
        add(farmerLabel);
        farmerLabel.setVisible(false);

        pirateLabel = new JLabel();
        pirateLabel.setText("<html><center>You chose the pirate.<br>"
                + "The pirate, well, he is just for fun!<br>"
                + "But, speed games will be difficult!</center></html>");
        pirateLabel.setFont(charLabelFont);
        pirateLabel.setForeground(Color.BLACK);
        Dimension pirLabSize = pirateLabel.getPreferredSize();
        pirateLabel.setBounds(250, 150, pirLabSize.width, pirLabSize.height);
        add(pirateLabel);
        pirateLabel.setVisible(false);

//=====================================
// When the user clicks the start button, this will read
// in the first name and last name information. It will
// also default the age to 1 if nothing is entered
//===================================== 
        hjp.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();
                if (obj == hjp.startButton) {

                    if (hjp.ageTextField.getText().length() > 0) {

                        int result = Integer.parseInt(hjp.ageTextField.getText());
                        Student st1 = new Student(hjp.firstNameTextField.getText(),
                                hjp.lastNameTextField.getText(), result);

                        welcomeMsg.setText("Welcome " + st1.getName() + "!!");
                        Dimension wmsize = welcomeMsg.getPreferredSize();
                        welcomeMsg.setBounds(100, 40, wmsize.width, wmsize.height);
                    } else {
                        int result = 1;
                        Student st1 = new Student(hjp.firstNameTextField.getText(),
                                hjp.lastNameTextField.getText(), result);

                        welcomeMsg.setText("Welcome " + st1.getName() + "!!");
                        Dimension wmsize = welcomeMsg.getPreferredSize();
                        welcomeMsg.setBounds(100, 40, wmsize.width, wmsize.height);
                    }
                }
            }
        });

        nextLabel = new JLabel();
        nextLabel.setText("Next: Choose a theme.");
        nextLabel.setFont(mainLabelFont);
        nextLabel.setForeground(new Color(95, 116, 226));
        Dimension nextSize = nextLabel.getPreferredSize();
        nextLabel.setBounds(100, 70, nextSize.width, nextSize.height);
        add(nextLabel);
        nextLabel.setVisible(false);

//=====================================
// Creates character buttons     
//=====================================  
        char1Button = new JButton();
        char1Button.setIcon(engineerImage);
        Dimension char1BSize = char1Button.getPreferredSize();
        char1Button.setBounds(200, 240, 115, 150);
        char1Button.setVerticalTextPosition(SwingConstants.TOP);
        char1Button.setHorizontalTextPosition(SwingConstants.CENTER);
        char1Button.setText("The Engineer");
        add(char1Button);
        char1Button.setVisible(true);
        char1Button.addActionListener(this);

        char2Button = new JButton();
        char2Button.setIcon(farmerImage);
        Dimension char2BSize = char2Button.getPreferredSize();
        char2Button.setBounds(350, 240, 115, 150);
        char2Button.setVerticalTextPosition(SwingConstants.TOP);
        char2Button.setHorizontalTextPosition(SwingConstants.CENTER);
        char2Button.setText("The Farmer");
        add(char2Button);
        char2Button.setVisible(true);
        char2Button.addActionListener(this);

        char3Button = new JButton();
        char3Button.setIcon(pirateImage);
        Dimension char3BSize = char3Button.getPreferredSize();
        char3Button.setBounds(500, 240, 115, 150);
        char3Button.setVerticalTextPosition(SwingConstants.TOP);
        char3Button.setHorizontalTextPosition(SwingConstants.CENTER);
        char3Button.setText("The Pirate");
        add(char3Button);
        char3Button.setVisible(true);
        char3Button.addActionListener(this);

//=====================================
// Add the theme choice combobox    
//=====================================  
        themeList.setEditable(false);
        themeList.setSelectedIndex(2);
        Dimension themeListSize = themeList.getPreferredSize();
        themeList.setBounds(350, 400, themeListSize.width, themeListSize.height);
        add(themeList);
        themeList.setVisible(false);

//=====================================
// Add the theme choice combobox ItemListener and records state changes
//=====================================  
        themeList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    e.getItem();

                    String x = String.valueOf(themeList.getSelectedItem());
                    int themePos = themeList.getSelectedIndex();

                    if (themePos == 1) {
                        System.out.println(x);
                        myThemeChoice = x;
                        startButton.setVisible(true);
                    }
                    if (themePos == 2) {
                        System.out.println(x);
                        myThemeChoice = x;
                        startButton.setVisible(true);
                    }
                    if (themePos == 3) {
                        System.out.println(x);
                        myThemeChoice = x;
                        startButton.setVisible(true);
                    }

                }
            }
        });
        themeList.setSelectedIndex(0);
//=====================================
// Creates and adds the undo  button  
//=====================================          
        undoButton = new JButton("Undo");
        undoButton.setIcon(undoImage);
        Dimension ubSize = undoButton.getPreferredSize();
        undoButton.setBounds(525, 400, ubSize.width, ubSize.height);
        add(undoButton);
        undoButton.setVisible(false);

//=====================================
// Creates and adds the begin game button  
//=====================================  
        startButton = new JButton();
        startButton.setIcon(goImage);
        Dimension sbSize = startButton.getPreferredSize();
        startButton.setBounds(630, 300, sbSize.width, sbSize.height);
        add(startButton);
        startButton.setVisible(false);

//=====================================
// Creates and adds the return to home button     
//=====================================          
        returnButton = new JButton("Return");
        returnButton.setBorder(raisedBevel);
        returnButton.setBounds(new Rectangle(640, 400, 125, 50));
        returnButton.setBackground(Color.WHITE);
        returnButton.setIcon(returnImage);
        add(returnButton);
        returnButton.setVisible(true);

//=====================================
// Creates the label heading and adds image       
//=====================================      
        bannerLabel = new JLabel(bannerImage);
        Dimension bSize = bannerLabel.getPreferredSize();
        bannerLabel.setBounds(0, 0, bSize.width, bSize.height);
        add(bannerLabel);
        bannerLabel.setOpaque(false);
        bannerLabel.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == char1Button) {
            engineerLabel.setVisible(true);
            mainLabel.setVisible(false);
            nextLabel.setVisible(true);
            char2Button.setVisible(false);
            char3Button.setVisible(false);
            themeList.setVisible(true);
            undoButton.setVisible(true);
            System.out.println("You chose the engineer");
        }
        if (obj == this.char2Button) {
            farmerLabel.setVisible(true);
            mainLabel.setVisible(false);
            nextLabel.setVisible(true);
            char1Button.setVisible(false);
            char3Button.setVisible(false);
            themeList.setVisible(true);
            undoButton.setVisible(true);
            System.out.println("You chose the farmer");
        }
        if (obj == this.char3Button) {
            pirateLabel.setVisible(true);
            mainLabel.setVisible(false);
            nextLabel.setVisible(true);
            char1Button.setVisible(false);
            char2Button.setVisible(false);
            themeList.setVisible(true);
            undoButton.setVisible(true);
            System.out.println("You chose the pirate");
        }

    }

}
