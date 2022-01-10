<%@ page import="org.example.entity.SaleDetail" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.entity.Persona" %>
<%@ page import="org.example.entity.Sale" %><%--
  Created by IntelliJ IDEA.
  User: lucasvasquez
  Date: 12/1/21
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm Sale</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Confirm Sale</h1>
<%

    Persona objPersona = (Persona) session.getAttribute("objPersona");
    if (objPersona!=null){
        Sale objSale = (Sale) session.getAttribute("SaleHeader");
        if (objSale == null){
            response.sendRedirect("../CartShopping");
        }

%>

    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Sale</h5>
            <h6 class="card-subtitle mb-2 text-muted"><%=(objSale.getObjPerson().getFirstName()+" "+objSale.getObjPerson().getLastName()).trim()%></h6>
            <p class="card-text">Fecha de compra: <%=objSale.getRegisterDateTime()%></p>
            <p class="card-text">Impuestos (IGV): <%=objSale.getIgv()%></p>
            <p class="card-text">Total de la compra: <%=objSale.getTotal()%></p>
        </div>
    </div>
    <br>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Description</th>
        <th scope="col">Unit</th>
        <th scope="col">Price Unit</th>
        <th scope="col">SubTotal</th>
    </tr>
    </thead>
    <tbody>
    <%
        int counter = 0;
        for (SaleDetail saleDetail:objSale.getLstSaleDetails()) {
    %>
    <tr>
        <th scope="row"><%=saleDetail.getObjProduct().getId()%></th>
        <td><%=saleDetail.getObjProduct().getName()%></td>
        <td><%=saleDetail.getObjProduct().getDescription()%></td>
        <td><%=saleDetail.getUnits()%></td>
        <td><%=saleDetail.getUnitPrice()%></td>
        <td><%=saleDetail.getSubTotal()%></td>
    </tr>
    <%
            counter++;
        }
    %>
    </tbody>
</table>

<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#confirmarVenta">Confirmar</button>
    <!-- Modal -->
    <div class="modal fade" id="confirmarVenta" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Confirmar Venta</h5>
                    <a type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></a>
                </div>
                <div class="modal-body">
                    Hola!, si deseas culminar tu venta, haz clic en el botón <b>Confirmar</b>
                </div>
                <div class="modal-footer">
                    <a href="../CartShopping" class="btn btn-secondary" >Cancelar</a>
                    <form method="post" action="../ConfirmSale">
                        <button type="submit" class="btn btn-primary">Confirmar</button>
                    </form>

                </div>
            </div>
        </div>
    </div>
    <%
        }else{
            response.sendRedirect("../login.jsp");
        }
    %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</body>
</html>
