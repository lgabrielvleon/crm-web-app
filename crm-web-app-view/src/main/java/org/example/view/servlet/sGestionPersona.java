package org.example.view.servlet;

import org.apache.log4j.Logger;
import org.example.dao.commons.PersonaDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "sGestionPersona", value = "/sGestionPersona")
public class sGestionPersona extends HttpServlet {
    private static Logger logger = Logger.getLogger(sGestionPersona.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            String typeAction = request.getParameter("type");
            if (typeAction.equals("E")){
                session.setAttribute("id", request.getParameter("id"));
                response.sendRedirect("sUpdatePersona");
            }
            if (typeAction.equals("D")){
                PersonaDAO.getInstance().delete(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("index.jsp");
            }
        }catch (Exception exception){
            logger.error(exception);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
