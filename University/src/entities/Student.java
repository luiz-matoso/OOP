package entities;

public class Student {

    private String name;
    private String enrollmentNumber;
    private String course;

    public Student(String name, String enrollmentNumber, String course) {
        this.name = name;
        this.enrollmentNumber = enrollmentNumber;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Enrollment number: " + enrollmentNumber + ", Course: " + course;
    }
}
