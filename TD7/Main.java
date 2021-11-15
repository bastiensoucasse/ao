import domain.Basket;
import domain.Reference;

public class Main {
    public static void main(String[] args) {
        final Reference r1 = new Reference("X9EF3", "Chiffon microfibre", "Pour nettoyer le MacBook Air", 1.99);
        final Reference r2 = new Reference("FEJ23", "Coque en verre", "Pour protéger l'iPhone", 9.99);

        final Basket basket = new Basket();
        basket.addCommand(r1, 6);
        basket.addCommand(r1, 8);
        basket.addCommand(r1, -4);
        System.out.println(basket);
        basket.addCommand(r2, 3);
        basket.removeCommand(r2);
        basket.addCommand(r2, 1);
        basket.validate();
        System.out.println(basket);
    }
}
