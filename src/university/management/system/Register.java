package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class Register extends JFrame implements ActionListener{


    JTextField tfusername;
    JPasswordField tfpassword;
    JButton register,login;

    Register(){
        setSize(600, 300);
        setLocation(500, 250);
        setLayout(null);

        JLabel heading=new JLabel("Registration Information");
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setBounds(150, 10, 280, 50);
        add(heading);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(70, 90, 100, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(200, 90, 150, 20);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(70, 140, 100, 20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(200, 140, 150, 20);
        add(tfpassword);

        register = new JButton("Register");
        register.setBounds(110, 200, 120, 30);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.white);
        register.addActionListener(this);
        register.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(register);

        login = new JButton("Cancel");
        login.setBounds(260, 200, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(login);


        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== register){
            String username = tfusername.getText();
            String password=tfpassword.getText();
            try {
                String query="insert into login values('"+username+"','"+password+"')";
                Conn c=new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Registered Successfully");
                setVisible(false);
                new Login();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        }else if(ae.getSource()== login){
            setVisible(false);
            new Login();
    }
}

    public static void main(String[] args) {
        new Register();
    }
}
