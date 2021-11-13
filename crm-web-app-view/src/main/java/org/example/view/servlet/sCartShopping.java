package org.example.view.servlet;

import org.apache.log4j.Logger;
import org.example.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "sCartShopping", value = "/CartShopping")
public class sCartShopping extends HttpServlet {
    private Logger logger = Logger.getLogger(sCartShopping.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("ingreso cartShopping");
        try{
            HttpSession session = request.getSession();
            Product objProductTmp = new Product();
            if (request.getParameter("idProduct")!= null){
                logger.info("ingreso idProduct");
                int idProduct = Integer.parseInt(request.getParameter("idProduct"));
                ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("lstProducts");
                ArrayList<Product> lstCartShopping = new ArrayList<Product>();
                logger.info("obtuvo lista productos");
                if(session.getAttribute("lstCartShopping")!=null){
                    logger.info("si hay carrito");
                    lstCartShopping = (ArrayList<Product>) session.getAttribute("lstCartShopping");
                    logger.info("lee el carrito");
                    for (Product product:products) {
                        if (product.getId() == idProduct){
                            objProductTmp = product;
                        }
                    }
                    String action = request.getParameter("action")+"";
                    logger.info(request.getParameter("action"));
                    if(request.getParameter("action") == null){
                        lstCartShopping.add(objProductTmp);
                    }else if (action.equals("D")){
                        logger.info("Action D");
                        lstCartShopping.remove(idProduct);
                        logger.info("Eliminando el producto de la lista index:"+idProduct);
                    }

                }else{
                    for (Product product:products) {
                        if (product.getId() == idProduct){
                            objProductTmp = product;
                        }
                    }
                    lstCartShopping.add(objProductTmp);
                }


                session.setAttribute("lstCartShopping", lstCartShopping);
            }

            response.sendRedirect("Store/Cart.jsp");

        }catch (Exception e){
            logger.error(e);
        }
    }
}
