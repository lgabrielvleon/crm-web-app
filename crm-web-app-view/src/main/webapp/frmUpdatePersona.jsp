<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="org.example.entity.Persona" %><%--
  Created by IntelliJ IDEA.
  User: lucasvasquez
  Date: 12/10/21
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Persona objPersona = new Persona();
    try{
        HttpSession sessionTmp = request.getSession();

        if (sessionTmp.getAttribute("objPersona") != null){
            objPersona = (Persona)sessionTmp.getAttribute("objPersona");
            sessionTmp.removeAttribute("objPersona");
        }else{
            response.sendRedirect("index.jsp");
        }
    }catch (Exception exception){
        throw exception;
    }
%>
    <h1>Actualizar datos de la persona</h1>
    <form method="post" action="sUpdatePersona">
        <label for="id">ID: <%=objPersona.getId()%></label>
        <input id="id" name="id" type="text" value="<%=objPersona.getId()%>" hidden/>
        <br>
        <label for="name">Name:</label>
        <input id="name" name="name" value="<%=objPersona.getName()%>" type="text"/>
        <br>
        <label for="lastName">Last Name:</label>
        <input id="lastName" name="lastName" value="<%=objPersona.getLastName()%>" type="text"/>
        <br>
        <label for="phone">Phone:</label>
        <input id="phone" name="phone" type="text" value="<%=objPersona.getPhone()%>"/>
        <br>
        <label for="documentNumber">Document Number:</label>
        <input id="documentNumber" name="documentNumber" type="text" value="<%=objPersona.getDocumentNumber()%>"/>
        <br>
        <button type="submit">Actualizar</button>
    </form>
</body>
</html>
