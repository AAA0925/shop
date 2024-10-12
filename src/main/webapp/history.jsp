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
        <tr>
            <td><%= product.getName() %></td>
            <td><%= product.getPrice() %></td>
            <td><%= product.getStatus() %></td>
        </tr>
        <%
            }
        %>
    </table>

    <a href="admin.jsp">返回商家后台</a>
</body>
</html>

