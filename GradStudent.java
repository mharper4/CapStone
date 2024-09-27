/*
    Name: Morgan Harper
    Professor: Hoing
    Date: April 2nd 2024
    Homework: Grocery/Admin combine your programs you both did
 */
/*
 UnderGrad will inherits its info from Student and implements Shopper (interface).
 --> Constructor: student info
 --> Graduate is going to be person
 --> applying the discount price (10%)
 --> Interface (Shopper) and interitance (underGrad and Grad will extend to student allowing for a good desing for modeling different types of shoppers/students.
 */

/*
public class GradStudent extends Student {

    // Constructor to initialize graduate student-specific attributes
    public GradStudent(String firstName, String lastName, int studentID, int day, int month, int year, ) {
        super(studentID, firstName + " " + lastName);
        // Additional initialization specific to GradStudent can be done here if needed
    }

    // Override getDiscount() method to calculate the discount for graduate students
    @Override
    public double getDiscount() {
        return 0.15; // Assuming graduate students get a 15% discount
    }
}

 */
import java.time.LocalDate;

public class GradStudent extends Student {

    // Constructor to initialize graduate student-specific attributes
    public GradStudent(String firstName, String lastName, int studentID, int day, int month, int year) {
        super(studentID, firstName, lastName, LocalDate.of(year, month, day));
        // Additional initialization specific to GradStudent can be done here if needed
    }

    // Override getDiscount() method to calculate the discount for graduate students
    @Override
    public double getDiscount() {
        return 0.15;

    }
}

