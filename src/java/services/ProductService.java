package services;

import dao.ProductDao;
import java.util.List;
import models.Product;

public class ProductService implements IProductService{
    ProductDao productDao;
    
    @Override
    public int insert(Product product) {
        if(productDao == null) productDao = new ProductDao();
        return (productDao.insert(product, "products"));
    }

    @Override
    public int update(Product product, int productId) {
        if(productDao == null) productDao = new ProductDao();
        return (productDao.update(product, productId, "products"));
    }

    @Override
    public int update(Product product, String name) {
        if(productDao == null) productDao = new ProductDao();
        return (productDao.update(product, name, "products"));
    }

    @Override
    public int update(Product product, double price) {
        if(productDao == null) productDao = new ProductDao();
        return (productDao.update(product, price, "products"));
    }

    @Override
    public int updateQuantity(Product product, int quantity) {
        if(productDao == null) productDao = new ProductDao();
        return (productDao.update(product, quantity, "products"));
    }

    @Override
    public int delete(int productId) {
        if(productDao == null) productDao = new ProductDao();
        return (productDao.delete(productId, "products"));
    }

    @Override
    public List<Product> all() {
        if(productDao == null) productDao = new ProductDao();
        return (productDao.all("products"));
    }

    @Override
    public Product getProductById(int id) {
        if(productDao == null) productDao = new ProductDao();
        return (productDao.getProductById(id, "products"));    
    }



}
