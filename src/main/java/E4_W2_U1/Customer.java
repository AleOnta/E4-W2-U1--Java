package E4_W2_U1;

public class Customer {
    long id;
    String name;
    int tier;

    public Customer(String n, int t) {
        id = Runnable.generateId();
        name = n;
        tier = t;
    }

}
