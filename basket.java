package kiosk_pj;

import java.util.List;

public class basket {
    private List<product> orderProducts;

    public void addProduct(product product) {
        orderProducts.add(product);
    }

}
