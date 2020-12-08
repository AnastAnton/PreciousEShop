package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Customer;

public class CustomerDao extends Database implements ICustomerDao {
    private Database db;
//    Connection con;
//    Statement statement;               
//    PreparedStatement prStatement;
//    ResultSet rs;
    
//    public CustomerDao(){
//        super();              epeidh exw kanei extends, me tin super kalw ton constructor tis Database. 
//    }                         Den xreiazetai na to grapsw gt me to extends ginetai automata
//    
    @Override
    public int insert(Customer customer, String tableName) {
        if(db == null)db = new Database();
        // INSERT INTO `customers` (first_name, last_name, tel, email)
        // VALUES ("John", "Johnakos", "211111", "j@j.jjj")
        int result = 0;
        StringBuilder sb = new StringBuilder();
                                                                                //gemizei to string (ta metatrepei ola se string)
        sb.append("INSERT INTO ");
        sb.append(tableName);
        sb.append("(first_name, last_name, tel, email) ");
        sb.append("VALUES(");
        sb.append("\""); sb.append(customer.getFirstName()); sb.append("\""); sb.append(",");
        sb.append("\""); sb.append(customer.getLastName()); sb.append("\""); sb.append(",");
        sb.append("\""); sb.append(customer.getTel()); sb.append("\""); sb.append(",");
        sb.append("\""); sb.append(customer.getEmail()); sb.append("\"");
        sb.append(")");
        try {
            //        System.out.println(sb.toString());
            if(con != null){
            statement = con.createStatement();
            result = statement.executeUpdate(sb.toString());                    //to execute update gurnaei posa row ephreastikan
        }else {
                System.out.println("Connetion problems!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (result);
    }

    @Override
    public int update(int customerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(String firstName, String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int customerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer getCustomerById(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


}
