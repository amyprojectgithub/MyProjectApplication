<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color: green; text-align: center">:::::Welcome To WhUserType View page::::::</h3>
<a href="excel?id=${ob.whUserId}">Excel Export</a>
<a href="pdf?id=${ob.whUserId}">Pdf Export</a>
<table border="1">
<tr>
<th>TYPE</th><td>${ob.whUserType}</td>
</tr>
<tr>
<th>CODE</th><td>${ob.whUserCode}</td>
</tr>
<tr>
<th>USER_FOR</th><td>${ob.userFor}</td>
</tr>
<tr>
<th>MAIL</th><td>${ob.whUserMail}</td>
</tr>
<tr>
<th>CONTACT</th><td>${ob.whUserContact}</td>
</tr>
<tr>
<th>ID_TYPE</th><td>${ob.whUserIdType}</td>
</tr>
<tr>
<th>OTHER_ID_TYPE</th><td>${ob.whUserOtherIdType}</td>
</tr>
<tr>
<th>USERID_NUM</th><td>${ob.whUserIdNum}</td>
</tr>
</table>
</body>
</html>