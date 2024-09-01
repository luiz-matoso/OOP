import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Student;
import entities.Subject;

public class App {

    private static List<Student> students = new ArrayList<>();
    private static List<Subject> subjects = new ArrayList<>();

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        availableSubjects();

        int option = 0;

        while (option != 7) {
            mainMenu();
            System.out.println();
            System.out.print("Select your option: ");
            if (sc.hasNextInt()){
                option = sc.nextInt();
                sc.nextLine();

                switch(option){
                    case 1:
                        enrollStudents(sc);
                        break;
                    case 2:
                        listSubjects();
                        break;
                    case 3:
                        listStudentBySubject(sc);
                        break;
                    case 4:
                        searchSubjects(sc);
                        break;
                    case 5:
                        searchStudents(sc);
                        break;
                    case 6:
                        updateStudentInformation(sc);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }

        sc.close();
    }

    private static void mainMenu(){
        System.out.println("1. Enroll students");
        System.out.println("2. List subjects");
        System.out.println("3. List students (by subject)");
        System.out.println("4. Search subject (by name or code)");
        System.out.println("5. Search student (by name or enrollment number)");
        System.out.println("6. Update student information");
        System.out.println("0. Exit");
    }

    private static void availableSubjects() {
        subjects.add(new Subject("Modelagem de Fenômenos Físicos", "MFF"));
        subjects.add(new Subject("Clinica de TIC", "CT"));
        subjects.add(new Subject("Programação Orientada a Objetos", "POO"));
        subjects.add(new Subject("Segurança da Informação", "SI"));
        subjects.add(new Subject("Performance em Sistemas Ciberfísicos", "PSC"));
        subjects.add(new Subject("Experiência Criativa: Criando Soluções Computacionais", "ECCSC"));
    }

    private static void enrollStudents(Scanner sc){

        System.out.println();
        System.out.print("Student name: ");

        String name = sc.nextLine();
        System.out.print("Enrollment number: ");
        String enrollmentNumber = sc.nextLine();

        System.out.print("Course name: ");
        String course = sc.nextLine();

        System.out.println("Available subjects:");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i));
        }
        System.out.print("Select a subject by number: ");
        int subjectOption = sc.nextInt();
        sc.nextLine();

        if (subjectOption < 1 || subjectOption > subjects.size()) {
            System.out.println("Invalid subject selection.");
            return;
        }

        Subject selectedSubject = subjects.get(subjectOption - 1);

        Student student = new Student(name, enrollmentNumber, course);
        students.add(student);
        selectedSubject.getEnrolledStudents().add(student);
        System.out.println("Student successfully enrolled in " + selectedSubject.getName() + "!");
        System.out.println();
    }

    private static void listSubjects() {
        System.out.println();
        System.out.println("Available subjects:");
        for (Subject subject : subjects){
            System.out.println(subject);
        }
        System.out.println();
    }

    private static void listStudentBySubject(Scanner sc){
        System.out.println("Avaible subjects codes: MFF, CT, POO, SI, PSC, ECCSC");
        System.out.print("Enter the subject code: ");
        String subjectCode = sc.nextLine();

        Subject subject = null;
        for (Subject subj : subjects) {
            if (subj.getCode().equalsIgnoreCase(subjectCode)) {
                subject = subj;
                break;
            }
        }

        if (subject == null) {
            System.out.println("Subject not found!.");
            return;
        }

        List<Student> enrolledStudents = subject.getEnrolledStudents();
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled in " + subject.getName() + ".");
        } else {
            System.out.println("Students enrolled in " + subject.getName() + ":");
            for (Student student : enrolledStudents) {
                System.out.println(student);
            }
        }
        System.out.println();
    }

    private static void searchSubjects(Scanner sc){
        System.out.println("Search subjects");
        System.out.print("Enter the subject code or name: ");
        String subjectCodeOrName = sc.nextLine().trim();

        Subject subject = null;
        for (Subject subj : subjects) {
            if (subj.getCode().equalsIgnoreCase(subjectCodeOrName) || subj.getName().equalsIgnoreCase(subjectCodeOrName)) {
                subject = subj;
                break;
            }
        }

        if (subject == null) {
            System.out.println("Subject not found!.");
        } else {
            System.out.println("Subject found:");
            System.out.println("Name: " + subject.getName());
            System.out.println("Code: " + subject.getCode());
        }
        System.out.println();
    }

    private static void searchStudents(Scanner sc){
        System.out.println("Search students");
        System.out.print("Enter the student name or enrollment code: ");
        String studentCodeOrName = sc.nextLine().trim();

        Student student = null;
        for (Student std : students){
            if (std.getEnrollmentNumber().equals(studentCodeOrName) || std.getName().equalsIgnoreCase(studentCodeOrName)){
                student = std;
                break;
            }
        }

        if (student == null){
            System.out.println("Student not found!");
        } else{
            System.out.println("Student found:");
            System.out.println("Enrollment number: " + student.getEnrollmentNumber());
            System.out.println("Name: " + student.getName());
            System.out.println("Course: " + student.getCourse());
        }
        System.out.println();
    }

    private static void updateStudentInformation(Scanner sc){
        System.out.print("Enter the student enrollment number to update: ");
        String enrollmentNumber = sc.nextLine();

        Student student = null;
        for (Student std : students){
            if (std.getEnrollmentNumber().equals(enrollmentNumber)){
                student = std;
                break;
            }
        }

        if (student == null){
            System.out.println("Student not foudn!");
            return;
        }

        System.out.println("Updating information for: " + student);
        System.out.print("Enter new name (leave blank to keep the same): ");
        String newName = sc.nextLine();

        if (!newName.isEmpty()){
            student.setName(newName);
        }

        System.out.print("Enter new course (leave blank to keep the same): ");
        String newCourse = sc.nextLine();

        if (!newCourse.isEmpty()){
            student.setCourse(newCourse);
        }

        System.out.println("Student information updated sucessfully!");


    }
}
