<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.*"%>

<%
	List<RecordBook>list=(List<RecordBook>)request.getAttribute("list");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>お小遣い帳</title>
  <link rel="stylesheet" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
  <link rel="stylesheet" href="css/main.css"/>
</head>
<body>
  <div id="wrapper">
    <h1>内訳</h1>

    <div id="breakdown">

    <%for(RecordBook rb:list){ %>
    	<div>
    	<p><%=rb.getId() %>
    		<%=rb.getDate() %>
    		<%=rb.getContent() %>
    		<%=rb.getPrice() %></p>
    	</div>
    	<%} %>

    </div>
  </div>
</body>
</html>