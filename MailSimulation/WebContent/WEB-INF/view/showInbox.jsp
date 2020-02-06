<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="background-color:lightblue">
	<h1 style="text-align:center" ><u>Inbox Details</u></h1>
 <hr>
 <hr>
<div style="background-color:lightblue">
<table style="background-color:lightblue" border='1' align="center">
<tr><th>Sent</th> <th>Message</th><th></th></tr>

<tr><td>${dto.getSent()}</td><td>${dto.getInbox()}</td><td></tr>

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