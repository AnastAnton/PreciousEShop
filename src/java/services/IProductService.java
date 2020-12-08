package services;

import java.util.List;
import models.Product;


public interface IProductService {
    public int insert(Product product);
    public int update(Product product, int productId);
    public int update(Product product, String name);
    public int update(Product product, double price);
    public int updateQuantity(Product product, int quantity);
    public int delete (int productId);
    public List<Product> all();
    public Product getProductById(int id);
    
    

}
