package ECommerce;
public class Customer {
    private String name;
    private int customerId;

    public Customer(String name, int customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public void placeOrder(Cart cart, PaymentMethod paymentMethod) {
        if (cart == null || paymentMethod == null) {
            System.out.println("Order failed: cart or payment method missing.");
            return;
        }

        if (cart.getItems().isEmpty()) {
            System.out.println("Order failed: cart is empty.");
            return;
        }

        double total = cart.calculateTotal();
        System.out.printf("Placing order for %s (Customer ID: %d). Total = %.2f", name, customerId, total);
        paymentMethod.ProcessPayment(total);
        System.out.println("Order placed successfully.");
        cart.clear();
    }
}
