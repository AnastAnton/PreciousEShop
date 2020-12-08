package dao;

import java.util.List;
import models.Product;


public interface IProductDao {
    public int insert(Product product, String tableName);
    public int update(Product product, int productId, String tableName);
    public int update(Product product, String name, String tableName);
    public int update(Product product, double price, String tableName);
    public int updateQuantity(Product product, int quantity, String tableName);
    public int delete (int productId, String tableName);
    public List<Product> all();
    public Product getProductById(int id);
    
    

}
