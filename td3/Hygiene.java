import json.Json;
import json.JsonObject;

/**
 * A hygiene product.
 * 
 * @author Iantsa Provost
 * @author Bastien Soucasse
 */
public class Hygiene extends Product {
    public Hygiene(final String name, final int quantity) {
        super(name, quantity);
    }

    /**
     * Converts hygiene object to Json syntax
     * 
     * @return string that represents the object
     */
    public JsonObject toJson() {
        return Json.object().add("type", "hygiene").add("name", getName()).add("quantity", getQuantity());
    }

    @Override
    public String toString() {
        return getName() + " (hygiene) {#" + getID() + ", quantity=" + getQuantity() + "}";
    }
}
