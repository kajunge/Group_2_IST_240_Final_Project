
import javax.swing.ImageIcon;

public class Student {

    String _firstName;
    String _lastName;
    int _age;
    int _score = 0;

    public int getScore() {
        return _score;
    }

    public void setScore(int _score) {
        this._score = _score;
    }
    ImageIcon randomImage;

    public Student(String firstName, String lastName, int age) {
        super();
        _firstName = firstName;
        _lastName = lastName;
        _age = age;
    }

    String getInfo() {
        return "NAME = " + _firstName + " " + _lastName + "  "
                + "Age = " + _age;
    }

    String getName() {
        return _firstName + " " + _lastName;
    }

    String whatsUp() {
        double randomNum = Math.random();
        int myNumber = (int) (randomNum * 3f);
        String answer = "I don't know";

        if (myNumber == 0) {
            answer = "searching the web";
        }
        if (myNumber == 1) {
            answer = "doing Java";
        }
        if (myNumber == 2) {
            answer = "Listening to endless lecture";
        }
        return answer;
    }

    public void setImage() {
        int randomNum = (int) (Math.random() * 5) + 1;

        if (randomNum == 1) {
            randomImage = new ImageIcon("images/minipirate1.png");
        }
        if (randomNum == 2) {
            randomImage = new ImageIcon("images/minifarmer1.png");
        }
        if (randomNum == 3) {
            randomImage = new ImageIcon("images/miniengineer1.png");
        }
        if (randomNum == 4) {
            randomImage = new ImageIcon("images/psulion.jpg");
        }
        if (randomNum == 5) {
            randomImage = new ImageIcon("images/peach.png");
        }
    }

}
