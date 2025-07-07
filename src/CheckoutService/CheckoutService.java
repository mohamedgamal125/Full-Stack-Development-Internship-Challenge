package CheckoutService;

import Cart.CartItem;
import Customer.Customer;
import Product.Behaviors.Expirable;
import Product.Behaviors.Shippable;
import Product.Product;
import Shipping_Service.ShippingService;
import Shipping_Service.Shipping_Item;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    public static  void checkout (Customer customer, ShippingService shippingService){
        if(customer.getCart().getItems().isEmpty())
        {
            throw new IllegalStateException("Cart is empty");

        }
        double subtotal = 0;
        double shippingFees = 0;

        List<Shipping_Item> shippingItems = new ArrayList<>();
        for (CartItem item: customer.getCart().getItems()){
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if(product instanceof Expirable)
            {
                Expirable exp = (Expirable) product;
                if(exp.isExpired()){
                    throw new IllegalStateException("Product " + product.getName() + " is expired");
                }
            }

            if(quantity > product.getQuantity())
            {
                throw new IllegalStateException("Product " + product.getName() + " is out of stock");
            }
            subtotal += product.getPrice()*quantity;

            if(product instanceof Shippable){
                Shippable shippable = (Shippable) product;
                shippingFees += 2.5 * quantity;
                for(int i = 0 ; i<quantity;i++)
                {
                    shippingItems.add(new Shipping_Item() {
                        @Override
                        public String getName() {
                            return product.getName();
                        }

                        @Override
                        public double getWeight() {
                            return shippable.getWeight();
                        }
                    });
                }
            }

        }

        double total = subtotal + shippingFees;
        if(total > customer.getBalance()){
            throw new IllegalStateException("Insufficient balance");
        }

        customer.deduct(total);

        for(CartItem item : customer.getCart().getItems()){
            Product product = item.getProduct();
            product.setQuantity(product.getQuantity()-item.getQuantity());

        }

        if(!shippingItems.isEmpty()){
            shippingService.ship(shippingItems);

        }
        CheckoutPrinter.printAll(customer, shippingItems, subtotal, shippingFees, total);

    }


}
