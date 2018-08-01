<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	if (request.getAttribute("user") == null) {
		response.sendRedirect("MyAccount");
	}
%>

<jsp:include page="header.jsp" />

<body class="container-fluid">
	<!--Navigation Bar-->
	<jsp:include page="navigationheader.jsp" />

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

		<div class="row justify-content-center">

			<!-- side navbar -->
			<div class="col-lg-3 col-md-4 col-sm-12 col-12 mb-3 ">
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
			<!-- TAB Content-->
			<div class="col-lg-8 col-md-8 col-11 border rounded bg-light">
				<div class="tab-content" id="nav-tabContent">
					<!-- Profile Tab Content-->
					<div class="tab-pane fade show active" id="list-profile"
						role="tabpanel" aria-labelledby="list-profile-list">
						<div class="mb-5 mt-5">
							<h4 class="text-center">Your Profile</h4>
							<ul class="list-group">
								<li class="list-group-item justify-content-between d-flex">
									<label
									class="font-italic d-none d-md-block d-lg-block d-xl-block">Full
										Name</label>
									<p>${user.getFullName()}</p>
									<button type="button" class="btn btn-link" data-toggle="modal"
										data-target="#fullnameModal">Edit</button>
								</li>
								<li class="list-group-item justify-content-between d-flex">
									<label
									class="font-italic d-none d-md-block d-lg-block d-xl-block">Phone</label>
									<p>${user.getPhone()}</p>
									<button type="button" class="btn btn-link" data-toggle="modal"
										data-target="#phoneModal">Edit</button>
								</li>
								<li class="list-group-item justify-content-between d-flex">
									<label
									class="font-italic d-none d-md-block d-lg-block d-xl-block">Address</label>
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
												id="firstname" placeholder="First Name" required>
										</div>
										<div class="form-group">
											<label class="font-italic" for="lastname">Last Name</label> <input
												name="lastname" type="text" class="form-control"
												id="lastname" placeholder="Last Name" required>
										</div>
										<div class="form-group">
											<label class="font-italic" for="currentpassword">Current
												Password</label> <input name="currentpassword" type="password"
												class="form-control" id="currentpassword"
												placeholder="Current Password" required>
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
												placeholder="Mobile / Tel" required>
										</div>
										<div class="form-group">
											<label class="font-italic" for="currentpassword">Current
												Password</label> <input name="currentpassword" type="password"
												class="form-control" id="currentpassword"
												placeholder="Current Password" required>
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
												placeholder="Line 1" required>
										</div>
										<div class="form-group">
											<label class="font-italic" for="lastname">Line 2</label> <input
												name="line2" type="text" class="form-control" id="line2"
												placeholder="Line 2">
										</div>
										<div class="form-group">
											<label class="font-italic" for="city">City</label> <input
												name="city" type="text" class="form-control" id="city"
												placeholder="City" required>
										</div>
										<div class="form-group">
											<label class="font-italic" for="state">State</label> <input
												name="state" type="text" class="form-control" id="state"
												placeholder="State" required>
										</div>
										<div class="form-group">
											<label class="font-italic" for="postalcode">Postal
												Code</label> <input name="postalcode" type="text"
												class="form-control" id="postalcode"
												placeholder="Postal Code" required>
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
						<div class="row p-2">
							<!-- loop cards -->
							<c:forEach items="${user.getCardLetters()}" var="letter">
								<c:if test="${letter !=null }">
									<div class="col">
										<ul class="list-unstyled">
											<!-- list of card letters of user -->
											<li class="media border-top p-2"><img class="mr-3"
												src="${letter.getImageURL()}"
												alt="Generic placeholder image">
												<div class="media-body">
													<h5 class="mt-0 mb-1">
														<span class="font-italic">To:</span>
														${letter.getRecipient()}
													</h5>
													<small>${letter.getDateAdded()}</small>
													<p class="mb-1 message-text ${letter.getFontStyle()}">${letter.getMessage()}</p>

													<small class="text-info">${letter.getStatus()}</small>
													<button type="button" class="btn btn-link"
														data-toggle="modal"
														data-target="#<c:out value="${letter.getId()}"/>">
														View</button>
													<div class="modal fade" id="${letter.getId()}"
														tabindex="-1" role="dialog"
														aria-labelledby="messageModalLabel" aria-hidden="true">
														<div class="modal-dialog" role="document">
															<div class="modal-content">
																<div class="modal-header">
																	<h5 class="modal-title" id="messageModalLabel">To:
																		${letter.getRecipient() }</h5>
																	<button type="button" class="close"
																		data-dismiss="modal" aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																	</button>
																</div>
																<div class="modal-body">
																	<p class="${letter.getFontStyle()}">${letter.getMessage()}</p>
																</div>
																<div class="modal-footer">
																	<c:if test="${letter.getStatus() != 'Paid' }">
																		<a class="btn btn-secondary"
																			href="EditLetter?letterId=${letter.getId()}">Edit</a>
																	</c:if>
																</div>
															</div>
														</div>
													</div>
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
						<div class="row p-2">
							<!-- loop cards -->
							<div class="col">
								<div class="list-group">
									<c:forEach items="${user.getPayments()}" var="payment">
										<div
											class="list-group-item list-group-item-action flex-column align-items-start">
											<div class="d-flex w-100 justify-content-between">
												<h5 class="mb-1">Payment for Card:
													${payment.getCardLetterId()}</h5>
												<small>Date of Payment: ${payment.getDateAdded()}</small>
											</div>
											<p class="mb-1">Shipped to: ${payment.getShipping()}</p>
											<small> Total Amount Paid: $<fmt:formatNumber
													value="${payment.getTotalAmount()}" />
											</small>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
					<!-- Top up Modal -->
					<div class="modal fade" id="topupModal" tabindex="-1" role="dialog"
						aria-labelledby="TopUp" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title">Top Up</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form action="MyAccount" method="POST" class="form">
										<input type="hidden" name="editmodal" value="topup">
										<div class="form-group">
											<label class="font-italic" for="current">Current
												Balance: $${user.getAccountDto().getCredit() }</label>
										</div>
										<div class="form-group">
											<label class="font-italic" for="topupamount">Amount </label>
											<input name="topupamount" type="text" class="form-control"
												id="topupamount" placeholder="0.00" autofocus required>
										</div>
										<div class="form-group">
											<label class="font-italic" for="currentpassword">Current
												Password</label> <input name="currentpassword" type="password"
												class="form-control" id="currentpassword"
												placeholder="Current Password" required>
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

					<!-- Security  TAB CONTENT-->
					<div class="tab-pane fade show" id="list-security" role="tabpanel"
						aria-labelledby="list-profile-list">
						<div class="mb-5 mt-5">
							<h4 class="text-center">Your Secure Login</h4>
							<ul class="list-group">
								<li class="list-group-item justify-content-between d-flex">
									<label class="d-none d-md-block d-lg-block d-xl-block">Email
										Address</label>
									<p>${user.getEmail()}</p>
									<button type="button" class="btn btn-link" data-toggle="modal"
										data-target="#emailModal">Edit</button>
								</li>
								<li class="list-group-item justify-content-between d-flex">
									<label class="d-none d-md-block d-lg-block d-xl-block">Password</label>
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
									<form action="MyAccount" method="POST" class="form">
										<input type="hidden" name="editmodal" value="email">
										<div class="form-group">
											<label class="font-italic" for="email">Email</label> <input
												name="email" type="text" class="form-control" id="email"
												placeholder="Email Address" required>
										</div>
										<div class="form-group">
											<label class="font-italic" for="currentpassword">Current
												Password</label> <input name="currentpassword" type="password"
												class="form-control" id="currentpassword"
												placeholder="Current Password" required>
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
												placeholder="Current Password" required>
										</div>
										<div class="form-group">
											<label class="font-italic" for="newpassword">New
												Password</label> <input name="newpassword" type="password"
												class="form-control" id="newpassword"
												placeholder="New Password" required>
										</div>
										<div class="form-group">
											<label class="font-italic" for="retypepassword">Retype
												Password</label> <input name="retypepassword" type="password"
												class="form-control" id="retypepassword"
												placeholder="Retype New Password" required>
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
				</div>
			</div>
		</div>
	</section>
	
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