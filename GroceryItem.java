/*
    Name: Morgan Harper
    Professor: Hoing
    Date: April 2nd 2024
    Homework: Grocery/Admin combine your programs you both did
 */
public class GroceryItem {
    private String itemName;
    private double pricePerUnit;


    public GroceryItem(String itemName, double pricePerUnit){
        this.itemName = itemName;
        this.pricePerUnit = pricePerUnit;
    }

    public double getPricePerUnit(){
        return pricePerUnit;
    }

    public String getItemName(){
        return itemName;
    }

}