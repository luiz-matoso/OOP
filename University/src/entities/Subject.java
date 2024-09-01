package entities;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private String name;
    private String code;
    private Teacher teacher;
    private List<Student> enrolledStudents;

    public Subject(String name, String code, Teacher teacher, List<Student> enrolledStudents) {
        this.name = name;
        this.code = code;
        this.teacher = teacher;
        this.enrolledStudents = enrolledStudents;
    }

    public Subject(String name, String code) {
        this.name = name;
        this.code = code;
        this.teacher = null;
        this.enrolledStudents = new ArrayList<>();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}
