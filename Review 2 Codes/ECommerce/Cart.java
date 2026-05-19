package ECommerce;
import java.util.*;

public class Cart {
    private final List<Product> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product != null) {
            items.add(product);
        }
    }

    public void removeProduct(Product product) {
        if (product == null)
            return;
        items.remove(product);
    }

    public List<Product> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product p : items) {
            if (p != null)
                total += p.price;
        }
        return total;
    }
}
