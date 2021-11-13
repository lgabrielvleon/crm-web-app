package org.example.dao.store;

import org.apache.log4j.Logger;
import org.example.dao.connection.ConnectionManager;
import org.example.entity.Product;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ProductDAO {
    private static Logger logger = Logger.getLogger(ProductDAO.class);
    private ConnectionManager connectionManager = ConnectionManager.getInstance();

    // Singleton
    private static ProductDAO instance = null;
    private ProductDAO(){}
    public static ProductDAO getInstance(){
        if (instance == null){
            instance = new ProductDAO();
        }
        return instance;
    }
    // End Singleton

    public ArrayList<Product> list () throws Exception{
        ArrayList<Product> lstProduct = new ArrayList<Product>();
        try{
            CallableStatement cs = connectionManager.getConnect().prepareCall("{ call sp_listProducts}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                lstProduct.add(new Product(
                   rs.getInt("idProduct"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("stock"),
                        rs.getDouble("price"),
                        new Date(),
                        new Date()
                ));
            }
        }catch (SQLException exception){
            logger.error(exception);
        }finally {
            connectionManager.getConnect().close();
        }

        return lstProduct;
    }
}
