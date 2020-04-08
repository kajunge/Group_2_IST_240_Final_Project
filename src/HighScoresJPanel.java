
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class HighScoresJPanel extends JPanel {

    JLabel instructionsLabel, bannerLabel;
    JButton returnButton, exitButton;
    int tally;

    ImageIcon returnImage = new ImageIcon("images/return.png");
    ImageIcon bannerImage = new ImageIcon("images/lion.jpg");
    JLabel themeChoice = new JLabel();

    public HighScoresJPanel() {
        super();

//=====================================
// Creates the label heading and provides some guidance        
//=====================================           
        setLayout(null);
        this.setBackground(Color.WHITE);
        Border raisedBevel = BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(95, 116, 226), new Color(95, 116, 226));

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
        //add(returnButton);

//=====================================
// Creates the label for character and theme selection       
//===================================== 
        themeChoice.setBorder(raisedBevel);
        themeChoice.setText("");

        Dimension charSize = themeChoice.getPreferredSize();
        themeChoice.setBackground(Color.WHITE);
        themeChoice.setForeground(Color.BLACK);

        themeChoice.setBounds(0, 0, 150, 100);
        this.add(themeChoice);
        this.themeChoice.setVisible(true);
        this.themeChoice.setOpaque(true);

        //returnButton.setBounds(new Rectangle(630, 400, 125, 50));
        //
        //
        //time.setBounds(new Rectangle(250, 340, 250, 40));
        //
        //add(time);
    }

}
