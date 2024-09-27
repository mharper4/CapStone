/*
    Name: Morgan Harper
    Professor: Hoing
    Date: April 2nd 2024
    Homework: Grocery/Admin combine your programs you both did
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Student extends Person {
    private int studentID;
    private int totalCreditHours;
    private LocalDate DOB;
    private List<Course> courses; // List to maintain courses regardless of semester
    private Map<Semester, List<Course>> semesterCourses; // Map semesters to courses

    public Student(int studentID, String familyName, String givenNames, LocalDate DOB) {
        super(familyName, givenNames, DOB); //(comment it out to see if i can find the bug)
        this.studentID = studentID;
        this.courses = new ArrayList<>();
        this.semesterCourses = new HashMap<>();
    }

    public Student() {
        super();
    }


    public int getStudentId() {
        return studentID;
    }

    // Add course with semester consideration
    public void addCourse(Course course, Semester semester) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudents(this);
            semesterCourses.computeIfAbsent(semester, k -> new ArrayList<>()).add(course);
        }
    }

    public void dropCourse(Course course, Semester semester) {
        if (courses.remove(course)) {
            course.unenrollStudent(this);
            List<Course> semesterCoursesList = semesterCourses.get(semester);
            if (semesterCoursesList != null) {
                semesterCoursesList.remove(course);
            }
        }
    }

    // Get courses for a specific semester
    public List<Course> getCoursesForSemester(Semester semester) {
        return semesterCourses.getOrDefault(semester, new ArrayList<>());
    }

    @Override
    public String toString() {
        return super.toString() + " ID: " ;
    }

//    public Student(Person person, int studentId) {
//        super(person.getFirstName(), person.getLastName());
//        this.studentID = studentId;
//        this.registeredCourses = new TreeSet<>();
//        this.totalCreditHours = 0;
//        //Admin.getInstance().addStudent(this);
//    }


//    public Student(int studentID, String s) {
//    }


//    public Student(String name, int studentI, int creditHOurs, String degree){
//        super(name);
//        this.studentID = getStudentId();
//        this.totalCreditHours = creditHOurs;
//        //this.degree = degree;
//    }



    public int compareTo(Student other) {
        int compareLastName = this.getLastName().compareTo(other.getLastName());
        if (compareLastName != 0) {
            return compareLastName;
        }
        return this.getFirstName().compareTo(other.getFirstName());
    }


//    public void addRegisteredCourse(Course course) {
//        this.registeredCourses.add(course);
//        this.totalCreditHours += course.getCreditHours();
//    }

//    public void addWaitListedCourse(Course course) {
//        this.waitListedCourses.add(course);
//    }

    public int getCreditHours() {
        return this.totalCreditHours;
    }

    //@Override
    public double getDiscount() {
        if (this.totalCreditHours < 30) {
            return 0.05;
        } else if (this.totalCreditHours < 60) {
            return 0.10;
        } else {
            return 0.15;
        }
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.9; // Apply a discount of 10%, assuming for fees or services
    }

//    public double applyMyDiscount() {
//        GroceryList myGroceryList = getGroceryList();
//        if (myGroceryList == null) return 0;
//        double totalCost = myGroceryList.currentBalance();
//        return totalCost * 0.9; // Apply a 10% discount for UnderGrad students
//    }


//    // Helper method to check for duplicate courses
//    private boolean ifDuplicate(Course course) {
//        for (Course c : courses) {
//            if (c.equals(course)) { // Use .equals to compare course objects
//                return false;
//            }
//        }
//        return true;
//    }

    //  public Set<Course> getRegisteredCourses(){
//        return this.registeredCourses;
//    }
}// End of Student


