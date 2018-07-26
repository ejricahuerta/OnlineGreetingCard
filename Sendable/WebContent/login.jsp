



<jsp:include page="header.jsp" />

<!--Body-->
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
				<li class="nav-item"><a class="btn nav-link" href="index.jsp">Home
				</a></li>
				<li class="nav-item"><a class="btn nav-link" href="cards.jsp">Cards</a>
				</li>
				<li class="nav-item"><a class="btn nav-link"
					href="categories.jsp">Categories</a></li>
				<li class="nav-item"><a class="btn nav-link" href="fonts.jsp">Fonts</a>
				</li>
			</ul>

			<ul class=" navbar-nav ml-auto">
				<li class="nav-item"><a class="btn nav-link "
					href="register.jsp">Register</a></li>
			</ul>
		</div>
	</nav>


	<!--Spaces-->
	<div class="break"></div>

	<!--Registration Form-->
	<div class="row justify-content-center mb-4">
		<div class="col-xl-4 col-lg-6 col-md-9 col-sm-12">
			<div class="card register-form shadow-lg">
				<div class="card-header lead">Login</div>
				<div class="card-body">
					<%
						if (request.getAttribute("validationMessage") == null) {
					%>
					<div class="alert alert-info shadow-sm" role="alert">Enter
						your Information.</div>
					<%
						} else {
					%>
					<div class="alert alert-danger shadow-sm" role="alert">
						<%=request.getAttribute("validationMessage")%>
					</div>
					<%
						}
					%>
					<form action="Login" method="POST">
						<div class="form-row row">
							<div class="form-group col-12">
								<label for="email">Email <span class="required-field">
										*</span>
								</label> <input name="email" type="email" class="form-control"
									id="email" placeholder="johndoe@example.com">
							</div>
							<div class="form-group col-12">
								<label for="password">Password <span
									class="required-field"> *</span>
								</label> <input name="password" type="password" class="form-control"
									id="password" placeholder="Enter your password">
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Login</button>
						<a class="btn btn-light" href="register.jsp" role="button">Register</a>
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- Optional JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>