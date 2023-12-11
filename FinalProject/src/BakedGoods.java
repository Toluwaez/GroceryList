// Concrete class Baked Goods extending Food
class BakedGoods extends Food {
    private String name;

    public BakedGoods(String name, int quantity, double price) {
        super(quantity, price);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Category getCategory() {
        return Category.BAKEDGOOD;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f", getName(), getPrice());
    }
}