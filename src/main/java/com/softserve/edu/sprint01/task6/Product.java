package sprint01.task6;

public class Product {
    private String name;
    private double price;
    private static int instanceCounter;

    public Product() {
        instanceCounter++;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        instanceCounter++;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int count() {
        return instanceCounter;
    }

    //debug
    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product("tomato", 5.0);
        Product p3 = new Product("potato", 3.0);
        int countOfProducts = Product.count();
        System.out.println(countOfProducts);
    }
}
