<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
</head>
<body>
<h1>商品列表</h1>
<table>
    <tr>
        <th>名称</th>
        <th>描述</th>
        <th>图片</th>
        <th>价格</th>
        <th>状态</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td><img src="${product.image}" alt="${product.name}" width="100"></td>
            <td>${product.price}</td>
            <td>${product.status}</td>
        </tr>
    </c:forEach>
</table>
<a href="index.html">返回</a>
</body>
</html>
