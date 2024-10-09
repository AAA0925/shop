<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopping.model.BuyerIntent" %>
<%@ page import="com.example.shopping.model.Product" %>
<%@ page import="com.example.shopping.dao.ProductDAO" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>商家后台</title>
</head>
<body>
    <h1>商家后台</h1>

    <h2>发布商品</h2>
    <form action="admin/add-product" method="post">
        <input type="text" name="name" placeholder="商品名称" required>
        <input type="text" name="description" placeholder="商品描述" required>
        <input type="text" name="image" placeholder="商品图片URL" required>
        <input type="number" name="price" placeholder="商品价格" required>
        <button type="submit">发布商品</button>
    </form>

	<h2>商品管理</h2>
<table border="1">
    <tr>
        <th>商品名称</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <%  ProductDAO productDAO = new ProductDAO(); 
        List<Product> products = productDAO.getAvailableProducts();
        for (Product product : products) {
    %>
    <tr>
        <td><%= product.getName() %></td>
        <td><%= product.getStatus() %></td>
        <td>
            <form action="admin/update-product-status" method="post">
                <input type="hidden" name="productId" value="<%= product.getId() %>">
                <% if ("available".equals(product.getStatus())) { %>
                    <button type="submit" name="status" value="frozen">冻结</button>
                <% } else if ("frozen".equals(product.getStatus())) { %>
                    <button type="submit" name="status" value="sold">下架</button>
                    <button type="submit" name="status" value="available">重新上架</button>
                <% } %>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>
	
    <h2>历史商品</h2>
    <a href="history.jsp">查看历史商品</a>


    <h2>意向购买用户</h2>
    <table border="1">
        <tr>
            <th>用户名</th>
            <th>联系方式</th>
            <th>操作</th>
        </tr>
        <%
            
            List<BuyerIntent> intents = productDAO.getBuyerIntents();
            for (BuyerIntent intent : intents) {
        %>
        <tr>
            <td><%= intent.getUserName() %></td>
            <td><%= intent.getUserContact() %></td>
            <td>
                <form action="admin/freeze-product" method="post">
                    <input type="hidden" name="productId" value="<%= intent.getProductId() %>">
                    <button type="submit">冻结商品</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
        <br><br>
        <a href="index.jsp">返回首页</a>
</body>
</html>
