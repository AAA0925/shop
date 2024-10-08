<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>历史商品</title>
</head>
<body>
    <h1>历史商品</h1>
    <div id="history-products">
        <c:forEach var="product" items="${historicalProducts}">
            <div class="product">
                <h2>商品名称：${product.name}</h2>
                <p>商品描述：${product.description}</p>
                <p>价格： ${product.price}</p>
                <p>状态： ${product.status}</p>
            </div>
        </c:forEach>
    </div>
    <a href="admin.jsp">返回后台</a>
</body>
</html>
