/*
    Name: Morgan Harper
    Professor: Hoing
    Date: April 2nd 2024
    Homework: Grocery/Admin combine your programs you both did
 */

import java.time.LocalDate;
import java.util.Objects;
import java.time.LocalDate;

public class Person implements Comparable<Person>, Shopper {
    // Constant to represent the age of majority
    //private static final int YEAR_OF_MAJORITY = 18;

    private String familyName;
    private String givenNames;
    private LocalDate DOB;  // The date of birth of the person
    private GroceryList groceryList;

    // Constructor without birthdate
    public Person(String firstName, String lastName) {
        this.familyName = firstName;
        this.givenNames = lastName;
        this.DOB = null; // No birthdate provided
    }

    // Constructor with birthdate as LocalDate
    public Person(String firstName, String lastName, LocalDate date) {
        this.familyName = firstName;
        this.givenNames = lastName;
        this.DOB = date; // Set the date of birth
    }

    public Person(String firstName, String lastName, int day, int month, int year) {
        familyName = lastName;
        givenNames = firstName;
        DOB = LocalDate.of(year, month, day); // Set the date of birth
    }

    // Default constructor
    public Person() {
        familyName = "";
        givenNames = "";
        DOB = null;
    }

    public boolean equals(Object that) {
        if (!(that instanceof Person)) {
            return false;
        }
        Person otherPerson = (Person) that;
        return this.familyName.equals(otherPerson.familyName) &&
                this.givenNames.equals(otherPerson.givenNames) &&
                this.DOB.equals(otherPerson.DOB);
    }

    public int compareTo(Person o) {
        int result;
        result = familyName.compareTo(o.familyName);
        if (result == 0) {
            result = givenNames.compareTo(o.givenNames);
            if (result == 0)
                result = DOB.compareTo(o.DOB);
        }
        return result;
    }
    @Override
    public String getName(){
        return familyName + " " + givenNames;
    }

    public GroceryList createGroceryList() {
        if (this.groceryList == null) {
            this.groceryList = new GroceryList();
        }
        return this.groceryList;
    }

    public void addGroceryItemOrder(GroceryItemOrder item) {
        if (item == null) {
            throw new IllegalStateException("Cannot add null item to Grocery List!");
        }
        if (this.groceryList == null) {
            this.createGroceryList();
        }
        this.groceryList.add(item);
    }

    public double deductPrice(double x) { //write a double argument
        if (this.groceryList == null) return 0; // No items, no discount
        double totalCost = this.groceryList.currentBalance();
        return totalCost * 0.9; // Apply no discount for regular customer
    }

    public String getFirstName() {
        return familyName;
    }

    public String getLastName() {
        return givenNames;
    }

    public LocalDate getDOB() {// call get DOB
        return DOB;
    }

    public GroceryList getGroceryList() {
        return this.groceryList;
    }

    public String toString() {
        return familyName + ", " + givenNames + (DOB != null ? " (" + DOB + ")" : "");
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyName, givenNames, DOB);
    }
   @Override
    public double getDiscount(){
        return 0.0;
}
    @Override
    public double applyDiscount(double totalAmount) {
        double discount = getDiscount();
        return totalAmount *(1-discount);

        }
    }



