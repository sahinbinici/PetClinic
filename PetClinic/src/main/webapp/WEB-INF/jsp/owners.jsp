<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<thead>
	<tr style="font-weight:bold;" bgcolor="LightBlue">
		<td>ID</td>
		<td>FirstName</td>
		<td>LastName</td>
	</tr>
	</thead>
	<c:forEach items="${owners}" var="owner">
		<tr>
			<td>${owner.id}</td>
			<td>${owner.firstName}</td>
			<td>${owner.lastName}</td>
		</tr>
	</c:forEach>
	</table>
	<c:if test="${not empty message}">
	<div style="color:red">
		${message}
	</div>
	</c:if>
</body>
</html>