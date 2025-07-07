public class Tv extends Product implements Shippable{

    private  Double weight;
    public Tv(String name, double price, int quantity, Double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return  weight ;

    }
}


