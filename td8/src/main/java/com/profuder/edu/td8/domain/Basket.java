package com.profuder.edu.td8.domain;

import java.util.HashSet;
import java.util.Set;

public class Basket {
    private static long basketsNumber = 0;

    private long id = basketsNumber;
    private Set<Command> commands = new HashSet<>();
    private double amount = 0.00;
    private boolean validated = false;

    public Basket() {
        basketsNumber++;
    }

    private Command getCommand(Product product) {
        for (Command command : commands)
            if (command.equals(new Command(product)))
                return command;
        return null;
    }

    public long getID() {
        return id;
    }

    public boolean addCommand(Product product, int quantity) {
        if (validated)
            return false;

        Command command = new Command(product, quantity);

        if (commands.contains(command)) {
            amount += quantity * product.getPrice();
            getCommand(product).modify(quantity);
            return true;
        }

        if (commands.add(command)) {
            amount += quantity * product.getPrice();
            return true;
        }

        return false;
    }

    public boolean removeCommand(Product product) {
        if (validated)
            return false;

        Command command = getCommand(product);

        if (commands.remove(command)) {
            amount -= command.getAmount();
            return true;
        }

        return false;
    }

    public void validate() {
        validated = true;
    }

    @Override
    public String toString() {
        return "Basket #" + id + ": $" + amount + (validated ? " validated " : " not validated ") + commands;
    }
}
