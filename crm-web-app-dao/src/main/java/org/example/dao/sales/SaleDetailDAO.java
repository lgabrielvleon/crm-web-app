package org.example.dao.sales;

import org.apache.log4j.Logger;
import org.example.dao.connection.ConnectionManager;
import org.example.entity.Product;
import org.example.entity.SaleDetail;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class SaleDetailDAO {
    private ConnectionManager connectionManager = ConnectionManager.getInstance();
    private Logger logger = Logger.getLogger(SaleDetailDAO.class);
    //Singleton
    private static SaleDetailDAO instance = null;
    private SaleDetailDAO(){}
    public static SaleDetailDAO getInstance(){
        if (instance == null){
            instance = new SaleDetailDAO();
        }
        return instance;
    }
    //End Singleton

    public boolean register(SaleDetail objSaleDetail,String idSale){
        try{
            CallableStatement cs = connectionManager.getConnect().prepareCall("{CALL sp_saleDetail_register(?,?,?,?)}");
            cs.setInt(1, objSaleDetail.getObjProduct().getId());
            cs.setInt(2, objSaleDetail.getUnits());
            cs.setDouble(3, objSaleDetail.getUnitPrice());
            cs.setString(4, idSale);

            cs.executeUpdate();

        }catch (SQLException e){
            logger.error(e.getMessage());
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return true;
    }

    public ArrayList<SaleDetail> get(String idSale){
        ArrayList<SaleDetail> lst = new ArrayList<>();
        try {
            CallableStatement cs = connectionManager.getConnect().prepareCall("{CALL sp_saleDetail_get(?)}");
            cs.setString(1, idSale);
            ResultSet rs = cs.executeQuery();

            while (rs.next()){
                lst.add(
                    new SaleDetail(
                        rs.getInt("idsale_detail"),
                        new Product(
                            rs.getInt("idProduct"),
                            rs.getString("name"),
                            "",
                            0,
                            0.00,
                            new Date(),
                            new Date()
                        ),
                        rs.getInt("units"),
                        rs.getDouble("unitPrice"),
                        new Date(),
                        new Date()
                ));
            }
            connectionManager.getConnect().close();
        }catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return lst;
    }
}
