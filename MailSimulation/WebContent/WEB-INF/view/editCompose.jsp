<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Page Title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

<div class="header">
  <h1>Mail Services</h1>
  
  

  <p>A website created by me.</p>
  <h1  align="center">Re Compose your Mail Here</h1>


	<hr>
    <div style="text-align:center">
	<form action="composeRe"  method="post">
	<div>
		
			<label for="id"></label> <br> <input  name="id" type="hidden" value="${dto.getMid() }"
				name="id" id="id">

		</div>
	
		<div>
		
			<label for="to">To</label> <br> <input type="text" value="${dto.getDraft() }"
				name="to" id="to">

		</div>

		<div>
			<label for="msg">Message</label> <br>
			<input name="msg" id="msg" value="${dto.getDraft_message()}"></textarea>
			
		</div>
		<div >
			<input type="Submit" value="Send">
		</div>



	</form></div>
<div class="navbar">
<a   href="compose">Compose</a>
<a   href="sentMail">Sent</a>
<a   href="inboxMail">Inbox</a>
<a   href="draftMail">Draft</a>
<a   href="delMessage">DeletedMessage</a>
<a   href="logout">Logout</a>
</body>
</html>
