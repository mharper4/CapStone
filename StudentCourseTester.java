/*
    Name: Morgan Harper
    Professor: Hoing
    Date: April 2nd 2024
    Homework: Grocery/Admin combine your programs you both did
 */


import java.util.List;
import java.util.*;

public class StudentCourseTester {


    /* Requriments: That are being ask for in directions:
    --> Create at least two GroceryStores

    -->  Create at least 7 GroceryItems and assign to stores so that some items
    are in multiple stores (at different prices)
    Details and Specific Requirements:
1. Continue to use the Shopper Interface and expand as necessary. Have
Person (and, hence, Student etc) implement Shopper.
2. Make sure all discounting based on Person sub classes works.
3. Add a container for all GroceryStores
a. Grocery store stocks certain GroceryItems and defines a price for
each one (assume quantity one, don’t get complex with BOGOs,
etc).
b. Use at least one MAP ADT in your design and implementation.
4. Add a user interface to allow any Person (identified by names) to
create a new GroceryList
a. Person can select a Grocery Store to use for the order
b. If GroceryStore is known to system, Person can add any
GroceryItem from that store to their list by providing quantity
(creates a GroceryItemOrder)
c. Person can see the discounted price of the full GroceryList.
5. All user interface is to be done in main or other methods outside your
OOP classes.
Mandatory Testing (expand and add to your recent test code):
1. Create at least two GroceryStores
2. Create at least 7 GroceryItems and assign to stores so that some items
are in multiple stores (at different prices)
3. Using the user interface above, have two different Persons create new
GroceryLists. Each list has at least 4 GroceryItemOrders, at least two
of those with quantity greater than 1. Have some differences between
the two GroceryLists. When the user is finished shopping, report the
total price, before and after discount, for the list and print out the
complete grocery list. As always with good testing you should know the
expected result before you run the test.


    * */


    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        List<GroceryStore> groceryStores = new ArrayList<>();
        createPersons(persons);
        createGroceryStores(groceryStores);
        populateStoresWithItems(groceryStores);

        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter person's first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter person's last name:");
        String lastName = scanner.nextLine();

        Person person = selectPersonByName(persons, firstName, lastName);
        if (person == null) {
            System.out.println("Person not found.");
            return;
        }

        System.out.println("Enter store name:");
        String storeName = scanner.nextLine();
        GroceryStore store = selectStoreByName(groceryStores, storeName);
        if (store == null) {
            System.out.println("Store not found.");
            return;
        }


        System.out.println("Enter item name (or type 'done' to finish):");
        String itemName = scanner.nextLine();

        while (!"done".equalsIgnoreCase(itemName)) {
            System.out.println("Enter quantity for " + itemName + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid quantity (integer). Try again:");
                scanner.next();
            }
            int quantity = scanner.nextInt();
            scanner.nextLine();

            addItemToPersonGroceryList(person, store, itemName, quantity);

            System.out.println("Enter next item name (or type 'done' to finish):");
            itemName = scanner.nextLine();
        }


        System.out.println("Grocery list for " + person.getFirstName() + " " + person.getLastName() + ":\n" + person.getGroceryList());
        double totalBeforeDiscount = person.getGroceryList().currentBalance();
        double totalAfterDiscount = person.deductPrice(1.0);
        System.out.println("Total cost before discount: $" + String.format("%.2f", totalBeforeDiscount));
        System.out.println("Total cost after discount: $" + String.format("%.2f", totalAfterDiscount));


    }

    //firstName, lastName, StudentID,  int day, int month, int year
    public static void createPersons(List<Person> persons) {
        persons.add(new UnderGradStudent("Madison", "Harper", 100070, 05, 31, 2003));
        persons.add(new UnderGradStudent("Anisa", "Ramos", 168088, 10, 26, 2003));
        persons.add(new GradStudent("Michelle-Danille", "Bowman", 200739, 03, 11, 1992));
        persons.add(new UnderGradStudent("James", "Brown", 200485, 07, 12, 1999));
        persons.add(new GradStudent("Mick", "Donald", 100542, 20, 02, 1989));
        persons.add(new UnderGradStudent("Tate", "Micheal", 200739, 26, 02, 2000));
        persons.add(new GradStudent("Merdith", "Grey", 239000, 15, 06, 1996));

    }

    public static List<GroceryStore> createGroceryStores(List<GroceryStore> groceryStores) {
        groceryStores.add(new GroceryStore("Whole Foods"));
        groceryStores.add(new GroceryStore("Trader Joe's"));
        return groceryStores;
    }


    public static Person selectPersonByName(List<Person> persons, String firstName, String lastName) {
        for (Person person : persons) {
            if (person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) {
                return person;
            }
        }
        return null;
    }

    public static GroceryStore selectStoreByName(List<GroceryStore> stores, String storeName) {
        for (GroceryStore store : stores) {
            if (store.getStoreName().equalsIgnoreCase(storeName)) {
                return store;
            }
        }
        return null;
    }


    public static void addItemToPersonGroceryList(Person person, GroceryStore store, String itemName, int quantity) {
        GroceryItem item = store.findItemByName(itemName);
        if (item != null) {
            GroceryItemOrder order = new GroceryItemOrder(item, quantity);
            person.addGroceryItemOrder(order);
        } else {
            System.out.println("Item not found in store.");
        }
    }

    public static void populateStoresWithItems(List<GroceryStore> stores) {
        GroceryItem apples = new GroceryItem("Apples", 0.99);
        GroceryItem pizza = new GroceryItem("Pizza", 4.99);
        GroceryItem milk = new GroceryItem("Milk", 2.49);
        GroceryItem bread = new GroceryItem("Bread", 1.99);
        GroceryItem eggs = new GroceryItem("Eggs", 2.99);
        GroceryItem bananas = new GroceryItem("Bananas", 0.69);
        GroceryItem chicken = new GroceryItem("Chicken", 5.99);
        GroceryItem pasta = new GroceryItem("Pasta", 1.49);
        GroceryItem tomatoes = new GroceryItem("Tomatoes", 1.99);
        GroceryItem cheese = new GroceryItem("Cheese", 3.49);

        stores.get(0).addItem(apples);
        stores.get(0).addItem(pizza);
        stores.get(0).addItem(milk);
        stores.get(0).addItem(bread);
        stores.get(0).addItem(eggs);
        stores.get(0).addItem(bananas);
        stores.get(0).addItem(chicken);
        stores.get(0).addItem(pasta);
        stores.get(0).addItem(tomatoes);
        stores.get(0).addItem(cheese);

        GroceryItem pizza2 = new GroceryItem("Pizza", 5.49);
        GroceryItem milk2 = new GroceryItem("Milk", 2.15);
        GroceryItem bread2 = new GroceryItem("Bread", 4.29);
        GroceryItem eggs2 = new GroceryItem("Eggs", 3.29);

        stores.get(1).addItem(apples);
        stores.get(1).addItem(pizza2);
        stores.get(1).addItem(milk2);
        stores.get(1).addItem(bread2);
        stores.get(1).addItem(eggs2);
        stores.get(1).addItem(bananas);
        stores.get(1).addItem(chicken);
        stores.get(1).addItem(pasta);
        stores.get(1).addItem(tomatoes);
        stores.get(1).addItem(cheese);
    }
}

