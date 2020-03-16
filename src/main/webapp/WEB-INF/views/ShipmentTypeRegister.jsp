<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3>Welcome To ShipmentType Register Page</h3>
			</div>
			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="shipmentType">
					<div class="row">
						<div class="col-4">
							<label for="shipMode">Shipment Mode</label>
						</div>
						<div class="col-4">
							<form:select path="shipMode" class="form-control">
								<form:option value="">--select--</form:option>
								<form:option value="Air">Air</form:option>
								<form:option value="Truck">Truck</form:option>
								<form:option value="Ship">Ship</form:option>
								<form:option value="Train">Train</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error Code -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipcode">Shipment Code</label>
						</div>
						<div class="col-4">
							<form:input path="shipcode" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Code -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="enbShipment">Enable Shipment</label>
						</div>
						<div class="col-4">
							<form:select path="enbShipment" class="form-control">
								<form:option value="">--select--</form:option>
								<form:option value="Yes">yes</form:option>
								<form:option value="No">No</form:option>
							</form:select>
						</div>
						<div class="col-4"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipGrade">Shipment Grade</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="shipGrade" value="A" />
							A&nbsp;
							<form:radiobutton path="shipGrade" value="B" />
							B&nbsp;
							<form:radiobutton path="shipGrade" value="C" />
							C
						</div>
						<div class="col-4"></div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipDesc">Description</label>
						</div>
						<div class="col-4">
							<form:textarea path="shipDesc" />
						</div>
						<div class="col-4"></div>
					</div>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="CREATE SHIPMENT">
						</div>
						<div class="col-4"></div>
					</div>
				</form:form>
			</div>
			<div class="card-footer">${message}</div>
		</div>
	</div>
</body>
</html>