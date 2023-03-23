package E4_W2_U1;

import java.time.LocalDate;
import java.util.List;

public class Order {
    long id;
    String status;
    LocalDate orderDate;
    LocalDate deliveryDate;
    List<Product> products;
    Customer customer;

    public Order(String s, LocalDate od, LocalDate dd, List<Product> p, Customer c) {
        id = Runnable.generateId();
        status = s;
        orderDate = od;
        deliveryDate = dd;
        products = p;
        customer = c;
    }
}
