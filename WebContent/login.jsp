<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="pages/res.jsp"/>
<title>LogIn</title>
</head>
<body>

<div id="header">
    <jsp:include page="pages/header.jsp"/>
</div>

<div id="main">
	<h3>Log In</h3>
    <form action="LoginUserServlet" method="post">
    	Name: <div class="form-group"><input type="text" name="name" class="form-control" required></div>
    	Password: <div class="form-group"><input type="password" name="password" class="form-control" required></div>
    	<input type="submit" value="Login">
    </form>
</div>

<div id="footer">
    <jsp:include page="pages/footer.jsp"/>
</div>

</body>
</html>