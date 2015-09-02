<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Hair and Stuff</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="list">Items</a></li>
     
        <%if(session.getAttribute("username")==null){%>
        	<li><a href="login.jsp">Login</a></li>
        	<li><a href="CreateAccount.jsp">Create Account</a></li>
        <%}else {%>
           <li><a href="CartServlet">View Cart</a></li>
        <li><a href="logout">Logout</a></li>
        <% } %>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>