// Concrete class Dairy extending Food
class Dairy extends Food {
    private String name;

    public Dairy(String name, int quantity, double price) {
        super(quantity, price);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Category getCategory() {
        return Category.DAIRY;
    }

    @Override
    public String toString() {
        return getName() + " - $" + getPrice();
    }
}