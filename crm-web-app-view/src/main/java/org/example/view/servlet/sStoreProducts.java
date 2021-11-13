package org.example.view.servlet;

import org.apache.log4j.Logger;
import org.example.dao.store.ProductDAO;
import org.example.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "sStoreProducts", value = "/StoreProducts")
public class sStoreProducts extends HttpServlet {
    private static Logger logger = Logger.getLogger(sStoreProducts.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ArrayList<Product> lstProducts = new ArrayList<Product>();
            lstProducts = ProductDAO.getInstance().list();
            HttpSession session = request.getSession();
            session.setAttribute("lstProducts", lstProducts);
            response.sendRedirect("Store/Products.jsp");
        }catch (Exception e){
            logger.error(e);
            response.sendRedirect("ErrorPage.jsp");
        }
    }
}
