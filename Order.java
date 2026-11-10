/**
 * Represents a customer's order.
 *@author Mae-an Acabal
 *@author Jella Quibot
 *@version 1.0
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

        // Checks if the order already contains the maximum of 3 items.
        if (itemCount >= 3) {
          System.out.println("------------------------------------------");
          System.out.println("|                                        |");
          System.out.println("|            ★Akaneryuu Cafe★           |");
          System.out.println("|                                        |");
          System.out.println("------------------------------------------");
            return false;
        }

        // Checks if the first item slot is available.
        if (itemCount == 0) {
            item1 = item;
        
        // Checks if the second item slot is available.
        } else if (itemCount == 1) {
            item2 = item;
        
        // Stores the item in the third slot if the first two are occupied.
        } else {
            item3 = item;
        }

        // Increases the item count after successfully adding an item.
        itemCount++;

        // Returns true to indicate that the item was successfully added.
        return true;
    }

    public double computeSubtotal() {
        double subtotal = 0;

        // Checks if the first item exists before adding its price.
        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        // Checks if the second item exists before adding its price.
        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        // Checks if the third item exists before adding its price.
        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        // Returns the total price of all ordered items.
        return subtotal;
    }

    public double computeTotal() {
        double total = computeSubtotal();

        // Checks if the customer is a student to apply a 10% discount.
        if (customer.isStudent()) {
            total -= total * 0.10;
        }

        // Returns the total amount after the student discount.
        return total;
    }

    public double computeTotal(double voucher) {
        double total = computeTotal();

        // Checks if the voucher amount is greater than zero before deducting it.
        if (voucher > 0) {
            total -= voucher;
        }

        // Checks if the total becomes negative and sets it to zero.
        if (total < 0) {
            total = 0;
        }

        // Returns the final amount after applying the voucher.
        return total;
    }

    public void printReceipt() {
        // Calls the receipt method with no voucher discount.
        printReceipt(0);
    }

    public void printReceipt(double voucher) {

        System.out.println("\nOrder #" + orderId
                + " - " + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));

        // Checks if the first item exists before displaying it on the receipt.
        if (item1 != null) {
            System.out.printf("  %-30s %.2f%n",
                    item1.getDescription(),
                    item1.computePrice());
        }

        // Checks if the second item exists before displaying it on the receipt.
        if (item2 != null) {
            System.out.printf("  %-30s %.2f%n",
                    item2.getDescription(),
                    item2.computePrice());
        }

        // Checks if the third item exists before displaying it on the receipt.
        if (item3 != null) {
            System.out.printf("  %-30s %.2f%n",
                    item3.getDescription(),
                    item3.computePrice());
        }

        // Displays the subtotal before discounts.
        System.out.printf("  Subtotal: %.2f%n", computeSubtotal());

        // Checks if the customer is a student before displaying the discount.
        if (customer.isStudent()) {
            System.out.printf("  Student Discount: 10%%%n");
        }

        // Checks if a voucher is used before displaying its deduction.
        if (voucher > 0) {
            System.out.printf("  Voucher: -%.2f%n", voucher);
        }

        // Calculates the final amount after discounts and voucher deductions.
        double total = computeTotal(voucher);

        // Displays the final amount the customer needs to pay.
        System.out.printf("  TOTAL: %.2f%n", total);

        // Adds loyalty points based on the customer's final payment.
        customer.addPoints(total);

        // Displays the customer's updated loyalty points.
        System.out.println("  Loyalty Points: "
                + customer.getLoyaltyPoints());
    }
}
