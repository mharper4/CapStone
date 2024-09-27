/*
    Name: Morgan Harper
    Professor: Hoing
    Date: April 2nd 2024
    Homework: Grocery/Admin combine your programs you both did
 */

import java.util.Objects;

public class GroceryItemOrder {
    private GroceryItem item;
    private int quantity;

    public GroceryItemOrder(GroceryItem item, int quantity){
        if(item == null){
            throw new IllegalStateException("Item not in Stock");
        } else if(quantity < 0){
            throw new IllegalStateException("quantity cannot be negative.");
        } else{
            this.item = item;
            this.quantity = quantity;
        }
    }

    public double getCost(){
        double cost = item.getPricePerUnit() * quantity;
        return (double) Math.round(cost * 100) / 100;
    }

    public int getQuantity(){
        return quantity;
    }

    public GroceryItem getGroceryItem(){
        return item;
    }

    public void setQuantity(int quantity){
        if(quantity < 0){
            throw new IllegalArgumentException("quantity must be positive.");
        } else {
            this.quantity = quantity;
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroceryItemOrder)) return false;
        GroceryItemOrder that = (GroceryItemOrder) o;
        return Objects.equals(item, that.item);
    }

    public int hashCode() {
        return Objects.hash(item);
    }
}