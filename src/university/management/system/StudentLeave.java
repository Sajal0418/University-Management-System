package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

// Factory interface for creating Conn instances
interface ConnFactory {
    Conn createConn(); // Method for creating Conn instances
}

// Concrete factory implementation for creating Conn instances
class ConnFactoryImpl implements ConnFactory {
    public Conn createConn() {
        return new Conn(); // Creating a new instance of Conn
    }
}

public class StudentLeave extends JFrame implements ActionListener {

    Choice crollno, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
    
    // Factory instance to create Conn objects
    private ConnFactory connFactory;
    
    StudentLeave() {
        // Setting up the JFrame
        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        // Creating an instance of the ConnFactoryImpl concrete factory
        connFactory = new ConnFactoryImpl();
        
        // Adding components to the JFrame
        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        // Adding Choice for selecting Roll Number
        JLabel lblrollno = new JLabel("Select Roll Number");
        lblrollno.setBounds(60, 100, 200, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(60, 130, 200, 20);
        add(crollno);
        
        // Populating Choice with Roll Numbers from database
        try {
            Conn c = connFactory.createConn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Adding JDateChooser for selecting Date
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        add(dcdate);
        
        // Adding Choice for selecting Time Duration
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        // Adding Submit Button
        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        // Adding Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    // ActionListener method implementation
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            
            String query = "insert into studentleave values('"+rollno+"', '"+date+"', '"+duration+"')";
            
            try {
                // Using the factory to create an instance of Conn
                Conn c = connFactory.createConn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeave();
    }
}
