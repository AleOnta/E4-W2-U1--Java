package E4_W2_U1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runnable {

    public static void main(String[] args) {
        // Exercise 1
        List<Product> productList = generateCatalogue();

        List<Product> res1 = productList.stream()
                .filter(product -> product.category.equals("Books") && product.price > 100)
                .collect(Collectors.toList());

        System.out.println("Exercise 1 LIST RESULT:");
        for (Product p : res1) {
            System.out.println(p.toString());
        }
    }

    protected static long generateId() {
        Random rand = new Random();
        return Math.abs(rand.nextLong());
    }

    public static List<Product> generateCatalogue() {
        List<Product> catalogue = new ArrayList<Product>();

        // generate 5 books
        catalogue.add(new Product("Book-A", "Books", 15.99));
        catalogue.add(new Product("Book-B", "Books", 33.99));
        catalogue.add(new Product("Book-C", "Books", 110.99));
        catalogue.add(new Product("Book-D", "Books", 21.99));
        catalogue.add(new Product("Book-E", "Books", 135.99));
        // generate 5 baby's products
        catalogue.add(new Product("Baby-A", "Baby", 32.99));
        catalogue.add(new Product("Baby-B", "Baby", 18.99));
        catalogue.add(new Product("Baby-C", "Baby", 65.99));
        catalogue.add(new Product("Baby-D", "Baby", 81.99));
        catalogue.add(new Product("Baby-E", "Baby", 101.99));
        // generate 5 boys products
        catalogue.add(new Product("Boys-A", "Boys", 14.99));
        catalogue.add(new Product("Boys-B", "Boys", 51.99));
        catalogue.add(new Product("Boys-C", "Boys", 79.99));
        catalogue.add(new Product("Boys-D", "Boys", 42.99));
        catalogue.add(new Product("Boys-E", "Boys", 99.99));

        return catalogue;
    }

    public static List<Order> generateOrders() {


    }
}
