<%--
  Created by IntelliJ IDEA.
  User: lucasvasquez
  Date: 12/10/21
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Registrar persona</h1>
    <form method="post" action="sAddPersona">
        <label for="name">Name:</label>
        <input id="name" name="name" type="text"/>
        <br>
        <label for="lastName">Last Name:</label>
        <input id="lastName" name="lastName" type="text"/>
        <br>
        <label for="phone">Phone:</label>
        <input id="phone" name="phone" type="text"/>
        <br>
        <label for="documentNumber">Document Number:</label>
        <input id="documentNumber" name="documentNumber" type="text"/>
        <br>
        <button type="submit">Agregar</button>
    </form>
</body>
</html>
