package design.patterns.behavioral.mvc;

public class Test {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        service.displayCustomer("C001");
        System.out.println();
        service.displayCustomer("C003");
    }
}
