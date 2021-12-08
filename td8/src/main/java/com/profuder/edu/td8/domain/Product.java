package com.profuder.edu.td8.domain;

import java.util.Objects;

public final class Product {
    private final String reference;
    private final String name;
    private final String description;
    private final double price;

    public Product(String reference, String name, String description, double price) {
        this.reference = reference;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }

    public String reference() {
        return reference;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public double price() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Product) obj;
        return Objects.equals(this.reference, that.reference) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.description, that.description) &&
                Double.doubleToLongBits(this.price) == Double.doubleToLongBits(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, name, description, price);
    }

}
