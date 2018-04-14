<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="forum.*" %>
<%
int id = Integer.parseInt(request.getParameter("id")); 
Threadd t = ThreadDAO.getThreadById(id);
Integer logedInUserId  = (Integer)session.getAttribute("userId");
if(logedInUserId!=null){
	//System.out.println(logedInUserId);
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="pages/res.jsp"/>
<title>Title here</title>
</head>
<body>

<div id="header">
    <jsp:include page="pages/header.jsp"/>
</div>

<div id="main">
	<h3><%=t.getTitle()%></h3>
	<p class="viewborders"><%=t.getSubject()%></p><br>
	<p>Thread by: <%=UserDAO.getUserById(t.getUserId()) %></p>
	<%
	if(logedInUserId!=null && t.getUserId() == logedInUserId){
		%>
		<form action="editThread.jsp" method="post">
			<input style="display:none" type="text" name="title" value="<%=t.getTitle()%>">
			<input style="display:none" type="text" name="subject" value="<%=t.getSubject()%>">
			<input style="display:none" type="text" name="id" value="<%=t.getThreadId()%>">
			<button class="btn btn-primary" type="submit">Edit Thread</button>
		</form><br>
		<form action="DeleteThread" method="post">
			<input style="display:none" type="text" name="id" value="<%=t.getThreadId()%>">
			<button class="btn btn-danger">Delete Thread</button>
		</form>
		<%
	}
	%>
	<hr/>
	<% 
		List<Post> posts = PostDAO.viewAllPosts(id);
		for(Post p:posts){
			%>
			<h5><%=p.getText()%></h5><br>By: <%=UserDAO.getUserById(p.getUserId())%><hr/>
			<%
		}
	%>
</div>
<hr/>

<a class="btn btn-primary" href="addPost.jsp?thread=<%=id%>">Add post</a>
<div id="footer">
    <jsp:include page="pages/footer.jsp"/>
</div>

</body>
</html>