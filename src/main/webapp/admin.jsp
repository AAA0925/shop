<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <h2>历史商品</h2>
    <a href="history.jsp">查看历史商品</a>
    <a href="index.jsp">返回首页</a>
</body>
</html>
