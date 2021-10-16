import java.util.Iterator;
import java.util.Vector;

import json.Json;
import json.JsonArray;
import json.JsonObject;

/**
 * A stock of products associated with a name and address.
 * 
 * @author Iantsa Provost
 * @author Bastien Soucasse
 */
public class Stock extends Vector<Product> {
    private final String name;
    private final String address;
    private final Vector<Product> products;

    public Stock(final String name, final String address, final Vector<Product> products) {
        this.name = name;
        this.address = address;
        this.products = products;
    }

    public Stock(final String name, final String address) {
        this.name = name;
        this.address = address;
        this.products = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Vector<Product> getProducts() {
        return products;
    }

    /**
     * Checks if the stock is empty or not.
     * 
     * @return {@code true} if this stock is empty; {@code false} otherwise.
     */
    public boolean isEmpty() {
        return products.isEmpty();
    }

    /**
     * Checks if a product is in the stock by its name.
     * 
     * @param name the name of the product to find.
     * @return {@code true} if this stock contains a product with this name;
     *         {@code false} otherwise.
     */
    public boolean contains(final String name) {
        final Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            if (name.equals(it.next().getName())) {
                // System.out.println("Ayo c'est le même"); // ;)
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a product from its name.
     * 
     * @param name the name of the product to retrieve.
     * @return the product if found or {@code null} otherwise.
     */
    public Product get(final String name) {
        final Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            final Product product = it.next();
            if (name.equals(product.getName()))
                return product;
        }
        return null;
    }

    /**
     * Adds a product to the stock.
     * 
     * @param product the product object to add.
     * @return {@code true} if this set did not already contain the specified
     *         element; {@code false} otherwise.
     */
    public boolean add(final Product product) {
        return products.add(product);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Stock other = (Stock) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public JsonObject toJson() {
        final JsonArray productsJson = Json.array();
        for (final Product product : products)
            productsJson.add(product.toJson());
        return Json.object().add("name", name).add("address", address).add("products", productsJson);
    }

    @Override
    public String toString() {
        return name + " {address=" + address + ", products=" + products + "}";
    }
}
