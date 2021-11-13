package org.example.view.servlet;

import org.apache.log4j.Logger;
import org.example.dao.commons.PersonaDAO;
import org.example.dao.security.UserDAO;
import org.example.entity.Persona;
import org.example.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "sAutentication", value = "/sAutentication")
public class sAutentication extends HttpServlet {
    private static Logger logger = Logger.getLogger(sAutentication.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        if (username != null && password != null ){
            Persona objPersona = new Persona();
            objPersona = UserDAO.getInstance().autentication(new User(0,username,password,new Date(),new Date()));
            logger.info(objPersona.toString());
            if (objPersona.getId() != 0){
                session.setAttribute("objPersona", objPersona);
                response.sendRedirect("index.jsp");
            }else{
                response.sendRedirect("login.jsp");
            }
        }else{
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("type").equals("logout")){
            HttpSession session = request.getSession();
            session.removeAttribute("objPersona");
        }
        response.sendRedirect("login.jsp");
    }
}
