package org.example.view.servlet;

import org.apache.log4j.Logger;
import org.example.dao.commons.PersonaDAO;
import org.example.entity.Persona;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "sAddPersona", value = "/sAddPersona")
public class sAddPersona extends HttpServlet {
    private static Logger logger = Logger.getLogger(sAddPersona.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Persona objPersona = new Persona();
            objPersona.setName(request.getParameter("name"));
            objPersona.setLastName(request.getParameter("lastName"));
            objPersona.setPhone(request.getParameter("phone"));
            objPersona.setDocumentNumber(request.getParameter("documentNumber"));

            logger.info("Obj a registrar: "+objPersona.toString());

            PersonaDAO.getInstance().add(objPersona);
            response.sendRedirect("index.jsp");
        }catch (Exception e){
            logger.error(e);
        }
    }
}
