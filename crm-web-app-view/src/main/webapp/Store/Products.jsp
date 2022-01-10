<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: lucasvasquez
  Date: 11/13/21
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<%
    ArrayList<Product> products = new ArrayList<Product>();
    if (session.getAttribute("lstProducts")!=null){
        products = (ArrayList<Product>) session.getAttribute("lstProducts");
    }else{
        response.sendRedirect("../ErrorPage.jsp");
    }

%>

<jsp:include page="../includes/navbar.jsp"/>
    <div class="container">
        <div class="row my-4">
        <%
            int j = 0;
            for (Product product:products) {
                if (j%3 == 0 && j != 0){
        %>
                    </div>
                    <div class="row my-4">
                        <div class="col-sm-4">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title"><%=product.getName()%></h5>
                                    <p class="card-text"><%=product.getDescription()%></p>
                                    <a href="../CartShopping?idProduct=<%=product.getId()%>" class="btn btn-primary">Seleccionar</a>
                                </div>
                            </div>
                        </div>
        <%
                }else{
        %>
                        <div class="col-sm-4">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title"><%=product.getName()%></h5>
                                    <p class="card-text"><%=product.getDescription()%></p>
                                    <a href="../CartShopping?idProduct=<%=product.getId()%>" class="btn btn-primary">Seleccionar</a>
                                </div>
                            </div>
                        </div>
        <%
                }
                j++;
            }
        %>
        </div>
    </div>
</body>
</html>
