<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.ufpi.es.appservlets.entities.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
<h2>Home Page</h2>

<ul>
<li>Welcome,
<%
User user = (User) request.getAttribute("user");
out.println(user.getName()+"!");
%>
<a href="LogoutServlet">Logout</a>
</li>
</ul>
Your information:<br><br>
<%
		out.println("Login: " + user.getLogin() + "<br>");
		out.println("Nome: " + user.getName() + "<br>");
		out.println("E-mail: " + user.getEmail() + "<br>");
%>
</body>
</html>