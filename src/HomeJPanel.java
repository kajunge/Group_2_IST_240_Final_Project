
import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HomeJPanel extends JPanel {

    JButton startButton, instructionsButton, designersButton, exitButton,
            scoresButton;
    ImageIcon backImage = new ImageIcon("images/home1.jpg");
    ImageIcon bannerImage = new ImageIcon("images/Penn_logo_copy.png");
    JLabel bannerLabel, startLabel, stopLabel, nameLabel;
    JLabel backLabel = new JLabel();
    JTextField firstNameTextField, lastNameTextField, ageTextField;
    JLabel firstNameLabel, lastNameLabel, ageLabel;

    public HomeJPanel() {
        super();

//=====================================
// Sets up the panel       
//=====================================         
        setLayout(null);
        this.setBackground(Color.WHITE);
        Font labelFont = new Font("Zapfino", Font.BOLD, 28);
        Border raisedBevel = BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(95, 116, 226), new Color(95, 116, 226));

//=====================================
// Creates the label heading and adds image
// Creates the name of the game label
//===================================== 
        bannerLabel = new JLabel(bannerImage);
        bannerLabel.setBounds(0, 0, 800, 200);
        bannerLabel.setVisible(true);
        add(bannerLabel);

//=====================================
// Creates and adds the buttons       
//=====================================     
        instructionsButton = new JButton("How to Play");
        instructionsButton.setBorder(raisedBevel);
        instructionsButton.setBounds(new Rectangle(140, 400, 125, 50));
        //  add(instructionsButton);

        startButton = new JButton("Start!");
        startButton.setBorder(raisedBevel);
        startButton.setBounds(new Rectangle(486, 270, 125, 50));
        add(startButton);
        startButton.setVisible(true);
        startButton.setEnabled(false);

        designersButton = new JButton("Game Designers");
        designersButton.setBorder(raisedBevel);
        designersButton.setBounds(new Rectangle(515, 400, 125, 50));
        add(designersButton);

        exitButton = new JButton("Exit");
        exitButton.setBorder(raisedBevel);
        exitButton.setBounds(new Rectangle(650, 400, 125, 50));
        add(exitButton);

        scoresButton = new JButton("High Scores");
        scoresButton.setBorder(raisedBevel);
        scoresButton.setBounds(new Rectangle(560, 400, 125, 50));
        //add(scoresButton);

//=====================================
// Creates and adds name and age text fields    
//=====================================          
        firstNameLabel = new JLabel("<html>First Name<br>(required):<html>");
        Dimension fnlSize = firstNameLabel.getPreferredSize();
        firstNameLabel.setBounds(new Rectangle(160, 260, fnlSize.width, fnlSize.height));
        add(firstNameLabel);
        firstNameLabel.setVisible(true);

        firstNameTextField = new JTextField(20);
        firstNameTextField.setBounds(new Rectangle(160, 290, 100, 30));
        add(firstNameTextField);
        firstNameTextField.setVisible(true);

        lastNameLabel = new JLabel("<html>Last Name<br>(required):<html>");
        Dimension lnlSize = lastNameLabel.getPreferredSize();
        lastNameLabel.setBounds(new Rectangle(260, 260, lnlSize.width, lnlSize.height));
        add(lastNameLabel);
        lastNameLabel.setVisible(true);

        lastNameTextField = new JTextField(20);
        lastNameTextField.setBounds(new Rectangle(260, 290, 100, 30));
        add(lastNameTextField);
        lastNameTextField.setVisible(true);

        ageLabel = new JLabel("<html>Age<br>(optional):");
        Dimension ageSize = ageLabel.getPreferredSize();
        ageLabel.setBounds(new Rectangle(360, 260, ageSize.width, ageSize.height));
        add(ageLabel);
        ageLabel.setVisible(true);

        ageTextField = new JTextField(10);
        ageTextField.setEnabled(true);
        ageTextField.setBounds(new Rectangle(360, 290, 100, 30));
        add(ageTextField);
        ageTextField.setVisible(true);

//=====================================
// Creates a document listener on the name text fields.
// Will only enable start button if both first and last
// name are filled in.
//=====================================         
        DocumentListener docListener = new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                updated(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updated(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updated(e);
            }

            private void updated(DocumentEvent e) {
                if (lastNameTextField.getText().length() > 0
                        && firstNameTextField.getText().length() > 0) {
                    startButton.setEnabled(true);
                } else {
                    startButton.setEnabled(false);
                }
            }
        };

        lastNameTextField.getDocument().addDocumentListener(docListener);
        firstNameTextField.getDocument().addDocumentListener(docListener);
    }

}
