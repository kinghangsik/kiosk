package kiosk_pj;

import java.util.ArrayList;
import java.util.List;

public class Product extends Menu {
    private double price;

    public Product(String name, String explanation, double price) {
        super(name,explanation);
        this.price = price;
    }
    @Override
    public String toString() {
        return String.format("%-15s |  %.2f  |%-100s", getName(), price, getExplanation());
    }
}
