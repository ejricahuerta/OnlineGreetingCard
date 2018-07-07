 <!--Navigation Bar-->
  <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="index.jsp">SENDABLE</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#sendablenav" aria-controls="sendablenav"
      aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="sendablenav">
      <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
        <li class="nav-item">
          <a class="btn nav-link" href="index.jsp">Home
          </a>
        </li>
        <li class="nav-item">
          <a class="btn nav-link" href="cards.jsp">Cards</a>
        </li>
        <li class="nav-item">
          <a class="btn nav-link" href="categories.jsp">Categories</a>
        </li>
      </ul>
      
      <ul class=" navbar-nav ml-auto">
      <% if(session.getAttribute("user") != null ) { %>
    	   <li class="nav-item">
          <a class="btn nav-link" href="myaccount.jsp">
          <%=session.getAttribute("user")%>
          </a>
          <li class="nav-item">
          <a class="btn nav-link" href="Logout">
          Logout</a>
        </li>
      <%} else { %>
    	<li class="nav-item">
          <a class="btn nav-link" href="login.jsp">Login</a>
        </li>
        <li class="nav-item">
          <a class="btn nav-link " href="register.jsp">Register</a>
        </li>  
      <% }%>
        </ul>
    </div>
  </nav>
