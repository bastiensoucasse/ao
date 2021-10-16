import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Vector;

import json.Json;
import json.JsonArray;
import json.JsonValue;

public class Loader {
    public static Stock load(final String filename) throws IOException {
        final String json = Files.readString(Path.of(filename));
        final String stockName = Json.parse(json).asObject().getString("name", "Unknown Stock");
        final String stockAddress = Json.parse(json).asObject().getString("address", "Unknown Address");
        final Vector<Product> stockProducts = new Vector<>();
        final JsonArray productsJson = Json.parse(json).asObject().get("products").asArray();
        for (final JsonValue productJson : productsJson) {
            final String productType = productJson.asObject().getString("type", "Unknown Product Type");
            final String productName = productJson.asObject().getString("name", "Unknown Product");
            final int productQuantity = productJson.asObject().getInt("quantity", 0);
            if (productType.equals("food")) {
                final Date productExpirationDate = new Date(productJson.asObject().get("expirationDate").asLong());
                stockProducts.add(new Food(productName, productQuantity, productExpirationDate));
            } else if (productType.equals("hygiene"))
                stockProducts.add(new Hygiene(productName, productQuantity));
            else
                System.err.println("Error with product " + productName + ", skipping.");
        }
        return new Stock(stockName, stockAddress, stockProducts);
    }

    public static void loadAll(final MyShop shop) {
        final String filenames[] = new File(".").list((dir, name) -> name.endsWith(".json"));
        for (final String filename : filenames) {
            try {
                shop.add(load(filename));
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }
}
