/**
 * Represents a customer's order.
 */
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
    }

    public boolean addItem(MenuItem item) {

        if (itemCount >= 3) {
            System.out.println("----------Maximum of 3 items only!----------");
            return false;
        }

        if (itemCount == 0) {
            item1 = item;
        } else if (itemCount == 1) {
            item2 = item;
        } else {
            item3 = item;
        }

        itemCount++;
        return true;
    }

    public double computeSubtotal() {
        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    public double computeTotal() {
        double total = computeSubtotal();

        if (customer.isStudent()) {
            total -= total * 0.10;
        }

        return total;
    }

    public double computeTotal(double voucher) {
        double total = computeTotal();

        if (voucher > 0) {
            total -= voucher;
        }

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    public void printReceipt() {
        printReceipt(0);
    }

    public void printReceipt(double voucher) {

        System.out.println("\nOrder #" + orderId
                + " - " + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));

        if (item1 != null) {
            System.out.printf("  %-30s %.2f%n",
                    item1.getDescription(),
                    item1.computePrice());
        }

        if (item2 != null) {
            System.out.printf("  %-30s %.2f%n",
                    item2.getDescription(),
                    item2.computePrice());
        }

        if (item3 != null) {
            System.out.printf("  %-30s %.2f%n",
                    item3.getDescription(),
                    item3.computePrice());
        }

        System.out.printf("  Subtotal: %.2f%n", computeSubtotal());

        if (customer.isStudent()) {
            System.out.printf("  Student Discount: 10%%%n");
        }

        if (voucher > 0) {
            System.out.printf("  Voucher: -%.2f%n", voucher);
        }

        double total = computeTotal(voucher);

        System.out.printf("  TOTAL: %.2f%n", total);

        customer.addPoints(total);

        System.out.println("  Loyalty Points: "
                + customer.getLoyaltyPoints());
    }
}