
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThemesJPanel extends JPanel {

    CharacterJPanel cjp;
    BeaverCampus bjp;
    JLabel instructionsLabel, bannerLabel;
    JButton returnButton;
    ImageIcon returnImage = new ImageIcon("images/return.png");
    ImageIcon footballTheme = new ImageIcon("images/newfootball.png");
    ImageIcon travelBackground = new ImageIcon("images/globe.png");
    ImageIcon mathTheme = new ImageIcon("images/math.png");
    ImageIcon travelTheme = new ImageIcon("images/luggage.png");
    JLabel characterChoice = new JLabel();
    JLabel themeLabel = new JLabel();

    public ThemesJPanel() {

        super();

        cjp.themeList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    e.getItem();

                    //String x = String.valueOf(cjp.themeList.getSelectedItem());
                    int themePos = cjp.themeList.getSelectedIndex();
                    switch (themePos) {
                        case 1:
                            bjp.setBackground(new Color(9, 49, 98));
                            bjp.themeLabel.setIcon(footballTheme);
                            bjp.themeLabel.setBounds(650, 10, 150, 150);
                            bjp.add(themeLabel);
                            bjp.themeLabel.setVisible(true);
                            validate();
                            break;
                        case 2:
                            bjp.themeLabel.setIcon(mathTheme);
                            bjp.setBackground(new Color(190, 196, 206));
                            break;
                        case 3:
                            bjp.themeLabel.setIcon(travelTheme);
                            JLabel backLabel = new JLabel(travelBackground);
                            backLabel.setBounds(0, 20, 800, 480);
                            backLabel.setOpaque(false);
                            backLabel.setVisible(true);
                            bjp.add(backLabel);
                            break;
                        default:
                            break;
                    }
                }
            }

        });
        cjp.themeList.setSelectedIndex(0);
    }

}
