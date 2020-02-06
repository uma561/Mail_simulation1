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

   <h1 align="center">Register Here!!!</h1>
 
	<hr>
 <h1 align="center">Enter Details</h1>
<hr>
	<form action="registrationData" align="center" method="post">
			
			<div >	<label for="username">
			
				Username</label> <br> <input type="text"name="username" id="username">
					
			</div>

			<div ><label for="password">
				 
					Password</label> <br><input type="password" name="password" id="password">
			</div>

			<div>
			<div ><label for="name">

				Email Id</label> <br> <input type="text" name="email" id="email">
			</div>

			<div ><label for="category">

				 Age</label> <br> <input type="text" name="age" id="age">
			</div>
			
			<div>
			<label for="">security Question</label>
			<select style="width:150px;" name="question">
			<option value="" selected disabled>select</option>
			<option value="what is your birthplace?" >what is your birthplace?</option>
			<option value="what is you middle name?" >what is you middle name?</option>
			<option value="what is first school?" >what is first school?</option>
			<option value="what is hometown?" >what is hometown?</option>
			</select>
			</div>
			<div>
			<label for="">answer</label>
			<input type="text" name="answer">
			</div>

			

			<div>
				<button type="submit">Sign Up</button>
				<a href="login">Login</a>|
			</div>

			

		</form>



</body>
</html>
