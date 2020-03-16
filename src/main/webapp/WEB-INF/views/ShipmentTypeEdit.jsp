<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow" style="color: blue">
<h3 style="text-align: center">::::Welcome To ShipmentType Edit Page::::</h3>
<form:form action="update" method="POST" modelAttribute="shipmentType">
<pre>
Shipment Id::<form:input path="shipId" readonly="true"/>
Shipment Mode::<form:select path="shipMode">
                             <form:option value="">--select--</form:option>
                             <form:option value="Air">Air</form:option>
                             <form:option value="Truck">Truck</form:option>
                             <form:option value="Ship">Ship</form:option>
                             <form:option value="Train">Train</form:option>  
                            </form:select>
Shipment Code::<form:input path="shipcode"/>     
Enable Shipment::<form:select path="enbShipment">
                               <form:option value="">--select--</form:option>
                               <form:option value="Yes">yes</form:option>
                               <form:option value="No">No</form:option>
                               </form:select>                       
Shipment Grade::<form:radiobutton path="shipGrade" value="A"/>A&nbsp; <form:radiobutton path="shipGrade" value="B"/>B&nbsp;<form:radiobutton path="shipGrade" value="C"/>C
Description::<form:textarea path="shipDesc"/>    
<input type="submit" value="UPDATE">                                            
</pre>
</form:form>
${message}
</body>
</html>