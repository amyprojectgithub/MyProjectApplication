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
				<h3>Welcome To Part Data page</h3>
			</div>
			<div class="card-body">
				<a href="excel">Excel Export</a> <a href="pdf">PDF Export</a>
				<c:choose>
					<c:when test="${!empty list}">
						<table class="table table-hover">
							<tr class="bg-success text-white">
								<th>ID</th>
								<th>CODE</th>
								<th>WIDTH</th>
								<th>LENGTH</th>
								<th>HEIGHT</th>
								<th>BASE COST</th>
								<th>BASE CURRENCY</th>
								<th>UOM MODEL</th>
								<th>ORDER CODE</th>
								<th>DESCRIPTION</th>
								<th colspan="3">OPERATIONS</th>
							</tr>
							<c:forEach items="${list}" var="ob">
								<tr>
									<td>${ob.partId}</td>
									<td>${ ob.partCode}</td>
									<td>${ ob.width}</td>
									<td>${ ob.length}</td>
									<td>${ ob.height}</td>
									<td>${ ob.baseCost}</td>
									<td>${ ob.baseCurrency}</td>
									<td>${ob.uomOb.uomModel}</td>
									<td>${ob.omSaleOb.orderCode}</td>
									<td>${ ob.pdesc}</td>
									<td><a href="delete?sid=${ob.partId}"
										class="btn btn-danger">DELETE</a></td>
									<td><a href="edit?sid=${ob.partId}" class="btn btn-info">EDIT</a></td>
									<td><a href="view?sid=${ob.partId}"
										class="btn btn-warning">SHOW</a></td>
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