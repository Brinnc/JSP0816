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

input[type=button] {
	background-color: #04AA6D;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=button]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript">
function regist(){
	//폼에 입력한 내용들을 서버로 요청
	$("form").attr({
		method:"post",
		action:"/board/regist"
	});
	$("form").submit(); //전송(요청)
}

$(function(){
	//편집기 연결
	$("#content").summernote();
	
	//전송 버튼에 이벤트 연결
	$("input[type='button']").click(function(){
		regist();
	});
});
</script>
</head>
<body>

	<div class="container">
		<form>
			<input type="text"  name="title" placeholder="Title.."> 
			<input type="text" name="writer" placeholder="Your name..">
			<textarea id="content" name="content" placeholder="Write something.." style="height: 200px"></textarea>
			<input type="button" value="Submit">
		</form>
	</div>

</body>
</html>
