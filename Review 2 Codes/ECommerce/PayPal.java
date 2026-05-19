package ECommerce;
public class PayPal extends PaymentMethod {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void ProcessPayment(double amount) {
        System.out.printf("Paid %.2f using PayPal (%s)", amount, email);
    }
}
