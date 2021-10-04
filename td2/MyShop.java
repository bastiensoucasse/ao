import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

/**
 * A shop with a set of stocks.
 * 
 * @author Iantsa Provost
 * @author Bastien Soucasse
 */
public class MyShop {
    private final Vector<Stock> stocks;

    public MyShop() {
        stocks = new Vector<Stock>();
    }

    public Vector<Stock> getStocks() {
        return stocks;
    }

    /**
     * Checks if the shop is empty or not.
     * 
     * @return {@code true} if this shop is empty; {@code false} otherwise.
     */
    public boolean isEmpty() {
        return stocks.isEmpty();
    }

    /**
     * Checks if a stock is in the shop by its name.
     * 
     * @param name the name of the stock to find.
     * @return {@code true} if this shop contains a stock with this name;
     *         {@code false} otherwise.
     */
    public boolean contains(final String name) {
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
     * Checks if a product is in a stock by their name.
     * 
     * @param stockName   the name of the stock to find.
     * @param productName the name of the product to find.
     * @return {@code true} if the stock contains a product with this name;
     *         {@code false} otherwise.
     */
    public boolean contains(final String stockName, final String productName) {
        if (!contains(stockName))
            return false;

        return get(stockName).contains(productName);
    }

    /**
     * Retrieves a stock from its name.
     * 
     * @param name the name of the stock to retrieve.
     * @return the stock if found or {@code null} otherwise.
     */
    public Stock get(final String name) {
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
    public boolean add(final String name, final String address) {
        return stocks.add(new Stock(name, address));
    }

    /**
     * Adds a product to a stock by whith name and a quantity.
     * 
     * @param stockName             the name of the stock to find.
     * @param productName           the name of the product to add.
     * @param productQuantity       the quantity.
     * @param productType           the type (1 for food, 2 for hygiene)
     * @param productExpirationDays number of days before product expires
     * @return {@code true} if the product has beend successfully added to the
     *         stock; {@code false} otherwise.
     */
    public boolean addToStock(final String stockName, final String productName, final int productQuantity,
            final int productType, final int productExpirationDays) {
        if (productType == 1)
            return get(stockName).add(new Food(productName, productQuantity,
                    new Date(new Date().getTime() + productExpirationDays * (long) 8.64e7)));
        return get(stockName).add(new Hygiene(productName, productQuantity));
    }

    @Override
    public String toString() {
        return "MyShop [stocks=" + stocks + "]";
    }
}
