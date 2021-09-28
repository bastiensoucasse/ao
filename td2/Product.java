/**
 * A product caracterised by a name and a quantity.
 * 
 * @author Iantsa Provost
 * @author Bastien Soucasse
 */
public class Product {
    private static long n = 0;

    private final long id;
    private final String name;
    private int quantity;

    public Product(final String name, final int quantity) {
        this.id = n;
        this.name = name;
        this.quantity = quantity;
        n++;
    }

    public Product() {
        this("", 0);
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
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
        final Product other = (Product) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + "]";
    }
}
