<%@ page import="org.example.entity.Persona" %>
<%@ page import="org.example.dto.Orders" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lucasvasquez
  Date: 12/27/21
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/d68f652799.js" crossorigin="anonymous"></script>
</head>
<body>

<%

    Persona objPersona = (Persona) session.getAttribute("objPersona");
    if (objPersona!=null) {
        ArrayList<Orders> orders = (ArrayList<Orders>) session.getAttribute("ordersList");

%>
<jsp:include page="../includes/navbar.jsp"/>
    <div class="container">

        <h1>Orders</h1>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Fecha y Hora</th>
                <th scope="col">Quantity Products</th>
                <th scope="col">Sub Total</th>
                <th scope="col">IGV</th>
                <th scope="col">Total</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Orders order:orders) {
            %>
            <tr>
                <th scope="row"><%=order.getIdOrder()%></th>
                <td><%=order.getRegisterDateTime()%></td>
                <td><%=order.getQuantity()%></td>
                <td><%=order.getSubtotal()%></td>
                <td><%=order.getIgv()%></td>
                <td><%=order.getTotal()%></td>
                <td><a href="../order/detail?idSale=<%=order.getIdOrder()%>"><i class="fas fa-receipt"></i></a></td>
            <%
                }
            %>
            </tr>
            </tbody>
        </table>

    </div>
<%
    }else{
        response.sendRedirect("../sAutentication");
    }
%>
</body>
</html>
