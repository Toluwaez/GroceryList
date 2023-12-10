// Concrete class Fruit extending Food
class Fruit extends Food {
    private String name;

    public Fruit(String name, int quantity, double price) {
        super(quantity, price);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Category getCategory() {
        return Category.FRUIT;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f", getName(), getPrice());
    }
}