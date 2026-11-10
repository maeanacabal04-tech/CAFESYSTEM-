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
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        }
    }

    @Override
    public double computePrice() {
        double price = basePrice;

        if (upsized) {
            price += 20;
        }

        price += extraSides * 12;

        return price;
    }

    @Override
    public String getDescription() {
        return name + ".......... [" + getItemCode() + "] .........."
                + (upsized ? "Upsized" : "Regular")
                + ", Extra Sides: " + extraSides;
    }
}