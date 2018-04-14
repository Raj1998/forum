<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/bootstrap.min.css">
<link rel="stylesheet" href="assets/style.css">
<title>Insert title here</title>
</head>
<body>

<div id="header">
    <jsp:include page="pages/header.jsp"/>
</div>

<%
String name = (String)session.getAttribute("userName");
%>
Hello,,, <%= name
%>
<a href="LogoutServlet">Log out</a>

<div id="footer">
    <jsp:include page="pages/footer.jsp"/>
</div>

</body>
</html>