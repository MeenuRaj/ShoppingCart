<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<%-- <c:forEach var="item" items="${sessionScope.shopping_cart}">
  <c:out value='${shopping_cart.price}'/> --%>

<%-- </c:forEach> --%>


<%--  ${sessionScope.shopping_cart[0].price}
  ${sessionScope.shopping_cart[1].price}
    ${sessionScope.shopping_cart[2].price} --%>
    
 <table> ${message} </table>
 
 <div class="container">
	<a href = "index.jsp"><button type="button" class="btn btn-info btn-lg">Continue Shopping</button></a>
	</div>


</body>
</html>