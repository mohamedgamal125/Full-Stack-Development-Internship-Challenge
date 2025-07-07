import java.util.Date;

public class Cheese extends Product implements Expirable , Shippable{

    private  Date expiryDate;

    private Double weight;

    public Cheese(String name, double price, int quantity, Date expiryDate, Double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public Date getExpiryDate() {

        return expiryDate;

    }

    @Override
    public boolean isExpired() {
        return  new Date().after(expiryDate);
    }

    @Override
    public double getWeight() {
       return weight;
    }


}
