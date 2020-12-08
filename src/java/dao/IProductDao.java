package dao;

import java.util.List;
import models.Product;


public interface IProductDao {
    public int insert(Product product, String tableName);
    public int update(int productId);
    public int update(String name);
    public int update(double price);
    public int updateQuantity(int quantity);
    public int delete (int productId);
    public List<Product> all();
    public Product getProductById(int id);
    
    

}
