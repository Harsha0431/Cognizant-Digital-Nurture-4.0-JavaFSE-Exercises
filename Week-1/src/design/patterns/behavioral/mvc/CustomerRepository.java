package design.patterns.behavioral.mvc;

public interface CustomerRepository {
    Customer findCustomerById(String id);
}
