
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructionsJPanel extends JPanel {

    XML_240 x2;
    JLabel instructionsLabel, bannerLabel;
    ImageIcon returnImage = new ImageIcon("images/return.png");
    ImageIcon bannerImage = new ImageIcon("images/lion.jpg");
    JButton returnButton, startButton;

    public InstructionsJPanel() {
        super();

//=====================================
// Sets up panel       
//=====================================          
        setLayout(null);
        this.setBackground(Color.WHITE);
        Border raisedBevel = BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(95, 116, 226), new Color(95, 116, 226));
        GridBagConstraints c = new GridBagConstraints();
        //setLayout(null);

//=====================================
        x2 = new XML_240(); // creates the 240 class that reads and writes XML
//=====================================
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        String s8 = "";

        int num = 0;
        x2.openReaderXML("XML_final.xml");
        s1 = (String) x2.ReadObject();
        s2 = (String) x2.ReadObject();
        num = (Integer) x2.ReadObject();//not used
        s3 = (String) x2.ReadObject();
        s4 = (String) x2.ReadObject();
        s5 = (String) x2.ReadObject();
        s6 = (String) x2.ReadObject();
        s7 = (String) x2.ReadObject();
        s8 = (String) x2.ReadObject();

        x2.closeReaderXML();
        //these statements above just open an xml file, read 3 lines in the file, then close it.
        //it is reading the XML file

        JButton b1 = new JButton(s1);
        add(b1);
        b1.setBounds(new Rectangle(0, 0, 800, 50));

        JButton b2 = new JButton(s2);
        add(b2);
        b2.setBounds(new Rectangle(0, 50, 800, 50));

        JButton b3 = new JButton(s3);
        add(b3);
        b3.setBounds(new Rectangle(0, 100, 800, 50));

        JButton b4 = new JButton(s4);
        add(b4);
        b4.setBounds(new Rectangle(0, 150, 800, 50));

        JButton b5 = new JButton(s5);
        add(b5);
        b5.setBounds(new Rectangle(0, 200, 800, 50));

        JButton b6 = new JButton(s6);
        add(b6);
        b6.setBounds(new Rectangle(0, 250, 800, 50));

        JButton b7 = new JButton(s7);
        add(b7);
        b7.setBounds(new Rectangle(0, 300, 800, 50));

        JButton b8 = new JButton(s8);
        add(b8);
        b8.setBounds(new Rectangle(0, 350, 800, 50));

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
        returnButton.setBorder(raisedBevel);
        returnButton.setBounds(new Rectangle(630, 400, 125, 50));
        returnButton.setBackground(Color.WHITE);
        returnButton.setIcon(returnImage);
        returnButton.setOpaque(true);
        add(returnButton);

        //start
        startButton = new JButton("Start!");
        startButton.setBorder(raisedBevel);
        startButton.setBounds(new Rectangle(330, 400, 125, 50));
        startButton.setBackground(Color.WHITE);
        //startButton.setIcon(returnImage);
        startButton.setOpaque(true);
        add(startButton);
    }
}
