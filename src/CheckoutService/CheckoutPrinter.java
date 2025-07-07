package CheckoutService;

import Cart.CartItem;
import Customer.Customer;
import Product.Behaviors.Shippable;
import Product.Product;
import Shipping_Service.Shipping_Item;

import java.util.List;

public class CheckoutPrinter {

    public static void printAll(Customer customer, List<Shipping_Item> shippingItems,
                                double subtotal, double shippingFees, double total) {

        System.out.println();
        printShipmentNotice(customer);

        printPackageWeight(shippingItems);

        printCheckoutReceipt(customer, subtotal, shippingFees, total);
    }

    private static void printShipmentNotice(Customer customer) {
        System.out.println("** Shipment notice **");
        for (CartItem item : customer.getCart().getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            if (product instanceof Shippable) {
                Shippable shippable = (Shippable) product;
                System.out.println(quantity + "x " + product.getName() +
                        "\t\t" + (int)(shippable.getWeight() * 1000) + "g");
            }
        }
    }

    private static void printPackageWeight(List<Shipping_Item> shippingItems) {
        double totalWeight = 0;
        for (Shipping_Item shippingItem : shippingItems) {
            totalWeight += shippingItem.getWeight();
        }
        System.out.println("Total package weight " + String.format("%.1f", totalWeight) + "kg");
        System.out.println();
    }

    private static void printCheckoutReceipt(Customer customer, double subtotal, double shippingFees, double total) {
        System.out.println("** Checkout receipt **");
        for (CartItem item : customer.getCart().getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            int itemTotal = (int)(product.getPrice() * quantity);
            System.out.println(quantity + "x " + product.getName() + "\t\t" + itemTotal);
        }

        System.out.println("----------------------");
        System.out.println("Subtotal\t\t" + (int)subtotal);
        System.out.println("Shipping\t\t" + (int)shippingFees);
        System.out.println("Amount\t\t\t" + (int)total);
    }}
