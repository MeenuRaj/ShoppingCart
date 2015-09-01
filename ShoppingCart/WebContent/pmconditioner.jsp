<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<div class="container">
		<center>
			<img src="bbconditioner.jpg" class="img-rounded" alt="Cinque Terre"
				width="250" height="240">
		</center>
	</div>


	<div class="container">
		<div class="jumbotron">
			<center>
				<h1>Paul Mitchell Instant Moist Conditioner</h1>
				<h3>6.8-ounce bottle. </h3>
				<p>Hydrates and revives damaged hair. Infuses hair with brilliant shine. Soy Protein and Shea Butter help strengthen and moisturize hair</p>
			</center>
		</div>
	</div>

	<div class="container">
		<form role="form" action="AddServlet" method="post">
			<input type="hidden" name="action" value="pmconditioner" />
			
			<div class="form-group">
				<label for="quantity">Quantity:</label> <input type="text"
					class="form-control" id="quantity" name="quantity">
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-5">
					<center>
						<button type="submit" class="btn btn-primary btn-lg btn-block">Add
							to Cart</button>
					</center>
				</div>
			</div>
		</form>
	</div>
	
	
	<div class="container">
		<form role="form" action="CartServlet" method="post">
			<input type="hidden" name="action" value="oil" />
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-2">
					<center>
						<button type="submit" class="btn btn-primary btn-lg btn-block">View Cart</button>
					</center>
				</div>
			</div>
		</form>
	</div>
	
	<div class="container">
	<a href = "index.jsp"><button type="button" class="btn btn-info btn-lg">Continue Shopping</button></a>
	</div>
	
</body>
</html>