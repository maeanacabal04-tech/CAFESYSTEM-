/**
 * Main application of the Campus Café Ordering System.
 *@author Mae-an Acabal
 *@author Jella Quibot
 *@version 1.0
 */
public class CafeApp {

    public static void main(String[] args) {

        
        Customer customer1 = new Customer("Layla", true);
        Customer customer2 = new Customer("MIYA", false);
        Customer customer3 = new Customer();

        
        Beverage beverage1 = new Beverage(
                "-MATCHA ICED LATTE", 95, "B-01", "L ");

        
        Pastry pastry1 = new Pastry(
                "-BURGER", 45, "P-01", true);

        
        Meal meal1 = new Meal(
                "-LETCHON", 8500, "M-01", true, 1);

        
        Pastry pastry2 = new Pastry();
        pastry2.setName("Cake");
        pastry2.setBasePrice(500);
        pastry2.setItemCode("P-02");

        
        Beverage beverage2 = new Beverage();
        beverage2.setName("-ICE CREAM");
        beverage2.setBasePrice(50);
        beverage2.setItemCode("B-02");
        beverage2.setSize("M");


        Order order1 = new Order("1001", customer1);

        order1.addItem(beverage1);
        order1.addItem(pastry1);
        order1.addItem(meal1);
        order1.addItem(pastry2);

        order1.printReceipt();

        Order order2 = new Order("1002", customer2);

        order2.addItem(beverage2);

        Meal meal2 = new Meal(
                "-ADOBONG MANOK", 268, "M-02", false, 0);

        order2.addItem(meal2);

        order2.printReceipt(20);
    }
}