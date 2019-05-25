<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="owner" method="post">
		FirstName:<form:input path="firstName"/>
		<form:errors path="firstName" cssStyle="color:red"/>
		<br>
		LastName:<form:input path="lastName"/>
		<form:errors path="lastName" cssStyle="color:red"/>
		<br>
		<form:button name="submit">Create </form:button>
	</form:form>
	
</body>
</html>