<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="forum.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="pages/res.jsp"/>
<title>All threads</title>
</head>
<body>

<div id="header">
    <jsp:include page="pages/header.jsp"/>
</div>

<div id="main" class="container">
	<h2>All threads</h2><br>
	<% 
		List<Threadd> threads = ThreadDAO.viewAllThreads();
		for(Threadd t:threads){
			%>
			<h3><a href="viewThread.jsp?id=<%=t.getThreadId()%>"><%=t.getTitle()%></a></h3>
			<%
		}
	%>
</div>


<div id="footer">
    <jsp:include page="pages/footer.jsp"/>
</div>

</body>
</html>