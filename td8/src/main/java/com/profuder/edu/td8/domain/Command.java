package com.profuder.edu.td8.domain;

public class Command {
    private Product product;
    private int quantity;
    private double amount;

    public Command(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        amount = quantity * product.getPrice();
    }

    public Command(Product product) {
        this(product, 1);
    }

    public Product getReference() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void modify(int delta) {
        quantity += delta;
        amount += delta * product.getPrice();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Command other = (Command) obj;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return product + " x" + quantity + " ($" + amount + ")";
    }
}
