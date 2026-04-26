package org.example;

import java.util.*;

public class ShoppingCart {

    public List<Product> cart = new ArrayList<>();

    public void addToCart(Product product) {
        cart.add(product);
        System.out.println("Added to cart!");
    }

    public void removeFromCart(Product product) {
        cart.remove(product);
        System.out.println("Removed from cart!");
    }

    public double getCartTotal() {
        double total = 0;
        for (Product p : cart) {
            total += p.getPrice();
        }
        return total;
    }

    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        for (Product p : cart) {
            System.out.println(p);
        }
        System.out.println("Total: $" + getCartTotal());
    }
}
