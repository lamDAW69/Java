package org.example.entities;

public class Products {
    int id;
    String reference;
    String name;
    double price;
    int categoria;

    public Products(int id, String reference, String name, double price, int categoria) {
        this.id = id;
        this.reference = reference;
        this.name = name;
        this.price = price;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }
    public void setReference() {
        this.reference = reference;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getCategoria() {
        return categoria;
    }
    public void setCategoria( int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format("%5d %5s  %-40s  %8.2f €", id, reference, name, price, categoria);
    }
}
