<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.entity.Persona" %>
<%@ page import="org.example.dao.commons.PersonaDAO" %><%--
  Created by IntelliJ IDEA.
  User: lucasvasquez
  Date: 19/09/21
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Persona objPersona = new Persona();
    HttpSession session1 = request.getSession();
    if (session1.getAttribute("objPersona")!= null){
        objPersona = (Persona) session1.getAttribute("objPersona");
        if (objPersona.getId() == 0){
            response.sendRedirect("login.jsp");
        }
    }else{
        response.sendRedirect("login.jsp");
    }
%>
<html>
<head>
    <title>Admin | CRM</title>
</head>
<body>
    <h1>Gestion de Personas</h1>
    <p>Hola <%=objPersona.getFirstName()%>, bienvenido!</p>
    <a href="sAutentication?type=logout">Logout</a>
    <a href="frmAddPersona.jsp">Registrar nueva Persona</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Last Name</th>
                <th>Phone</th>
                <th>Document Number</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Persona> lst = new ArrayList<>();
            lst = PersonaDAO.getInstance().list();
            for(Persona persona: lst) {
        %>
            <tr>
                <td><%=persona.getId()%></td>
                <td><%=persona.getFirstName()%></td>
                <td><%=persona.getLastName()%></td>
                <td><%=persona.getPhone()%></td>
                <td><%=persona.getDocumentNumber()%></td>
                <td>
                    <a href="sGestionPersona?type=E&id=<%=persona.getId()%>">Edit</a>
                    <a href="sGestionPersona?type=D&id=<%=persona.getId()%>">Delete</a>
                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>

</body>
</html>
