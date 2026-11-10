/**
 * Represents a café customer.
 *@author Jella Quibot
 *@author Mae-an Acabal
 *@version 1.0
 */
public class Customer {

    private String name;
    private boolean student;
    private int loyaltyPoints;

    public Customer() {
        name = "LAYLA";
        student = false;
        loyaltyPoints = 0;
    }

    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        loyaltyPoints = 0;
    }

    public Customer(String name, boolean student,
                    int loyaltyPoints) {
        this.name = name;
        this.student = student;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        // Checks if the loyalty points are zero or positive.
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        }
    }

    public void addPoints(int points) {
        // Checks if the given points are greater than zero before adding them.
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    public void addPoints(double amount) {
        // Checks if the purchase amount is greater than zero.
        if (amount > 0) {
        // Awards 1 loyalty point for every 50 pesos spent.
            loyaltyPoints += (int) (amount / 50);
        }
    }
}
