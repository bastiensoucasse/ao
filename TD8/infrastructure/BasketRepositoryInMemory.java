package infrastructure;

import java.util.HashMap;
import java.util.Map;

import domain.Basket;
import domain.BasketRepository;

public class BasketRepositoryInMemory implements BasketRepository {
    private final Map<Long, Basket> baskets = new HashMap<>();

    @Override
    public void saveBasket(final Basket basket) {
        baskets.put(basket.getID(), basket);
    }

    @Override
    public Basket findBasketById(final long basketID) {
        return baskets.get(basketID);
    }
}
