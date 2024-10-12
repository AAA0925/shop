<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>卖家登录</title>
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body>
    <h1>卖家登录</h1>
    <form action="seller-login" method="post">

    <a>系统用户名admin，初始密码123456</a>
    <br>
	    <label for="username">用户名:</label>
	    <input type="text" id="username" name="username" required>
	    <br>
	    <label for="password">密码:</label>
	    <input type="password" id="password" name="password" required>
	    <br>
	    <button type="submit">登录</button>
	</form>

    
</body>
</html>
