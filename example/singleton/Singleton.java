package singleton;

public class Singleton {
    private static Singleton instance = null;

    // To prevent classic instantiation
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
