<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
index page
<br>
	<form action="logout" method="post">
	<input type="submit" value="exit">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
	</form>
	
</body>
</html>