<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1 style="font-size: 30px;">LOGIN</h1>

<form action="ManagerLogin"  method="post" >
<pre>
<h3 ><b>
Email Id:  <input type="email" name="email"  required="required"><br>
Password: <input type="password" name="password"  required="required"><br><br>
<input  type="submit" value="Login"> | <a  href="Register">Register</a> </b></h3> </b></h3> 
</pre>
</form>
<br><br>
<h3 align="center" style=" font-size: 30px">${msg}</h3>
</center>
</body>
</html>