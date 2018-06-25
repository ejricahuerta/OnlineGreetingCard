<jsp:include page="header.jsp" />

<!--Body-->
<body class="container-fluid">

	<!-- nav header -->
	<jsp:include page="navigationheader.jsp" />

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
					<div class="alert alert-danger row"  role="alert">
						<%=request.getAttribute("validationMessage")%>
					</div>
					<%
						}
					%>
					<form action="Register" method="POST">
						<div class="form-row">
							<div class="form-group col-md-6 col-sm-6">
								<label for="firstname">First Name<span
									class="required-field"> *</span></label> <input name="firstname"
									type="text" class="form-control" id="firstname"
									placeholder="Seneca" required>
							</div>
							<div class="form-group col-md-6 col-sm-6">
								<label for="lastname">Last Name<span
									class="required-field"> *</span>
								</label> <input name="lastname" type="text" class="form-control"
									id="lastname" placeholder="College" required>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6 col-sm-6">
								<label for="email">Email<span class="required-field">
										*</span></label> <input name="email" type="email" class="form-control"
									id="email" placeholder=" ptreg@senecacollege.ca" required>
							</div>
							<div class="form-group col-md-6 col-sm-6">
								<label for="phone">Phone</label> <input name="phone"
									type="tel" class="form-control" id="phone"  
									placeholder="4164934144">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6 col-sm-6">
								<label for="password">Password<span
									class="required-field"> *</span></label> <input name="password"
									type="password" class="form-control" id="password"
									placeholder="Password" required>
							</div>
							<div class="form-group col-md-6 col-sm-6">
								<label for="retypepassword">Re-type Password<span
									class="required-field"> *</span></label> <input name="retypepassword"
									type="password" class="form-control" id="retypepassword"
									placeholder="Password" required>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md">
								<label for="line1">Line 1<span class="required-field">
										*</span></label> <input name="line1" type="text" class="form-control"
									id="line1" placeholder="70 The Pond Rd" required>
							</div>
							<div class="form-group col-sm">
								<label for="line2">Line 2</label> <input name="line2"
									type="text" class="form-control" id="line2"
									placeholder="Apartment, studio, or floor">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6 col-sm-6">
								<label for="city">City<span class="required-field">
										*</span></label> <input name="city" type="text" class="form-control"
									id="city" placeholder="Toronto" required>
							</div>
							<div class="form-group col-md-6 col-sm-4">
								<label for="state">State<span class="required-field">
										*</span></label> <input name="state" type="text" id="state" 
									class="form-control" placeholder="Ontario" required>
							</div>
							<div class="form-group col-md-3 col-sm-4 col-xs-4 col-6">
								<label for="postal">Zip<span class="required-field">
										*</span></label> <input type="text" class="form-control" id="postal"
									placeholder="A1A 1A1" required>
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Register</button>
						<a class="btn btn-light" href="register.jsp" role="button">Reset</a>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	
	<jsp:include page="footer.jsp" />