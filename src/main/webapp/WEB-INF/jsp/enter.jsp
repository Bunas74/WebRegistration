<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter page</title>
</head>
<body>
	<h1 style="text-align: center;">Please login to your account.</h1>

	<form action="EnterServlet" method="post" style="text-align: center;">
		<input type="hidden" name="command" value="forward" /> Enter login:<input
			type="text" name="login" value="" /> Enter password:<input
			type="password" name="password" value="" /> <br>
		<br> <input type="submit" value="Send" />
	</form>
</body>
</html>