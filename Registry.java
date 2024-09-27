/*
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Registry {
    private List<Person> people;

    public Registry() {
        // Initialize an empty list to store people.
        this.people = new ArrayList<>();
    }

    public void recordPerson(String familyName, String givenName, int day, int month, int year) {
        // Create a new Person object with the provided details and add it to the list.
        Person newPerson = new Person(givenName, familyName, LocalDate.of(year, month, day));
        people.add(newPerson);
    }

    public void recordStudent(String familyName, String givenName, int studentID, int day, int month, int year) {
        // Create a new Student object with the given details
        Student newStudent = new Student(studentID, familyName + " " + givenName);
        // Add the new student to the list of people
        people.add(newStudent);
    }

    public Person getPersonByName(String name) {
        // Retrieve a person by their name (case-insensitive search).
        for (Person person : people) {
            if (person.getFirstName().equalsIgnoreCase(name)) {
                return person;
            }
        }


        return null; // Person not found
    }

    public void recordUnderGradStudent(String familyName, String givenName, int studentID, int day, int month, int year) {
        // Create a new UnderGradStudent object with the provided details and add it to the list.
        UnderGradStudent newStudent = new UnderGradStudent(familyName, givenName, studentID, day, month, year);
        people.add(newStudent);
    }

    public void recordGradStudent(String familyName, String givenName, int studentID, int day, int month, int year) {
        // Create a new GradStudent object with the provided details and add it to the list.
        GradStudent newStudent = new GradStudent(familyName, givenName, studentID, day, month, year);
        people.add(newStudent);
    }
}// End of Registry
*/


import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Registry {
    private List<Person> people;
    private Map<Integer, List<Course>> studentCourseMap; // Map to keep track of student IDs and their courses


    public Registry() {
        this.people = new LinkedList<>();
        this.studentCourseMap = new HashMap<>();
    }

    public void recordStudent(String familyName, String givenName, int studentID, int day, int month, int year) {
        Student newStudent = new Student(studentID, givenName, familyName, LocalDate.of(year, month, day));
        people.add(newStudent);
        studentCourseMap.put(studentID, new LinkedList<>()); // Initialize an empty list of courses for the new student
    }

    public void recordUnderGradStudent(String familyName, String givenName, int studentID, int day, int month, int year) {
        // Create a new UnderGradStudent object with the provided details and add it to the list.
        UnderGradStudent newStudent = new UnderGradStudent(familyName, givenName, studentID, day, month, year);
        people.add(newStudent);
    }

    public void recordGradStudent(String familyName, String givenName, int studentID, int day, int month, int year) {
        // Create a new GradStudent object with the provided details and add it to the list.
        GradStudent newStudent = new GradStudent(familyName, givenName, studentID, day, month, year);
        people.add(newStudent);
    }

    public void enrollStudentInCourse(int studentID, Course course) {
        if (studentCourseMap.containsKey(studentID)) {
            studentCourseMap.get(studentID).add(course);
            course.enrollStudents(getStudentByID(studentID)); // Assuming Course class has an enrollStudent method
        }
    }

    public void unenrollStudentFromCourse(int studentID, Course course) {
        if (studentCourseMap.containsKey(studentID) && studentCourseMap.get(studentID).contains(course)) {
            studentCourseMap.get(studentID).remove(course);
            course.unenrollStudent(getStudentByID(studentID)); // Assuming Course class has an unenrollStudent method
        }
    }

    public Student getStudentByID(int studentID) {
        return people.stream()
                .filter(p -> p instanceof Student && ((Student) p).getStudentId() == studentID)
                .map(p -> (Student) p)
                .findFirst()
                .orElse(null);
    }

    public List<Course> getCoursesForStudent(int studentID) {
        return studentCourseMap.getOrDefault(studentID, new LinkedList<>());
    }
}



