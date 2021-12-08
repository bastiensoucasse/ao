package com.profuder.edu.td8;

import com.profuder.edu.td8.domain.Basket;
import com.profuder.edu.td8.domain.BasketRepository;
import com.profuder.edu.td8.domain.Product;
import com.profuder.edu.td8.infrastructure.BasketRepositoryFile;
import com.profuder.edu.td8.infrastructure.BasketRepositoryInMemory;

public class Client {
    public static void main(String[] args) {
        Product r1 = new Product("X9EF3", "Chiffon microfibre", "Pour nettoyer le MacBook Air", 1.99);
        Product r2 = new Product("FEJ23", "Coque en verre", "Pour protéger iPhone", 9.99);

        Basket b1 = new Basket();
        if (!b1.addCommand(r1, 10))
            System.err.println("Error");

        Basket b2 = new Basket();
        if (!b2.addCommand(r2, 1))
            System.err.println("Error");

        BasketRepository br1 = new BasketRepositoryInMemory();
        br1.saveBasket(b1);
        br1.saveBasket(b2);
        System.out.println(br1.findBasketById(b1.getID()));
        System.out.println(br1.findBasketById(b2.getID()));

        BasketRepository br2 = new BasketRepositoryFile();
        br2.saveBasket(b1);
        br2.saveBasket(b2);
        System.out.println(br2.findBasketById(b1.getID()));
        System.out.println(br2.findBasketById(b2.getID()));
    }
}
