package StudentManagementSystem;

public class Student {

    private String registrationNumber;
    private String name;
    private String rollNumber;
    private String email;
    private String course;

    public Student(String registrationNumber, String name, String rollNumber, String email, String course) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.rollNumber = rollNumber;
        this.email = email;
        this.course = course;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Reg No: " + registrationNumber +
               "\nName: " + name +
               "\nRoll Number: " + rollNumber +
               "\nEmail: " + email +
               "\nCourse: " + course;
    }
}