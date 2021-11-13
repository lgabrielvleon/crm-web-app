package org.example.dao.commons;

import org.apache.log4j.Logger;
import org.example.dao.connection.ConnectionManager;
import org.example.entity.Persona;
import org.example.entity.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PersonaDAO {
    private static PersonaDAO instance = null;
    private PersonaDAO(){}

    public static PersonaDAO getInstance(){
        if (instance==null){
            instance = new PersonaDAO();
        }
        return instance;
    }
    private Connection connection = ConnectionManager.getInstance().getConnect();
    private static Logger logger = Logger.getLogger(PersonaDAO.class);
    // List
    public ArrayList<Persona> list (){
        ArrayList<Persona> lst = new ArrayList<>();
        try{
            CallableStatement cs = connection.prepareCall("{call sp_listPersonas}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                Persona objTmp = new Persona(
                        rs.getInt("idPersona"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("phone"),
                        rs.getString("documentNumber"),
                        "",
                        "",
                        new Date(),
                        new Date(),
                        new User()
                );
                lst.add(objTmp);
                logger.info("Se agregó a la lista: "+ objTmp.toString());
            }
            return lst;
        }catch (SQLException sqlException){
            logger.error(sqlException);
        }
        return lst;
    }

    // Add
    public Boolean add (Persona objPersona) {

        try{
            CallableStatement cs = connection.prepareCall("{call sp_addPersona(?,?,?,?)}");
            cs.setString(1,objPersona.getFirstName());
            cs.setString(2,objPersona.getLastName());
            cs.setString(3,objPersona.getPhone());
            cs.setString(4, objPersona.getDocumentNumber());
            cs.executeUpdate();
            return true;
        }catch (SQLException sqlException){
            logger.error(sqlException);
        }
        return false;
    }

    // Update
    public Boolean update (Persona objPersona) {
        try{
            CallableStatement cs = connection.prepareCall("{call sp_updatePersona(?, ?, ?, ?, ?)}");
            cs.setInt(1, objPersona.getId());
            cs.setString(2, objPersona.getFirstName());
            cs.setString(3, objPersona.getLastName());
            cs.setString(4, objPersona.getPhone());
            cs.setString(5, objPersona.getDocumentNumber());

            cs.executeUpdate();

            return true;
        }catch (SQLException sqlException){
            logger.error(sqlException);
        }
        return false;
    }

    // Delete
    public Boolean delete (int id) {
        try{
            CallableStatement cs = connection.prepareCall("{call sp_deletePersona(?)}");
            cs.setInt(1, id);

            cs.executeUpdate();

            return true;
        }catch (SQLException sqlException){
            logger.error(sqlException);
        }
        return false;
    }

    // Search
    public Persona getById (int id) {
        Persona objPersona = new Persona();
        try{
            CallableStatement cs = connection.prepareCall("{call sp_getByIdPersona(?)}");
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            if (rs.next()){
                objPersona = new Persona(
                    rs.getInt("idPersona"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("phone"),
                    rs.getString("documentNumber"),
                    rs.getString("birthday"),
                    rs.getString("email"),
                    rs.getDate("timestamp_register"),
                    rs.getDate("timestamp_update"),
                    new User()
                );
            }
        }catch (SQLException sqlException){
            logger.error(sqlException);
        }
        return objPersona;
    }
}
