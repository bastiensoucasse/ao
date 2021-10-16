import java.util.Scanner;

/**
 * UI of the app.
 * 
 * @author Iantsa Provost
 * @author Bastien Soucasse
 */
public class MyAppli {
    private static MyShop shop;
    private static Scanner scanner;

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
            if (shop.contains(name))
                break;
            System.out.println(name + " is not an existing stock. Please try again.");
        }
        return shop.get(name);
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
        String stockName;
        while (true) {
            System.out.print("What do you want to call this stock? ");
            stockName = scanner.nextLine();
            if (!shop.contains(stockName))
                break;
            System.out.println("This stock name already exists. Please choose another name.");
        }
        System.out.print("What is its address? ");
        final String address = scanner.nextLine();

        // Create and add the new stock to the stock set
        shop.add(stockName, address);
        System.out.println("The stock " + stockName + " has been created!");

        // Add products to the new stock by collecting their name and quantity
        System.out.println();
        System.out.println("Now, let's add some products! (Enter 'q' when done)");
        int productType;
        String productName;
        int productQuantity, productExpirationDays = -1;
        while (true) {
            // TODO: Quit.

            // Ask for the type
            while (true) {
                System.out.print("Type (1 for food and 2 for hygiene): ");
                productType = Integer.parseInt(scanner.nextLine());
                if (productType == 1 || productType == 2)
                    break;
                System.out.println("This product type is incorrect. Please try again.");
            }

            // Ask for the name
            while (true) {
                System.out.print("Name: ");
                productName = scanner.nextLine();
                if (!shop.contains(stockName, productName))
                    break;
                System.out.println("This product name already exists. Please choose another name.");
            }

            // Quit & go back to menu
            if (productName.trim().toLowerCase().equals("q"))
                break;

            if (productType == 1) {
                while (true) {
                    System.out.print("Days before expired: ");
                    productExpirationDays = Integer.parseInt(scanner.nextLine());
                    if (productExpirationDays > 0)
                        break;
                    System.out.println("This expiration date is invalid. Please choose another name.");
                }
            }

            // Ask for the quantity
            System.out.print("Quantity: ");
            productQuantity = Integer.parseInt(scanner.nextLine());

            // Add the product to the stock
            shop.addToStock(stockName, productName, productQuantity, productType, productExpirationDays);
        }

        // Confirmation
        System.out.println("All done! Your stock " + stockName + " is finished.");
    }

    /**
     * Displays the characteristics (id & quantity) of a chosen product in a chosen
     * stock.
     */
    private static void displayCharacteristics() {
        // Check if there is a stock to find
        if (shop.isEmpty()) {
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
        if (shop.isEmpty()) {
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
            shop = new MyShop();
            scanner = new Scanner(System.in);
            int option = -1;
            while (option != 0) {
                System.out.println();
                System.out.println("*** Menu ***");
                System.out.println("1. Create a stock/add products to the stock");
                System.out.println("2. Display a product characteristics");
                System.out.println("3. Add/remove a quantity of product to a stock");
                System.out.println("4. Save stocks");
                System.out.println("5. Load stocks");
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
                    case 4:
                        Saver.saveAll(shop);
                        break;
                    case 5:
                        Loader.loadAll(shop);
                        break;
                    case 6:
                        System.out.println(shop);
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
