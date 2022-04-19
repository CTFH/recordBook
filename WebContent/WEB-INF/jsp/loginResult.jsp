<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.User"%>


<% //セッションスコープからユーザー情報を取得
    User loginUser =(User)session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お小遣い帳アプリ</title>
</head>
<body>
<h1>ログイン</h1>
<% if(loginUser !=null) { %>
<p>ログインに成功しました</p>
<p>ようこそ<%= loginUser.getName() %>さん</p>
<a href="/recordBook/Admin">データ登録・一覧へ</a>
<% }else{ %>
<p>ログインに失敗しました</p>
<a href="/recordBook/">TOPへ</a>
<% } %>
</body>
</html>