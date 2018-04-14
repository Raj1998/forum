<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String name  = (String)session.getAttribute("userName"); 
if(name==null){
	response.sendRedirect("login.jsp");
}
int id = Integer.parseInt(request.getParameter("thread"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="pages/res.jsp"/>
<title>New post</title>
</head>
<body>

<div id="header">
    <jsp:include page="pages/header.jsp"/>
</div>

<div id="main">
	<h2>New post</h2>
	<form action="AddNewPost" method="post">
		<textarea class="form-control" name="text"></textarea>
		<input style="display:none" name="threadId" value="<%=id%>"><br>
		<button class="btn" type="submit">Add post</button>
	</form>
</div>


<div id="footer">
    <jsp:include page="pages/footer.jsp"/>
</div>

</body>
</html>