<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="forum.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="pages/res.jsp"/>
<title>Messages</title>
</head>
<body>

<div id="header">
    <jsp:include page="pages/header.jsp"/>
</div>

<div id="main">
	<%
	List<Message> messages = UserDAO.getMessagesById((Integer)session.getAttribute("userId"));
	for(Message m:messages){
		%>
		<h4>From: <%=UserDAO.getUserById(m.getS_id())%></h4>
		<h3><%=m.getTitle()%></h3>
		<p><%=m.getMessage()%></p>
		<%
	}

	%>
</div>


<div id="footer">
    <jsp:include page="pages/footer.jsp"/>
</div>

</body>
</html>