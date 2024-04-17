package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

// Interface for ClonableLogin
interface ClonableLogin {
    ClonableLogin makeCopy(); // Method to create a shallow copy

    JPasswordField getPasswordPasswordField();

    JTextField getUsernameTextField();
}

// Concrete Prototype Implementation
class LoginPrototype implements ClonableLogin {
    private JTextField usernameField;
    private JPasswordField passwordField;

    // Constructor to initialize username and password fields
    public LoginPrototype(JTextField usernameField, JPasswordField passwordField) {
        this.usernameField = usernameField;
        this.passwordField = passwordField;
    }

    // Method to create a shallow copy of LoginPrototype
    public ClonableLogin makeCopy() {
        return new LoginPrototype(usernameField, passwordField);
    }

    // Getter method for username field
    public JTextField getUsernameTextField() {
        return usernameField;
    }

    // Getter method for password field
    public JPasswordField getPasswordPasswordField() {
        return passwordField;
    }
}

public class Login extends JFrame implements ActionListener {

    JButton login, cancel,register;
    JTextField tfusername;
    JPasswordField tfpassword;
    ClonableLogin loginPrototype; // Reference to ClonableLogin

    Login() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(login);

        // On clicking cancel the login frame should be closed
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(cancel);

        register = new JButton("Register");
        register.setBounds(110, 200, 120, 30);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.white);
        register.addActionListener(this);
        register.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(register);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);// used only when u set layout as null
        add(image);

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);

        // Creating an instance of LoginPrototype with initial state
        loginPrototype = new LoginPrototype(tfusername, tfpassword);
    }

    // Adding functionalities to the buttons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            // Retrieving text fields from loginPrototype object
            JTextField usernameField = loginPrototype.getUsernameTextField();
            JPasswordField passwordField = loginPrototype.getPasswordPasswordField();

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            String query = "select * from login where username = '" + username + "' and password='" + password + "'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
                c.s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }else if(ae.getSource() == register){
            setVisible(false);
            new Register();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
