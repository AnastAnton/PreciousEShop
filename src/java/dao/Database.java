package dao;

//import cmdutils.Command;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Customer;
import models.Product;
import models.ProductDTO;

public class Database {
    public String server;
    public String username;
    public String password; // kanonika ola private me getters setters
    public String database;
    
    static Connection con;
    Statement statement;                //auto pernaei mono strings(me stringbuilder ta kanoume ola string)
    PreparedStatement prStatement;
    ResultSet rs;
    
    public Database(){
        
        username = "root";
        password = "4991MPA2103sket";
        database = "eshop1";
        server = "jdbc:mysql://localhost/" + database + "?useSSL=false&serverTimezone=Europe/Athens";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");      //prepei na valw auto gia na kanw register to driver gia na mporesei na sundethei
            con = DriverManager.getConnection(server, username, password);
            System.out.println("Connected");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection is not established");
        }
    }
 
//    public int insertOrder (Scanner sc){
//        int result = 0;
//        
//        /*  Step    1 - Select customer
//                    1.1 SELECT * FROM CUSTOMERS
//                    1.2 PRINT CUSTOMERS
//                    1.3 From cmd choose customer
//            Step    2 - Select products
//                    2.1 SELECT * FROM products
//                    2.2 PRINT products
//                    2.3 From cmd choose products
//            Step    3 - Sum products
//            Step    4 - insertOrder()
//            Step    5 - insertProductDetails()
//        */
//        int customerId = selectCustomer(sc);
//        System.out.println("Customer Id: " + customerId);
//        List<ProductDTO> productIdsQuantities = selectProducts(sc);
//        System.out.println("Products's Ids: " + productIdsQuantities);
//        double sumPricesOfSelectedProducts = sumProductsPrices(productIdsQuantities);
//        int orderId = addOrder(customerId, sumPricesOfSelectedProducts, "orders2");
//        String orders2_id = lastOrderId();
//        insertOrderDetails(orders2_id, productIdsQuantities, "orders2_details");
//        
//        return (result);
//    }
    
//    public int selectCustomer (Scanner sc){
//        int customerID = -1;
//        Command cmd = new Command();
//        
//        ResultSet rs;
//        try {
//            //        System.out.println(sb.toString());
//            statement = con.createStatement();
//            rs = statement.executeQuery("SELECT * FROM customers");
//            while(rs.next()){
//                System.out.println(rs.getString("id") + ". " +
//                                   rs.getString("first_name") + " " +
//                                   rs.getString("last_name"));
//            }    
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        // we should check that the returned Id is valid
//        customerID = cmd.getIntField(sc, "Please select the customer");
//        return (customerID);
//    }
//    
//    public List<ProductDTO> selectProducts (Scanner sc){
//        List<ProductDTO> productIdsQuantities = new ArrayList<>();
//        Command cmd = new Command();
//        
//        ResultSet rs;
//        try {
//            //        System.out.println(sb.toString());
//            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            rs = statement.executeQuery("SELECT * FROM products");
//            while(rs.next()){
//                System.out.println(rs.getString("id") + ". " +
//                                   rs.getString("name") + " "
//                );
//            }    
//            // we should check that the returned Ids are valid
//            while(cmd.getIntField(sc, "Please type 1 to add a new product") == 1){
//                //product id
//                int prId = cmd.getIntField(sc, "Please select the products");
//                
//                //ask for quantity for the previous product
//                int quant = cmd.getIntField(sc, "Please type the quantity of the product with id: " + 
//                                     prId);
//                rs.absolute(prId);          //kanonika edw thelei select me where gt ama exei ginei kapoio delete den sunadei to row me to id!!
////                rs = statement.executeQuery("SELECT * FROM `products` WHERE id = " + prId);
//                double price = rs.getDouble("price");
//                productIdsQuantities.add(new ProductDTO(prId, quant, price));
//                
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        return (productIdsQuantities);
//    }
    
//    double sumProductsPrices(List<ProductDTO> products){
//        double result = 0;
//        for (ProductDTO product : products){
//            result += product.getPrice() * product.getQuantity();
//        }
//        return (result);
//    }
//    
//    public int addOrder(int customerId, double totalPrice, String tableName){
//        //INSERT INTO orders2(`customers_id`, `totatl_price`, `date`) 
//        //VALUES (1, 187.65, "2020-12-03"), (1, 4128.3, "2020-12-03")
//        int result = 0;
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("INSERT INTO ");
//        sb.append(tableName); 
//        sb.append("(`customers_id`, `total_price`, `date`) ");
//        sb.append("VALUES(");
//        sb.append("\""); sb.append(customerId); sb.append("\""); sb.append(",");
//        sb.append("\""); sb.append(totalPrice); sb.append("\""); sb.append(",");
//        sb.append("\""); sb.append(LocalDateTime.now()); sb.append("\"");
//        sb.append(")");
//        try {
//            //        System.out.println(sb.toString());
//            statement = con.createStatement();
//            result = statement.executeUpdate(sb.toString());
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return (result);
//    }

    public int insertOrderDetails(String orderId, List<ProductDTO> productsDTO, String tableName){
        //INSERT INTO orders2_details (`orders2_id`, `products_id`, `price`, `quantity`) 
        //                      VALUES(1           , 1            , 10     , 1),
        //                            (1           , 2            , 100    , 1)
        
        int result = 0;
        
        for(ProductDTO product : productsDTO){
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ");
            sb.append(tableName); 
            sb.append("(`orders2_id`, `products_id`, `price`, `quantity`) ");
            sb.append("VALUES(");
            sb.append("\""); sb.append(orderId); sb.append("\""); sb.append(",");
            sb.append("\""); sb.append(product.getProductId()); sb.append("\""); sb.append(",");
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
        }
        return (result);
        
    }

    public String lastOrderId(){
        String result = null;
        
        ResultSet rs;
        try {
            //        System.out.println(sb.toString());
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT `id` FROM orders2");
            while(rs.next()){
                result = rs.getString("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
   
        return (result);
    }
}
