<%--
  Created by IntelliJ IDEA.
  User: lucasvasquez
  Date: 11/7/21
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Autentication</title>
</head>
<body>
    <header>
        <h1>Autentication</h1>
    </header>
    <section>
        <form action="sAutentication" method="post">
            <label for="user">Username: </label>
            <input name="user" id="user" type="text"/>

            <label for="password">Password: </label>
            <input name="password" id="password" type="password"/>

            <button type="submit">Login</button>
        </form>
    </section>

</body>
</html>
