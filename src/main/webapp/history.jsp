<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopping.dao.ProductDAO" %>
<%@ page import="com.example.shopping.model.Product" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>历史商品</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <h1>历史商品</h1>

    <table border="1">
        <tr>
            <th>商品名称</th>
            <th>价格</th>
            <th>状态</th>
        </tr>
        <%
            ProductDAO productDAO = new ProductDAO();
            List<Product> historicalProducts = productDAO.getHistoricalProducts();
            for (Product product : historicalProducts) {
        %>
		<div class="product-details">
            <h2><%= product.getName() %></h2>
            <p>描述：<%= product.getDescription() %></p>
            <p>价格：¥<%= product.getPrice() %></p>
            <p>状态：<%= product.getStatus() %></p>
            <img src="<%= product.getImage() %>" alt="<%= product.getName() %>" style="width: 150px; height: auto;">

        </div>
        <%
            }
        %>
    </table>

    <a href="admin.jsp">返回商家后台</a>
</body>
</html>

