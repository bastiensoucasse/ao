package domain;

public class Command {
    private final Reference reference;
    private int quantity;
    private double amount;

    public Command(final Reference reference, final int quantity) {
        this.reference = reference;
        this.quantity = quantity;
        amount = quantity * reference.getPrice();
    }

    public Command(final Reference reference) {
        this(reference, 1);
    }

    public Reference getReference() {
        return reference;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void modify(final int delta) {
        quantity += delta;
        amount += delta * reference.getPrice();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((reference == null) ? 0 : reference.hashCode());
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
        final Command other = (Command) obj;
        if (reference == null) {
            if (other.reference != null)
                return false;
        } else if (!reference.equals(other.reference))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return reference + " x" + quantity + " ($" + amount + ")";
    }
}
