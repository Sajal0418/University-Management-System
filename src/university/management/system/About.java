package university.management.system;
import javax.swing.*;
import java.awt.*;

public class About extends JFrame{
    About(){
        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 300, 200);
        add(image);
        
        JLabel heading = new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 35));
        add(heading);

        JLabel label1 = new JLabel("Developed by");
        label1.setBounds(70, 170, 150, 30);
        label1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(label1);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(70, 200, 150, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 21));
        add(lblname);

        JLabel lblsrn = new JLabel("SRN");
        lblsrn.setBounds(250, 200, 150, 30);
        lblsrn.setFont(new Font("serif", Font.BOLD, 21));
        add(lblsrn);

        JLabel usr1 = new JLabel("Sajal Jaiswal");
        usr1.setBounds(70, 230, 150, 30);
        usr1.setFont(new Font("serif", Font.PLAIN, 18));
        add(usr1);

        JLabel srn1 = new JLabel("PES1UG21CS517");
        srn1.setBounds(250, 230, 150, 30);
        srn1.setFont(new Font("serif", Font.PLAIN, 18));
        add(srn1);

        JLabel usr2 = new JLabel("Samar Pratap");
        usr2.setBounds(70, 260, 150, 30);
        usr2.setFont(new Font("serif", Font.PLAIN, 18));
        add(usr2);

        JLabel srn2 = new JLabel("PES1UG21CS522");
        srn2.setBounds(250, 260, 150, 30);
        srn2.setFont(new Font("serif", Font.PLAIN, 18));
        add(srn2);

        JLabel usr3 = new JLabel("Saanvi");
        usr3.setBounds(70, 290, 150, 30);
        usr3.setFont(new Font("serif", Font.PLAIN, 18));
        add(usr3);

        JLabel srn3 = new JLabel("PES1UG21CS930");
        srn3.setBounds(250, 290, 150, 30);
        srn3.setFont(new Font("serif", Font.PLAIN, 18));
        add(srn3);

        JLabel usr4 = new JLabel("Sai Sooraj Ramagiri");
        usr4.setBounds(70, 320, 180, 30);
        usr4.setFont(new Font("serif", Font.PLAIN, 18));
        add(usr4);

        JLabel srn4 = new JLabel("PES1UG21CS515");
        srn4.setBounds(250, 320, 150, 30);
        srn4.setFont(new Font("serif", Font.PLAIN, 18));
        add(srn4);

        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}