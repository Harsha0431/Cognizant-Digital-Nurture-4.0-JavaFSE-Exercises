package design.patterns.behavioral.mvc;

import java.util.HashMap;
import java.util.Map;

// This class contains all the operations that to be performed on model class in our database
public class CustomerRepositoryImpl implements CustomerRepository {

    private Map<String, Customer> customerData;

    public CustomerRepositoryImpl() {
        customerData = new HashMap<>();
        customerData.put("C001", new Customer("001", "Harsha", "harsha@gmail.com"));
        customerData.put("C002", new Customer("002", "Vardhan", "vardhan@gmail.com"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerData.get(id);
    }
}

