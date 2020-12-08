package services;

import java.util.List;
import models.Product;


public interface IProductService {
    public int insert(Product product);
    public int update(int productId);
    public int update(String name);
    public int update(double price);
    public int updateQuantity(int quantity);
    public int delete (int productId);
    public List<Product> all();
    public Product getProductById(int id);
    
    

}
