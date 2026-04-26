package org.example;

public class Product {
        private String name;
        private double price;
        private String department;

        public Product(String name, double price, String department) {
            this.name = name;
            this.price = price;
            this.department = department;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
        public String getDepartment() { return department; }

        @Override
        public String toString() {
            return name + " | $" + price + " | " + department;
        }
    }
