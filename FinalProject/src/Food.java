import java.io.Serializable;

abstract class Food implements Serializable{
    private int quantity;
    private double price;
    

    public Food(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }

    // Abstract method to get the name of the food item
    public abstract String getName();

    // Abstract method to get the category of the food item
    public abstract Category getCategory();

    @Override
    public String toString() {
        // Format the string to include the price
        return String.format("%dx %s - $%.2f (Total: $%.2f)", getQuantity(), getName(), getPrice(), getTotalPrice());
    }
}