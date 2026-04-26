package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");

                String name = parts[1]; // skip SKU
                double price = Double.parseDouble(parts[2]);
                String department = parts[3];

                products.add(new Product(name, price, department));
            }

            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("Error reading file");
        }

        return products;
    }
}