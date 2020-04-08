
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class MyJFrame extends JFrame implements ActionListener {

    Student st1;

    // images
    ImageIcon pirateImage = new ImageIcon("images/pirate1.png");
    ImageIcon engineerImage = new ImageIcon("images/engineer1.png");
    ImageIcon farmerImage = new ImageIcon("images/farmer1.png");
    ImageIcon disabledImage = new ImageIcon("images/greenCheck.png");
    ImageIcon miniPirateImage = new ImageIcon("images/minipirate1.png");
    ImageIcon miniEngineerImage = new ImageIcon("images/miniengineer1.png");
    ImageIcon miniFarmerImage = new ImageIcon("images/minifarmer1.png");
    ImageIcon wcDisabledImage = new ImageIcon("images/wc.jpg");

    // various panels
    HomeJPanel hp1 = new HomeJPanel();
    CharacterJPanel cjp = new CharacterJPanel(hp1);
    MapJPanel mjp = new MapJPanel();
    InstructionsJPanel ip1 = new InstructionsJPanel();
    DesignersJPanel dp1 = new DesignersJPanel();
    HighScoresJPanel hsp = new HighScoresJPanel();
    ScoreJPanel sp1 = new ScoreJPanel();

    //timer
    JTextArea message = new JTextArea("Timer");
    JButton start, stop;
    Timer tim;
    int limit = 0;
    int delay = 0;
    int i = 0;
    int tally = 0;

    //score
    JButton score;
    int counter;
    JButton exitButton2;

    //campus panels
    BeaverCampus bjp = new BeaverCampus(cjp);
    DuBoisCampus djp = new DuBoisCampus(cjp);
    HazletonCampus hjp = new HazletonCampus(cjp);
    UniversityPark ujp = new UniversityPark(cjp);
    YorkCampus yjp = new YorkCampus(cjp);
    WorldCampus wjp = new WorldCampus(cjp);

    //user choices
    String userThemeChoice;

    public MyJFrame() {
        super();
        Border raisedBevel = BorderFactory.createBevelBorder(BevelBorder.RAISED,
                new Color(95, 116, 226), new Color(95, 116, 226));

        exitButton2 = new JButton("Click here to close the game.");
        exitButton2.setBounds(new Rectangle(250, 400, 250, 40));
        add(exitButton2);
        exitButton2.setVisible(false);
        exitButton2.addActionListener(this);

        //timer code
        //JButton time2 = new JButton("Your time is: "+i);
        //time2.setBounds(new Rectangle(250, 340, 250, 40));
        start = new JButton("start timer");
        stop = new JButton("stop");
        start.addActionListener(this);
        add(start);
        start.setBounds(new Rectangle(10, 150, 100, 30));
        stop.addActionListener(this);
        //add(stop);
        stop.setBounds(new Rectangle(110, 150, 90, 30));
        start.setVisible(true);
        stop.setVisible(true);

        add(message);
        message.setBounds(new Rectangle(20, 180, 100, 20));
        message.setBorder(raisedBevel);
        message.setVisible(true);

        start.setVisible(false);
        stop.setVisible(false);
        message.setVisible(false);

        //end timer code
        //score code
        //counter = 0;
        //counter = counter+15;
        score = new JButton("Score:  0");
        Dimension sSize = score.getPreferredSize();
        score.setBounds(10, 210, sSize.width, sSize.height);
        add(score);
        score.setOpaque(false);
        score.setVisible(false);

        this.mjp = new MapJPanel();

        this.setTitle("IST 240 Final Project Home Page");
        this.add(hp1);
        //message.setVisible(true);
        this.pack();
        this.setResizable(false);
        this.setSize(new Dimension(800, 480));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

//=====================================
// Adds the listeners to the buttons from the other panels      
//=====================================          
        hp1.instructionsButton.addActionListener(this);
        hp1.startButton.addActionListener(this);
        hp1.designersButton.addActionListener(this);
        hp1.exitButton.addActionListener(this);
        hp1.scoresButton.addActionListener(this);
        ip1.returnButton.addActionListener(this);
        ip1.startButton.addActionListener(this);
        dp1.returnButton.addActionListener(this);
        mjp.returnButton.addActionListener(this);
        hsp.returnButton.addActionListener(this);
        //hsp.exitButton.addActionListener(this);
        cjp.returnButton.addActionListener(this);
        cjp.startButton.addActionListener(this);
        cjp.undoButton.addActionListener(this);
        cjp.char1Button.addActionListener(this);
        cjp.char2Button.addActionListener(this);
        cjp.char3Button.addActionListener(this);
        hjp.returnButton.addActionListener(this);

        yjp.start2.addActionListener(this);
        yjp.b2.addActionListener(this);

        bjp.returnButton.addActionListener(this);
        djp.returnButton.addActionListener(this);
        hjp.returnButton.addActionListener(this);
        ujp.returnButton.addActionListener(this);
        yjp.returnButton.addActionListener(this);
        wjp.returnButton.addActionListener(this);

        //campus buttons
        mjp.cbutton1.addActionListener(this);
        mjp.cbutton2.addActionListener(this);
        mjp.cbutton3.addActionListener(this);
        mjp.cbutton4.addActionListener(this);
        mjp.cbutton5.addActionListener(this);
        mjp.cbutton6.addActionListener(this);
        mjp.cbutton6.setEnabled(false);
        mjp.cbutton6.setDisabledIcon(wcDisabledImage);

//        //game over buttons
        bjp.endButton.addActionListener(this);
        ujp.endButton.addActionListener(this);
        wjp.endButton.addActionListener(this);
        hjp.endButton.addActionListener(this);
        djp.endButton.addActionListener(this);
        yjp.b4.addActionListener(this);

        //quit game buttons
        yjp.exit.addActionListener(this);
        ujp.exit.addActionListener(this);
        hjp.exit.addActionListener(this);
        djp.exit.addActionListener(this);
        bjp.exit.addActionListener(this);
        wjp.exit.addActionListener(this);
        hjp.exit.addActionListener(this);

        //finish game button
        wjp.finishGame.addActionListener(this);

        delay = 1000; //milliseconds
        tim = new Timer(delay, this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();

        if (obj == hsp.exitButton) {
            System.exit(0);
        }

        if (obj == hp1.exitButton) {
            System.exit(0);
        }

        if (obj == yjp.exit) {
            System.exit(0);
        }
        if (obj == wjp.exit) {
            System.exit(0);
        }
        if (obj == bjp.exit) {
            System.exit(0);
        }
        if (obj == djp.exit) {
            System.exit(0);
        }
        if (obj == hjp.exit) {
            System.exit(0);
        }
        if (obj == ujp.exit) {
            System.exit(0);
        }
        if (obj == hp1.instructionsButton) {
            hp1.setVisible(false);
            ip1.setVisible(true);
            start.setVisible(false);
            stop.setVisible(false);
            message.setVisible(false);
            score.setVisible(false);
            this.add(ip1);
            this.setTitle("Instructions");
            validate();
        }
        if (obj == ip1.returnButton) {
            ip1.setVisible(false);
            hp1.setVisible(true);
            this.add(hp1);
            this.setTitle("IST 240 Final Project Home Page");
            validate();
        }
        if (obj == ip1.startButton) {
            ip1.setVisible(false);
            mjp.setVisible(false);
            cjp.setVisible(true);
            counter = 0;
            this.add(cjp);
            this.setTitle("Character and Theme Choice");
            validate();
        }
        if (obj == hp1.startButton) {
            hp1.setVisible(false);
            cjp.setVisible(false);
            ip1.setVisible(true);
            //start.setVisible(true);
            this.add(ip1);
            this.setTitle("INSTRUCTIONS");
            validate();
        }
        if (obj == cjp.startButton) {
            cjp.setVisible(false);
            mjp.setVisible(true);
            tim.start();
            message.setVisible(true);
            score.setVisible(false);
            this.add(mjp);
            this.setTitle("Navigate to a Campus - The timer has started - view it in the campuses!");
            validate();
        }
        if (obj == cjp.char1Button) {
            mjp.characterChoice.setIcon(engineerImage);
            mjp.mychoice = "engineer";
            bjp.hintButton.setVisible(true);
            ujp.hintButton.setVisible(true);
            wjp.hintButton.setVisible(true);
            bjp.characterChoice.setIcon(engineerImage);
            djp.characterChoice.setIcon(engineerImage);
            hjp.characterChoice.setIcon(engineerImage);
            ujp.characterChoice.setIcon(engineerImage);
            yjp.characterChoice.setIcon(engineerImage);
            wjp.characterChoice.setIcon(engineerImage);
            validate();
        }
        if (obj == cjp.char2Button) {
            mjp.characterChoice.setIcon(farmerImage);
            mjp.mychoice = "farmer";
            bjp.characterChoice.setIcon(farmerImage);
            bjp.hintButton.setVisible(false);
            djp.characterChoice.setIcon(farmerImage);
            hjp.characterChoice.setIcon(farmerImage);
            ujp.characterChoice.setIcon(farmerImage);
            yjp.characterChoice.setIcon(farmerImage);
            wjp.characterChoice.setIcon(farmerImage);
            validate();
        }
        if (obj == cjp.char3Button) {
            mjp.characterChoice.setIcon(pirateImage);
            mjp.mychoice = "pirate";
            bjp.characterChoice.setIcon(pirateImage);
            bjp.hintButton.setVisible(false);
            djp.characterChoice.setIcon(pirateImage);
            hjp.characterChoice.setIcon(pirateImage);
            ujp.characterChoice.setIcon(pirateImage);
            yjp.characterChoice.setIcon(pirateImage);
            wjp.characterChoice.setIcon(pirateImage);
            validate();
        }
        if (obj == mjp.returnButton) {
            mjp.setVisible(false);
            cjp.setVisible(true);
            start.setVisible(false);
            stop.setVisible(false);
            message.setVisible(false);
            score.setVisible(false);
            this.add(cjp);
            this.setTitle("Character and Theme Choice");
            validate();
        }
        if (obj == cjp.returnButton) {
            cjp.setVisible(false);
            hp1.setVisible(true);
            this.add(hp1);
            this.setTitle("IST 240 Final Project Home Page");
            validate();
        }
        if (obj == hp1.designersButton) {
            hp1.setVisible(false);
            dp1.setVisible(true);
            this.add(dp1);
            this.setTitle("Meet the Designers");
            validate();
        }
        if (obj == dp1.returnButton) {
            dp1.setVisible(false);
            hp1.setVisible(true);
            this.add(hp1);
            this.setTitle("IST 240 Final Project Home Page");
            validate();
        }
        if (obj == hp1.scoresButton) {
            hp1.setVisible(false);
            hsp.setVisible(true);
            this.add(hsp);
            this.setTitle("High Scores");
            validate();
        }
        if (obj == hsp.returnButton) {
            hsp.setVisible(false);
            hp1.setVisible(true);
            this.add(hp1);
            this.setTitle("IST 240 Final Project Home Page");
            validate();
        }
        if (obj == cjp.undoButton) {
            cjp.mainLabel.setVisible(true);
            cjp.nextLabel.setVisible(false);
            cjp.engineerLabel.setVisible(false);
            cjp.farmerLabel.setVisible(false);
            cjp.pirateLabel.setVisible(false);
            cjp.char1Button.setVisible(true);
            cjp.char2Button.setVisible(true);
            cjp.char3Button.setVisible(true);
            cjp.themeList.setVisible(false);
            cjp.startButton.setVisible(false);
            cjp.undoButton.setVisible(false);
            this.setTitle("Character and Theme Choice");
            validate();
        }

//return buttons for campus panels
        if (obj == bjp.returnButton) {
            bjp.setVisible(false);
            mjp.setVisible(true);
            setTitle("Navigate to a Campus - The timer has started - view it in the campuses!");
            this.add(mjp);
            validate();
        }
        if (obj == djp.returnButton) {
            djp.setVisible(false);
            mjp.setVisible(true);
            this.setTitle("Navigate to a Campus - The timer has started - view it in the campuses!");
            this.add(mjp);
            validate();
        }

        if (obj == hjp.returnButton) {
            hjp.setVisible(false);
            mjp.setVisible(true);
            this.setTitle("Navigate to a Campus - The timer has started - view it in the campuses!");
            this.add(mjp);
            validate();
        }

        if (obj == ujp.returnButton) {
            ujp.setVisible(false);
            mjp.setVisible(true);
            this.setTitle("Navigate to a Campus - The timer has started - view it in the campuses!");
            this.add(mjp);
            validate();
        }
        if (obj == yjp.returnButton) {
            yjp.setVisible(false);
            mjp.setVisible(true);
            this.setTitle("Navigate to a Campus - The timer has started - view it in the campuses!");
            this.add(mjp);
            validate();
        }

        if (obj == wjp.returnButton) {
            wjp.setVisible(false);
            mjp.setVisible(true);
            this.setTitle("Navigate to a Campus - The timer has started - view it in the campuses!");
            this.add(mjp);
            validate();
        }
        //switch for campus buttons

        if (obj == mjp.cbutton1) {
            mjp.setVisible(false);
            bjp.setVisible(true);
            bjp.endButton.setText("<html><center>Game Over!<br>"
                    + "Total current score is " + this.setScore(tally)
                    + " points.<br>"
                    + "Click to End.</center></html>");
            this.add(bjp);
            this.setTitle("Beaver Campus game");
            this.bjp.showMessage();
            validate();
        }
        if (obj == mjp.cbutton2) {
            mjp.setVisible(false);
            djp.setVisible(true);
            djp.endButton.setText("<html><center>Game Over!<br>"
                    + "Total current score is " + this.setScore(tally)
                    + " points.<br>"
                    + "Click to End.</center></html>");
            this.add(djp);
            this.setTitle("DuBois Campus game");
            this.djp.showMessage();
            validate();
        }
        if (obj == mjp.cbutton3) {
            mjp.setVisible(false);
            hjp.setVisible(true);
            hjp.endButton.setText("<html><center>Game Over!<br>"
                    + "Total current score is " + this.setScore(tally)
                    + " points.<br>"
                    + "Click to End.</center></html>");
            this.add(hjp);
            this.setTitle("Hazleton Campus game");
            this.hjp.showMessage();
            validate();
        }
        if (obj == mjp.cbutton4) {
            mjp.setVisible(false);
            ujp.setVisible(true);
            ujp.endButton.setText("<html><center>Game Over!<br>"
                    + "Total current score is " + this.setScore(tally)
                    + " points.<br>"
                    + "Click to End.</center></html>");
            this.add(ujp);
            this.setTitle("University Park Campus game");
            this.ujp.showMessage();
            validate();
        }
        if (obj == mjp.cbutton5) {
            mjp.setVisible(false);
            yjp.setVisible(true);
            yjp.b4.setText("<html><center>Game Over!<br>"
                    + "Total current score is " + this.setScore(tally)
                    + " points.<br>"
                    + "Click to End.</center></html>");
            this.add(yjp);
            this.setTitle("York Campus game");
            this.yjp.showMessage();
            validate();
        }
        if (obj == mjp.cbutton6) {
            mjp.setVisible(false);
            wjp.setVisible(true);
            this.add(wjp);
            this.setTitle("World Campus game");
            this.wjp.showMessage();
            validate();
        }
        if (obj == bjp.endButton) {
            bjp.setVisible(false);
            this.add(mjp);
            this.setTitle(userThemeChoice);
            mjp.setVisible(true);
            mjp.cbutton1.setEnabled(false);
            mjp.cbutton1.setDisabledIcon(disabledImage);
            mjp.cbutton1.setBorderPainted(false);
            mjp.cbutton1.setFocusPainted(false);
            mjp.cbutton1.setVisible(true);
        }
        if (obj == djp.endButton) {
            djp.setVisible(false);
            this.add(mjp);
            this.setTitle(userThemeChoice);
            mjp.setVisible(true);
            mjp.cbutton2.setEnabled(false);
            mjp.cbutton2.setDisabledIcon(disabledImage);
            mjp.cbutton2.setBorderPainted(false);
            mjp.cbutton2.setFocusPainted(false);
            mjp.cbutton2.setVisible(true);
        }
        if (obj == ujp.endButton) {
            ujp.setVisible(false);
            this.add(mjp);
            this.setTitle(userThemeChoice);
            mjp.setVisible(true);
            mjp.cbutton4.setEnabled(false);
            mjp.cbutton4.setDisabledIcon(disabledImage);
            mjp.cbutton4.setBorderPainted(false);
            mjp.cbutton4.setFocusPainted(false);
            mjp.cbutton4.setVisible(true);
        }
        if (obj == wjp.endButton) {
            wjp.setVisible(false);
            this.add(mjp);
            this.setTitle(userThemeChoice);
            mjp.setVisible(true);
            mjp.cbutton6.setEnabled(false);
            mjp.cbutton6.setDisabledIcon(disabledImage);
            mjp.cbutton6.setBorderPainted(false);
            mjp.cbutton6.setFocusPainted(false);
            mjp.cbutton6.setVisible(true);
        }
        if (obj == hjp.endButton) {
            hjp.setVisible(false);
            this.add(mjp);
            this.setTitle(userThemeChoice);
            mjp.setVisible(true);
            mjp.cbutton3.setEnabled(false);
            mjp.cbutton3.setDisabledIcon(disabledImage);
            mjp.cbutton3.setBorderPainted(false);
            mjp.cbutton3.setFocusPainted(false);
            mjp.cbutton3.setVisible(true);
        }
        if (obj == yjp.b4) {
            yjp.setVisible(false);
            this.add(mjp);
            this.setTitle(userThemeChoice);
            mjp.setVisible(true);
            mjp.cbutton5.setEnabled(false);
            mjp.cbutton5.setDisabledIcon(disabledImage);
            mjp.cbutton5.setBorderPainted(false);
            mjp.cbutton5.setFocusPainted(false);
            mjp.cbutton5.setVisible(true);
        }
        if (!mjp.cbutton1.isEnabled() && !mjp.cbutton2.isEnabled()
                && !mjp.cbutton3.isEnabled()
                && !mjp.cbutton4.isEnabled()
                && !mjp.cbutton5.isEnabled()) {
            mjp.cbutton6.setEnabled(true);
        }
        if (obj == wjp.finishGame) {
            wjp.setVisible(false);
            setLayout(null);
            tim.stop();
            this.add(hsp);
            hsp.setVisible(true);
            this.setTitle("Final Score");
            JButton time2 = new JButton("<html><center>Your total time played "
                    + "is:<br>" + i + " seconds</center></html>");
            JButton thanks, score2;
            thanks = new JButton("Thank you for playing!");
            score2 = new JButton("<html><center>Well done! Your Final Score is :<br>"
                    + this.setScore(tally) + " points.");
            time2.setBounds(new Rectangle(250, 200, 250, 40));
            thanks.setBounds(new Rectangle(250, 160, 250, 40));
            score2.setBounds(new Rectangle(250, 240, 250, 40));
            score.setVisible(false);
            message.setVisible(false);
            exitButton2.setVisible(true);
            add(thanks);
            add(score2);
            add(time2);

        }
        if (obj == exitButton2) {
            System.exit(0);
        }

        String choice = e.getActionCommand();
        if (obj == stop) {
            tim.stop();
        }
        if (obj == start) {
            tim.start();
        }

//============================================================		
// every tick of the timer clock will call
        if (obj == tim) {
            i = i + 1;
            message.setText("counting ... " + i);
        }
        revalidate();
        repaint();
    }

    public int setScore(int tally) {

        if (!mjp.cbutton1.isEnabled()) {
            tally = tally + 15;
            System.out.println("current score is: " + tally);
        }
        if (!mjp.cbutton2.isEnabled()) {
            tally = tally + 15;
            System.out.println("current score is: " + tally);
        }
        if (!mjp.cbutton3.isEnabled()) {
            tally = tally + 15;
            System.out.println("current score is: " + tally);
        }
        if (!mjp.cbutton4.isEnabled()) {
            tally = tally + 15;
            System.out.println("current score is: " + tally);
        }
        if (!mjp.cbutton5.isEnabled()) {
            tally = tally + 15;
            System.out.println("current score is: " + tally);
        }
        if (!mjp.cbutton6.isEnabled()) {
            tally = tally + 15;
            System.out.println("current score is: " + tally);
        }
        if (wjp.finishGame.isDisplayable()) {
            tally = tally + 15;
            System.out.println("current score is: " + tally);
        }
        return tally;
    }
}
