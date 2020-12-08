package services;

import java.util.List;
import models.Customer;


public interface ICustomerService {
    public int insert(Customer customer);
    public int update(int customerId);
    public int update(String firstName, String lastName);
    public int update(String email);
    public int delete(int customerId);
    public List<Customer> all();
    public Customer getCustomerById(int Id);
}
