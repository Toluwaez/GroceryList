abstract class Food {
    private int quantity;
    private double price;

    public Food(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method to get the name of the food item
    public abstract String getName();

    // Abstract method to get the category of the food item
    public abstract Category getCategory();

    @Override
    public String toString() {
        return getName() + " - Quantity: " + getQuantity() + ", Price: $" + getPrice();
    }
}
