/*
    Name: Morgan Harper
    Professor: Hoing
    Date: April 2nd 2024
    Homework: Grocery/Admin combine your programs you both did
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/*
    Comments/Notes:
        --> class is represented as collection of  GroceryStore objects
        --> ArrayList is to store the GroceryStore objects
        --> Constructors initlitalzes the groceryStore list
        --> addGroceryStore: it will remove a grocery store the collection
        --> removeGroceryStore:
        --> getGroceryStore: retrieves info of groceryStore from the collection by its a name defined.

 */
public class AllGroceryStores {
    private ArrayList<GroceryStore> groceryStores;

    public AllGroceryStores(){
        this.groceryStores = new ArrayList<>();
    }

    public void addGroceryStore(GroceryStore groceryStore) {
        if (!groceryStores.contains(groceryStore)) {
            groceryStores.add(groceryStore);
        }
    }

    public boolean removeGroceryStore(GroceryStore groceryStore) {
        return groceryStores.remove(groceryStore);
    }

    public GroceryStore getGroceryStore(String storeName) {
        for (GroceryStore store : groceryStores) {
            if (store.getStoreName().equals(storeName)) {
                return store;
            }
        }
        return null;
    }
}
