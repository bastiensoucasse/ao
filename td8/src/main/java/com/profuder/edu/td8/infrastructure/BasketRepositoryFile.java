package com.profuder.edu.td8.infrastructure;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.profuder.edu.td8.domain.Basket;
import com.profuder.edu.td8.domain.BasketRepository;

public class BasketRepositoryFile implements BasketRepository {
    @Override
    public void saveBasket(Basket basket) {
        Gson gson = new Gson();
        try {
            Writer writer = new FileWriter("Basket " + basket.getID() + ".json");
            gson.toJson(basket, writer);
            writer.flush();
            writer.close();
        } catch (JsonIOException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Basket findBasketById(long basketID) {
        Gson gson = new Gson();
        Basket basket = null;
        try {
            basket = gson.fromJson(new FileReader("Basket " + basketID + ".json"), Basket.class);
        } catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return basket;
    }
}
