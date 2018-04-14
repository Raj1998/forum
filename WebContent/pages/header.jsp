<%String name  = (String)session.getAttribute("userName"); %>
<nav class="navbar navbar-inverse navbar-fixed-top">
	  <div class="container-fluid container">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        	<span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>         
	      </button>
	      <a class="navbar-brand" href="index.jsp"> Forum App</a>
	    </div>

	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <%if(name!=null){
	      			%>
	      <ul class="nav navbar-nav">
	        <li><a href="newThread.jsp">New Thread</a></li>
	      </ul>
	      <ul class="nav navbar-nav">
	        <li><a href="newMessage.jsp">Send Messages</a></li>
	      </ul>
	      <ul class="nav navbar-nav">
	        <li><a href="showMessages.jsp">View Messages</a></li>
	      </ul>
	      
	      <% } %>
	      <ul class="nav navbar-nav">
	        <li><a href="viewAllThreads.jsp">View Threads</a></li>
	      </ul>

	      
	      <ul class="nav navbar-nav navbar-right">
	      	<%	  
	      		if(name!=null){
	      			%>
	      			<li><a href="#"><%= name%></a></li>
	      			<li><a href="LogoutServlet">Log Out </a></li>
	      		<%
	      		}
	      		else{
	      			%>
	      				<li><a href="signup.jsp">Sign Up</a></li>
	      				<li><a href="login.jsp">Log In </a></li>
	      			<%
	      		}
	      	%>
	      	
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
</nav>