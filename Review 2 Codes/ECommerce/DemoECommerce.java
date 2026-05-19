package ECommerce;
public class DemoECommerce {
    public static void main(String[] args) {
        Product p1 = new Product(1, "Keyboard", 49.99);
        Product p2 = new Product(2, "Mouse", 19.99);

        Cart cart = new Cart();
        cart.addProduct(p1);
        cart.addProduct(p2);

        Customer customer = new Customer("Alice", 101);

        PaymentMethod payment1 = new CreditCard("1234-****-5678");
        customer.placeOrder(cart, payment1);

        // Refill cart to demonstrate another payment method
        cart.addProduct(p1);
        PaymentMethod payment2 = new PayPal("alice@example.com");
        customer.placeOrder(cart, payment2);

        // Refill cart to demonstrate UPI
        cart.addProduct(p2);
        PaymentMethod payment3 = new UPI("alice@upi");
        customer.placeOrder(cart, payment3);
    }
}
