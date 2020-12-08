package dao;

import static dao.Database.con;
import java.sql.SQLException;
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
    public int update(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateQuantity(int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getProductById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
