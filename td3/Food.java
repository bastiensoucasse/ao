import java.util.Date;

import json.Json;
import json.JsonObject;

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
    public JsonObject toJson() {
        return Json.object().add("type", "food").add("name", getName()).add("quantity", getQuantity())
                .add("expirationDate", expirationDate.getTime());
    }

    @Override
    public String toString() {
        return getName() + " (food) {#" + getID() + ", quantity=" + getQuantity() + ", expirationDate=" + expirationDate
                + "}";
    }
}
