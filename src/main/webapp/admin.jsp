<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopping.dao.ProductDAO" %>
<%@ page import="com.example.shopping.model.Product" %>
<%@ page import="com.example.shopping.model.BuyerIntent" %>
<%@ page import="com.example.shopping.dao.BuyerIntentDAO" %>

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
            <div class="product-details">
            <h2><%= product.getName() %></h2>
            <p>描述：<%= product.getDescription() %></p>
            <p>价格：¥<%= product.getPrice() %></p>
            <p>状态：<%= product.getStatus() %></p>
            <img src="<%= product.getImage() %>" alt="<%= product.getName() %>" style="width: 150px; height: auto;">

        </div>
            <td>
                <form action="manage-product" method="post">
                    <input type="hidden" name="productId" value="<%= product.getId() %>">
                    <%
                        if ("available".equals(product.getStatus())) {
                    %>
                    <button type="submit" name="action" value="freeze">冻结商品</button>
                    <%
                        } else if ("frozen".equals(product.getStatus())) {
                    %>
                    <button type="submit" name="action" value="unlist">下架商品</button>
                    <button type="submit" name="action" value="restore">恢复商品</button>
                    <%
                        }
                    %>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>

    <h2>发布商品</h2>
	<a href="addproduct.jsp">发布商品</a>
	
	<h2>查看意向购买人</h2>
    <table border="1">
        <tr>
            <th>商品ID</th>
            <th>商品名称</th>
            <th>买家姓名</th>
            <th>联系方式</th>
        </tr>
        <%
            BuyerIntentDAO buyerIntentDAO = new BuyerIntentDAO();
            List<BuyerIntent> buyerIntents = buyerIntentDAO.getBuyerIntentsExcludingSoldProducts();
            for (BuyerIntent intent : buyerIntents) {
                Product product = productDAO.getProductById(intent.getProductId()); // 获取对应商品的信息
        %>
        <tr>
            <td><%= intent.getProductId() %></td>
            <td><%= product != null ? product.getName() : "商品已下架" %></td>
            <td><%= intent.getUserName() %></td>
            <td><%= intent.getUserContact() %></td>
        </tr>
        <%
            }
        %>
    </table>
	
    <h2>历史商品</h2>
    <a href="history.jsp">查看历史商品</a>
    <a href="index.jsp">返回首页</a>
    
    <h2>修改密码</h2>
	<form action="change-password" method="post">
	    <input type="password" name="oldPassword" placeholder="当前密码" required>
	    <input type="password" name="newPassword" placeholder="新密码" required>
	    <button type="submit">修改密码</button>
	</form>
	<form action="reset-system" method="post">
    	<button type="submit">重置系统</button>
	</form>
	
    
</body>
</html>
