
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class DesignersJPanel extends JPanel {

    ImageIcon pirateImage = new ImageIcon("images/pirate.png");
    ImageIcon engineerImage = new ImageIcon("images/engineer.png");
    ImageIcon farmerImage = new ImageIcon("images/farmer.png");
    ImageIcon kImage = new ImageIcon("images/girl.png");
    ImageIcon rImage = new ImageIcon("images/boy2.png");
    ImageIcon tImage = new ImageIcon("images/boy1.png");
    ImageIcon returnImage = new ImageIcon("images/return.png");
    ImageIcon bannerImage = new ImageIcon("images/lion.jpg");
    JLabel mainLabel, kristinaLabel, ryanLabel, tonyLabel, bannerLabel;
    JButton returnButton;

    public DesignersJPanel() {
        super();
//=====================================
// Sets up the panel       
//=====================================  
        setLayout(null);
        this.setBackground(Color.WHITE);
//=====================================
// Establishes font for main label and dev labels      
//===================================== 
        Font mainLabelFont = new Font("Phosphate", Font.BOLD, 28);
        Font devLabelFont = new Font("Courier", Font.PLAIN, 12);
        Border raisedBevel = BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(95, 116, 226), new Color(95, 116, 226));

//=====================================
// Creates the label heading     
//=====================================         
        mainLabel = new JLabel();
        mainLabel.setText("The designers of this game are...");
        mainLabel.setFont(mainLabelFont);
        mainLabel.setForeground(new Color(95, 116, 226));
        Dimension size = mainLabel.getPreferredSize();
        mainLabel.setBounds(200, 80, size.width, size.height);
        add(mainLabel);

//=====================================
// Creates the labels for designers     
//=====================================         
        kristinaLabel = new JLabel();
        kristinaLabel.setIcon(kImage);
        kristinaLabel.setText("<html>Kristina Mantha<br>(kam6564)<html>");
        kristinaLabel.setFont(devLabelFont);
        kristinaLabel.setHorizontalTextPosition(JLabel.RIGHT);
        kristinaLabel.getPreferredSize();
        kristinaLabel.setBounds(50, 200, 300, 200);
        kristinaLabel.setVisible(true);
        add(kristinaLabel);

        tonyLabel = new JLabel();
        tonyLabel.setIcon(tImage);
        tonyLabel.setText("<html>Tony Alessi<br>(aja5608)<html>");
        tonyLabel.setFont(devLabelFont);
        tonyLabel.setHorizontalTextPosition(JLabel.RIGHT);
        tonyLabel.setBounds(310, 200, 300, 200);
        tonyLabel.setOpaque(false);
        tonyLabel.setVisible(true);
        add(tonyLabel);

        ryanLabel = new JLabel();
        ryanLabel.setIcon(rImage);
        ryanLabel.setText("<html>Ryan Noakes<br>(rnn5)<html>");
        ryanLabel.setFont(devLabelFont);
        ryanLabel.setHorizontalTextPosition(JLabel.RIGHT);
        ryanLabel.setBounds(555, 200, 300, 200);
        ryanLabel.setVisible(true);
        add(ryanLabel);

//=====================================
// Creates the label heading and adds image       
//=====================================      
        bannerLabel = new JLabel(bannerImage);
        Dimension bSize = bannerLabel.getPreferredSize();
        bannerLabel.setBounds(0, 0, bSize.width, bSize.height);
        bannerLabel.setOpaque(false);
        bannerLabel.setVisible(true);
        add(bannerLabel);

//=====================================
// Creates and adds the return to home button     
//=====================================          
        returnButton = new JButton("Return");
        returnButton = new JButton("Return");
        returnButton.setBorder(raisedBevel);
        returnButton.setBounds(new Rectangle(630, 400, 125, 50));
        returnButton.setBackground(Color.WHITE);
        returnButton.setIcon(returnImage);
        returnButton.setOpaque(true);
        add(returnButton);

    }
}
