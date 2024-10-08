<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>卖家登录</title>
</head>
<body>
    <h1>卖家登录</h1>
    <form action="login" method="post">
        <input type="password" name="password" placeholder="请输入密码" required>
        <button type="submit">登录</button>
    </form>
    <c:if test="${param.error == 'invalid'}">
        <p style="color:red;">密码错误，请重试。</p>
    </c:if>
</body>
</html>
