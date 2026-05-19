package ECommerce;

public class UPI extends PaymentMethod {
    private String upiId;

    public UPI(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void ProcessPayment(double amount) {
        System.out.printf("Paid %.2f using UPI (%s)", amount, upiId);
    }
}
