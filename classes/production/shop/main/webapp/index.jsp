<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
    <h1>商品列表</h1>
    <div id="products">
        <c:forEach var="product" items="${products}">
            <div class="product">
                <h2>商品名称：${product.name}</h2>
                <p>商品描述：${product.description}</p>
                <p>价格： ${product.price}</p>
                <form action="purchase" method="post">
                    <input type="hidden" name="productId" value="${product.id}">
                    <input type="text" name="userName" placeholder="请输入您的姓名" required>
                    <input type="text" name="userContact" placeholder="请输入您的联系方式" required>
                    <button type="submit">购买</button>
                </form>
            </div>
        </c:forEach>
    </div>
    <a href="login.jsp">卖家登录</a>
</body>
</html>

