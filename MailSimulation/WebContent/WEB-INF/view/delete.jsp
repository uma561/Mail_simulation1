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
<div style="background-color:white">
	<h1 style="text-align:center" ><u>DeleteMessage</u></h1>
 <hr>
 <hr>
<div style="background-color:white">
<table style="background-color:white" border='1' align="center">
<tr><th>Message</th> <th>from</th><th>Status</th><th>PDelete</th></tr>
<c:forEach var="dto" items="${msg}">
<tr><td>${dto.getInbox()}</td><td>${dto.getSentBy()}</td><td>${dto.getMailStatus()}</td><td><a href="permaDel?id=+${dto.getMid()}+">PermanentDel</a></td></tr>
</c:forEach>
</table>
</div>
</div>
<div class="navbar">
<a   href="compose">Compose</a>
<a   href="sentMail">Sent</a>
<a   href="inboxMail">Inbox</a>
<a   href="draftMail">Draft</a>
<a   href="delMessage">DeletedMessage</a>
<a   href="logout">Logout</a>



</body>
</html>