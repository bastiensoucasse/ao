package com.profuder.edu.td8.infrastructure;

import java.util.HashMap;
import java.util.Map;

import com.profuder.edu.td8.domain.Basket;
import com.profuder.edu.td8.domain.BasketRepository;

public class BasketRepositoryInMemory implements BasketRepository {
    private Map<Long, Basket> baskets = new HashMap<>();

    @Override
    public void saveBasket(Basket basket) {
        baskets.put(basket.getID(), basket);
    }

    @Override
    public Basket findBasketById(long basketID) {
        return baskets.get(basketID);
    }
}
