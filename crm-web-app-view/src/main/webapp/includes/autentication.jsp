<%@ page import="org.example.entity.Persona" %><%--
  Created by IntelliJ IDEA.
  User: lucasvasquez
  Date: 11/7/21
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession session1 = request.getSession();
    if (session1.getAttribute("objPersona")!= null){
        Persona objPersona = (Persona) session1.getAttribute("objPersona");
        if (objPersona.getId() == 0){
            response.sendRedirect("login.jsp");
        }
    }else{
        response.sendRedirect("login.jsp");
    }
%>