import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.LinkedList;

public class Locus {
    // Set to store all courses
    private Set<Course> allCourses = new HashSet<>();
    // Set to store all students
    private Set<Person> allStudents = new HashSet<>();

    // Inner class representing a course
    static class Course {
        private String departmentName;
        private int courseNumber;
        private String givenName;
        private int maxCapacity;
        private Set<String> registeredStudents = new HashSet<>();
        private Set<String> waitlistedStudents = new HashSet<>();

        // Constructor for Course
        public Course(String departmentName, int courseNumber, String givenName, int maxCapacity) {
            this.departmentName = departmentName;
            this.courseNumber = courseNumber;
            this.givenName = givenName;
            this.maxCapacity = maxCapacity;
        }

        // Method to add a student to the course
        public void addStudent(String studentID) {
            if (registeredStudents.size() < maxCapacity) {
                registeredStudents.add(studentID);
            } else {
                waitlistedStudents.add(studentID);
            }
        }

        public boolean removeStudent(String studentID) {
            if (registeredStudents.remove(studentID)) {
                considerWaitlistedStudent();
                return true;
            }
            return waitlistedStudents.remove(studentID);
        }

        private void considerWaitlistedStudent() {
            if (!waitlistedStudents.isEmpty()) {
                String firstWaitlisted = waitlistedStudents.iterator().next();
                registeredStudents.add(firstWaitlisted);
                waitlistedStudents.remove(firstWaitlisted);
            }
        }

        @Override
        public String toString() {
            return String.format("[%s %d (%s) Registered: %s]", departmentName, courseNumber, givenName, registeredStudents);
        }
    }
    // Method to record a new course
    public void recordCourse(String departmentName, int courseNumber, String givenName, int maxCapacity) {
        Course newCourse = new Course(departmentName, courseNumber, givenName, maxCapacity);
        allCourses.add(newCourse);
    }

    public void enrollStudents(String studentID, String departmentName, int courseNumber) {
        Course course = locateCourse(departmentName, courseNumber);
        if (course != null) {
            course.addStudent(studentID);
        }
    }

    // Method to remove a student from a course
    public boolean removeStudent(String studentID, String departmentName, int courseNumber) {
        Course course = locateCourse(departmentName, courseNumber);
        return course != null && course.removeStudent(studentID);
    }

    private Course locateCourse(String departmentName, int courseNumber) {
        return allCourses.stream()
                .filter(c -> c.departmentName.equals(departmentName) && c.courseNumber == courseNumber)
                .findFirst()
                .orElse(null);
    }

    // Method to generate a report of all registered students
    public List<String> reportRegistrations() {
        List<String> registrationReport = new LinkedList<>();
        for (Course course : allCourses) {
            String registeredStudents = course.registeredStudents.isEmpty() ? "" : course.registeredStudents.toString();
            registrationReport.add("[" + course.departmentName + " " + course.courseNumber + " (" + course.givenName + ")  " + registeredStudents + "]\n");
        }
        return registrationReport;
    }

    // Override toString method to display all courses after some drop
    @Override
    public String toString() {
        return "Courses:\n" + reportRegistrations();
    }
}// End of Locus