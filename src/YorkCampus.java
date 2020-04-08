
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class YorkCampus extends JPanel implements ActionListener {

    CharacterJPanel cjp;
    MyJFrame mjf;
    JLabel instructionsLabel, bannerLabel;
    JButton returnButton;
    ImageIcon returnImage = new ImageIcon("images/return.png");
    ImageIcon bannerImage = new ImageIcon("images/psu.york.bg.png");
    ImageIcon footballTheme = new ImageIcon("images/newfootball.png");
    ImageIcon travelBackground = new ImageIcon("images/globe.png");
    ImageIcon mathTheme = new ImageIcon("images/math.png");
    ImageIcon travelTheme = new ImageIcon("images/luggage.png");
    JLabel characterChoice = new JLabel();
    JLabel themeLabel = new JLabel();
    JLabel backLabel = new JLabel();
    JButton b2, b3, b4;
    JButton start2, stop, exit;

    Timer tim;
    int limit = 0;
    int delay = 0;
    int count = 0;
    String Student = "";

    public YorkCampus(CharacterJPanel importedCharacterJPanel) {
        super();
        cjp = importedCharacterJPanel;
//=====================================
// Creates the label heading and provides some guidance        
//=====================================           

        setLayout(null);
        this.setBackground(Color.WHITE);
        Border raisedBevel = BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(95, 116, 226), new Color(95, 116, 226));

        //game
        b2 = new JButton(""); //main moving button
        b2.add(new JLabel(""));

        b3 = new JButton("York score");//b3 = score button
        start2 = new JButton("Start");
        start2.addActionListener(this);

        add(b2);

        b2.addActionListener(this);
        JLabel JLabel = new JLabel("");
        b2.add(new JLabel("York Campus Game"));
        b2.setEnabled(false);

        add(b3);
        add(start2);

        Hashtable labelTable = new Hashtable();
        labelTable.put(new Integer(0), new JLabel("Slower"));
        labelTable.put(new Integer(25), new JLabel("Faster"));
        b2.setBounds(new Rectangle(350, 200, 165, 65));
        b3.setBounds(new Rectangle(40, 350, 140, 50));
        start2.setBounds(new Rectangle(180, 350, 140, 50));

        cjp.char1Button.addActionListener(this);
        cjp.char2Button.addActionListener(this);
        cjp.char3Button.addActionListener(this);
//=====================================
// actual delay is set below based on character
// choice
//===================================== 
        delay = 0; //milliseconds
        tim = new Timer(delay, this);// the word 'this' here means that the action listener

//=====================================
// Creates the label for character and theme selection       
//===================================== 
        characterChoice.setText("");
        characterChoice.setBounds(20, 10, 100, 150);
        add(characterChoice);
        characterChoice.setVisible(true);

        themeLabel.setBounds(650, 10, 150, 150);
        add(themeLabel);
        themeLabel.setVisible(true);

        backLabel.setIcon(travelBackground);
        backLabel.setBounds(180, 20, 800, 480);
        add(backLabel);
        backLabel.setOpaque(false);
        backLabel.setVisible(false);
//=====================================
// Creates the label heading and adds image       
//=====================================      
        bannerLabel = new JLabel(bannerImage);
        Dimension bSize = bannerLabel.getPreferredSize();
        bannerLabel.setBounds(170, 0, bSize.width, bSize.height);
        add(bannerLabel);
        bannerLabel.setOpaque(false);
        bannerLabel.setVisible(true);

//=====================================
// Creates and adds the return to home button     
//=====================================          
        returnButton = new JButton("Return");
        returnButton.setBorder(raisedBevel);
        returnButton.setBounds(new Rectangle(640, 400, 125, 50));
        returnButton.setBackground(Color.WHITE);
        add(returnButton);
        returnButton.setIcon(returnImage);
        returnButton.setOpaque(true);

        exit = new JButton("Exit Game");
        exit.setBorder(raisedBevel);
        exit.setBounds(new Rectangle(640, 340, 125, 50));
        exit.setBackground(Color.WHITE);
        add(exit);
        exit.setVisible(true);
        exit.setOpaque(true);

        b4 = new JButton("");
        b4.setOpaque(true);
        Dimension b4Size = b4.getPreferredSize();
        b4.setBounds(new Rectangle(300, 280, 125, 100));
        add(b4);
        b4.setVisible(false);

        cjp.themeList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    e.getItem();

                    int themePos = cjp.themeList.getSelectedIndex();
                    switch (themePos) {
                        case 1:
                            setBackground(new Color(9, 49, 98));
                            themeLabel.setIcon(footballTheme);
                            backLabel.setVisible(false);
                            break;
                        case 2:
                            themeLabel.setIcon(mathTheme);
                            setBackground(new Color(242, 242, 242));
                            backLabel.setVisible(false);
                            break;
                        case 3:
                            themeLabel.setIcon(travelTheme);
                            setBackground(new Color(242, 242, 242));
                            backLabel.setVisible(true);
                            break;
                        default:
                            break;
                    }
                }
            }
        });
        cjp.themeList.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        Object obj = event.getSource();

//=====================================
// This section creates delay based on character chosen    
//=====================================          
        if (obj == cjp.char1Button) {
            delay = 1200;
            tim = new Timer(delay, this);
        } else if (obj == cjp.char2Button) {
            delay = 700;
            tim = new Timer(delay, this);
        } else if (obj == cjp.char3Button) {
            delay = 200;
            tim = new Timer(delay, this);
        }

        String choice = event.getActionCommand();
        if (obj == b2) {
            count++;
            Image img = null;
            String filename = "";
            String Student = " ";
            b3.setText("York Score = " + count);

            if (count == 15) {//stop at 10 or 15
                //add(b4);
                b4.setVisible(true);
                //b4.setBounds(new Rectangle(300, 300, 360, 65));
                tim.stop();
                b3.setVisible(false);
                b2.setVisible(false);

            }
        }

        if (obj == start2) {
            b2.setEnabled(true);
            if (start2.getText().equals("Start")) {
                tim.start();
                start2.setText(" ");
                start2.setVisible(false);
            } else {
                tim.stop();
                start2.setText("Start");
            }
        }
        if (obj == tim) {
            //need random value x and y on the panel
            double x = Math.random();
            int myNumber = (int) ((x * 340) + 200);
            double y = Math.random();
            int myNumber2 = (int) (y * 395);
            b2.setBounds(new Rectangle(myNumber, myNumber2, 165, 65));//set random button location
        }
    }

    public void showMessage() {
        JOptionPane.showMessageDialog(null, "<html><center>Click start to begin.<br>"
                + "To gain points, click on the York Campus Game button.<br>"
                + "The button will move faster or slower based on the chosen character.<br>"
                + "Good Luck!</center></html>");
    }
}
