import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Register extends JPanel implements ActionListener {

    private JTextField tf1, tf2;
    private JLabel l1, l2, l3, l4;
    private JPasswordField pwd1, pwd2;
    private JCheckBox jcb1, jcb2;
    private static final Font LABEL_FONT = new Font("Algerian", Font.BOLD, 18);
    private static final Font CHECKBOX_FONT = new Font("Algerian", Font.BOLD, 13);
    private static final Font TFIELD_FONT = new Font("ARIAL", Font.BOLD, 15);
    private static final Font PWD_FONT = new Font("ARIAL", Font.BOLD, 18);
    private static final Color BACKGROUND_COLOR = new Color(0, 0, 63);

    private JLabel addLabel(String text, int x, int y, int z, int w) {
        JLabel label = new JLabel(text, JLabel.RIGHT);
        label.setBounds(x, y, z, w);
        label.setFont(LABEL_FONT);
        label.setForeground(Color.WHITE);
        return label;
    }

    private JTextField addTextField(int x, int y, int z, int w) {
        JTextField textField = new JTextField();
        textField.setFont(TFIELD_FONT);
        textField.setBounds(x, y, z, w);
        return textField;
    }

    private JPasswordField addPwdField(int x, int y, int z, int w) {
        JPasswordField pwdField = new JPasswordField();
        pwdField.setEchoChar('*');
        pwdField.setFont(PWD_FONT);
        pwdField.setBounds(x, y, z, w);
        return pwdField;
    }

    private JCheckBox addCheckBox(String str, int x, int y, int z, int w) {
        JCheckBox checkBox = new JCheckBox(str);
        checkBox.setBounds(x, y, z, w);
        checkBox.setFont(CHECKBOX_FONT);
        checkBox.setBackground(Color.ORANGE);
        checkBox.setForeground(Color.BLACK);
        return checkBox;
    }

    public Register() {
        setLayout(null);
        setBackground(BACKGROUND_COLOR);

        ImageIcon regImage = new ImageIcon("RegImage.jpg");
        JLabel topImg = new JLabel(regImage);
        topImg.setBounds(0, 0, 800, 300);
        add(topImg);

        l1 = addLabel("NAME: ", 70, 320, 260, 30);
        add(l1);
        l2 = addLabel("EMAIL ADDRESS: ", 70, 370, 260, 30);
        add(l2);
        l3 = addLabel("PASSWORD: ", 70, 420, 260, 30);
        add(l3);
        l4 = addLabel("CONFIRM PASSWORD: ", 70, 470, 260, 30);
        add(l4);
        tf1 = addTextField(360, 320, 290, 30);
        add(tf1);
        tf2 = addTextField(360, 370, 290, 30);
        add(tf2);
        pwd1 = addPwdField(360, 420, 225, 30);
        add(pwd1);
        pwd2 = addPwdField(360, 470, 225, 30);
        add(pwd2);
        jcb1 = addCheckBox("SHOW", 585, 420, 65, 30);
        add(jcb1);
        jcb2 = addCheckBox("SHOW", 585, 470, 65, 30);
        add(jcb2);

        jcb1.addActionListener(ae -> {
            JCheckBox c = (JCheckBox) ae.getSource();
            pwd1.setEchoChar(c.isSelected() ? '\u0000' : (Character) UIManager.get("PasswordField.echoChar"));
        });

        jcb2.addActionListener(ae -> {
            JCheckBox c = (JCheckBox) ae.getSource();
            pwd2.setEchoChar(c.isSelected() ? '\u0000' : (Character) UIManager.get("PasswordField.echoChar"));
        });

        JButton b = new JButton("SUBMIT FORM");
        b.setBounds(270, 520, 200, 50);
        b.setBackground(Color.ORANGE);
        b.setForeground(Color.BLACK);
        b.setFont(LABEL_FONT);
        add(b);

        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // You can perform in this way too.. but getText() method is deprecated for
        // JPasswordField
        // String pass1 = (String) pwd1.getText(); // String pass2 = (String)
        // pwd2.getText();
        String pass1 = new String(pwd1.getPassword());
        String pass2 = new String(pwd2.getPassword());

        if (tf1.getText().isEmpty() || tf2.getText().isEmpty() || pass1.isEmpty() || pass2.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "ALL THE MENTIONED FIELDS ARE MANDATORY TO FILL. PLEASE FILL ALL THE FIELDS.", "ERROR DETECTED",
                    JOptionPane.ERROR_MESSAGE);
        } else if (!pass1.equals(pass2)) {
            JOptionPane.showMessageDialog(this, "BOTH THE PASSWORDS DOES NOT MATCH!!", "MISMATCH ERROR",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (pass1.equals(pass2)) {
            String pass = pass1;
            if (pass.length() < 6)
                JOptionPane.showMessageDialog(this, "YOUR PASSWORD IS WEAK", "ALERT", JOptionPane.WARNING_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "YOUR FORM HAS BEEN SUBMITTED SUCCESSFULLY!!", "THANK YOU",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

class Login extends JPanel implements ActionListener {
    JFrame frame;
    private JButton b1, b2;
    private JLabel l1, l2;
    private JTextField tf1;
    private JPasswordField tf2;
    private static final Font LABEL_FONT = new Font("ALGERIAN", Font.BOLD, 20);
    private static final Font TFIELD_FONT = new Font("ARIAL", Font.BOLD, 18);
    private static final Font BTN_FONT = new Font("ARIAL", Font.BOLD, 20);
    private static final Color BTN_BG_COLOR = new Color(21, 27, 141);

    private JLabel addLabel(String STR, int x, int y, int z, int w) {
        JLabel label = new JLabel(STR, JLabel.RIGHT);
        label.setBounds(x, y, z, w);
        label.setFont(LABEL_FONT);
        return label;
    }

    private JTextField addTextField(String str, int x, int y, int z, int w) {
        JTextField textField = new JTextField();
        textField.setToolTipText(str);
        textField.setFont(TFIELD_FONT);
        textField.setBounds(x, y, z, w);
        return textField;
    }

    private JPasswordField addPwdField(int x, int y, int z, int w) {
        JPasswordField pwdField = new JPasswordField();
        pwdField.setEchoChar('*');
        pwdField.setFont(TFIELD_FONT);
        pwdField.setBounds(x, y, z, w);
        return pwdField;
    }

    private JButton addBtn(String str, int x, int y, int z, int w) {
        JButton btn = new JButton(str);
        btn.setBounds(x, y, z, w);
        btn.setBackground(BTN_BG_COLOR);
        btn.setFont(BTN_FONT);
        btn.setForeground(Color.WHITE);
        return btn;
    }

    public Login(JFrame frame) {
        this.frame = frame;
        setLayout(null);

        ImageIcon logImage = new ImageIcon(ClassLoader.getSystemResource("LogImage.jpg"));
        JLabel sideImg = new JLabel(logImage);
        sideImg.setBounds(0, 0, 350, 600);
        add(sideImg);

        Font font = new Font("ARIAL BLACK", Font.BOLD, 35);
        JLabel l = new JLabel("<html><u>USER LOGIN</u></html>");
        l.setForeground(new Color(21, 27, 141));
        l.setBounds(440, 90, 280, 40);
        l.setFont(font);
        add(l);

        l1 = addLabel("USER NAME: ", 360, 210, 150, 30);
        add(l1);

        tf1 = addTextField("Enter your name here", 525, 210, 225, 30);
        add(tf1);

        l2 = addLabel("PASSWORD: ", 360, 310, 150, 30);
        add(l2);

        tf2 = addPwdField(525, 310, 225, 30);
        add(tf2);

        b1 = addBtn("START", 380, 415, 162, 40);
        b1.addActionListener(this);
        add(b1);

        b2 = addBtn("EXIT", 590, 415, 162, 40);
        // b2.addActionListener(e -> {frame.setVisible(false);});
        b2.addActionListener(e -> {
            frame.dispose();
        });
        add(b2);

        setBackground(new Color(254, 110, 131));
        // setBackground(new Color(247,77,101));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (tf1.getText() == null || tf1.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "PLEASE ENTER YOUR NAME", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String name = tf1.getText();
                frame.setVisible(false);
                new Quiz(name);
            }
        }
    }
}

class Notice extends JPanel {
    public Notice() {
        setLayout(null);
        setBackground(Color.WHITE);

        JLabel heading = new JLabel("KINDLY NOTE", JLabel.CENTER);
        heading.setBounds(0, 20, 800, 35);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("ARIAL", Font.BOLD, 28));
        add(heading);

        JLabel l = new JLabel();
        l.setBounds(20, 10, 750, 600);
        l.setFont(new Font("ARIAL", Font.ITALIC + Font.PLAIN, 20));
        l.setText(
            "<html>" +
                "Mental age is about people's intelligence, and it shows how people behave intellectually at a certain age."
                +
                " The result has nothing to do with your Intelligence Quotient (IQ) <br>" +
                "Answer all the questions honestly! :) <br><br>" +
                "DISCLAIMER: <br> ~ This quiz is for entertainment purpose only. The result has nothing to do with your IQ <br><br>"
                +
                "~ Remember that your score doesn't necessarily reflect your mood, intelligence, or behavior." +
                " It is not intended to be a psychological advice of any kind <br><br>" +
                "~ Having a younger mental age doesn't necessarily mean that you're childish or immature. " +
                "Similarly, if you have an older mental age, it doesn't mean that you're too uptight or an old 'fuddy duddy'.<br><br>"
                +
                "<h1>NO MATTER YOUR AGE - CHRONOLOGICAL OR MENTAL - TRY TO EMBRACE IT AND ACCEPT WHO YOU ARE!<h1>"
                +
            "</html>");
        add(l);
    }
}

class Quiz extends JFrame implements ActionListener {
    String userName;
    String questions[][] = new String[10][5]; // 10 rows and 5 columns
    String userAns[][] = new String[10][1];
    String morethan440 = new String(
            "YOUR MENTAL AGE IS MORE THAN 51 YEARS OLD. \n\nYOUR PERSONALITY TRAITS INCLUDE HAVING COMPLETE SELF-AWARENESS OF THINGS YOU WANT IN LIFE NOW. \nYOU ARE USUALLY TOO ENGROSSED IN WORKING FOR WHAT YOU WANT. \nYOU SHOULD TAKE TIME TO ENJOY YOUR LIFE. \nYOU ENJOY LUXURY AND ARE VERY ATTENTIVE TO DETAILS. \nYOU DANCE TO YOUR OWN TUNE. \nYOU ARE WARM, FRIENDLY, AND CARING.");
    String btwn360and440 = new String(
            "YOUR MENTAL AGE IS BETWEEN 36 TO 50 YEARS. \n\nYOUR PERSONALITY TRAITS INCLUDE THINKING, ACTING, AND FEELING LIKE AN ADULT. \nYOU ARE WAY WISER THAN YOUR AGE. \nYOU KNOW WHAT IS DEMANDED OF YOU AND YOU LOOK FORWARD TO FULFILLING YOUR ROLE. \nYOU GIVE IMPORTANCE TO SAFETY AND STABILITY. \nYOU ARE SELF-AWARE OF YOUR LIST OF PRIORITIES. \nYOU WOULD RATHER SKIP PARTIES AND UTILIZE YOUR WEEKENDS TO PUT YOUR LIFE IN ORDER, \nATTEND TO THE NEEDS AND DEMANDS OF YOUR LOVED ONES, AND DO CHORES OF YOUR HOUSE OR BUSINESS.");
    String btwn270and350 = new String(
            "YOUR MENTAL AGE IS BETWEEN 21 TO 35 YEARS. \n\nYOUR PERSONALITY TRAITS INCLUDE BEING AN ADULT AND TAKING FULL RESPONSIBILITY FOR THE CHOICES YOU MAKE. \nYOU LOVE TO DISCOVER WHAT WORKS FOR YOU AND WHAT DOES NOT. \nYOU ENJOY LIFE ONCE YOU HAVE ACHIEVED all YOUR GOALS. \nYOU ARE GOAL-ORIENTED, COURAGEOUS, DRIVEN, AND COMMITTED TO ACHIEVING YOUR GOALS. \nYOU WOULD RATHER SKIP PARTIES AND UTILIZE YOUR WEEKENDS TO EXPLORE, EXPERIMENT, AND DISCOVER NEW THINGS THAT HELP YOU BUILD YOUR CAREER OR LEGACY. \n YOUR BIGGEST FEAR IS USUALLY BEING FINANCIALLY DEPENDENT ON ANYBODY.");
    String btwn180and260 = new String(
            "YOUR MENTAL AGE IS BETWEEN 13 TO 20 YEARS. \n\nYOUR PERSONALITY TRAITS INCLUDE BEING AWARE OF YOUR RESPONSIBILITIES, BUT NOT ALWAYS BEING COMMITTED TO FULFILLING THEM. \nYOU SWAY BETWEEN HAVING FUN AND BEING RESPONSIBLE. \nYOU ARE VERY MOODY LIKE A TEENAGER. \n YOU ARE COURAGEOUS AND NOT SCARED TO TAKE RISKS. \nYOU ARE WITH OUT-OF-BOX THINKING. \nYOU COME UP WITH FRESH AND UNIQUE IDEAS. \nYOU ARE ALSO BOLD AND NOT SCARED TO SPEAK UP YOUR MIND. \nYOU ARE CREATIVE. \nYOU ARE A LEARNER AND OPEN TO NEW LEARNINGS. \nYOU NEED TO LEARN THAT CONSISTENCY IS THE KEY TO SUCCESS, BE IT IN WORK, FAMILY, CAREER, OR ANYTHING.");
    String btwn100and170 = new String(
            "YOUR MENTAL AGE IS BETWEEN  5 TO 12 YEARS. \n\nYOUR PERSONALITY TRAITS INCLUDE FULL OF ENERGY, ENTHUSIASM, CHILDISHNESS, AND JOYFUL. \nYOU TEND TO BE SELF-CENTERED. \nAT TIMES, YOU FAIL TO ACT YOUR AGE IN SITUATIONS THAT DEMAND MATURITY AND PATIENCE. \nEVEN IF YOU ARE AWARE OF YOUR REALITY, YOU CHOSE TO LIVE IN A WORLD OF FANTASIES. \nYOU LOVE TO LIVE FULFILLED LIFE. \nYOU SHOULD AIM TO BECOME MORE CONSCIOUS OF THE CHOICES YOU MAKE.");

    ButtonGroup bg;
    JRadioButton option4, option3, option2, option1;
    JButton next, submit;
    JLabel question;
    private static final Font RADIO_FONT = new Font("ARIAL", Font.PLAIN, 22);

    public static int score = 0;
    public static int count = 0;

    public Quiz(String name) {
        setLayout(new GridLayout(7, 1, 15, 20));
        this.userName = name.toUpperCase();

        question = new JLabel();
        question.setFont(new Font("ARIAL", Font.BOLD, 22));
        add(question);

        option1 = new JRadioButton();
        option1.setFont(RADIO_FONT);

        option2 = new JRadioButton();
        option2.setFont(RADIO_FONT);

        option3 = new JRadioButton();
        option3.setFont(RADIO_FONT);

        option4 = new JRadioButton();
        option4.setFont(RADIO_FONT);

        bg = new ButtonGroup();
        bg.add(option1);
        bg.add(option2);
        bg.add(option3);
        bg.add(option4);

        next = new JButton("NEXT");
        next.setFont(new Font("ARIAL", Font.BOLD, 24));
        next.setBackground(new Color(21, 105, 199));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);

        submit = new JButton("SUBMIT");
        submit.setFont(new Font("ARIAL", Font.BOLD, 24));
        submit.setBackground(new Color(21, 105, 199));
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);
        submit.addActionListener(this);

        add(option1);
        add(option2);
        add(option3);
        add(option4);
        add(next);
        add(submit);

        questions[0][0] = "  01. You see someone fall over in the street. Do you ... >> ";
        questions[0][1] = "Laugh";
        questions[0][2] = "Shake your head and think 'muppet'";
        questions[0][3] = "Thank the heavens it wasn't you";
        questions[0][4] = "Run over to make sure they are OK";

        questions[1][0] = "  02. Do you like to listen to others >> ";
        questions[1][1] = "No";
        questions[1][2] = "Yes, they have more interesting lifes";
        questions[1][3] = "Yes, sometimes, when I care about someone";
        questions[1][4] = "I have to, I can learn a lot of things like that";

        questions[2][0] = "  03. Solve: 5 * (2 * 34) ÷ 6 + 7 - 8 >> ";
        questions[2][1] = "138";
        questions[2][2] = "136";
        questions[2][3] = "139";
        questions[2][4] = "134";

        questions[3][0] = "  04. Did you answered the previous question honestly? >> ";
        questions[3][1] = "I listened to the person sitting to my right";
        questions[3][2] = "I listened to the person sitting to my left";
        questions[3][3] = "No. I just selected randomly";
        questions[3][4] = "Yes";

        questions[4][0] = "  05. What do you love doing the most in your leisure time >> ";
        questions[4][1] = "Netflic";
        questions[4][2] = "Cooking";
        questions[4][3] = "Going out";
        questions[4][4] = "Sleep";

        questions[5][0] = "  06. What new skill would you like to learn? >> ";
        questions[5][1] = "Time Management";
        questions[5][2] = "Drawing/Painting";
        questions[5][3] = "Sport";
        questions[5][4] = "Foreign language";

        questions[6][0] = "  07. What is your biggest fear? >> ";
        questions[6][1] = "Monsters";
        questions[6][2] = "Loneliness";
        questions[6][3] = "Death";
        questions[6][4] = "Nothing!";

        questions[7][0] = "  08. How would you like to celebrate your birthday? >> ";
        questions[7][1] = "It's for kids";
        questions[7][2] = "Birthday games and cakes";
        questions[7][3] = "Partying and traveling";
        questions[7][4] = "Meal with family";

        questions[8][0] = "  09. Do you like being around people >> ";
        questions[8][1] = "Yes";
        questions[8][2] = "No";
        questions[8][3] = "Sometimes";
        questions[8][4] = "It depends on the company";

        questions[9][0] = "  10. Finally, how was this quiz? >> ";
        questions[9][1] = "To tell the truth, I didn't really like it :(";
        questions[9][2] = "Not that great -_-";
        questions[9][3] = "Good";
        questions[9][4] = "Awesome! :)";

        start(count);

        getContentPane().setBackground(Color.WHITE);
        setTitle("IT'S QUIZ TIME!!");
        setVisible(true);
        setSize(800, 650);
        setLocation(350, 80);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            if (bg.getSelection() == null)
                score = score + 0;
            else {
                if (bg.getSelection().getActionCommand() == questions[count][1])
                    score = score + 15;
                if (bg.getSelection().getActionCommand() == questions[count][2])
                    score = score + 30;
                if (bg.getSelection().getActionCommand() == questions[count][3])
                    score = score + 45;
                if (bg.getSelection().getActionCommand() == questions[count][4])
                    score = score + 60;
            }

            count++;
            start(count);

            if (count == 9) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
        }
        if (e.getSource() == submit) {
            JOptionPane.showConfirmDialog(this, "DO YOU REALLY WANT TO SUBMIT?");
            if (score > 440)
                JOptionPane.showMessageDialog(this, userName + ", " + morethan440, "YOUR  SCORE IS " + score,
                        JOptionPane.INFORMATION_MESSAGE);
            else if (score >= 360 && score <= 440)
                JOptionPane.showMessageDialog(this, userName + ", " + btwn360and440, "YOUR  SCORE IS " + score,
                        JOptionPane.INFORMATION_MESSAGE);
            else if (score >= 270 && score <= 350)
                JOptionPane.showMessageDialog(this, userName + ", " + btwn270and350, "YOUR  SCORE IS " + score,
                        JOptionPane.INFORMATION_MESSAGE);
            else if (score >= 180 && score <= 260)
                JOptionPane.showMessageDialog(this, userName + ", " + btwn180and260, "YOUR  SCORE IS " + score,
                        JOptionPane.INFORMATION_MESSAGE);
            else if (score >= 100 && score <= 170)
                JOptionPane.showMessageDialog(this, userName + ", " + btwn100and170, "YOUR  SCORE IS " + score,
                        JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, userName + ", " + ", ASK FOR HELP FROM FAMILY AND FRIENDS >_<",
                        "YOUR  SCORE IS " + score, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void start(int count) {
        question.setText(questions[count][0]);
        option1.setText(questions[count][1]);
        option1.setActionCommand(questions[count][1]);
        option2.setText(questions[count][2]);
        option2.setActionCommand(questions[count][2]);
        option3.setText(questions[count][3]);
        option3.setActionCommand(questions[count][3]);
        option4.setText(questions[count][4]);
        option4.setActionCommand(questions[count][4]);

        bg.clearSelection();
    }
}

public class micro {
    JFrame frame;

    micro() {
        frame = new JFrame();
        frame.setTitle("Microproject");
        frame.setVisible(true);
        frame.setSize(800, 650);
        frame.setLocation(350, 80);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane jtp = new JTabbedPane();
        jtp.setBackground(Color.WHITE);
        jtp.setForeground(Color.BLACK);

        frame.add(jtp, BorderLayout.CENTER);

        jtp.add("REGISTER", new Register());
        jtp.add("NOTICE", new Notice());
        jtp.add("LOGIN", new Login(frame));
    }

    public static void main(String[] args) {
        new micro();
    }
}