<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color: green; text-align: center">:::::Welcome To ShipmentType View page::::::</h3>
<a href="excel?sid=${ob.shipId}">Excel Export</a>
<a href="pdf?sid=${ob.shipId}">Pdf Export</a>
<table border="1">
<tr>
<th>MODE</th><td>${ob.shipMode}</td>
</tr>
<tr>
<th>CODE</th><td>${ob.shipcode}</td>
</tr>
<tr>
<th>ENABLE</th><td>${ob.enbShipment}</td>
</tr>
<tr>
<th>GRADE</th><td>${ob.shipGrade}</td>
</tr>
<tr>
<th>NOTE</th><td>${ob.shipDesc}</td>
</tr>
</table>
</body>
</html>