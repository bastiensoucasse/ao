/**
 * A hygiene product.
 * 
 * @author Iantsa Provost
 * @author Bastien Soucasse
 */
public class Hygiene extends Product {

    public Hygiene(String name, int quantity) {
        super(name, quantity);
    }

    /**
     * Converts hygiene object to Json syntax
     * 
     * @return string that represents the object
     */
    public String toJson() {
        String json = "{";
        json += "\"type\": \"hygiene\"";
        json += "\"id\":\"" + this.getID() + "\",";
        json += "\"name\":\"" + this.getName() + "\",";
        json += "\"quantity\":\"" + this.getQuantity() + "\",";
        json += "}";
        return json;
    }

    @Override
    public String toString() {
        return super.toString() + " Hygiene []";
    }
}
