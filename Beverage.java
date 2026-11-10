/**
 * Represents a café beverage.
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

        if (size.equals("M")) {
            price += 15;
        } else if (size.equals("L")) {
            price += 25;
        }

        return price;
    }

    @Override
    public String getDescription() {
        return name + ".......... [" + getItemCode()
                + "] .......... Size: " + size;
    }
}