package kiosk_pj;

public class product extends menu {
    private double price;

    public product(String name, String explanation, double price) {
        super(name,explanation);
        this.price = price;
    }
    @Override
    public String toString() {
        return String.format("%-15s |  %.2f  |%-100s", getName(), price, getExplanation());
    }
}
