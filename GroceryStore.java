/*
    Name: Morgan Harper
    Professor: Hoing
    Date: April 2nd 2024
    Homework: Grocery/Admin combine your programs you both did
 */
/*
 Comments/Notes:
 --> This will represent collection of grocery store objects
 --> HashMap will store the inventory items along with the prices
 --> Two constructors, storing the name andother ofr initalizing with a pre-existing inventory
 --> equals and hasCode methods will be overriden to force a comparsion based on the names of the stores.
 --> addItem: stores inventory
 --> will retrive the store name
 --> getPrice: will retrieve the unit price of the given item
 --> findItemByName: item in the inventory by its name
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
//import java.util.TreeMap;

public class GroceryStore {
    private String storeName;
    private Map<GroceryItem, Double> inventory;


    public GroceryStore(String storeName){
        this.inventory = new HashMap<>();
        this.storeName = storeName;
    }

    public GroceryStore(String storeName,Map<GroceryItem,Double> inventory){
        this.inventory = new HashMap<>(inventory);
        this.storeName = storeName;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        GroceryStore that = (GroceryStore) o;
        return Objects.equals(storeName, that.storeName);
    }

    public int hashCode() {
        return Objects.hash(storeName);
    }

    public void addItem(GroceryItem item) {
        inventory.put(item, item.getPricePerUnit());
    }

    public String getStoreName(){
        return storeName;
    }

    public Double getPrice(GroceryItem item) {
        return inventory.get(item);
    }

    public GroceryItem findItemByName(String itemName) {
        for (GroceryItem item : inventory.keySet()) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
}

