<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.*"%>

<%
	List<RecordBook> list =(List<RecordBook>)request.getAttribute("list");
	String msg=(String)request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お小遣い帳</title>

<style>
.container{
	padding-top:20px;
	padding-bottom:60px;
}
td>img{
	width:200px;
}
input.form-control,
.alert{
	width:500px;
}
table.table{
	width:70%;}
</style>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
<!-- <a href="/recordBook/Main" class="btn btn-outline-info btn-sm float-right">公開内訳を見る</a> -->

<% if(msg !=null) { %>
<div class="alert alert-success" role="alert">
<%=msg %>
</div>
<%} %>

<form class="mt-3" action="/recordBook/Admin" method="post" >

<div class ="form-group">
<label for="date">
日付：</label>
<input type="date" name="date" required class="form-control" placeholder="日付を入力 20xxxxxx"><br>
</div>

<div class="form-group">
<label for="content">
内容：</label>
<input type="text" name="content" required class="form-control" placeholder="内容を入力"><br>
</div>

<div class="form-group">
<label for="price">
金額：
</label>
<input type="number" name="price" required class="form-control" placeholder="金額を入力"><br>
</div>

<button type="submit" class = "btn btn-primary">登録</button>

</form>


<% if(list !=null && list.size()>0){ %>

<table class="table table-bordered mt-5">

<th>ID</th><th>日付</th><th>内容</th><th>金額</th><th>更新</th><th>削除</th>

<%for(RecordBook rb:list){ %>
<tr>
<td><name="id"><%= rb.getId() %></td>
<td><name="date"><%=rb.getDate() %></td>
<td><name="content"><%=rb.getContent() %></td>
<td><name="price><%= rb.getPrice() %></td>
<td>

<a href="/recordBook/Admin/Update?id=<%=rb.getId() %>">更新</a>
</td>
<td>
<a href="/recordBook/Admin/Delete?id=<%=rb.getId() %>" onclick="return confirm('削除してよろしいですか？')">削除</a>
</td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>