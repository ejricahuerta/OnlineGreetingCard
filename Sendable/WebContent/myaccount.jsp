<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<body class="container-fluid">
	<!--Navigation Bar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="index.jsp">SENDABLE</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#sendablenav" aria-controls="sendablenav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="sendablenav">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="btn nav-link"
					href="index.jsp">Home </a></li>
				<li class="nav-item"><a class="btn nav-link" href="cards.jsp">Cards</a>
				</li>
				<li class="nav-item"><a class="btn nav-link"
					href="categories.jsp">Categories</a></li>
			</ul>
			<ul class=" navbar-nav ml-auto">
				<li class="nav-item"><a class="btn nav-link" href="login.jsp">Logout</a>
				</li>
			</ul>
		</div>
	</nav>

	<!--spacer-->
	<div class="break"></div>
	<section class="container">
		<%
			if (request.getAttribute("validationMessage") == null) {
		%>
		<div class="alert alert-light text-right shadow-sm d-sm-block-none"
			role="alert">Welcome to your Page!</div>
		<%
			} else {
		%>

		<div class="alert alert-danger text-right show-sm d-sm-block-none"
			role="alert">${requestScope['validationMessage']}</div>
		<%
			}
		%>
		<!--left-side bar-->
		<div class="row justify-content-center">
			<div class="col-lg-3 col-md-4 col-sm-10 col-10 mb-3">
				<div class="list-group" id="list-tab" role="tablist">
					<a class="list-group-item list-group-item-action active"
						id="list-profile-list" data-toggle="list" href="#list-profile"
						role="tab" aria-controls="profile">Profile</a> <a
						class="list-group-item list-group-item-action" id="list-card-list"
						data-toggle="list" href="#list-card" role="tab"
						aria-controls="messages">My Cards</a> <a
						class="list-group-item list-group-item-action"
						id="list-payment-list" data-toggle="list" href="#list-payment"
						role="tab" aria-controls="messages">My Payments</a> <a
						class="list-group-item list-group-item-action "
						id="list-security-list" data-toggle="list" href="#list-security"
						role="tab" aria-controls="profile">Security</a>
				</div>
			</div>

			<c:set var="user" value="${sessionScope['user']}" />
			<!-- TAB Content-->
			<div class="col-8 border rounded bg-light">
				<div class="tab-content" id="nav-tabContent">

					<!-- Profile Tab Content-->
					<div class="tab-pane fade show active" id="list-profile"
						role="tabpanel" aria-labelledby="list-profile-list">
						<div class="mb-5 mt-5">
							<h4 class="text-center">Your Profile</h4>
							<ul class="list-group">
								<li class="list-group-item justify-content-between d-flex">
									<p class="font-italic">Full Name</p>
									<p>${user.getFullName()}</p>
									<button type="button" class="btn btn-link" data-toggle="modal"
										data-target="#fullnameModal">Edit</button>
								</li>
								<li class="list-group-item justify-content-between d-flex">
									<p class="font-italic">Phone</p>
									<p>${user.getPhone()}</p>
									<button type="button" class="btn btn-link" data-toggle="modal"
										data-target="#phoneModal">Edit</button>
								</li>
								<li class="list-group-item justify-content-between d-flex">
									<p class="font-italic">Address</p>
									<p>${user.getCurrentAddress()}</p>
									<button type="button" class="btn btn-link" data-toggle="modal"
										data-target="#addressModal">Edit</button>
								</li>
							</ul>
						</div>
					</div>
					<!--Full Name Modal -->
					<div class="modal fade" id="fullnameModal" tabindex="-1"
						role="dialog" aria-labelledby="FullName" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="ProfileModal">Edit Name</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form action="MyAccount" method="POST" class="form">
										<input type="hidden" name="editmodal" value="fullname">
										<div class="form-group">
											<label class="font-italic" for="firstname">First Name</label>
											<input name="firstname" type="text" class="form-control"
												id="firstname" placeholder="First Name">
										</div>
										<div class="form-group">
											<label class="font-italic" for="lastname">Last Name</label> <input
												name="lastname" type="text" class="form-control"
												id="lastname" placeholder="Last Name">
										</div>
										<div class="form-group">
											<label class="font-italic" for="currentpassword">Current
												Password</label> <input name="currentpassword" type="password"
												class="form-control" id="currentpassword"
												placeholder="Current Password">
										</div>
										<div class="float-right">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
											<button type="submit" class="btn btn-primary">Save
												changes</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>

					<!--Phone Modal -->
					<div class="modal fade" id="phoneModal" tabindex="-1" role="dialog"
						aria-labelledby="Phone" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="ProfileModal">Edit Contact
										Number</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form action="MyAccount" method="POST" class="form">
										<div class="form-group">
											<input type="hidden" name="editmodal" value="phone">
											<label class="font-italic" for="phone">Phone Number</label> <input
												name="phone" type="text" class="form-control" id="phone"
												placeholder="Mobile / Tel">
										</div>
										<div class="form-group">
											<label class="font-italic" for="currentpassword">Current
												Password</label> <input name="currentpassword" type="password"
												class="form-control" id="currentpassword"
												placeholder="Current Password">
										</div>
										<div class="float-right">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
											<button type="submit" class="btn btn-primary">Save
												changes</button>
										</div>
									</form>
								</div>

							</div>
						</div>
					</div>

					<!-- Addres Modal-->
					<div class="modal fade" id="addressModal" tabindex="-1"
						role="dialog" aria-labelledby="Address" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="ProfileModal">Edit Address</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form action="MyAccount" method="POST" class="form">
										<input type="hidden" name="editmodal" value="address">
										<div class="form-group">
											<label class="font-italic" for="line1">Line 1</label> <input
												name="line1" type="text" class="form-control" id="line1"
												placeholder="Line 1">
										</div>
										<div class="form-group">
											<label class="font-italic" for="lastname">Line 2</label> <input
												name="line2" type="text" class="form-control" id="line2"
												placeholder="Line 2">
										</div>
										<div class="form-group">
											<label class="font-italic" for="city">City</label> <input
												name="city" type="text" class="form-control" id="city"
												placeholder="City">
										</div>
										<div class="form-group">
											<label class="font-italic" for="state">State</label> <input
												name="state" type="text" class="form-control" id="state"
												placeholder="State">
										</div>
										<div class="form-group">
											<label class="font-italic" for="postalcode">Postal
												Code</label> <input name="postalcode" type="text"
												class="form-control" id="postalcode"
												placeholder="Postal Code">
										</div>
										<div class="form-group">
											<label class="font-italic" for="currentpassword">Current
												Password</label> <input name="currentpassword" type="password"
												class="form-control" id="currentpassword"
												placeholder="Current Password">
										</div>
										<div class="float-right">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
												
											<button type="submit" class="btn btn-primary">Save
												Changes</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					<!-- CARD Tab Content-->
					<div class="tab-pane fade sendable-usercards" id="list-card"
						role="tabpanel" aria-labelledby="list-card-list">
						<h4 class="text-center mt-4">Your Cards</h4>
						<div class="row p-4">
							<!-- loop cards -->
							<c:forEach items="${user.getCardLetters()}" var="letter">
								<c:if test="${letter !=null }">
									<div class="col">
										<ul class="list-unstyled">
											<!-- list of card letters of user -->
											<li class="media border-top p-3"><img class="mr-3"
												src="${letter.getImageURL()}"
												alt="Generic placeholder image">
												<div class="media-body">
													<h5 class="mt-0 mb-1">To: ${letter.getRecipient()}</h5>
													<small name="date">${letter.getDateAdded()}</small>
													<p class="mb-1" name="message ">${letter.getMessage()}</p>
													<small class="text-danger" name="status">${letter.getStatus()}</small>
												</div></li>
										</ul>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
					<!-- PAYMENT Tab Content-->
					<div class="tab-pane fade sendable-usercards" id="list-payment"
						role="tabpanel" aria-labelledby="list-payment-list">
						<h4 class="text-center mt-4">Your Payments</h4>
						<div class="row p-4">
							<!-- loop cards -->
							<div class="col">
								<div class="list-group">
									<a href="#"
										class="list-group-item list-group-item-action flex-column align-items-start">
										<div class="d-flex w-100 justify-content-between">
											<h5 class="mb-1">List group item heading</h5>
											<small>3 days ago</small>
										</div>
										<p class="mb-1">Donec id elit non mi porta gravida at eget
											metus. Maecenas sed diam eget risus varius blandit.</p> <small>Donec
											id elit non mi porta.</small>
									</a> <a href="#"
										class="list-group-item list-group-item-action flex-column align-items-start">
										<div class="d-flex w-100 justify-content-between">
											<h5 class="mb-1">List group item heading</h5>
											<small class="text-muted">3 days ago</small>
										</div>
										<p class="mb-1">Donec id elit non mi porta gravida at eget
											metus. Maecenas sed diam eget risus varius blandit.</p> <small
										class="text-muted">Donec id elit non mi porta.</small>
									</a> <a href="#"
										class="list-group-item list-group-item-action flex-column align-items-start">
										<div class="d-flex w-100 justify-content-between">
											<h5 class="mb-1">List group item heading</h5>
											<small class="text-muted">3 days ago</small>
										</div>
										<p class="mb-1">Donec id elit non mi porta gravida at eget
											metus. Maecenas sed diam eget risus varius blandit.</p> <small
										class="text-muted">Donec id elit non mi porta.</small>
									</a>
								</div>
							</div>
						</div>
					</div>
					<!-- Security  TAB CONTENT-->
					<div class="tab-pane fade show" id="list-security" role="tabpanel"
						aria-labelledby="list-profile-list">
						<div class="mb-5 mt-5">
							<h4 class="text-center">Your Security</h4>
							<ul class="list-group">
								<li class="list-group-item justify-content-between d-flex">
									<p>Email Addres</p>
									<p>${user.getEmail()}</p>
									<button type="button" class="btn btn-link" data-toggle="modal"
										data-target="#emailModal">Edit</button>
								</li>
								<li class="list-group-item justify-content-between d-flex">
									<p>Password</p>
									<p>Reset Password?</p>
									<button type="button" class="btn btn-link" data-toggle="modal"
										data-target="#passwordModal">Reset</button>
								</li>
							</ul>
						</div>
					</div>

					<!--email modal -->
					<div class="modal fade" id="emailModal" tabindex="-1" role="dialog"
						aria-labelledby="EmailPassword" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="ProfileModal">Edit Login</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form action="" class="form">
										<input type="hidden" name="editmodal" value="email">
										<div class="form-group">
											<label class="font-italic" for="email">Email</label> <input
												name="email" type="text" class="form-control" id="email"
												placeholder="Email Address">
										</div>
										<div class="form-group">
											<label class="font-italic" for="currentpassword">Current
												Password</label> <input name="currentpassword" type="password"
												class="form-control" id="currentpassword"
												placeholder="Current Password">
										</div>
										<div class="float-right">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-primary">Save
												changes</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>

					<!--password modal -->
					<div class="modal fade" id="passwordModal" tabindex="-1"
						role="dialog" aria-labelledby="EmailPassword" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="ProfileModal">Change Password</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form action="MyAccount" method="POST" class="form">
										<input type="hidden" name="editmodal" value="password">
										<div class="form-group">
											<label class="font-italic" for="currentpassword">Current
												Password</label> <input name="currentpassword" type="password"
												class="form-control" id="currentpassword"
												placeholder="Current Password">
										</div>
										<div class="form-group">
											<label class="font-italic" for="newpassword">New
												Password</label> <input name="newpassword" type="password"
												class="form-control" id="newpassword"
												placeholder="New Password">
										</div>
										<div class="form-group">
											<label class="font-italic" for="retypepassword">Retype
												Password</label> <input name="retypepassword" type="password"
												class="form-control" id="retypepassword"
												placeholder="Retype New Password">
										</div>
										<div class="float-right">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-primary">Save
												changes</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>

		<!-- Optional JavaScript -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
			integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
			crossorigin="anonymous"></script>
		<script text="text/javascript" src="js/bootstrap.min.js"></script>
</body>

</html>