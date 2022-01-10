package org.example.view.servlet;

import org.apache.log4j.Logger;
import org.example.entity.Product;
import org.example.entity.SaleDetail;

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
                ArrayList<SaleDetail> lstCartShopping = new ArrayList<SaleDetail>();
                logger.info("obtuvo lista productos");
                if(session.getAttribute("lstCartShopping")!=null){
                    logger.info("si hay carrito");
                    lstCartShopping = (ArrayList<SaleDetail>) session.getAttribute("lstCartShopping");
                    logger.info("lee el carrito");


                    String action = request.getParameter("action")+"";
                    logger.info(request.getParameter("action"));
                    if(request.getParameter("action") == null){
                        Boolean flagListExists = false;

                        for (SaleDetail saleDetail: lstCartShopping){
                            if (saleDetail.getObjProduct().getId() == idProduct){
                                flagListExists = true;
                                saleDetail.setUnits(saleDetail.getUnits()+1);
                            }
                        }

                        logger.info("Flag si existe en lista: "+flagListExists);

                        if (!flagListExists){
                            objProductTmp = searchProduct(idProduct, products);

                            SaleDetail objTmp = new SaleDetail();
                            objTmp.setObjProduct(objProductTmp);
                            objTmp.setUnits(1);
                            objTmp.setUnitPrice(objProductTmp.getPrice());
                            lstCartShopping.add(objTmp);
                        }

                    }else if (action.equals("D")){
                        logger.info("Action D");
                        lstCartShopping.remove(idProduct);
                        logger.info("Eliminando el producto de la lista index:"+idProduct);
                    }

                }else{
                    objProductTmp = searchProduct(idProduct, products);
                    SaleDetail objTmp = new SaleDetail();
                    objTmp.setObjProduct(objProductTmp);
                    objTmp.setUnits(1);
                    objTmp.setUnitPrice(objProductTmp.getPrice());
                    lstCartShopping.add(objTmp);
                }


                session.setAttribute("lstCartShopping", lstCartShopping);
            }

            response.sendRedirect("Store/Cart.jsp");

        }catch (Exception e){
            logger.error(e);
        }
    }

    private Product searchProduct(int idProduct, ArrayList<Product> products){
        Product objProductTmp = new Product();
        for (Product product:products) {
            if (product.getId() == idProduct){
                objProductTmp = product;
            }
        }
        return objProductTmp;
    }
}
