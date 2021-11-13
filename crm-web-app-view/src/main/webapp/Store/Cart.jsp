<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: lucasvasquez
  Date: 11/13/21
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/d68f652799.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">


    <h1>Shopping Cart</h1>
    <%
        ArrayList<Product> lstShoppingCart = (ArrayList<Product>) session.getAttribute("lstCartShopping");
        if (lstShoppingCart != null){
            out.print(lstShoppingCart.size());
    %>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <%
                int counter = 0;
                for (Product product:lstShoppingCart) {
            %>
                <tr>
                    <th scope="row"><%=product.getId()%></th>
                    <td><%=product.getName()%></td>
                    <td><%=product.getDescription()%></td>
                    <td><a href="../CartShopping?idProduct=<%=counter%>&action=D"><i class="fas fa-trash-alt"></i></a></td>
                </tr>
            <%
                    counter++;
                }
            %>
            </tbody>
        </table>
    <%
        }else{
    %>
        <h2>Tu carrito de compras está vacio</h2>
    <%
        }
    %>

    <a href="../StoreProducts" class="btn btn-primary">Seguir Comprando</a>


</div>
</body>
</html>
