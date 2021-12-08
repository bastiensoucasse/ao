package observer;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<Client> observers = new ArrayList<>();

    private void notifyObservers(Object arg) {
        for (Client o : observers) o.update(arg);
    }

    public void addObserver(Client o) {
        observers.add(o);
    }

    public void addProduct(String s) {
        notifyObservers(s);
    }
}
