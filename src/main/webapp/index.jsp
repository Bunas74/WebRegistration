<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome page</title>
</head>
<body>
	<h1 style="text-align: center;">Welcome to our site.</h1>
	<h2 style="text-align: center;">
		If you are already registered on our site, click the "Enter" button, <br>otherwise
		click the "Register" button.
	</h2>

	<form action="WelcomeServlet" method="get" style="text-align: center;">
		<input type="submit" name="enter" value="Enter"> <strong>
			or </strong> <input type="submit" name="enter" value="Register">
	</form>
</body>
</html>