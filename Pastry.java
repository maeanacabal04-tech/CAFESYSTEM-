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

        if (warmed) {
            price += 10;
        }

        return price;
    }

    @Override
    public String getDescription() {
        return name + ".......... [" + getItemCode() + "] .........."
                + (warmed ? " (Warmed)" : "");
    }
}
