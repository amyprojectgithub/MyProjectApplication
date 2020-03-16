<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<div class="card-header bg-primary text-center text-white">
				<h3>Welcome To Part Register Page</h3>
			</div>
			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="part">
					<div class="row">
						<div class="col-4">
							<label for="partCode">CODE</label>
						</div>
						<div class="col-4">
							<form:input path="partCode" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label>DIMENSIONS</label>
						</div>
						<div class="col-3">
							<div class="row">
								<div class="col-6">
									<label for="length">LENGTH</label>
								</div>
								<div class="col-6">
									<form:input path="length" class="form-control" />
								</div>
							</div>
						</div>

						<div class="col-3">
							<div class="row">
								<div class="col-6">
									<label for="width">WIDTH</label>
								</div>
								<div class="col-6">
									<form:input path="width" class="form-control" />
								</div>
							</div>
						</div>

						<div class="col-3">
							<div class="row">
								<div class="col-6">
									<label for="width">HEIGHT</label>
								</div>
								<div class="col-6">
									<form:input path="height" class="form-control" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="baseCost">BASE COST</label>
						</div>
						<div class="col-4">
							<form:input path="baseCost" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="baseCurrency">BASE CURRENCY</label>
						</div>
						<div class="col-4">
							<form:select path="baseCurrency" class="form-control">
								<form:option value="">--Select--</form:option>
								<form:option value="INR">INR</form:option>
								<form:option value="USD">USD</form:option>
								<form:option value="AUS">AUS</form:option>
								<form:option value="ERU">ERU</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					
						<div class="row">
						<div class="col-4">
							<label for="uomOb.uomId">UOM</label>
						</div>
						<div class="col-4">
							<form:select path="uomOb.uomId" class="form-control">
							<form:option value="">--Select--</form:option>
							<form:options items="${uomMap}"/>
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					
					<div class="row">
						<div class="col-4">
							<label for="uomSaleOb.orderMId">ORDER METHOD</label>
						</div>
						<div class="col-4">
							<form:select path="omSaleOb.orderMId" class="form-control">
							<form:option value="">--Select--</form:option>
							<form:options items="${omSaleMap}"/>
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="pdesc">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:textarea path="pdesc" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="CREATE" class="btn btn-danger" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
				</form:form>
			</div>
			<c:if test="${!empty message }">
				<div class="card-footer bg-info text-white text-center">
					<b>${message}</b>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>