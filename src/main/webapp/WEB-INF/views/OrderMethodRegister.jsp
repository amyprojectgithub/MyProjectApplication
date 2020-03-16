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
			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3>Welcome To OrderMethod Register Page</h3>
			</div>
			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="orderMethod">
					<div class="row">
						<div class="col-4">
							<label for="orderMode">Order Mode</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="orderMode" value="sale" />Sale						
							<form:radiobutton path="orderMode" value="purchase" />Purchase
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
						<label for="orderCode">Order Code</label>
						</div>
						<div class="col-4">
						<form:input path="orderCode" class="form-control" />
						</div>
						<div class="col-4">
						<!-- Error Message -->
						</div>
			     </div>

					<div class="row">
						<div class="col-4">
						<label for="orderMethod">Order Method</label>
						</div>
						<div class="col-4">				
                        <form:select path="orderMethod" class="form-control" >
						<form:option value="">--select--</form:option>
						<form:option value="FIFO">FIFO</form:option>
						<form:option value="LIFO">LIFO</form:option>
						<form:option value="FCFO">FCFO</form:option>
						<form:option value="FEFO">FEFO</form:option>
					    </form:select>  
						</div>
						<div class="col-4">
						<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
						<label for="orderAccept">Order Accept</label>
						</div>
						<div class="col-4">
						<form:checkbox path="orderAccept" value="Multi-Model" />Multi-Model
                        <form:checkbox path="orderAccept" value="AcceptReturn" />Accept Return
						</div>
						<div class="col-4">
						<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
						<label for="orderDesc">Description</label>
						</div>
						<div class="col-4">
						<form:textarea path="orderDesc" class="form-control"/>
						</div>
						<div class="col-4">
						<!-- Error Message -->
						</div>
					</div>
                  
                     <div class="row">
						<div class="col-4">
						</div>
						<div class="col-4">						
			     		<input type="submit" value="Create Order Method" class="btn btn-danger">
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