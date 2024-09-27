/*    Name: Morgan Harper
    Professor: Hoing
    Date: April 2nd 2024
    Homework: Grocery/Admin combine your programs you both did
 */

import java.time.LocalDate;

public class UnderGradStudent extends Student {

    // Constructor to initialize undergraduate student-specific attributes
    public UnderGradStudent(String firstName, String lastName, int studentID, int day, int month, int year) {
        super(studentID, lastName, firstName, LocalDate.of(year, month, day));
        // Additional initialization specific to UnderGradStudent can be done here if needed
    }

    // Override getDiscount() method to calculate the discount for undergraduate students

    public double getDeductPrice() {
        // Assuming undergraduate students get a 10% discount
        return 0.10;
    }
}






