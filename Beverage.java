/**
 * Represents a café beverage.
 *@author Mae-an Acabal
 *@author Jella Quibot
 *@version 1.0
 */
public class Beverage extends MenuItem {

    private String size;

    public Beverage() {
        super();
        size = "S";
    }

    public Beverage(String name, double basePrice,
                    String itemCode, String size) {
        super(name, basePrice, itemCode);
        setSize(size);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if ("S".equals(size) || "M".equals(size)
                || "L".equals(size)) {
            this.size = size;
        } else {
            this.size = "S";
        }
    }

    @Override
    public double computePrice() {
        double price = basePrice;

        // Checks if the selected size is Medium and adds 15 to the base price.
        if (size.equals("M")) {
            price += 15;
        } 
        // Checks if the selected size is Large and adds 25 to the base price.
        else if (size.equals("L")) {
            price += 25;
        }

        // Returns the final price after adding the size charge.
        return price;
    }

    @Override
    public String getDescription() {
        return name + ".......... [" + getItemCode()
                + "] .......... Size: " + size;
    }
}
