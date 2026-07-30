package StudentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager {

    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";       
    private static final String PASSWORD = "bharat@123A";   

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 1. ADD STUDENT (Updated: String parameters for regNo and rollNo)
    public void addStudent(String regNo, String rollNo, String name, String email, String course) {
        String sql = "INSERT INTO students (registration_number, roll_number, name, email, course) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, regNo);
            pstmt.setString(2, rollNo);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.setString(5, course);

            pstmt.executeUpdate();
            System.out.println("✅ Student added successfully to Database!");

        } catch (SQLException e) {
            System.out.println("❌ Error adding student: " + e.getMessage());
        }
    }

    // 2. VIEW ALL STUDENTS
    public void viewStudents() {
        String sql = "SELECT registration_number, roll_number, name, email, course FROM students";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean hasRecords = false;
            System.out.println("\n===== STUDENT LIST =====");

            while (rs.next()) {
                hasRecords = true;
                System.out.println("Reg No: " + rs.getString("registration_number") +
                                   "\nRoll Number: " + rs.getString("roll_number") +
                                   "\nName: " + rs.getString("name") +
                                   "\nEmail: " + rs.getString("email") +
                                   "\nCourse: " + rs.getString("course"));
                System.out.println("----------------------");
            }

            if (!hasRecords) {
                System.out.println("No students found in the database.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching students: " + e.getMessage());
        }
    }

    // 3. SEARCH STUDENT BY ROLL NUMBER (Updated: Accepts String rollNumber)
    public void searchStudent(String rollNumber) {
        String sql = "SELECT registration_number, roll_number, name, email, course FROM students WHERE roll_number = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, rollNumber);
            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    System.out.println("\n✅ Student Found:");
                    System.out.println("Reg No: " + rs.getString("registration_number") +
                                       "\nRoll Number: " + rs.getString("roll_number") +
                                       "\nName: " + rs.getString("name") +
                                       "\nEmail: " + rs.getString("email") +
                                       "\nCourse: " + rs.getString("course"));
                } else {
                    System.out.println("❌ No student found with Roll Number: " + rollNumber);
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Error searching student: " + e.getMessage());
        }
    }

    // 4. DELETE STUDENT BY ROLL NUMBER (Updated: Accepts String rollNumber)
    public void deleteStudent(String rollNumber) {
        String sql = "DELETE FROM students WHERE roll_number = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, rollNumber);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("✅ Student deleted successfully from Database!");
            } else {
                System.out.println("❌ No student found with Roll Number: " + rollNumber);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error deleting student: " + e.getMessage());
        }
    }
}