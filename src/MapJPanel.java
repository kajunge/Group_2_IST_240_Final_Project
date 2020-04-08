
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class MapJPanel extends JPanel implements ActionListener, KeyListener {

    Timer tm = new Timer(5, this);
    int x = 0, y = 0, velX = 0, velY = 0;

    Student st1;
    CharacterJPanel cjp;
    ImageIcon mapImage = new ImageIcon("images/map2copy.png");
    ImageIcon returnImage = new ImageIcon("images/return.png");
    ImageIcon cbuttonImage = new ImageIcon("images/x.jpg");
    ImageIcon wbuttonImage = new ImageIcon("images/wc.jpg");
    ImageIcon miniPirateImage = new ImageIcon("images/minipirate1.png");
    ImageIcon miniEngineerImage = new ImageIcon("images/miniengineer1.png");
    ImageIcon miniFarmerImage = new ImageIcon("images/minifarmer1.png");
    ImageIcon character = new ImageIcon();
    ImageIcon image = new ImageIcon();
    String mychoice = "";
    JLabel mapLabel = new JLabel();
    JButton returnButton;
    JLabel characterChoice = new JLabel();

    //campus buttons
    JButton cbutton1;
    JButton cbutton2;
    JButton cbutton3;
    JButton cbutton4;
    JButton cbutton5;
    JButton cbutton6;

    public MapJPanel() {
        super();

//=====================================
// Creates the label heading and provides some guidance        
//=====================================   
        setLayout(null);
        this.setBackground(Color.WHITE);
        Border raisedBevel = BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(95, 116, 226), new Color(95, 116, 226));

//=====================================
// Creates and adds the return to home buttons      
//===================================== 
        returnButton = new JButton("Return");
        returnButton.setBounds(new Rectangle(630, 400, 125, 50));
        returnButton.setBorder(raisedBevel);
        returnButton.setBackground(Color.WHITE);
        returnButton.setIcon(returnImage);
        returnButton.setOpaque(true);
        add(returnButton);

//=====================================
// Adds the buttons for campuses        
//=====================================   
        cbutton1 = new JButton();
        cbutton1.setBounds(new Rectangle(10, 260, 40, 40));
        cbutton1.setIcon(cbuttonImage);
        cbutton1.setOpaque(true);
        add(cbutton1);

        cbutton2 = new JButton();
        cbutton2.setBounds(new Rectangle(225, 175, 40, 40));
        cbutton2.setIcon(cbuttonImage);
        cbutton2.setOpaque(true);
        add(cbutton2);

        cbutton3 = new JButton();
        cbutton3.setBounds(new Rectangle(600, 200, 40, 40));
        cbutton3.setIcon(cbuttonImage);
        cbutton3.setOpaque(true);
        add(cbutton3);

        cbutton4 = new JButton();
        cbutton4.setBounds(new Rectangle(345, 245, 40, 40));
        cbutton4.setIcon(cbuttonImage);
        cbutton4.setOpaque(true);
        add(cbutton4);

        cbutton5 = new JButton();
        cbutton5.setBounds(new Rectangle(510, 390, 40, 40));
        cbutton5.setIcon(cbuttonImage);
        cbutton5.setOpaque(true);
        add(cbutton5);

        cbutton6 = new JButton();
        cbutton6.setBounds(new Rectangle(630, 0, 165, 120));
        cbutton6.setIcon(wbuttonImage);
        cbutton6.setOpaque(true);
        add(cbutton6);

//=====================================
// Creates the label for character and theme selection       
//===================================== 
        characterChoice.setText("");
        characterChoice.setBounds(20, 10, 100, 150);
        add(characterChoice);
        characterChoice.setVisible(true);

//=====================================
// Creates the label with the map background       
//===================================== 
        mapLabel.setIcon(mapImage);
        Dimension size = mapLabel.getPreferredSize();
        mapLabel.setBounds(0, 0, size.width, size.height);
        mapLabel.setVisible(true);
        add(mapLabel);

//=====================================
//  Starts timer for character movement adds the key listener
//=====================================
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        setFocusTraversalKeysEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (x < 0) {
            velX = 0;
            x = 0;
        }
        if (x > 750) {
            velX = 0;
            x = 750;
        }
        if (y < 0) {
            velY = 0;
            y = 0;
        }
        if (y > 420) {
            velY = 0;
            y = 420;
        }

        x = x + velX;
        y = y + velY;

        requestFocus();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT) {
            velX = -3;
            velY = 0;
        }
        if (c == KeyEvent.VK_UP) {
            velX = 0;
            velY = -3;
        }
        if (c == KeyEvent.VK_RIGHT) {
            velX = 3;
            velY = 0;
        }
        if (c == KeyEvent.VK_DOWN) {
            velX = 0;
            velY = 3;
            requestFocus();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        velX = 0;
        velY = 0;
        requestFocus();
    }

    @Override
    public void paintComponent(Graphics g) {
        // create if statements that change the image to the one that the character picked.

        super.paintComponent(g);

        ImageIcon character = this.getCharImage(image);
        character.paintIcon(this, g, x, y);

        //   System.out.println(x + " " + y);
        requestFocus();
        repaint();

    }

    public ImageIcon getCharImage(ImageIcon image) {
        if ("engineer".equals(mychoice)) {
            image = new ImageIcon("images/miniengineer1.png");
        }
        if ("farmer".equals(mychoice)) {
            image = new ImageIcon("images/minifarmer1.png");
        }
        if ("pirate".equals(mychoice)) {
            image = new ImageIcon("images/minipirate1.png");
        }
        return image;
    }

}
