<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:green;text-align: center">::::Welcome To Uom View Page::::</h3>
<a href="excel?id=${ob.uomId}">Excel Export</a>
<a href="pdf?id=${ob.uomId}">Pdf Export</a>
<table border="1">
<tr>
<th>Type</th><td>${ob.uomType}</td>
</tr>
<tr>
<th>Model</th><td>${ob.uomModel}</td>
</tr>
<tr>
<th>Note</th><td>${ob.uomDesc}</td>
</tr>
</table>
</body>
</html>