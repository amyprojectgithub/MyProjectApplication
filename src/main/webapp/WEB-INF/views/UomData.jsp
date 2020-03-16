<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
			<h3>Welcome To Uom Data page</h3>
			</div>
			<div class="card-body">
			<a href="excel">Excel Export</a> <a href="pdf">PDF Export</a>
			<c:choose>
				<c:when test="${!empty list}">
					<table class="table table-hover">
						<tr class="bg-success text-white">
							<th>UomId</th>
							<th>UomType</th>
							<th>UomMode</th>
							<th>UomDesc</th>
							<th colspan="3">OPERATIONS</th>
						</tr>
						<c:forEach items="${list}" var="ob">
							<tr>
								<td>${ob.uomId}</td>
								<td>${ ob.uomType}</td>
								<td>${ ob.uomModel}</td>
								<td>${ ob.uomDesc}</td>
								<td><a href="delete?sid=${ob.uomId}" class="btn btn-danger">DELETE</a></td>
								<td><a href="edit?sid=${ob.uomId}" class="btn btn-info">EDIT</a></td>
								<td><a href="view?sid=${ob.uomId}" class="btn btn-warning">SHOW</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<h3 style="color: :red; text-align: center">NO DATA
						FOUND!!!!!!!!!!!!!!!</h3>
				</c:otherwise>
			</c:choose>
			</div>
					<c:if test="${!empty message }">
						<div class="card-footer bg-info text-white text-center">
							<b>${message }</b>
						</div>
					</c:if>
		</div>
	</div>
</body>
</html>