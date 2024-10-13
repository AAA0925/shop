<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopping.dao.ProductDAO" %>
<%@ page import="com.example.shopping.model.Product" %>
<%@ page import="com.example.shopping.model.BuyerIntent" %>
<%@ page import="com.example.shopping.dao.BuyerIntentDAO" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <h1>商品列表</h1>

   <div id="products">
    <%
        ProductDAO productDAO = new ProductDAO();
        BuyerIntentDAO buyerIntentDAO = new BuyerIntentDAO();
        List<Product> availableProducts = productDAO.getAvailableProducts();
        for (Product product : availableProducts) {
    %>
    <div class="product">
        <div class="product-details">
            <h2><%= product.getName() %></h2>
            <p>描述：<%= product.getDescription() %></p>
            <p>价格：¥<%= product.getPrice() %></p>
            <p>状态：<%= product.getStatus() %></p>
            <img src="<%= product.getImage() %>" alt="<%= product.getName() %>" style="width: 150px; height: auto;">

        </div>

        <div class="purchase-form">
            <form action="buyer-intent" method="post">
                <input type="hidden" name="productId" value="<%= product.getId() %>">
                <input type="text" name="userName" placeholder="请输入您的姓名" required>
                <input type="text" name="userContact" placeholder="请输入您的联系方式" required>
                <button type="submit">购买</button>
            </form>
        </div>
    </div>
    <%
        }
    %>
</div>



    <a href="login.jsp">卖家登录</a>
</body>
</html>
