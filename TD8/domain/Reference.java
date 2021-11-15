package domain;

public class Reference {
    private final String reference;
    private final String name;
    private final String description;
    private final double price;

    public Reference(final String reference, final String name, final String description, final double price) {
        this.reference = reference;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
