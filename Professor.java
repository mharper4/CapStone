/*
    Name: Morgan Harper
    Professor: Hoing
    Date: April 2nd 2024
    Homework: Grocery/Admin combine your programs you both did
 */

/*
 Notes:
       * straightforward class
       * Person class will provide a inherits methods allowing to Professor to act as a Shopper
 */

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String courseTitle;
    private String courseName;
    private String name;
    private ArrayList<Course> courses;
    private List<Semester> semesters;


    public Professor(String name) {
        this.courseTitle = courseTitle;
        this.courseName = courseName;
        this.name = name;
        this.courses = new ArrayList<>();
        this.semesters = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addInstructor(this);
        }
    }

    public void removeCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            // Removes the course from the list.
            course.removeInstructor(this);
        }
    }

    @Override
    public String toString() {
        String result = "Professor: " + courseTitle + " " + courseName + "\n";
        result += "Teaching Courses:\n";
        for (Course course : courses) {
            result += "- " + course.toString() + "\n";
        }
        return result;
    }

    public void addSemester(Semester semester) {
        if (!semesters.contains(semester)) {
            semesters.add(semester);
        }
    }

    public void removeSemester(Semester semester) {
        semesters.remove(semester);
    }

    public List<Course> getCoursesForSemester(Semester semester) {
        List<Course> semesterCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getSemester().equals(semester)) {
                semesterCourses.add(course);
            }
        }
        return semesterCourses;
    }


//do this the for professor only
    public double getDiscountRate() {
        // Implement the logic to calculate the discount for Professor individuals
        // Example: return 0.0 for a 0% discount
        return 0.0; // Assuming a 0% discount for Professor individuals
    }
}// add this to person file no need to submit another file