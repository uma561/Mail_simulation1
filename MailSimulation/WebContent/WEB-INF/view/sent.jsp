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
<div style="background-color:lightblue">
	<h1 style="text-align:center" ><u>Sent</u></h1>
 <hr>
 <hr>
<div style="background-color:lightblue">
<table style="background-color:lightblue" border='1' align="center">
<tr><th>Sent</th> <th>delete</th></tr>
<c:forEach var="dto" items="${msg}">
<tr><td><a href="showSent?id=+${dto.getMid()}+">Msg</a></td><td><a href="delete?id=+${dto.getMid()}+">Delete</a></td></tr>
</c:forEach>
</table>

<div class="navbar">
<a   href="compose">Compose</a>
<a   href="sentMail">Sent</a>
<a   href="inboxMail">Inbox</a>
<a   href="draftMail">Draft</a>
<a   href="delMessage">DeletedMessage</a>
<a   href="logout">Logout</a>
</div>
</div>
</body>
</html>