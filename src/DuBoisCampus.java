
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class DuBoisCampus extends JPanel {

    CharacterJPanel cjp;

    JButton buttons[];
    JButton[] transistors = new JButton[5];
    JButton[] barn = new JButton[5];
    JButton[] pirateShip = new JButton[5];
    ImageIcon miniEngineer = new ImageIcon("images/miniengineer1.png");
    ImageIcon miniPirate = new ImageIcon("images/minipirate1.png");
    ImageIcon miniFarmer = new ImageIcon("images/minifarmer1.png");
    ImageIcon transistor = new ImageIcon("images/eng.png");
    ImageIcon barnImage = new ImageIcon("images/barn.png");
    ImageIcon pirateShipImage = new ImageIcon("images/pirateship.png");
    ImageIcon xImage = new ImageIcon("images/false.png");
    JLabel characterChoice = new JLabel();
    JLabel themeLabel = new JLabel();
    JLabel backLabel = new JLabel();
    JLabel scoreLabel = new JLabel();
    JLabel instructionsLabel, bannerLabel;
    JButton returnButton, goToFarmer, goToPirate, incorrect, exit, endButton;
    ImageIcon returnImage = new ImageIcon("images/return.png");
    ImageIcon bannerImage = new ImageIcon("images/psu.dubois.bg.png");
    ImageIcon footballTheme = new ImageIcon("images/newfootball.png");
    ImageIcon travelBackground = new ImageIcon("images/globe.png");
    ImageIcon mathTheme = new ImageIcon("images/math.png");
    ImageIcon travelTheme = new ImageIcon("images/luggage.png");
    int i = 0, score;

    public DuBoisCampus(CharacterJPanel importedCharacterJPanel) {
        super();

//=====================================
// Creates the label heading and provides some guidance        
//=====================================           
        setLayout(null);
        setBackground(new Color(242, 242, 242));
        Border raisedBevel = BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(95, 116, 226), new Color(95, 116, 226));
        cjp = importedCharacterJPanel;

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
// Creates and adds the return to home button     
//=====================================          
        returnButton = new JButton("Return");
        returnButton.setBorder(raisedBevel);
        returnButton.setBounds(new Rectangle(640, 400, 125, 50));
        returnButton.setBackground(Color.WHITE);
        returnButton.setIcon(returnImage);
        add(returnButton);
        returnButton.setOpaque(true);

        exit = new JButton("Exit Game");
        exit.setBorder(raisedBevel);
        exit.setBounds(new Rectangle(640, 340, 125, 50));
        exit.setBackground(Color.WHITE);
        add(exit);
        exit.setVisible(true);
        exit.setOpaque(true);

        endButton = new JButton("");
        endButton.setBorder(raisedBevel);
        endButton.setBounds(new Rectangle(300, 280, 125, 90));
        endButton.setBackground(Color.WHITE);
        endButton.setOpaque(true);
        add(endButton);
        endButton.setVisible(false);
//=====================================
// Creates the label heading and adds image       
//=====================================      
        bannerLabel = new JLabel(bannerImage);
        Dimension bSize = bannerLabel.getPreferredSize();
        bannerLabel.setBounds(180, 0, bSize.width, bSize.height);
        add(bannerLabel);
        bannerLabel.setOpaque(false);
        bannerLabel.setVisible(true);

        score = 0;
        scoreLabel = new JLabel("Quiz Score: " + score);
        Dimension slSize = scoreLabel.getPreferredSize();
        scoreLabel.setBounds(20, 250, 150, 30);
        add(scoreLabel);
        scoreLabel.setVisible(true);

        incorrect = new JButton("<html><center>Try Again</center></html>");
        Dimension iSize = incorrect.getPreferredSize();
        incorrect.setBounds(320, 400, iSize.width, iSize.height);
        add(incorrect);
        incorrect.setVisible(false);
        incorrect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();
                if (obj == incorrect) {

                    incorrect.setVisible(false);
                }
            }

        });

        cjp.themeList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    e.getItem();

                    int choicePos = cjp.themeList.getSelectedIndex();
                    switch (choicePos) {
                        case 1:
                            setBackground(new Color(9, 49, 98));
                            themeLabel.setIcon(footballTheme);
                            backLabel.setVisible(false);
                            incorrect.setForeground(Color.black);
                            incorrect.setBackground(Color.WHITE);
                            goToFarmer.setForeground(Color.black);
                            goToFarmer.setBackground(Color.WHITE);
                            goToPirate.setForeground(Color.black);
                            goToPirate.setBackground(Color.WHITE);
                            scoreLabel.setForeground(Color.WHITE);
                            break;
                        case 2:
                            themeLabel.setIcon(mathTheme);
                            setBackground(new Color(242, 242, 242));
                            //questionLabel.setForeground(Color.BLACK);
                            incorrect.setForeground(Color.BLACK);
                            goToFarmer.setForeground(Color.BLACK);
                            goToPirate.setForeground(Color.BLACK);
                            scoreLabel.setForeground(Color.BLACK);
                            backLabel.setVisible(false);
                            break;
                        case 3:
                            setBackground(new Color(242, 242, 242));
                            themeLabel.setIcon(travelTheme);
                            backLabel.setBounds(180, 20, 800, 480);
                            backLabel.setIcon(travelBackground);
                            add(backLabel);
                            backLabel.setVisible(true);
                            incorrect.setForeground(Color.BLACK);
                            goToFarmer.setForeground(Color.BLACK);
                            goToPirate.setForeground(Color.BLACK);
                            scoreLabel.setForeground(Color.BLACK);
                            break;
                        default:
                            break;
                    }
                }
            }
        });
        cjp.themeList.setSelectedIndex(0);

        for (int i = 0; i < transistors.length; i++) {
            int x = this.randXPoint();
            int y = this.randYPoint();

            transistors[i] = new JButton();
            transistors[i].setIcon(transistor);
            transistors[i].setBounds(x, y, 80, 80);
            add(transistors[i]);
            transistors[i].setOpaque(false);
            transistors[i].setEnabled(true);
            transistors[i].setBorderPainted(false);
            transistors[i].setFocusPainted(false);
            transistors[i].setVisible(true);

            transistors[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Object obj = e.getSource();

                    if (obj == transistors[2]) {
                        score = score + 5;
                        scoreLabel.setText("Quiz Score: " + score);
                        goToFarmer.setVisible(false);
                        incorrect.setVisible(false);
                        transistors[2].setDisabledIcon(miniEngineer);
                        transistors[2].setVisible(true);
                        transistors[0].setVisible(false);
                        transistors[1].setVisible(false);
                        transistors[3].setVisible(false);
                        transistors[4].setVisible(false);
                        transistors[2].setEnabled(false);
                        goToFarmer.setVisible(true);
                        incorrect.setVisible(false);
                        revalidate();
                        repaint();
                    }
                    if (obj == transistors[0]) {
                        transistors[0].setDisabledIcon(xImage);
                        transistors[0].setVisible(true);
                        transistors[0].setEnabled(false);
                        incorrect.setVisible(true);
                        goToFarmer.setVisible(false);
                    }
                    if (obj == transistors[1]) {
                        transistors[1].setDisabledIcon(xImage);
                        transistors[1].setVisible(true);
                        transistors[1].setEnabled(false);
                        incorrect.setVisible(true);
                        goToFarmer.setVisible(false);
                    }
                    if (obj == transistors[3]) {
                        transistors[3].setDisabledIcon(xImage);
                        transistors[3].setVisible(true);
                        transistors[3].setEnabled(false);
                        incorrect.setVisible(true);
                        goToFarmer.setVisible(false);
                    }
                    if (obj == transistors[4]) {
                        transistors[4].setDisabledIcon(xImage);
                        transistors[4].setVisible(true);
                        transistors[4].setEnabled(false);
                        incorrect.setVisible(true);
                        goToFarmer.setVisible(false);
                    }

                }
            });
        }
        goToFarmer = new JButton("<html><center>Correct!<br>Now find the "
                + "Farmer.</center></html>");
        Dimension cSize = goToFarmer.getPreferredSize();
        goToFarmer.setBounds(320, 400, cSize.width, cSize.height);
        add(goToFarmer);
        goToFarmer.setVisible(false);
        goToFarmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();

                if (obj == goToFarmer) {
                    goToFarmer.setVisible(false);
                    for (int i = 0; i < transistors.length; i++) {

                        transistors[i].setVisible(false);
                    }
                    for (int j = 0; j < barn.length; j++) {

                        barn[j].setVisible(true);
                    }
                }
            }
        });

        for (int i = 0; i < barn.length; i++) {
            int x = this.randXPoint();
            int y = this.randYPoint();
            barn[i] = new JButton();
            barn[i].setIcon(barnImage);
            barn[i].setBounds(x, y, 80, 80);
            add(barn[i]);
            barn[i].setOpaque(false);
            barn[i].setEnabled(true);
            barn[i].setBorderPainted(false);
            barn[i].setFocusPainted(false);
            barn[i].setVisible(false);

            barn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Object obj = e.getSource();

                    if (obj == barn[3]) {
                        score = score + 5;
                        scoreLabel.setText("Quiz Score: " + score);
                        barn[3].setDisabledIcon(miniFarmer);
                        barn[3].setVisible(true);
                        barn[3].setEnabled(false);
                        barn[0].setVisible(false);
                        barn[1].setVisible(false);
                        barn[2].setVisible(false);
                        barn[4].setVisible(false);
                        goToPirate.setVisible(true);
                        incorrect.setVisible(false);
                    }
                    if (obj == barn[0]) {
                        barn[0].setDisabledIcon(xImage);
                        barn[0].setVisible(true);
                        barn[0].setEnabled(false);
                        incorrect.setVisible(true);
                        goToPirate.setVisible(false);
                    }
                    if (obj == barn[1]) {
                        barn[1].setDisabledIcon(xImage);
                        barn[1].setVisible(true);
                        barn[1].setEnabled(false);
                        incorrect.setVisible(true);
                        goToPirate.setVisible(false);
                    }
                    if (obj == barn[2]) {
                        barn[2].setDisabledIcon(xImage);
                        barn[2].setVisible(true);
                        barn[2].setEnabled(false);
                        incorrect.setVisible(true);
                        goToPirate.setVisible(false);
                    }
                    if (obj == barn[4]) {
                        barn[4].setDisabledIcon(xImage);
                        barn[4].setVisible(true);
                        barn[4].setEnabled(false);
                        incorrect.setVisible(true);
                        goToPirate.setVisible(false);
                    }
                }
            });
        }

        goToPirate = new JButton("<html><center>Correct!<br>Now find the "
                + "Pirate.</center></html>");
        Dimension pSize = goToPirate.getPreferredSize();
        goToPirate.setBounds(320, 400, pSize.width, pSize.height);
        add(goToPirate);
        goToPirate.setVisible(false);
        goToPirate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();

                if (obj == goToPirate) {
                    goToPirate.setVisible(false);
                    for (int i = 0; i < barn.length; i++) {

                        barn[i].setVisible(false);
                    }
                    for (int j = 0; j < pirateShip.length; j++) {

                        pirateShip[j].setVisible(true);
                    }
                }

            }
        });
        for (int i = 0; i < pirateShip.length; i++) {
            int x = this.randXPoint();
            int y = this.randYPoint();
            pirateShip[i] = new JButton();
            pirateShip[i].setIcon(pirateShipImage);
            pirateShip[i].setBounds(x, y, 80, 80);
            add(pirateShip[i]);
            pirateShip[i].setOpaque(false);
            pirateShip[i].setEnabled(true);
            pirateShip[i].setBorderPainted(false);
            pirateShip[i].setFocusPainted(false);
            pirateShip[i].setVisible(false);

            pirateShip[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Object obj = e.getSource();

                    if (obj == pirateShip[4]) {
                        score = score + 5;
                        scoreLabel.setText("Quiz Score: " + score);
                        pirateShip[4].setDisabledIcon(miniPirate);
                        pirateShip[4].setVisible(true);
                        pirateShip[4].setEnabled(false);
                        pirateShip[0].setVisible(false);
                        pirateShip[1].setVisible(false);
                        pirateShip[2].setVisible(false);
                        pirateShip[3].setVisible(false);
                        endButton.setVisible(true);
                        incorrect.setVisible(false);
                    }
                    if (obj == pirateShip[0]) {
                        pirateShip[0].setDisabledIcon(xImage);
                        pirateShip[0].setVisible(true);
                        pirateShip[0].setEnabled(false);
                        incorrect.setVisible(true);
                        goToPirate.setVisible(false);
                    }
                    if (obj == pirateShip[1]) {
                        pirateShip[1].setDisabledIcon(xImage);
                        pirateShip[1].setVisible(true);
                        pirateShip[1].setEnabled(false);
                        incorrect.setVisible(true);
                        goToPirate.setVisible(false);
                    }
                    if (obj == pirateShip[3]) {
                        pirateShip[3].setDisabledIcon(xImage);
                        pirateShip[3].setVisible(true);
                        pirateShip[3].setEnabled(false);
                        incorrect.setVisible(true);
                        goToPirate.setVisible(false);
                    }
                    if (obj == pirateShip[2]) {
                        pirateShip[2].setDisabledIcon(xImage);
                        pirateShip[2].setVisible(true);
                        pirateShip[2].setEnabled(false);
                        incorrect.setVisible(true);
                        goToPirate.setVisible(false);
                    }
                }
            });
        }
    }

    public int randXPoint() {

        //maximum x value
        int min = 200;

        //minimum x value
        int max = 550;

        // generates x values
        int xValue = (int) (min + Math.random() * (max - min));

        return xValue;
    }

    public int randYPoint() {

        //maximum y value
        int min = 180;

        //minimum y value
        int max = 300;

        // generates y values
        int yValue = (int) (min + Math.random() * (max - min));

        return yValue;
    }

    public void showMessage() {
        JOptionPane.showMessageDialog(null, "<html>Find all the characters!<br>"
                + "They are hiding behind various objects.<html>");
    }
}
