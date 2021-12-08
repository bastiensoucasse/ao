package observer;

public class Demo {
    public static void main(String[] args) {
        Store shop = new Store();
        Client denis = new Client();
        shop.addObserver(denis);
        shop.addProduct("Apple MacBook Air");
        shop.addProduct("Apple iPhone");
    }
}
