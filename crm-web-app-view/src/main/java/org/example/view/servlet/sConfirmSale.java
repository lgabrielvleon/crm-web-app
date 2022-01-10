package org.example.view.servlet;

import org.apache.log4j.Logger;
import org.example.dao.sales.SaleDAO;
import org.example.entity.Persona;
import org.example.entity.Sale;
import org.example.entity.SaleDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "sConfirmSale", value = "/ConfirmSale")
public class sConfirmSale extends HttpServlet {
    private Logger logger = Logger.getLogger(sConfirmSale.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            if (session.getAttribute("SaleHeader")!=null) {
                SaleDAO.getInstance().register((Sale) session.getAttribute("SaleHeader"));
                session.removeAttribute("SaleHeader");
                session.removeAttribute("lstCartShopping");
                response.sendRedirect("Sale/SuccessSale.jsp");
            }else {
                response.sendRedirect("CartShopping");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            if (session.getAttribute("lstCartShopping")!=null && session.getAttribute("objPersona")!=null){
                ArrayList<SaleDetail> saleDetails = (ArrayList<SaleDetail>) session.getAttribute("lstCartShopping");
                int total = 0;
                for (SaleDetail saleDetail:saleDetails){
                    saleDetail.setSubTotal(saleDetail.getUnits()*saleDetail.getUnitPrice());
                    total += saleDetail.getSubTotal();
                }

                Sale objSale = new Sale();
                objSale.setObjPerson((Persona) session.getAttribute("objPersona"));
                objSale.setTotal(((total*objSale.getIgv())/100)+total);
                objSale.setRegisterDateTime(new Date());
                objSale.setLstSaleDetails(saleDetails);
                session.setAttribute("SaleHeader", objSale);

            }
            response.sendRedirect("Sale/ConfirmSale.jsp");
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
