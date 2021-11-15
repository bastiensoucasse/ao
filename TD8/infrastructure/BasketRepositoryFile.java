package infrastructure;

import java.io.File;

import domain.Basket;
import domain.BasketRepository;

public class BasketRepositoryFile implements BasketRepository {
    @Override
    public void saveBasket(final Basket basket) {
    }

    @Override
    public Basket findBasketById(final long basketID) {
        File file = new File(basketID + ".json");
        return null;
    }
}
