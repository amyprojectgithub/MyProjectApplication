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
				<h3>Welcome To ShipmentType Data page</h3>
			</div>
			<div class="card-body">
				<a href="excel">Excel Export</a> <a href="pdf">PDF Export</a>
				<c:choose>
					<c:when test="${!empty list}">
						<table class="table table-hover">
							<tr class="bg-success text-white">
								<th>SID</th>
								<th>SHIP_MODE</th>
								<th>SHIP_CODE</th>
								<th>ENABLE_SHIPMENT</th>
								<th>SHIP_GRADE</th>
								<th>SHIP_DESC</th>
								<th colspan="3">OPERATIONS</th>
							</tr>
							<c:forEach items="${list}" var="ob">
								<tr>
									<td>${ob.shipId }</td>
									<td>${ ob.shipMode}</td>
									<td>${ ob.shipcode}</td>
									<td>${ ob.enbShipment}</td>
									<td>${ ob.shipGrade}</td>
									<td>${ ob. shipDesc}</td>
									<td><a href="delete?sid=${ob.shipId}" class="btn btn-danger">DELETE</a></td>
									<td><a href="edit?sid=${ob.shipId}" class="btn btn-info">EDIT</a></td>
									<td><a href="view?sid=${ob.shipId}" class="btn btn-warning">VIEW</a></td>
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