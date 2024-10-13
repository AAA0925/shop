<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>发布商品</title>
    <link rel="stylesheet" href="styles/style.css">
</head>
<body>
    <div class="container">
        <h1>发布商品</h1>
        <form action="add-product" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">商品名称:</label>
                <input type="text" id="name" name="name" placeholder="商品名称" required>
            </div>
            <div class="form-group">
                <label for="description">商品描述:</label>
                <textarea id="description" name="description" placeholder="商品描述" required></textarea>
            </div>
            <div class="form-group">
                <label for="price">商品价格:</label>
                <input type="number" id="price" name="price" placeholder="商品价格" required>
            </div>
            <div class="form-group">
                <label for="image">上传商品图片:</label>
                <input type="file" id="image" name="image" accept="image/*" required>
            </div>
            <button type="submit">发布商品</button>
        </form>
        <a href="admin.jsp">返回后台</a>
    </div>
</body>
</html>
