<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<h3 style="color: green; text-align: center">:::::Welcome To	WhUserType Data page::::::</h3>
	<c:choose>
		<c:when test="${!empty list}">
			<table border="1" align="centre">
				<tr>
					<th>ID</th>
					<th>TYPE</th>
					<th>CODE</th>
					<th>USER_FOR</th>
					<th>MAIL</th>
					<th>CONTACT</th>
					<th>ID_TYPE</th>
					<th>OTHER_ID_TYPE</th>
					<th>USERID_NUM</th>
					<th colspan="3">OPERATIONS</th>
				</tr>
				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.whUserId}</td>
						<td>${ ob.whUserType}</td>
						<td>${ ob.whUserCode}</td>
						<td>${ ob.userFor}</td>
						<td>${ ob.whUserMail}</td>
						<td>${ ob.whUserContact}</td>
						<td>${ ob.whUserIdType}</td>
						<td>${ ob.whUserOtherIdType}</td>
						<td>${ ob.whUserIdNum}</td>
						<td><a href="delete?id=${ob.whUserId}"><img src="../resources/images/delete.png" width="20" height="20"></a></td>
						<td><a href="edit?id=${ob.whUserId}"><img src="../resources/images/edit.png" width="20" height="20"></a></td>
						<td><a href="view?id=${ob.whUserId}"><img src="../resources/images/show.png" width="20" height="20"></a></td>
					</tr>
				</c:forEach>
			</table>
${message}
</c:when>
		<c:otherwise>
			<h3 style="color: :red; text-align: center">NO DATA FOUND!!!!!!!!!!!!!!!</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>