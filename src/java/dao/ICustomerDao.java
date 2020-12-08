package dao;

import services.*;
import java.util.List;
import models.Customer;


public interface ICustomerDao {
    public int insert(Customer customer, String tableName);
    public int update(int customerId);
    public int update(String firstName, String lastName);
    public int update(String email);
    public int delete(int customerId);
    public List<Customer> all();
    public Customer getCustomerById(int Id);
}
