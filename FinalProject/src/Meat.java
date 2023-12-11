// Concrete class Meat extending Food
class Meat extends Food {
    private String name;

    public Meat(String name, int quantity, double price) {
        super(quantity, price);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Category getCategory() {
        return Category.MEAT;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f", getName(), getPrice());
    }
}