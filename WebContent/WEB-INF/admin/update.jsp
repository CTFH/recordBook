<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%
	RecordBook rb=(RecordBook)request.getAttribute("rb");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お小遣い帳</title>
</head>
<body>
<form action="/recordBook/Admin/Update" method="post" >
<input type="hidden" name="id" value="<%=rb.getId()%>" required><br>
日付:<input type="date" name="date" value="<%=rb.getDate()%>" required><br>
内容:<input type="text" name="content"  value="<%=rb.getContent()%>" required><br>
金額:<input type="number" name="price"  value="<%=rb.getPrice()%>" required><br>
<button type="submit">更新</button>
</form>
</body>
</html>