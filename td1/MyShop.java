import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * A shop with a set of stocks.
 * 
 * @author Iantsa Provost
 * @author Bastien Soucasse
 */
public class MyShop {
    private static Set<Stock> stocks = new HashSet<Stock>();
    private static Scanner scanner;

    /**
     * Checks if the shop is empty or not.
     * 
     * @return {@code true} if this shop is empty; {@code false} otherwise.
     */
    // private static boolean isEmpty() {
    // return stocks.isEmpty();
    // }

    /**
     * Checks if a stock is in the shop by its name.
     * 
     * @param name the name of the stock to find.
     * @return {@code true} if this shop contains a stock with this name;
     *         {@code false} otherwise.
     */
    private static boolean contains(final String name) {
        final Iterator<Stock> it = stocks.iterator();
        while (it.hasNext()) {
            if (name.equals(it.next().getName())) {
                // System.out.println("Ayo c'est le même"); // ;)
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a stock from its name.
     * 
     * @param name the name of the stock to retrieve.
     * @return the stock if found or {@code null} otherwise.
     */
    private static Stock get(final String name) {
        final Iterator<Stock> it = stocks.iterator();
        while (it.hasNext()) {
            final Stock stock = it.next();
            if (name.equals(stock.getName()))
                return stock;
        }
        return null;
    }

    /**
     * Adds a stock to the shop.
     * 
     * @param stock the stock object to add.
     * @return {@code true} if this set did not already contain the specified
     *         element; {@code false} otherwise.
     */
    // private static boolean add(final Stock stock) {
    // return stocks.add(stock);
    // }

    // @Override
    // private static String toString() {
    // return "MyShop [stocks=" + stocks + "]";
    // }

    /**
     * Asks for the user for a stock and returns the object associated.
     * 
     * @return the stock the user wanted.
     */
    private static Stock retrieveStock() {
        String name;
        while (true) {
            System.out.print("Choose a stock: ");
            name = scanner.nextLine();
            if (contains(name))
                break;
            System.out.println(name + " is not an existing stock. Please try again.");
        }
        return get(name);
    }

    /**
     * Asks for the user for a product in a stock and returns the object associated.
     * 
     * @param stock the stock where to look for the product.
     * @return the product the user wanted.
     */
    private static Product retrieveProduct(final Stock stock) {
        String name;
        while (true) {
            System.out.print("Choose a product: ");
            name = scanner.nextLine();
            if (stock.contains(name))
                break;
            System.out.println("The stock " + stock.getName() + " doesn't register a product named " + name
                    + ". Please try again.");
        }
        return stock.get(name);
    }

    /**
     * Creates a stock and adds it to the stock set. User can choose its name, its
     * address, its products and quantities.
     */
    private static void createStock() {
        // Welcome
        System.out.println();
        System.out.println("** Create a stock **");

        // Collect information about the new stock
        String name;
        while (true) {
            System.out.print("What do you want to call this stock? ");
            name = scanner.nextLine();
            if (!contains(name))
                break;
            System.out.println("This stock name already exists. Please choose another name.");
        }
        System.out.print("What is its address? ");
        final String address = scanner.nextLine();

        // Create and add the new stock to the stock set
        final Stock stock = new Stock(name, address);
        stocks.add(stock);
        System.out.println("The stock " + name + " has been created!");

        // Add products to the new stock by collecting their name and quantity
        System.out.println();
        System.out.println("Now, let's add some products! (Enter 'q' when done)");
        String productName;
        int productQuantity;
        while (true) {
            while (true) {
                System.out.print("Name: ");
                productName = scanner.nextLine();
                if (!stock.contains(productName))
                    break;
                System.out.println("This product name already exists. Please choose another name.");
            }

            // Quit & go back to menu
            if (productName.trim().toLowerCase().equals("q"))
                break;

            System.out.print("Quantity: ");
            productQuantity = Integer.parseInt(scanner.nextLine());

            // Add the product to the stock
            stock.add(new Product(productName, productQuantity));
        }

        // Confirmation
        System.out.println("All done! Your stock " + stock.getName() + " is finished.");
    }

    /**
     * Displays the characteristics (id & quantity) of a chosen product in a chosen
     * stock.
     */
    private static void displayCharacteristics() {
        // Check if there is a stock to find
        if (stocks.isEmpty()) {
            System.out.println("No stock yet. Create a stock first.");
            return;
        }

        // Welcome
        System.out.println();
        System.out.println("** Display a product characteristics **");

        // Retrieve the stock
        final Stock stock = retrieveStock();

        // Check if there is a product to find
        if (stock.isEmpty()) {
            System.out.println("The stock " + stock.getName() + " is empty.");
            return;
        }

        // Confirmation
        System.out.println("You chose the stock " + stock.getName() + ".");

        // Retrieve the product
        final Product product = retrieveProduct(stock);

        // Finalization
        System.out.println(product);
    }

    /**
     * Allow user to add or remove a quantity of a product in a stock Warning: User
     * cannot add a product that is not in the stock!
     */
    private static void changeQuantity() {
        // Check if there is a stock to find
        if (stocks.isEmpty()) {
            System.out.println("No stock yet. Create a stock first.");
            return;
        }

        // Welcome
        System.out.println();
        System.out.println("** Add/remove a quantity of product to a stock **");

        // Retrieve the stock
        final Stock stock = retrieveStock();

        // Check if there is a product to find
        if (stock.isEmpty()) {
            System.out.println("The stock " + stock.getName() + " is empty.");
            return;
        }

        // Confirmation
        System.out.println("You chose the stock " + stock.getName() + ".");

        // Retrieve the product
        final Product product = retrieveProduct(stock);

        // Confirmation
        System.out.println(
                "The stock contains " + product.getQuantity() + " time(s) the product " + product.getName() + ".");

        // Add/remove a given quantity of product
        String input;
        char operator;
        int quantity;
        System.out.println("How do you want to change the quantity? (+7; -9)");
        while (true) {
            input = scanner.nextLine();
            operator = input.charAt(0);

            if (operator == '+' || operator == '-') {
                quantity = Integer.parseInt(input.substring(1));
                if (operator == '+' || quantity <= product.getQuantity())
                    break;
                System.out.println("Cannot remove more products than there are. Try again!");
            } else
                System.out.println("Invalid input. Try again!");
        }

        // Modify the product quantity as requested
        String res;
        if (operator == '+') {
            product.setQuantity(product.getQuantity() + quantity);
            res = "added";
        } else {
            product.setQuantity(product.getQuantity() - quantity);
            res = "removed";
        }

        // Print the modifications
        System.out.printf("You %s %d %s to the stock %s.\n", res, quantity, product.getName(), stock.getName());
        System.out.printf("There are now %d %s in it.\n", product.getQuantity(), product.getName());
    }

    public static void main(final String[] args) {
        try {
            scanner = new Scanner(System.in);
            int option = -1;
            while (option != 0) {
                System.out.println();
                System.out.println("*** Menu ***");
                System.out.println("1. Create a stock/add products to the stock");
                System.out.println("2. Display a product characteristics");
                System.out.println("3. Add/remove a quantity of product to a stock");
                System.out.println("0. Exit");
                System.out.print("Enter an option: ");

                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 0:
                        System.out.println("");
                        System.out.println("Thank you for using our app.");
                        break;
                    case 1:
                        createStock();
                        break;
                    case 2:
                        displayCharacteristics();
                        break;
                    case 3:
                        changeQuantity();
                        break;
                    default:
                        System.out.println("Invalid option, try again!");
                }
            }
            scanner.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
