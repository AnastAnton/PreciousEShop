package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ProductService;

@WebServlet(name = "product", urlPatterns = {"/product"})
public class Product extends HttpServlet{
    ProductService productService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        if(productService == null) productService = new ProductService();
//        int result = productService.insert(new models.Product("Swiss Army Knife", 20, 1));
//        int result = productService.update(new models.Product("Screwdriver", 50, 1), 4);
//        int result = productService.update(new models.Product("smart watch", 80, 2), "smart watch");
//        int result = productService.update(new models.Product("Fixit all", 187.65, 3), 187.65);
//        int result = productService.update(new models.Product("smart watch elite", 75, 2), 2);
//        int result = productService.delete(5);
        
        
        try {
            //        super.doGet(req, resp); // 405 - HttpServlet does not implement doGet
//            showHtml("<p>Inserted Records for Product: " + result, resp);
//            showHtml("<p>Updated Records for Customer: " + result, resp);
//            showAllHtml(productService.all(), resp);
            showOneHtml(productService.getProductById(2), resp);
            
        } catch (IOException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showHtml(String body, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html;charset=UTF-8"); // servlet
        try (PrintWriter out = resp.getWriter()) {
            /* for the browser */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Precious Eshop!</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(body);
            out.println("</body>");
            out.println("</html>");
        }
    }
    public void showAllHtml(List<models.Product> products, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html;charset=UTF-8"); // servlet
        try (PrintWriter out = resp.getWriter()) {
            /* for the browser */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Precious Eshop!</title>");            
            out.println("</head>");
            out.println("<body>");
            for(models.Product pr : products){
                out.println(pr.toString()); 
                out.println("</br>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    public void showOneHtml(models.Product product, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html;charset=UTF-8"); // servlet
        try (PrintWriter out = resp.getWriter()) {
            /* for the browser */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Precious Eshop!</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(product.toString()); 
            out.println("</body>");
            out.println("</html>");
        }
    }


}
