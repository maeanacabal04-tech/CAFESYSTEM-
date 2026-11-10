/**
 * Represents a pastry.
 *@author Jella Quibot
 *@author Mae-an Acabal
 *@version 1.0
 */
public class Pastry extends MenuItem {

    private boolean warmed;

    public Pastry() {
        super();
        warmed = false;
    }

    public Pastry(String name, double basePrice,
                  String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    public boolean isWarmed() {
        return warmed;
    }

    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }

    @Override
    public double computePrice() {
        double price = basePrice;

        // Checks if the customer wants the pastry to be warmed.
        if (warmed) {
            // Adds 10 pesos to the base price if the pastry is warmed.
            price += 10;
        }

        // Returns the final price of the pastry.
        return price;
    }

    @Override
    public String getDescription() {
        
        // Displays "(Warmed)" if the pastry is warmed; otherwise, displays no additional text.
        return name + ".......... [" + getItemCode() + "] .........."
                + (warmed ? " (Warmed)" : "");
    }
}
