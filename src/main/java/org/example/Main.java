package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Product> products = FileManager.getProducts();
    static ShoppingCart cart = new ShoppingCart();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- STORE MENU ---");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showAllProducts();
                case 2 -> showCart();
                case 3 -> {
                    System.out.println("Goodbye!");
                    return;
                }
            }
        }
    }

    public static void showAllProducts() {
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("\nEnter product NAME to add to cart or X to go back:");
        String input = scanner.nextLine();

        if (!input.equalsIgnoreCase("X")) {
            Product selected = findProductByName(input);
            if (selected != null) {
                cart.addToCart(selected);
            } else {
                System.out.println("Product not found.");
            }
        }
    }

    public static Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static void showCart() {
        cart.displayCart();

        System.out.println("\n1. Remove Item");
        System.out.println("2. Checkout");
        System.out.println("3. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter product NAME to remove:");
                String name = scanner.nextLine();
                Product product = findProductByName(name);
                if (product != null) {
                    cart.removeFromCart(product);
                }
            }
            case 2 -> {
                System.out.println("Checked out. Total: $" + cart.getCartTotal());
                cart.cart.clear();
            }
        }
    }
}