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
  <h1  align="center"> Welcome to Mail service</h1>

</div>
<h4 align="right">${dto.getUsername()}</h4>
<h4 align="right">${dto.getEmail()}</h4>

<hr>
<h4 align="right">${msg}</h4>
<div class="navbar">
<a   href="compose">Compose</a>
<a   href="sentMail">Sent</a>
<a   href="inboxMail">Inbox</a>
<a   href="draftMail">Draft</a>
<a   href="delMessage">DeletedMessage</a>
<a   href="logout">Logout</a>



</div>

</body>
</html>
