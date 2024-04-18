package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener {

    private TeacherLeaveView view;
    private TeacherLeaveModel model;

    public TeacherLeave() {
        view = new TeacherLeaveView();
        model = new TeacherLeaveModel();

        view.setEmpIds(model.fetchEmpIds());

        view.addSubmitListener(this);
        view.addCancelListener(this);

        // Ensure proper layout manager and size
        setLayout(new BorderLayout());
        getContentPane().add(view, BorderLayout.CENTER);

        setSize(500, 450); // Adjusted size
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        setTitle("Apply Leave (Teacher)"); // Set title
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view.getSubmitButton()) {
            String rollNo = view.getSelectedEmpId();
            String date = view.getSelectedDate();
            String duration = view.getSelectedDuration();
            model.insertLeave(rollNo, date, duration);
            JOptionPane.showMessageDialog(null, "Leave Confirmed");
            dispose();
        } else if (ae.getSource() == view.getCancelButton()) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}
