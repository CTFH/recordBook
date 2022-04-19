<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お小遣い帳</title>
</head>
<body>
<h1>ログイン</h1>
<form action="/recordBook/Login"  method="post">
ユーザー名:<input type="text" name="name"><br>
パスワード:<input type="password" name="pass"><br>
<input type ="submit" value="ログイン">
</form>
</body>
</html>