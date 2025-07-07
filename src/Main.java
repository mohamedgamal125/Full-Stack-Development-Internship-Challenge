import Cart.Cart;
import CheckoutService.CheckoutService;
import Customer.Customer;
import Product.Cheese;
import Product.Product;
import  Product.TV;
import  Product.MobileScratchCard;
import Shipping_Service.ShippingService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create products
        Product cheese = new Cheese("Cheese", 10.0, 5, new Date(System.currentTimeMillis() + 100000), 0.5);
        Product tv = new TV("TV", 500.0, 2, 15.0);
        Product scratchCard = new MobileScratchCard("Scratch Card", 5.0, 100);

        // Create customer
        Cart cart = new Cart();
        Customer customer = new Customer(1000.0,cart);

        // Create cart and add products

        try {
            customer.getCart().add_product(cheese, 2);
            customer.getCart().add_product(tv, 1);
            customer.getCart().add_product(scratchCard, 5);

        }catch (Exception e)
        {
            System.out.println("Checkout error: " + e.getMessage());
            return  ;
        }

        // Perform checkout
        ShippingService shippingService = new ShippingService();
        try {
            CheckoutService.checkout(customer, shippingService);
        } catch (Exception e) {
            System.out.println("Checkout error: " + e.getMessage());
            return  ;
        }
    }
}