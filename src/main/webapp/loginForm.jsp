<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
<h2>Login Form</h2>
<ul><li>Please enter your credentials bellow:</li></ul>
<form method="post" action="LoginServlet">
User:<input type="text" name="login"><br>
Password:<input type="password" name="password"><br>
<input type="submit" value="Login">
<input type="button" value="Cancel">
</form>
</body>
</html>