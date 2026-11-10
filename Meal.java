/**
 * Represents a café meal.
 *@author Jella Quibot
 *@author Mae-an Acabal
 *@version 1.0
 */
public class Meal extends MenuItem {

    private boolean upsized;
    private int extraSides;

    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    public Meal(String name, double basePrice,
                String itemCode, boolean upsized,
                int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        setExtraSides(extraSides);
    }

    public boolean isUpsized() {
        return upsized;
    }

    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    public int getExtraSides() {
        return extraSides;
    }

    public void setExtraSides(int extraSides) {
         // Checks if the number of extra sides is zero or positive.
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        }
    }

    @Override
    public double computePrice() {
        double price = basePrice;

         // Checks if the customer chooses to upsize the meal.
         if (upsized) {
            price += 20;
        }

        // Adds 12 pesos for every extra side ordered.
        price += extraSides * 12;

        // Returns the total price of the meal.
        return price;
    }

    @Override
    public String getDescription() {
        return name + ".......... [" + getItemCode() + "] .........."
                + (upsized ? "Upsized" : "Regular")
                + ", Extra Sides: " + extraSides;
    }
}
