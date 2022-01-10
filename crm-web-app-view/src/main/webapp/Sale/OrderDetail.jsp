<%@ page import="org.example.entity.Sale" %>
<%@ page import="org.example.entity.SaleDetail" %><%--
  Created by IntelliJ IDEA.
  User: lucasvasquez
  Date: 1/8/22
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <%
        Sale sale = new Sale();
        if (session.getAttribute("orderDetail")!=null){
            sale = (Sale) session.getAttribute("orderDetail");
        }else{
            response.sendRedirect("../Orders");
        }
    %>
    <jsp:include page="../includes/navbar.jsp" />

    <div class="container">
        <div class="row align-middle">
            <p>Order Number: <%=sale.getIdSale()%></p>
        </div>
        <div class="row align-middle">
            <p>Date: <%=sale.getRegisterDateTime()%></p>
        </div>
        <div class="row">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">SKU</th>
                        <th scope="col">Product name</th>
                        <th scope="col">Units</th>
                        <th scope="col">Units Price</th>
                        <th scope="col">Sub total</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (SaleDetail detail:sale.getLstSaleDetails()) {
                    %>
                    <tr>
                        <th scope="row"><%=detail.getObjProduct().getId()%></th>
                        <td><%=detail.getObjProduct().getName()%></td>
                        <td><%=detail.getUnits()%></td>
                        <td><%=detail.getUnitPrice()%></td>
                        <td><%=detail.getSubTotal()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <div class="row">
            <div class="col-4 align-items-center">
                <a href="../Orders" class="btn btn-primary">Retornar</a>
            </div>
            <div class="col-4 align-items-center">
                <a href="javascript:print()" class="btn btn-success">Imprimir</a>
            </div>
            <div class="col-4">
                <div class="row">
                    <p>IGV: <%=sale.getIgv()%></p>
                </div>
                <div class="row">
                    <p>TOTAL: <%=sale.getTotal()%></p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
