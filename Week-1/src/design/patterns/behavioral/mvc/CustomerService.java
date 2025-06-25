package design.patterns.behavioral.mvc;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomer(String id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer != null) {
            System.out.println("Customer ID   : " + customer.getId());
            System.out.println("Customer Name : " + customer.getName());
            System.out.println("Customer Email: " + customer.getEmail());
        } else {
            System.out.println("Customer not found with ID: " + id);
        }
    }
}
