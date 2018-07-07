<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/main.css">
<title>Sendable</title>
</head>

<body class="container-fluid">
	<!-- nav header -->
	<!--Navigation Bar-->
	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
	<a class="navbar-brand" href="index.jsp">SENDABLE</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#sendablenav" aria-controls="sendablenav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="sendablenav">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item"><a class="btn nav-link" href="../index.jsp">Home
			</a></li>
			<li class="nav-item"><a class="btn nav-link" href="../cards.jsp">Cards</a>
			</li>
			<li class="nav-item"><a class="btn nav-link"
				href="../categories.jsp">Categories</a></li>
		</ul>

		<ul class=" navbar-nav ml-auto">
			<%
				if (session.getAttribute("user") != null) {
			%>
			<li class="nav-item"><a class="btn nav-link"
				href="myaccount.jsp"> <%=session.getAttribute("user")%>
			</a> <li class="nav-item">
          <a class="btn nav-link" href="Logout">
          Logout</a>
        </li>
      <%
      	} else {
      %>
    	<li class="nav-item">
          <a class="btn nav-link" href="../Authenticate/login.jsp">Login</a>
        </li>
        <li class="nav-item">
          <a class="btn nav-link " href="../Authenticate/register.jsp">Register</a>
        </li>  
      <%
        	}
        %>
        </ul>
    </div>
  </nav>

   
    <!--spacer-->
				<div class="break"></div>

    <div class="container">
        <!--content write-->
        <section class="row">
            <!--side-->
            <div class="col-lg-3 col-md-4">
                <div class="card p-4">
                    <img class="card-img-top rounded-circle"
								src="images/greetingcard1.jpg" alt="card 1">
                    <div class="card-body">
                        <h5 class="card-title">Selected Card</h5>
                        <p>some descriptive texts</p>
                        <a class="btn btn-info">Change Card</a>

                    </div>
                </div>
            </div>
            <!--textarea-->
            <div class="col-lg-9 col-md-8 mb-5">
                <div class="row m-1">
                    <div class="col-12 shadow-sm">
                        <ul class="nav justify-content-around">
                            <li class="nav-item nav-link disabled font1">Sacramento</li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle"
										data-toggle="dropdown" href="#" role="buton"
										aria-haspopup="true" aria aria-expanded="false">Choose Font</a>
                                <div class="dropdown-menu">
                                    <a href="#"
												class="dropdown-item font1">Sacramento</a>
                                    <a href="#"
												class="dropdown-item font2">Nothing You Could Do</a>
                                    <a href="#"
												class="dropdown-item font3">Homemade Apple</a>
                                    <a href="#"
												class="dropdown-item font4">Allura</a>
                                </div>
                            </li>

                        </ul>
                    </div>
                    <div class=" text-space col-12 shadow-lg mt-3">
                        <form class="mt-1" action="#" method="POST">
                            <div class="form-group">
                                <label for="personalizedmsg">Your Message</label>
                                <textarea class=" form-control font1"
											id="personalizedmsg" rows="8"></textarea>
                            </div>                            
                            <button type="button"
										class="btn btn-primary">Save</button>
                            <a class="btn" href="#">Clear</a>
                        
                        </form>

                    </div>
                </div>
            </div>
        </section>
    </div>
    
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
					integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
					crossorigin="anonymous"></script>
    <script
					src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
					integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
					crossorigin="anonymous"></script>
    <script src="../js/bootstrap.min.js"></script>

			</body>

</html>