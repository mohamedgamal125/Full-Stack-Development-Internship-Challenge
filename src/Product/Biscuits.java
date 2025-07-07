package Product;

import Product.Behaviors.Expirable;

import java.util.Date;

 public class Biscuits extends Product implements Expirable {
    private Date expirationDate;

    public Biscuits(String name, double price, int quantity, Date expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired() {
        return new Date().after(expirationDate);
    }
}