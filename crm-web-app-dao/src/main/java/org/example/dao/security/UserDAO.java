package org.example.dao.security;

import org.apache.log4j.Logger;
import org.example.dao.connection.ConnectionManager;
import org.example.entity.Persona;
import org.example.entity.User;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserDAO {
    private static Logger logger = Logger.getLogger(UserDAO.class);
    private ConnectionManager con = ConnectionManager.getInstance();

    /*Start Singleton*/
    private static UserDAO instance = null;
    private UserDAO(){}
    public static UserDAO getInstance(){
        if (instance == null){
            instance = new UserDAO();
        }
        return instance;
    }
    /*End Singleton*/

    public Persona autentication (User user){
        Persona objPersona = new Persona();
        try{
            CallableStatement cs = con.getConnect().prepareCall("{call sp_autentication(?,?)}");
            cs.setString(1, user.getUsername());
            cs.setString(2, user.getPassword());

            ResultSet rs = cs.executeQuery();

            if (rs.next()){
                objPersona = new Persona(
                        rs.getInt("idPersona"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        "",
                        "",
                        "",
                        rs.getString("email"),
                        new Date(),
                        new Date(),
                        new User(
                                rs.getInt("idUser"),
                                rs.getString("userName"),
                                "",
                                new Date(),
                                new Date()
                        )
                );
            }

        }catch (SQLException sqlException){
            logger.error(sqlException);
        }
        return objPersona;
    }


}
