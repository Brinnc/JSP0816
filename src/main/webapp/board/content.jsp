<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=submit] {
	background-color: #04AA6D;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
</head>
<body>

	<div class="container">
		<form action="/action_page.php">
			<input type="text" id="fname" name="firstname" placeholder="Your name.."> 
			<input type="text" id="lname" name="lastname" placeholder="Your last name..">
			<textarea id="subject" name="subject" placeholder="Write something.." style="height: 200px"></textarea>
			<input type="button" value="목록">
			<input type="button" value="수정">
			<input type="button" value="삭제">
		</form>
	</div>

</body>
</html>

