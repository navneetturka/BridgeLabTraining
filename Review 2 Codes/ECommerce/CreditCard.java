package ECommerce;
public class CreditCard extends PaymentMethod {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void ProcessPayment(double amount) {
        System.out.printf("Paid %.2f using Credit Card", amount);
    }
}
