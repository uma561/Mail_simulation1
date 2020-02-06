<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<h1 align="center" font-size: 30px;"><b><i>Welcome To Stock Management</b></i></h1>
<br><br>
<h3 align="right" >${user} <br><br>
 <a  href="logout">LOGOUT</a></h3></h3> 
<hr>

<h3 align="center">
<a   href="search">Search Product</a> <br> <a   href="add">Add Product </a><br>  <a   href="ShowCart">Show Cart </a> <br> <a  href="addtocart">Items for cart</a> <br> <a   href="allproduct">All Products/Update</a></h3>
<h1 align="center">${msg}</h1>
</body>
</html>