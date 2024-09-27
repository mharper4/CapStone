/*
    Name: Morgan Harper
    Professor: Hoing
    Date: April 2nd 2024
    Homework: Grocery/Admin combine your programs you both did
 */

public interface Shopper {
   double applyDiscount(double totalAmount);
   double getDiscount();
  String getName();
   double deductPrice(double EndingAmount);//Make all sub-class give some type of discount
}
