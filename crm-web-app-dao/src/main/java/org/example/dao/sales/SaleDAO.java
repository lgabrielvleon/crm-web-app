package org.example.dao.sales;

import org.apache.log4j.Logger;
import org.example.dao.connection.ConnectionManager;
import org.example.entity.Sale;
import org.example.entity.SaleDetail;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.UUID;

public class SaleDAO {
    private ConnectionManager connectionManager = ConnectionManager.getInstance();
    private Logger logger = Logger.getLogger(SaleDAO.class);
    //Singleton
    private static SaleDAO instance = null;
    private SaleDAO(){}
    public static SaleDAO getInstance(){
        if (instance == null){
            instance = new SaleDAO();
        }
        return instance;
    }
    //End Singleton


    public boolean register (Sale objSale){
        try{
            String UUID = java.util.UUID.randomUUID().toString();
            logger.info(UUID);
            Calendar cal = Calendar.getInstance();
            cal.setTime(objSale.getRegisterDateTime());
            cal.set(Calendar.MILLISECOND, 0);
            CallableStatement cs = connectionManager.getConnect().prepareCall("{call sp_sale_register(?,?)}");
            cs.setString(1,UUID);
            cs.setInt(2, objSale.getObjPerson().getId());
            cs.executeUpdate();

            for (SaleDetail saleDetail:objSale.getLstSaleDetails()){
                SaleDetailDAO.getInstance().register(saleDetail,UUID);
            }

        }catch (SQLException sqlException){
            logger.error(sqlException.getMessage());
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return true;
    }
}
