package kiosk_pj;

public class Product extends Menu {
    private double price;

    public double getPrice() {
        return price;
    }

    public Product(String name, String explanation, double price) {
        this.name = name;
        this.explanation = explanation;
        this.price = price;
    }
}
