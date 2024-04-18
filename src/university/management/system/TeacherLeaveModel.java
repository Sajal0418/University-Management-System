package university.management.system;
import java.sql.*;
import java.util.ArrayList;

public class TeacherLeaveModel {
    public ArrayList<String> fetchEmpIds() {
        ArrayList<String> empIds = new ArrayList<>();
        try {
            ResultSet rs = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root", "TgFRYUJ@03")
                    .createStatement().executeQuery("select * from teacher");
            while (rs.next()) {
                empIds.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empIds;
    }

    public void insertLeave(String rollNo, String date, String duration) {
        String query = "insert into teacherleave values('" + rollNo + "', '" + date + "', '" + duration + "')";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root", "TgFRYUJ@03");
            conn.createStatement().executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
