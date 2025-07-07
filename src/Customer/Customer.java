package Customer;

public class Customer {

    private double balance;

    public Customer(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deduct(double amount){
        if(amount > balance)
        {
            throw new Error("invalid amount");
        }
        balance -= amount;
    }
}
