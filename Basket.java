package kiosk_pj;

import java.util.List;

public class Basket {
    private List<Product> orderProducts;

    public void addProduct(Product product) {
        orderProducts.add(product);
    }

}
