// Concrete class Vegetable extending Food
class Vegetable extends Food {
    private String name;

    public Vegetable(String name, int quantity, double price) {
        super(quantity, price);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Category getCategory() {
        return Category.VEGETABLE;
    }

    @Override
    public String toString() {
        return getName() + " - Meat - Quantity: " + getQuantity() + ", Price: $" + getPrice();
    }
}
