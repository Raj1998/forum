<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="pages/res.jsp"/>
<title>New Message</title>
</head>
<body>

<div id="header">
    <jsp:include page="pages/header.jsp"/>
</div>

<div id="main">

	<h3>New message</h3>
	
	<form class="form-horizontal" action="SendMessage" method="post">
	    <div class="form-group">
	      <label class="control-label col-sm-2">To: </label>
	      <div class="col-sm-10">
	      	<input type="text" class="form-control" placeholder="To" name="receiver" required>
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2">Message Title:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" placeholder="Title" name="title" required>
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2">Message: </label>
	      <div class="col-sm-10">
	        <textarea type="text" class="form-control" placeholder="Message" name="subject" required></textarea>
	      </div>
	    </div>
    
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default">Send</button>
	      </div>
	    </div>
  	</form>

</div>


<div id="footer">
    <jsp:include page="pages/footer.jsp"/>
</div>

</body>
</html>