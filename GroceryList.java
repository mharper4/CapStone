/*
    Name: Morgan Harper
    Professor: Hoing
    Date: April 2nd 2024
    Homework: Grocery/Admin combine your programs you both did
 */


import java.util.ArrayList;
import java.util.List;

public class GroceryList {
    private List<GroceryItemOrder> items;
    private int size;
    //private GroceryList groceryList;

    public GroceryList() {
        this.items = new ArrayList<GroceryItemOrder>();
        size = 0;
    }

    //@Override
//  public GroceryList createGroceryList() {
    //calling the parent class method to create the groceryList
    //   return new GroceryList();
//    }

    public void add(GroceryItemOrder item) {
        // Check if the list is not full before adding the item.
        if (size < 10) {
            items.set(size, item);
            size++;
        }
    }

    public void remove(GroceryItemOrder item) {
        items.remove(item); // Assumes GroceryItemOrder has a proper equals and hashCode for comparison
    }

    public double currentBalance() {
        double totalCost = 0;
        for (GroceryItemOrder itemOrder : items) {
            totalCost += itemOrder.getQuantity() * itemOrder.getGroceryItem().getPricePerUnit();
        }
        return totalCost;
    }

    public String toString() {
        String result = "";
        for (GroceryItemOrder itemOrder : items) {
            result += itemOrder.getGroceryItem().getItemName()
                    + " - Quantity: "
                    + itemOrder.getQuantity()
                    + ", Price per unit: $"
                    + String.format("%.2f", itemOrder.getGroceryItem().getPricePerUnit())
                    + ", Total: $"
                    + String.format("%.2f", itemOrder.getCost())
                    + "\n";
        }
        return result;
    }


    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        // Iterate through the items in the list and sum up their individual prices.
        for (int i = 0; i < items.size(); i++) {
            // Add the price of the current item to the total price.
            totalPrice += items.get(i).getCost();
        }
        // Return the total price.
        return totalPrice;
    }
}



/*
    public void removeGroceryItemOrder(GroceryItemOrder item) {
        groceryList.remove(item);
    }

 */

    /*
    public List<GroceryItemOrder> getGroceryList() {
        return groceryList;
    }

     */
/*
    public void setGroceryList(List<GroceryItemOrder> groceryList) {
        this.groceryList = groceryList;
    }

 */

