/**
 * Represents a café customer.
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
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        }
    }

    public void addPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    public void addPoints(double amount) {
        if (amount > 0) {
            loyaltyPoints += (int) (amount / 50);
        }
    }
}