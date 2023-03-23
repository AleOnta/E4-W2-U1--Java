package E4_W2_U1;

import java.text.DecimalFormat;
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

    public double calculateDiscount() {
       return (price * 10) / 100;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Product { " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", category = " + category + '\'' +
                ", price = " + df.format(price)+"€" +
                " }";
    }
}
