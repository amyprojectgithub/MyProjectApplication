<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow" style="color: blue">
<h3 style="text-align: center">::::Welcome To Documents Page::::</h3>
<form action="upload" method="POST" enctype="multipart/form-data">
<pre>
ID::<input type="text" name="fileId">
DOC::<input type="file" name="fileOb">
<input type="submit" value="UPLOAD">
</pre>
</form>
<table border="1">
<tr>
<th>ID</th>
<th>NAME</th>
<th>LINK</th>
</tr>
<c:forEach items="${list}" var="ob">
<tr>
<td>${ob[0]}</td>
<td>${ob[1]}</td>
<td><a href="download?fid=${ob[0]}">DOWNLOAD</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>