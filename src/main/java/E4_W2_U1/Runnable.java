package E4_W2_U1;

import java.util.Random;

public class Runnable {

    public static void main(String[] args) {
        Product p1 = new Product("Lib1", "Books", 13.99);
        Product p2 = new Product("Lib2", "Books", 13.99);
        Product p3 = new Product("Lib3", "Books", 13.99);

        p1.getId();
        p2.getId();
        p3.getId();
    }

    protected static long generateId() {
        Random rand = new Random();
        return Math.abs(rand.nextLong());
    }

}
