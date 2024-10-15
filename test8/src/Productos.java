public record Productos(String name, double price) {

    public double getPriceTaxed(double tax) {
        return (this.price * tax);
    }

    public Productos(Productos p) { //Constructor copia de productos
        this(p.name, p.price);
    }
}
