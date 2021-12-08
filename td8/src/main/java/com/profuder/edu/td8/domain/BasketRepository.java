package com.profuder.edu.td8.domain;

public interface BasketRepository {
    public void saveBasket(Basket basket);

    public Basket findBasketById(long basketID);
}
