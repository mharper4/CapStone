/*
    Name: Morgan Harper
    Professor: Hoing
    Date: April 2nd 2024
    Homework: Grocery/Admin combine your programs you both did
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    private String departmentName;
    private String courseTitle;
    private int courseNumber;
    private int credits;
    private int name;
    private Professor instructor;
    private Semester semester;

    private List<Student> enrolledStudents;
    private List<Student> waitListedStudents;

    private List<Professor> professorEnrolled;

    public Course(String departmentName, String courseTitle, int courseNumber, int credits) {
        this.departmentName = departmentName;
        this.courseTitle = courseTitle;
        this.credits = credits;
        this.courseNumber = courseNumber;
        this.enrolledStudents = new ArrayList<>();
        this.waitListedStudents = new ArrayList<>();
    }

    public Course(String courseTitle, int credits) {
        this.courseTitle = courseTitle;
        this.credits = credits;
        this.enrolledStudents = new ArrayList<>(); // Initialize enrolled list
        this.waitListedStudents = new ArrayList<>(); // Initialize waitListed list
    }

    public void enrollStudents(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void unenrollStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public void addInstructor(Professor professor) {
        if (instructor == null) {
            instructor = professor;
            professor.addCourse(this);
        }
    }

    public void removeInstructor(Professor professor) {
        if (instructor == professor) {
            instructor = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder roster = new StringBuilder(courseTitle + " (" + credits + " credits): ");
        if (enrolledStudents.isEmpty()) {
            roster.append("\nNo students enrolled in the course");
        } else {
            for (Student student : enrolledStudents) {
                roster.append("\nStudent Name: ").append(student.toString());
            }
        }
        return roster.toString();
    }

    public String getName() {
        return courseTitle;
    }

    public int getNumber() {
        return courseNumber;
    }

    public Professor getInstructor() {
        return instructor;
    }



    public Semester getSemester() {
        return semester;
    }
}


