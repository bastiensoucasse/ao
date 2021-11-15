package domain;

import java.util.HashSet;
import java.util.Set;

public class Basket {
    private static long basketsNumber = 0;

    private final long id = basketsNumber;
    private final Set<Command> commands = new HashSet<>();
    private double amount = 0.00;
    private boolean validated = false;

    public Basket() {
        basketsNumber++;
    }

    private Command getCommand(final Reference reference) {
        for (Command command : commands)
            if (command.equals(new Command(reference)))
                return command;
        return null;
    }

    public long getID() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public boolean addCommand(final Reference reference, final int quantity) {
        if (validated)
            return false;

        final Command command = new Command(reference, quantity);

        if (commands.contains(command)) {
            amount += quantity * reference.getPrice();
            getCommand(reference).modify(quantity);
            return true;
        }

        if (commands.add(command)) {
            amount += quantity * reference.getPrice();
            return true;
        }

        return false;
    }

    public boolean removeCommand(final Reference reference) {
        if (validated)
            return false;

        final Command command = getCommand(reference);

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
