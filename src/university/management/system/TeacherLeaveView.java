package university.management.system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.ArrayList;

public class TeacherLeaveView extends JPanel {
    private Choice cEmpId, ctime;
    private JDateChooser dcdate;
    private JButton submit, cancel;

    public TeacherLeaveView() {
        setLayout(null);

        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblrollno = new JLabel("Select Employee Id");
        lblrollno.setBounds(60, 100, 200, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);

        cEmpId = new Choice();
        cEmpId.setBounds(60, 130, 200, 20);
        add(cEmpId);

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        add(dcdate);

        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
    }

    public void setEmpIds(ArrayList<String> empIds) {
        for (String empId : empIds) {
            cEmpId.add(empId);
        }
    }

    public String getSelectedEmpId() {
        return cEmpId.getSelectedItem();
    }

    public String getSelectedDate() {
        return ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
    }

    public String getSelectedDuration() {
        return ctime.getSelectedItem();
    }

    public JButton getSubmitButton() {
        return submit;
    }

    public JButton getCancelButton() {
        return cancel;
    }

    public void addSubmitListener(ActionListener listener) {
        submit.addActionListener(listener);
    }

    public void addCancelListener(ActionListener listener) {
        cancel.addActionListener(listener);
    }
}
