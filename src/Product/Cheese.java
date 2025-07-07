package Product;

import Product.Behaviors.Expirable;
import Product.Behaviors.Shippable;

import java.util.Date;

public class Cheese extends Product implements Expirable, Shippable {
    private Date expirationDate;
    private double weight;

    public Cheese(String name, double price, int quantity, Date expirationDate, double weight) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return new Date().after(expirationDate);
    }

    @Override
    public double getWeight() {
        return weight;
    }
}