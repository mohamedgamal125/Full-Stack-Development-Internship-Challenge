package Customer;

import Cart.Cart;

public class Customer {

    private double balance;
    private Cart cart;

     public Customer(double balance,Cart cart) {
        this.balance = balance;
        this.cart = cart;
    }

    public double getBalance() {
        return balance;
    }

    public void deduct(double amount){
        if(amount > balance)
        {
            throw new IllegalStateException("invalid amount");
        }
        balance -= amount;
    }

    public Cart getCart() {
        return cart;
    }
}
