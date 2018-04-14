<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String name  = (String)session.getAttribute("userName"); 
if(name==null){
	response.sendRedirect("index.jsp");
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
	<h3>Edit thread</h3>
	
	<form class="form-horizontal" action="EditThread" method="post">
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="email">Thread title:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" placeholder="Title" name="title" value="<%=request.getParameter("title")%>" required>
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2">Description:</label>
	      <div class="col-sm-10">          
	        <textarea type="text" class="form-control" placeholder="Description" name="subject" required><%=request.getParameter("subject")%></textarea>
	      </div>
	    </div>
    	<input style="display:none" type="text" name="id" value="<%=request.getParameter("id")%>">
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default">Update</button>
	      </div>
	    </div>
  	</form>
	
</div>


<div id="footer">
    <jsp:include page="pages/footer.jsp"/>
</div>

</body>
</html>