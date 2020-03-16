<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color: green; text-align: center">:::::Welcome To OrderMethod View page::::::</h3>
<a href="excel?id=${ob.orderMId}">Excel Export</a>
<a href="pdf?id=${ob.orderMId}">Pdf Export</a>
<table border="1">
<tr>
<th>MODE</th><td>${ob.orderMode}</td>
</tr>
<tr>
<th>CODE</th><td>${ob.orderCode}</td>
</tr>
<tr>
<th>METHOD</th><td>${ob.orderMethod}</td>
</tr>
<tr>
<th>ORDER ACCEPT</th><td>${ob.orderAccept}</td>
</tr>
<tr>
<th>NOTE</th><td>${ob.orderDesc}</td>
</tr>
</table>
</body>
</html>