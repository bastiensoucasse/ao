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

    @Override
    public String toString() {
        return super + " Hygiene []";
    }
}
