package org.example.view.servlet;

import org.apache.log4j.Logger;
import org.example.dao.commons.PersonaDAO;
import org.example.entity.Persona;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "sUpdatePersona", value = "/sUpdatePersona")
public class sUpdatePersona extends HttpServlet {
    private static Logger logger = Logger.getLogger(sUpdatePersona.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            Persona objPersona;
            objPersona = PersonaDAO.getInstance().getById(Integer.parseInt(session.getAttribute("id").toString()));
            session.removeAttribute("id");
            session.setAttribute("objPersona", objPersona);
            response.sendRedirect("frmUpdatePersona.jsp");
        }catch (Exception exception){
            logger.error(exception);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Persona objPersona = new Persona();
            objPersona.setId(Integer.parseInt(request.getParameter("id")));
            objPersona.setName(request.getParameter("name"));
            objPersona.setLastName(request.getParameter("lastName"));
            objPersona.setPhone(request.getParameter("phone"));
            objPersona.setDocumentNumber(request.getParameter("documentNumber"));
            logger.info("sUpdatePersona: " + objPersona.toString());

            PersonaDAO.getInstance().update(objPersona);
            response.sendRedirect("index.jsp");
        }catch (Exception exception){
            logger.error(exception);
        }
    }
}
