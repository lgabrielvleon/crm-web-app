package org.example.dao.sales;

import org.apache.log4j.Logger;
import org.example.dao.connection.ConnectionManager;
import org.example.dto.Orders;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderDAO {
    private ConnectionManager connectionManager = ConnectionManager.getInstance();
    private static Logger logger = Logger.getLogger(OrderDAO.class);

    /*Singleton*/
    private static OrderDAO instance = null;
    private OrderDAO(){}
    public static OrderDAO getInstance(){
        if (instance == null){
            instance = new OrderDAO();
        }
        return instance;
    }
    /*End Singleton*/

    public ArrayList<Orders> getList(int idCustomer) throws SQLException{
        ArrayList<Orders> orders = new ArrayList<Orders>();
        try {
            CallableStatement cs = connectionManager.getConnect().prepareCall("{call sp_reportSalesByClient(?)}");
            cs.setInt(1, idCustomer);

            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                orders.add(new Orders(
                        rs.getString("idSale"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("register_date")),
                        rs.getInt("quantity"),
                        rs.getDouble("subTotal"),
                        rs.getDouble("igv"),
                        rs.getDouble("total")
                ));
            }

        }catch (SQLException sqlException){
            logger.error(sqlException);
        }catch (Exception e){
            logger.error(e);
        }finally {
            connectionManager.getConnect().close();
            return orders;
        }
    }
}
