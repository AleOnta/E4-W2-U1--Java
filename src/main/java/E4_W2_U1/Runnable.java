package E4_W2_U1;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runnable {

    public static void main(String[] args) {
        List<Product> productList = generateCatalogue();
        List<Customer> customersList = generateCustomers();

        // Exercise 1
        List<Product> res1 = productList.stream()
                .filter(product -> product.category.equals("Books") && product.price > 100)
                .collect(Collectors.toList());

        System.out.println("Exercise 1 LIST RESULT:");
        System.out.println(res1);

        // Exercise 2

        List<Order> orderList = generateOrders(productList, customersList);
        List<Product> res2 = orderList.stream()
                .map(order -> order.products)
                .flatMap(Collection::stream)
                .filter(product -> product.category.equals("Baby"))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\nExercise 2 LIST RESULT:");
        System.out.println(res2);


        // Exercise 3
        List<Product> res3 = productList.stream()
                .filter(product -> product.category.equals("Boys"))
                .map(product -> applyDiscount(product))
                .collect(Collectors.toList());
        System.out.println("\nExercise 3 LIST RESULT:");
        System.out.println(res3);

        // Exercise 4
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

    public static List<Customer> generateCustomers() {
        List<Customer> customersList = new ArrayList<Customer>();
        // generate 5 customers
        customersList.add(new Customer("Giorgio", 2));
        customersList.add(new Customer("Laura", 1));
        customersList.add(new Customer("Ivan", 3));
        customersList.add(new Customer("Lorenzo", 2));
        customersList.add(new Customer("Alessandro", 1));

        return customersList;
    }

    public static List<Product> partialProductsListGenerator(List<Product> list) {
        List<Product> listToReturn = new ArrayList<Product>();
        int i = 0;
        while (i < 6) {
            int randomIndex = (int) (Math.random() * 14);
            if( randomIndex != 0) {
                randomIndex += 1;
            }
            listToReturn.add(list.get(randomIndex));
            i++;
        }
        return listToReturn;
    }

    public static List<Order> generateOrders(List<Product> pl, List<Customer> lc) {
        List<Order> ordersList = new ArrayList<Order>();
        // generate 5 orders
        ordersList.add(new Order(
                "pending",
                LocalDate.parse("2021-08-25", DateTimeFormatter.ISO_LOCAL_DATE),
                LocalDate.parse("2021-08-30", DateTimeFormatter.ISO_LOCAL_DATE),
                partialProductsListGenerator(pl),
                lc.get(0)
                ));
        ordersList.add(new Order(
                "pending",
                LocalDate.parse("2021-03-22", DateTimeFormatter.ISO_LOCAL_DATE),
                LocalDate.parse("2021-03-29", DateTimeFormatter.ISO_LOCAL_DATE),
                partialProductsListGenerator(pl),
                lc.get(1)
        ));
        ordersList.add(new Order(
                "delivered",
                LocalDate.parse("2021-01-10", DateTimeFormatter.ISO_LOCAL_DATE),
                LocalDate.parse("2021-01-18", DateTimeFormatter.ISO_LOCAL_DATE),
                partialProductsListGenerator(pl),
                lc.get(2)
        ));
        ordersList.add(new Order(
                "pending",
                LocalDate.parse("2021-03-28", DateTimeFormatter.ISO_LOCAL_DATE),
                LocalDate.parse("2021-04-05", DateTimeFormatter.ISO_LOCAL_DATE),
                partialProductsListGenerator(pl),
                lc.get(3)
        ));
        ordersList.add(new Order(
                "delivered",
                LocalDate.parse("2021-01-01", DateTimeFormatter.ISO_LOCAL_DATE),
                LocalDate.parse("2021-01-12", DateTimeFormatter.ISO_LOCAL_DATE),
                partialProductsListGenerator(pl),
                lc.get(4)
        ));
        return ordersList;
    }

    public static Product applyDiscount(Product p) {
        p.price -= p.calculateDiscount();
        return p;
    }
}
