import domain.Basket;
import domain.BasketRepository;
import domain.Reference;
import infrastructure.BasketRepositoryInMemory;

public class Main {
    public static void main(String[] args) {
        final Reference r1 = new Reference("X9EF3", "Chiffon microfibre", "Pour nettoyer le MacBook Air", 1.99);
        final Reference r2 = new Reference("FEJ23", "Coque en verre", "Pour protéger l'iPhone", 9.99);

        final Basket b1 = new Basket();
        b1.addCommand(r1, 10);

        final Basket b2 = new Basket();
        b2.addCommand(r2, 1);

        final BasketRepository br = new BasketRepositoryInMemory();
        br.saveBasket(b1);
        br.saveBasket(b2);
        System.out.println(br.findBasketById(b1.getID()));
        System.out.println(br.findBasketById(b2.getID()));
    }
}
