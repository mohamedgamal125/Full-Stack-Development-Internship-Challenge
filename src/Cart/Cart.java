package Cart;

import Product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() {
        return items;
    }

    public void add_product(Product product,int quantity){
        if(quantity > product.getQuantity()){
            throw new Error("Quantity exceeds the available");
        }
        items.add(new CartItem(product,quantity));

    }
}

