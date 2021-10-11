import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Saver {
    public static void save(final MyShop shop) {
        for (Stock stock : shop.getStocks()) {
            try {
                BufferedWriter file = new BufferedWriter(new FileWriter(stock.getName() + ".json"));
                file.write(stock.toJson());
                file.flush();
                file.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void read(final File file) {
        // TODO
    }
}
