package org.example.view.servlet;

import org.apache.log4j.Logger;
import org.example.dao.sales.SaleDetailDAO;
import org.example.dto.Orders;
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

@WebServlet(name = "sOrdersDetail", value = "/order/detail")
public class sOrdersDetail extends HttpServlet {
    private static Logger logger = Logger.getLogger(sOrdersDetail.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Get del detalle orden");
        try{
            HttpSession session = request.getSession();
            if (request.getParameter("idSale")!=null){
                String idSale = request.getParameter("idSale")+"";
                Sale sale = searchOrder(idSale, (ArrayList<Orders>) session.getAttribute("ordersList"));
                sale.setLstSaleDetails(calcSubtotal(SaleDetailDAO.getInstance().get(idSale)));
                session.setAttribute("orderDetail", sale);

                response.sendRedirect("../Sale/OrderDetail.jsp");
            }
        }catch (Exception e){
            logger.error(e);
        }
    }

    private Sale searchOrder(String idSale, ArrayList<Orders> list){
        Sale sale = new Sale();

        for (Orders order:list) {
            if (order.getIdOrder().equals(idSale)){
                sale.setIdSale(order.getIdOrder());
                sale.setRegisterDateTime(order.getRegisterDateTime());
                sale.setIgv(order.getIgv());
                sale.setTotal(order.getTotal());
                break;
            }
        }

        return sale;
    }

    private ArrayList<SaleDetail> calcSubtotal (ArrayList<SaleDetail> lstSaleDetails){

        for (SaleDetail detail: lstSaleDetails) {
            Double subTotal = detail.getUnits() * detail.getUnitPrice();
            detail.setSubTotal(subTotal);
        }

        return lstSaleDetails;
    }
}
