<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>



<jsp:include page="header.jsp"/>


<div class="container">
		<center>
			<img src="bbconditioner.jpg" class="img-rounded" alt="Cinque Terre"
				width="250" height="240">
		</center>
	</div>


	<div class="container">
		<div class="jumbotron">
			<center>
				${item}
			</center>
		</div>
	</div>

${quantity}
<jsp:include page="footer.jsp"/>
</body>
</html>