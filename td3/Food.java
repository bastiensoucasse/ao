import java.util.Date;

/**
 * A food product with an expiration date.
 * 
 * @author Iantsa Provost
 * @author Bastien Soucasse
 */
public class Food extends Product {

    private final Date expirationDate;

    public Food(final String name, final int quantity, final Date expirationDate) {
        super(name, quantity);
        this.expirationDate = expirationDate;
    }

    /**
     * Check if the food expiration date is reached
     * 
     * @return {@code true} if the food is expired; {@code false} otherwise.
     */
    public boolean isExpired() {
        final Date currentDate = java.util.Calendar.getInstance().getTime();
        return expirationDate.after(currentDate) || expirationDate.equals(currentDate);
    }

    /**
     * Converts food object to Json syntax
     * 
     * @return string that represents the object
     */
    public String toJson() {
        String json = "{";
        json += "\"type\": \"food\",";
        json += "\"id\":\"" + this.getID() + "\",";
        json += "\"name\":\"" + this.getName() + "\",";
        json += "\"quantity\":\"" + this.getQuantity() + "\",";
        json += "\"expirationDate\":\"" + expirationDate.toString() + "\"";
        json += "}";
        return json;
    }

    @Override
    public String toString() {
        return super.toString() + " Food [expirationDate=" + expirationDate + "]";
    }

}
