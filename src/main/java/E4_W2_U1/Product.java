package E4_W2_U1;

import java.util.Random;

public class Product {
    long id;
    String name;
    String category;
    double price;

    public Product(String n, String c, double p) {
        id = Runnable.generateId();
        name = n;
        category = c;
        price = p;
    }

    public void getId() {
        System.out.println(id);
    }
}
