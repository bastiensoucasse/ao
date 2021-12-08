package observer;

public interface Observable {
    void notifyObservers(Object arg);
    void addObserver(Observer o);
}
