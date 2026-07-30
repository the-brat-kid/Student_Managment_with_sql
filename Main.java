package StudentManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter Registration Number: ");
                    String regNo = sc.nextLine();

                    System.out.print("Enter Roll Number: ");
                    String rollNo = sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    manager.addStudent(regNo, rollNo, name, email, course);
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Search: ");
                    String searchRollNumber = sc.nextLine();

                    manager.searchStudent(searchRollNumber);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Delete: ");
                    String deleteRollNumber = sc.nextLine(); 

                    manager.deleteStudent(deleteRollNumber);
                    break;

                case 5:
                    System.out.println("Exiting Student Management System...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice! Please enter a valid option.");
            }
        }
    }
}