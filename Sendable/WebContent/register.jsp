

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
				<li class="nav-item"><a class="btn nav-link" href="login.jsp">Login</a>
				</li>
			</ul>
		</div>
	</nav>

	<!--Spaces-->
	<div class="break"></div>

	<!--Registration Form-->
	<div class="row justify-content-center mb-5">
		<div class="col-xl-6 col-lg-8 col-md-8 col-sm-11 ">
			<div class="card register-form shadow-lg">
				<div class="card-header lead">Register</div>
				<div class="card-body">
					<%
						if (request.getAttribute("validationMessage") == null) {
					%>
					<div class="alert alert-info" role="alert">Enter your
						information.</div>
					<%
						} else {
					%>
					<div class="alert alert-danger row" role="alert">
						<%=request.getAttribute("validationMessage")%>
					</div>
					<%
						}
					%>
					<form action="Register" method="POST">
						<div class="form-row">
							<div class="form-group col-md-6 col-sm-6">
								<label for="firstname">First Name<span
									class="required-field"> *</span></label> <input name="firstname" pattern=".{2,}"
									type="text" class="form-control" id="firstname"
									placeholder="First Name" required>
							</div>
							<div class="form-group col-md-6 col-sm-6">
								<label for="lastname">Last Name<span
									class="required-field"> *</span>
								</label> <input name="lastname" type="text" class="form-control" pattern=".{2,}"
									id="lastname" placeholder="Last Name" required>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6 col-sm-6">
								<label for="email">Email<span class="required-field">
										*</span></label> <input name="email" type="email" class="form-control" pattern=".{6,}"
									id="email" placeholder="Email Address" required>
							</div>
							<div class="form-group col-md-6 col-sm-6">
								<label for="phone">Phone</label> <input name="phone" type="text" pattern=".{9,14}"
									class="form-control" id="phone" placeholder="Tel / Mobile">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6 col-sm-6">
								<label for="password">Password<span
									class="required-field"> *</span></label> <input name="password" pattern=".{6,}" maxlength = "20"
									type="password" class="form-control" id="password"
									placeholder="New Password" required>
							</div>
							<div class="form-group col-md-6 col-sm-6">
								<label for="retypepassword">Re-type Password<span
									class="required-field"> *</span></label> <input name="retypepassword" pattern=".{6,}" maxlength = "20"
									type="password" class="form-control" id="retypepassword"
									placeholder="Re-enter New Password" required>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md">
								<label for="line1">Line 1<span class="required-field">
										*</span></label> <input name="line1" type="text" class="form-control" maxlength="40"
									id="line1" placeholder="# Street Name" required>
							</div>
							<div class="form-group col-sm">
								<label for="line2">Line 2</label> <input name="line2"
									type="text" class="form-control" id="line2"
									placeholder="Apartment, Studio, or Floor">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6 col-sm-6">
								<label for="city">City<span class="required-field">
										*</span></label> <input name="city" type="text" class="form-control"
									id="city" placeholder="City" required>
							</div>
							<div class="form-group col-md-6 col-sm-4">
								<label for="state">State<span class="required-field">
										*</span></label> <input name="state" type="text" id="state" maxlength = "20"
									class="form-control" placeholder="State" required>
							</div>
							<div class="form-group col-md-3 col-sm-4 col-xs-4 col-6">
								<label for="postal">Zip<span class="required-field">
										*</span></label> <input type="text" class="form-control" id="postal" pattern=".{5,}" maxlength = "7"
									name="postalcode" placeholder="A1A1A1" required>
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Register</button>
						<a class="btn btn-light" href="register.jsp" role="button">Reset</a>
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