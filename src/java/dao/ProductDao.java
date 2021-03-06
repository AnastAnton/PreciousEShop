package dao;

import static dao.Database.con;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Product;

public class ProductDao extends Database implements IProductDao{
    private Database db;

    @Override
    public int insert(Product product, String tableName) {
        if(db == null) db = new Database();
        int result = 0;
        StringBuilder sb = new StringBuilder();
        
        sb.append("INSERT INTO ");
        sb.append(tableName);                                                  
        sb.append("(name, price, quantity) ");
        sb.append("VALUES(");
        sb.append("\""); sb.append(product.getName()); sb.append("\""); sb.append(",");
        sb.append("\""); sb.append(product.getPrice()); sb.append("\""); sb.append(",");
        sb.append("\""); sb.append(product.getQuantity()); sb.append("\""); 
        sb.append(")");
        try {
            //        System.out.println(sb.toString());
            statement = con.createStatement();
            result = statement.executeUpdate(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (result);
    }

    @Override
    public int update(Product product, int productId, String tableName) {
        if(db == null) db = new Database();
        int result = 0;
        StringBuilder sb = new StringBuilder();
        
        sb.append("UPDATE ");
        sb.append(tableName);
        sb.append(" SET");
        sb.append(" name = ");
        sb.append("\""); sb.append(product.getName()); sb.append("\""); sb.append(",");
        sb.append(" price = ");
        sb.append("\""); sb.append(product.getPrice()); sb.append("\""); sb.append(",");
        sb.append(" quantity = ");
        sb.append("\""); sb.append(product.getQuantity()); sb.append("\"");
        sb.append(" WHERE id = ");
        sb.append(productId);
        try {
            //        System.out.println(sb.toString());
            statement = con.createStatement();
            result = statement.executeUpdate(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
     return (result); 
    }

    @Override
    public int update(Product product, String name, String tableName) {
        if(db == null) db = new Database();
        int result = 0;
        StringBuilder sb = new StringBuilder();
        
        sb.append("UPDATE ");
        sb.append(tableName);
        sb.append(" SET");
        sb.append(" price = ");
        sb.append("\""); sb.append(product.getPrice()); sb.append("\""); sb.append(",");
        sb.append(" quantity = ");
        sb.append("\""); sb.append(product.getQuantity()); sb.append("\""); 
        sb.append(" WHERE name = ");
        sb.append("\""); sb.append(product.getName()); sb.append("\""); 
        try {
            //        System.out.println(sb.toString());
            statement = con.createStatement();
            result = statement.executeUpdate(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
     return (result); 
    }

    @Override
    public int update(Product product, double price, String tableName) {
        if(db == null) db = new Database();
        int result = 0;
        StringBuilder sb = new StringBuilder();
        
        sb.append("UPDATE ");
        sb.append(tableName);
        sb.append(" SET");
        sb.append(" name = ");
        sb.append("\""); sb.append(product.getName()); sb.append("\""); sb.append(",");
        sb.append(" quantity = ");
        sb.append("\""); sb.append(product.getQuantity()); sb.append("\""); 
        sb.append(" WHERE price = ");
        sb.append(product.getPrice());
        try {
            //        System.out.println(sb.toString());
            statement = con.createStatement();
            result = statement.executeUpdate(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
     return (result);
    }

    @Override
    public int updateQuantity(Product product, int quantity, String tableName) {
        if(db == null) db = new Database();
        int result = 0;
        StringBuilder sb = new StringBuilder();
        
        sb.append("UPDATE ");
        sb.append(tableName);
        sb.append(" SET");
        sb.append(" name = ");
        sb.append("\""); sb.append(product.getName()); sb.append("\""); sb.append(",");
        sb.append(" price = ");
        sb.append("\""); sb.append(product.getPrice()); sb.append("\""); 
        sb.append(" WHERE quantity = ");
        sb.append(product.getQuantity());
        try {
            //        System.out.println(sb.toString());
            statement = con.createStatement();
            result = statement.executeUpdate(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
     return (result);
    }

    @Override
    public int delete(int productId, String tableName) {
        if(db == null) db = new Database();
        int result = 0;
        StringBuilder sb = new StringBuilder();
        
        sb.append("DELETE FROM ");
        sb.append(tableName);
        sb.append(" WHERE ID = ");
        sb.append(productId);
        try {
            //        System.out.println(sb.toString());
            statement = con.createStatement();
            result = statement.executeUpdate(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
     return (result);    }

    @Override
    public List<Product> all(String tableName) {
        if(db == null) db = new Database();
        int result = 0;
        StringBuilder sb = new StringBuilder();
        Product product;
        List<Product> products = new ArrayList();
        
        try {
            //        System.out.println(sb.toString());
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT * FROM " + tableName);
            while(rs.next()){
                products.add(new Product(rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(products);
    }

    @Override
    public Product getProductById(int id, String tableName) {
        if(db == null) db = new Database();
        Product product = new Product();
        
        try {
            //        System.out.println(sb.toString());
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT * FROM " + tableName + " WHERE id = " + id);
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setQuantity(rs.getInt("quantity"));
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(product);
    }

}
