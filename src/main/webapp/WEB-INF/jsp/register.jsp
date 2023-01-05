<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register page</title>
</head>
<body>
	<h1 style="text-align: center;">To register fill out the following
		form.</h1>

	<form action="RegisterServlet" method="post">
		<input type="hidden" name="command" value="forward" /> Login: <input
			type="text" name="login" /> <br>
		<br> Password: <input type="password" name="password" /> <br>
		<br> Nickname: <input type="text" name="nickName" /> <br>
		<br> Email: <input type="email" name="email" /> <br>
		<br> Phonenumber: <input type="tel" name="phoneNumber" /> <br>
		<br>      <input type="submit" value="Send" />
	</form>
</body>
</html>