package org.example.dao.connection;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static ConnectionManager instance = null;
    private ConnectionManager(){}
    public static ConnectionManager getInstance(){
        if (instance==null){
            instance=new ConnectionManager();
        }
        return instance;
    }

    private static final Logger logger = Logger.getLogger(ConnectionManager.class);

    public Connection getConnect(){
        PropertyConfigurator.configure("/usr/local/tomcat/conf/log4j.properties");
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://172.17.0.3:3306/CRM","uBseAppDev","uBseAppDev");
        }catch (SQLException sqlException){
            logger.error(sqlException);
        }catch (Exception exception){
            logger.error(exception);
        }
        return con;
    }



}
