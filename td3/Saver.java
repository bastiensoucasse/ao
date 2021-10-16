import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import json.WriterConfig;

public class Saver {
    public static void save(final Stock stock) throws IOException {
        final BufferedWriter file = new BufferedWriter(new FileWriter(stock.getName() + ".json"));
        stock.toJson().writeTo(file, WriterConfig.PRETTY_PRINT);
        file.flush();
        file.close();
    }

    public static void saveAll(final MyShop shop) {
        for (final Stock stock : shop.getStocks()) {
            try {
                save(stock);
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }
}
