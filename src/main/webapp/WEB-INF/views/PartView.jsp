<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:green;text-align: center">::::Welcome To Part View Page::::</h3>
<a href="excel?id=${ob.partId}">Excel Export</a>
<a href="pdf?id=${ob.partId}">Pdf Export</a>
<table border="1">
<tr>
<th>CODE</th><td>${ob.partCode}</td>
</tr>
<tr>
<th>WIDTH</th><td>${ob.width}</td>
</tr>
<tr>
<th>LENGTH</th><td>${ob.length}</td>
</tr>
<tr>
<th>HEIGHT</th><td>${ob.height}</td>
</tr>
<tr>
<th>BASE COST</th><td>${ob.baseCost}</td>
</tr>
<tr>
<th>BASE CURRENCY</th><td>${ob.baseCurrency}</td>
</tr>

<tr>
<th>UOM MODEL</th><td>${ob.uomOb.uomModel}</td>
</tr>

<tr>
<th>NOTE</th><td>${ob.pdesc}</td>
</tr>
</table>
</body>
</html>