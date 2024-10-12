<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopping.dao.ProductDAO" %>
<%@ page import="com.example.shopping.model.Product" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>商家后台</title>
</head>
<body>
    <h1>商家后台</h1>

    <h2>可用商品</h2>
    <table border="1">
        <tr>
            <th>商品名称</th>
            <th>价格</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <%
            ProductDAO productDAO = new ProductDAO();
            List<Product> products = productDAO.getAvailableProducts();
            for (Product product : products) {
        %>
        <tr>
            <td><%= product.getName() %></td>
            <td><%= product.getPrice() %></td>
            <td><%= product.getStatus() %></td>
            <td>
                <form action="freezeProduct" method="post">
                    <input type="hidden" name="productId" value="<%= product.getId() %>">
                    <button type="submit">冻结商品</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>

    <h2>发布商品</h2>
    <form action="admin/add-product" method="post">
        <input type="text" name="name" placeholder="商品名称" required>
        <input type="text" name="description" placeholder="商品描述" required>
        <input type="text" name="image" placeholder="商品图片URL" required>
        <input type="number" name="price" placeholder="商品价格" required>
        <button type="submit">发布商品</button>
    </form>

    <h2>历史商品</h2>
    <a href="history.jsp">查看历史商品</a>
    <a href="index.jsp">返回首页</a>
</body>
</html>
