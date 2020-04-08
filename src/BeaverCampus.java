
import java.awt.Color;
import java.awt.Dimension;
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
import java.util.ArrayList;
import javax.swing.JComboBox;

public class BeaverCampus extends JPanel {

    XML_240 x2;

    CharacterJPanel cjp;
    MyJFrame mjf;
    JLabel bannerLabel;
    JButton returnButton, goQuestion2, goQuestion3, goQuestion4, tryAgain,
            hintButton, endButton, exit;
    ImageIcon returnImage = new ImageIcon("images/return.png");
    ImageIcon bannerImage = new ImageIcon("images/psu.beaver.bg.png");
    ImageIcon footballTheme = new ImageIcon("images/newfootball.png");
    ImageIcon travelBackground = new ImageIcon("images/globe.png");
    ImageIcon mathTheme = new ImageIcon("images/math.png");
    ImageIcon travelTheme = new ImageIcon("images/luggage.png");
    JLabel characterChoice = new JLabel();
    JLabel themeLabel = new JLabel();
    JLabel backLabel = new JLabel();
    JLabel questionLabel = new JLabel();
    JLabel q1Label = new JLabel();
    JLabel q2Label = new JLabel();
    JLabel q3Label = new JLabel();
    JLabel q4Label = new JLabel();
    JLabel correct = new JLabel();
    JLabel incorrect = new JLabel();
    JLabel scoreLabel = new JLabel();
    ArrayList<String> questions = new ArrayList();
    ArrayList<String> choices = new ArrayList();
    ArrayList<String> answers = new ArrayList();
    ArrayList<String> choicesList = new ArrayList();

    String[] q1Choices = new String[]{"Choose an Answer"};
    JComboBox<String> q1ChoicesList = new JComboBox<>(q1Choices);
    String[] q2Choices = new String[]{"Choose an Answer"};
    JComboBox<String> q2ChoicesList = new JComboBox<>(q2Choices);
    String[] q3Choices = new String[]{"Choose an Answer"};
    JComboBox<String> q3ChoicesList = new JComboBox<>(q3Choices);
    String[] q4Choices = new String[]{"Choose an Answer"};
    JComboBox<String> q4ChoicesList = new JComboBox<>(q4Choices);

    int i, point, tally;
    float score;

    public BeaverCampus(CharacterJPanel importedCharacterJPanel) {
        super();

        cjp = importedCharacterJPanel;

//=====================================
// Creates the label heading and provides some guidance        
//=====================================           
        setLayout(null);
        setBackground(new Color(242, 242, 242));
        Border raisedBevel = BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(95, 116, 226), new Color(95, 116, 226));

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

//=====================================
// Creates and adds the return to home button
// and end of game button
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
                            questionLabel.setForeground(Color.WHITE);
                            incorrect.setForeground(Color.WHITE);
                            correct.setForeground(Color.WHITE);
                            scoreLabel.setForeground(Color.WHITE);
                            break;
                        case 2:
                            themeLabel.setIcon(mathTheme);
                            setBackground(new Color(242, 242, 242));
                            questionLabel.setForeground(Color.BLACK);
                            incorrect.setForeground(Color.BLACK);
                            correct.setForeground(Color.BLACK);
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
                            questionLabel.setOpaque(false);
                            questionLabel.setForeground(Color.BLACK);
                            incorrect.setForeground(Color.BLACK);
                            correct.setForeground(Color.BLACK);
                            scoreLabel.setForeground(Color.BLACK);
                            q1ChoicesList.setBackground(new Color(242, 242, 242));
                            break;
                        default:
                            break;
                    }
                }
            }
        });
        cjp.themeList.setSelectedIndex(0);

//=====================================
        x2 = new XML_240(); // creates the 240 class that reads and writes XML       
//=====================================

        String question1 = "";
        String question1Choice1 = "";
        String question1Choice2 = "";
        String question1Choice3 = "";
        String question1Choice4 = "";
        String question1Answer = "";
        String question2 = "";
        String question2Choice1 = "";
        String question2Choice2 = "";
        String question2Choice3 = "";
        String question2Choice4 = "";
        String question2Answer = "";
        String question3 = "";
        String question3Choice1 = "";
        String question3Choice2 = "";
        String question3Answer = "";
        String question4 = "";
        String question4Choice1 = "";
        String question4Choice2 = "";
        String question4Choice3 = "";
        String question4Answer = "";

        x2.openReaderXML("beavercampusquiz.xml");
        question1 = (String) x2.ReadObject();
        question1Choice1 = (String) x2.ReadObject();
        question1Choice2 = (String) x2.ReadObject();
        question1Choice3 = (String) x2.ReadObject();
        question1Choice4 = (String) x2.ReadObject();
        question1Answer = (String) x2.ReadObject();
        question2 = (String) x2.ReadObject();
        question2Choice1 = (String) x2.ReadObject();
        question2Choice2 = (String) x2.ReadObject();
        question2Choice3 = (String) x2.ReadObject();
        question2Choice4 = (String) x2.ReadObject();
        question2Answer = (String) x2.ReadObject();
        question3 = (String) x2.ReadObject();
        question3Choice1 = (String) x2.ReadObject();
        question3Choice2 = (String) x2.ReadObject();
        question3Answer = (String) x2.ReadObject();
        question4 = (String) x2.ReadObject();
        question4Choice1 = (String) x2.ReadObject();
        question4Choice2 = (String) x2.ReadObject();
        question4Choice3 = (String) x2.ReadObject();
        question4Answer = (String) x2.ReadObject();
        x2.closeReaderXML();

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);

        choices.add(question1Choice1);
        choices.add(question1Choice2);
        choices.add(question1Choice3);
        choices.add(question1Choice4);
        choices.add(question2Choice1);
        choices.add(question2Choice2);
        choices.add(question2Choice3);
        choices.add(question2Choice4);
        choices.add(question3Choice1);
        choices.add(question3Choice2);
        choices.add(question4Choice1);
        choices.add(question4Choice2);
        choices.add(question4Choice3);

        answers.add(question1Answer);
        answers.add(question2Answer);
        answers.add(question3Answer);
        answers.add(question4Answer);

        correct = new JLabel("CORRECT!");
        Dimension cSize = correct.getPreferredSize();
        correct.setBounds(230, 280, cSize.width, cSize.height);
        add(correct);
        correct.setVisible(false);

        incorrect = new JLabel("INCORRECT!");
        Dimension iSize = incorrect.getPreferredSize();
        incorrect.setBounds(230, 280, iSize.width, iSize.height);
        add(incorrect);
        incorrect.setVisible(false);

        goQuestion2 = new JButton("Next Question");
        Dimension nq1Size = goQuestion2.getPreferredSize();
        goQuestion2.setBounds(300, 275, nq1Size.width, nq1Size.height);
        add(goQuestion2);
        goQuestion2.setVisible(false);

        goQuestion3 = new JButton("Next Question");
        Dimension nq2Size = goQuestion3.getPreferredSize();
        goQuestion3.setBounds(300, 275, nq2Size.width, nq2Size.height);
        add(goQuestion3);
        goQuestion3.setVisible(false);

        goQuestion4 = new JButton("Next Question");
        Dimension nq3Size = goQuestion4.getPreferredSize();
        goQuestion4.setBounds(300, 275, nq3Size.width, nq3Size.height);
        add(goQuestion4);
        goQuestion4.setVisible(false);

        tryAgain = new JButton("Click to Try Again");
        Dimension taSize = tryAgain.getPreferredSize();
        tryAgain.setBounds(325, 275, taSize.width, taSize.height);
        add(tryAgain);
        tryAgain.setVisible(false);

        hintButton = new JButton("Click for Hint");
        Dimension hbSize = hintButton.getPreferredSize();
        hintButton.setBounds(10, 300, hbSize.width, hbSize.height);
        add(hintButton);
        hintButton.setVisible(false);

        questionLabel.setText(questions.get(0));
        Dimension q1Size = questionLabel.getPreferredSize();
        questionLabel.setBounds(200, 200, q1Size.width, q1Size.height);
        add(questionLabel);
        questionLabel.setOpaque(false);
        questionLabel.setVisible(true);
//=====================================
// Add the q1 choice combobox    
//=====================================  
        q1ChoicesList.setEditable(false);
        q1ChoicesList.setSelectedIndex(0);
        q1ChoicesList.addItem(question1Choice1);
        q1ChoicesList.addItem(question1Choice2);
        q1ChoicesList.addItem(question1Choice3);
        q1ChoicesList.addItem(question1Choice4);
        Dimension q1ChoicesListSize = q1ChoicesList.getPreferredSize();
        q1ChoicesList.setBounds(220, 230, q1ChoicesListSize.width, q1ChoicesListSize.height);
        add(q1ChoicesList);
        q1ChoicesList.setVisible(true);
//=====================================
// Add the q2 choice combobox    
//=====================================  
        q2ChoicesList.setEditable(false);
        q2ChoicesList.setSelectedIndex(0);
        q2ChoicesList.addItem(question2Choice1);
        q2ChoicesList.addItem(question2Choice2);
        q2ChoicesList.addItem(question2Choice3);
        q2ChoicesList.addItem(question2Choice4);
        Dimension q2ChoicesListSize = q2ChoicesList.getPreferredSize();
        q2ChoicesList.setBounds(220, 230, q2ChoicesListSize.width, q2ChoicesListSize.height);
        add(q2ChoicesList);
        q2ChoicesList.setVisible(false);
//=====================================
// Add the q3 choice combobox    
//=====================================  
        q3ChoicesList.setEditable(false);
        q3ChoicesList.setSelectedIndex(0);
        q3ChoicesList.addItem(question3Choice1);
        q3ChoicesList.addItem(question3Choice2);
        Dimension q3ChoicesListSize = q3ChoicesList.getPreferredSize();
        q3ChoicesList.setBounds(220, 230, q3ChoicesListSize.width, q3ChoicesListSize.height);
        add(q3ChoicesList);
        q3ChoicesList.setVisible(false);
//=====================================
// Add the q4 choice combobox    
//=====================================  
        q4ChoicesList.setEditable(false);
        q4ChoicesList.setSelectedIndex(0);
        q4ChoicesList.addItem(question4Choice1);
        q4ChoicesList.addItem(question4Choice2);
        q4ChoicesList.addItem(question4Choice3);
        Dimension q4ChoicesListSize = q4ChoicesList.getPreferredSize();
        q4ChoicesList.setBounds(220, 230, q4ChoicesListSize.width, q4ChoicesListSize.height);
        add(q4ChoicesList);
        q4ChoicesList.setVisible(false);

        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();
                if (obj == hintButton) {
                    if (q1ChoicesList.isVisible()) {
                        hintButton.setText("D");
                    }
                    if (q2ChoicesList.isVisible()) {
                        hintButton.setText("B");
                    }
                    if (q3ChoicesList.isVisible()) {
                        hintButton.setText("A");
                    }
                    if (q4ChoicesList.isVisible()) {
                        hintButton.setText("C");
                    }
                }
            }
        });
//=====================================
// Add the question 1 answer combobox ItemListener and records state changes
//=====================================  
        q1ChoicesList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    e.getItem();

                    String x = String.valueOf(q1ChoicesList.getSelectedItem());
                    int choicePos = q1ChoicesList.getSelectedIndex();

                    if (choicePos == 4) {
                        score = (float) (score + 3.75);
                        scoreLabel.setText("Quiz Score: " + score);
                        correct.setVisible(true);
                        q1ChoicesList.setEnabled(false);
                        goQuestion2.setVisible(true);
                        goQuestion2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object obj = e.getSource();
                                if (obj == goQuestion2) {
                                    hintButton.setText("Click for Hint");
                                    questionLabel.setVisible(false);
                                    q1ChoicesList.setVisible(false);
                                    correct.setVisible(false);
                                    questionLabel.setText(questions.get(1));
                                    Dimension q1Size = questionLabel.getPreferredSize();
                                    questionLabel.setBounds(200, 200, q1Size.width, q1Size.height);
                                    questionLabel.setVisible(true);
                                    q2ChoicesList.setVisible(true);
                                    goQuestion2.setVisible(false);
                                }
                            }

                        });

                    } else {
                        correct.setVisible(false);
                        incorrect.setVisible(true);
                        q1ChoicesList.setEnabled(false);
                        tryAgain.setVisible(true);
                        tryAgain.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object obj = e.getSource();
                                if (obj == tryAgain) {
                                    incorrect.setVisible(false);
                                    tryAgain.setVisible(false);
                                    q1ChoicesList.setEnabled(true);
                                }

                            }
                        });
                    }
                }
            }
        });
        q1ChoicesList.setSelectedIndex(0);

//=====================================
// Add the question 2 answer combobox ItemListener and records state changes
//=====================================  
        q2ChoicesList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    e.getItem();

                    String x = String.valueOf(q2ChoicesList.getSelectedItem());
                    int choicePos = q2ChoicesList.getSelectedIndex();

                    if (choicePos == 2) {
                        q2ChoicesList.setEnabled(false);
                        score = (float) (score + 3.75);
                        scoreLabel.setText("Quiz Score: " + score);
                        correct.setVisible(true);
                        goQuestion3.setVisible(true);
                        goQuestion3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object obj = e.getSource();
                                if (obj == goQuestion3) {
                                    hintButton.setText("Click for Hint");
                                    questionLabel.setVisible(false);
                                    q2ChoicesList.setVisible(false);
                                    correct.setVisible(false);
                                    goQuestion3.setVisible(false);
                                    questionLabel.setText(questions.get(2));
                                    Dimension q1Size = questionLabel.getPreferredSize();
                                    questionLabel.setBounds(200, 200, q1Size.width, q1Size.height);
                                    questionLabel.setVisible(true);
                                    q3ChoicesList.setVisible(true);
                                }
                            }

                        });

                    } else {
                        correct.setVisible(false);
                        incorrect.setVisible(true);
                        q2ChoicesList.setEnabled(false);
                        tryAgain.setVisible(true);
                        tryAgain.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object obj = e.getSource();
                                if (obj == tryAgain) {
                                    incorrect.setVisible(false);
                                    tryAgain.setVisible(false);
                                    q2ChoicesList.setEnabled(true);
                                }

                            }
                        });
                    }
                }
            }
        });
        q2ChoicesList.setSelectedIndex(0);

//=====================================
// Add the question 3 answer combobox ItemListener and records state changes
//=====================================  
        q3ChoicesList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    e.getItem();

                    String x = String.valueOf(q3ChoicesList.getSelectedItem());
                    int choicePos = q3ChoicesList.getSelectedIndex();

                    if (choicePos == 1) {
                        q3ChoicesList.setEnabled(false);
                        score = (float) (score + 3.75);
                        scoreLabel.setText("Quiz Score: " + score);
                        correct.setVisible(true);
                        goQuestion4.setVisible(true);
                        goQuestion4.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object obj = e.getSource();
                                if (obj == goQuestion4) {
                                    hintButton.setText("Click for Hint");
                                    questionLabel.setVisible(false);
                                    q3ChoicesList.setVisible(false);
                                    correct.setVisible(false);
                                    goQuestion4.setVisible(false);
                                    questionLabel.setText(questions.get(3));
                                    Dimension q1Size = questionLabel.getPreferredSize();
                                    questionLabel.setBounds(200, 200, q1Size.width, q1Size.height);
                                    questionLabel.setVisible(true);
                                    q4ChoicesList.setVisible(true);
                                }
                            }

                        });
                    } else {
                        correct.setVisible(false);
                        incorrect.setVisible(true);
                        q3ChoicesList.setEnabled(false);
                        tryAgain.setVisible(true);
                        tryAgain.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object obj = e.getSource();
                                if (obj == tryAgain) {
                                    incorrect.setVisible(false);
                                    tryAgain.setVisible(false);
                                    q3ChoicesList.setEnabled(true);
                                }
                            }
                        });
                    }
                }
            }
        });
        q3ChoicesList.setSelectedIndex(0);

//=====================================
// Add the question 4 answer combobox ItemListener and records state changes
//=====================================  
        q4ChoicesList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    e.getItem();

                    String x = String.valueOf(q4ChoicesList.getSelectedItem());
                    int choicePos = q4ChoicesList.getSelectedIndex();

                    if (choicePos == 3) {
                        q4ChoicesList.setEnabled(false);
                        score = (float) (score + 3.75);
                        scoreLabel.setText("Final Score: " + score);
                        correct.setVisible(true);
                        endButton.setVisible(true);
                    } else {
                        correct.setVisible(false);
                        incorrect.setVisible(true);
                        q4ChoicesList.setEnabled(false);
                        tryAgain.setVisible(true);
                        tryAgain.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object obj = e.getSource();
                                if (obj == tryAgain) {
                                    incorrect.setVisible(false);
                                    tryAgain.setVisible(false);
                                    q4ChoicesList.setEnabled(true);
                                }

                            }
                        });
                    }
                }
            }
        });
        q4ChoicesList.setSelectedIndex(0);

    }

    public void showMessage() {
        JOptionPane.showMessageDialog(null, "<html>Answer each question "
                + "correctly to gain points.<html>");
    }

}
