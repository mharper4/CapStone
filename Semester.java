/*
Adding Semester
        Add a semester concept so that courses happen in a semester (eg Fall 2024).
        Be sure Professor can be assigned to a course in a specific semester. Student
        enroll and unenroll takes semesters into account. Waitlist continues to work.
        Using GUI allow professors to be assigned to courses and be able to generate a
        list of all courses a named professor is assigned for a certain semester.
        Sort the list by course name and number.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class Semester {
    private String semName; // Possible Semester name
    private List<Course> courses; // Courses offered in this semester
    private Registry studentRegistry; //
    //private List<Professor> professors; // New: List of professors assigned to this semester
    private String name;

    public Semester(String semName, Registry studentRegistry) {
        this.semName = semName;
        this.courses = new ArrayList<>();
        this.studentRegistry = studentRegistry;
        //this.professors = new ArrayList<>();
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public boolean enrollStudent(int studentID, Course course) {
        Student student = studentRegistry.getStudentByID(studentID);
        if (student != null && courses.contains(course)) {
            course.enrollStudents(student);
            return true;
        }
        return false;
    }

    // Method to get the list of courses for the semester
    public List<Course> getCourses() {
        return courses;
    }

    // Method to get the semester name
    public String getSemName() {
        return semName;
    }

    public String getName() {
        return name;
    }

    public List<Course> findCoursesByProfessor(Professor professor) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getInstructor().equals(professor)) {
                result.add(course);
            }
        }
        result.sort((c1, c2) -> {
            int nameCmp = c1.getName().compareTo(c2.getName());
            return nameCmp != 0 ? nameCmp : Integer.compare(c1.getNumber(), c2.getNumber());
        });
        return result;
    }

    public static void main(String[] args) {
        // Create professors
        Professor professorOne = new Professor("Prof. Naomi Fisher");
        Professor professorTwo = new Professor("Dr. Joseph Simpson");
        Professor professorThree = new Professor("Prof. Alice Weinreb");

        // Define courses
        Course MATH101 = new Course("Mathematics", "MATH101", 101, 4);
        Course MATH202 = new Course("Mathematics", "MATH202", 104, 4);
        Course ETHICS110 = new Course("Ethics", "ETHICS110", 110, 4);
        Course ETHICS210 = new Course("Ethics", "PHYS210", 210, 4);
        Course CHEM101 = new Course("Chemistry", "CHEM101", 103, 4);
        Course CHEM202 = new Course("Chemistry", "CHEM202", 206, 4);

        // Assign professors to courses
        //Math
        MATH101.addInstructor(professorOne);
        MATH202.addInstructor(professorOne);

        //Ethics
        ETHICS110.addInstructor(professorTwo);
        ETHICS210.addInstructor(professorTwo);

        //Chemistry
        CHEM101.addInstructor(professorThree);
        CHEM202.addInstructor(professorThree);

        //Create the semester
        Registry registry = new Registry();
        Semester fall2023 = new Semester("Fall 2023", registry);
        fall2023.addCourse(MATH101);
        fall2023.addCourse(MATH202);
        fall2023.addCourse(ETHICS110);
        fall2023.addCourse(ETHICS210);
        fall2023.addCourse(CHEM101);
        fall2023.addCourse(CHEM202);

        Professor professorFour = new Professor("Prof. Patricia Ramos");
        Professor professorFive = new Professor("Dr. Alexander Washington");
        Professor professorSix = new Professor("Prof. London Hill");

        // New courses for Spring 2024
        Course ART101 = new Course("Art History", "ART101", 201, 3);
        Course COMP101 = new Course("Economics", "COMP101", 202, 4);
        Course HIST101 = new Course("English Literature", "HIST101", 203, 3);

        // Assign professors to new courses
        ART101.addInstructor(professorFour);
        COMP101.addInstructor(professorFive);
        HIST101.addInstructor(professorSix);

        // Create the Spring 2024 semester and add courses
        Registry registry2 = new Registry();
        Semester spring2024 = new Semester("Spring 2024", registry2);
        spring2024.addCourse(ART101);
        spring2024.addCourse(COMP101);
        spring2024.addCourse(HIST101);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Are You Classified as a Professor?( type yes or no)");
        String isProfessor = scanner.nextLine();

        if (!isProfessor.equalsIgnoreCase("yes")) {
            System.out.println("This Program is only Accessible to Professors.");
            return;
        }

        System.out.println("Enter Your Name:");
        String name = scanner.nextLine();

        System.out.println("Enter The Semester Interested in ('Fall 2023' OR 'Spring 2024'):");
        String semName = scanner.nextLine();

        // Identify the professor
        Professor professor = null;
        if (name.equalsIgnoreCase(professorOne.getName())) {
            professor = professorOne;
        } else if (name.equalsIgnoreCase(professorTwo.getName())) {
            professor = professorTwo;
        } else if (name.equalsIgnoreCase(professorThree.getName())) {
            professor = professorThree;
        }

        if (professor == null) {
            System.out.println("No Professor Was Founded from Name: " + name);
         return;
        }

        // Identify the semester and list courses
        Semester selectedSemester = null;
        if (semName.equalsIgnoreCase("Fall 2023")) {
            selectedSemester = fall2023;
        } else if (semName.equalsIgnoreCase("Spring 2024")) {
            selectedSemester = spring2024;
        }

        if (selectedSemester == null) {
            System.out.println("No Data is Available for The Semester: " + semName);
           return;
        }

        List<Course> courses = selectedSemester.findCoursesByProfessor(professor);
        System.out.println("Courses Taught By " + name + " within " + semName + ":");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }
}


