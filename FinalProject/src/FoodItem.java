// FoodItem class implementing GroceryItem
class FoodItem implements GroceryItemInt {
    private String name;
    private String category;
    private double price;

    public FoodItem(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name; // Display the name in the ListView
    }
}