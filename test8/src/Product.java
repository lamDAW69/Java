public class Product {
    String name;
    double price;

    public Product(String name, double price) {     //Constructor
        this.name = name;
        this.price = price;
    }
    public double getPriceTaxed(double tax) {
        return (this.price * tax);
    }
}
