<%@page import="sendable.logic.services.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<jsp:include page="header.jsp" />
<body class="container-fluid">
	<jsp:include page="navigationheader.jsp" />


	<!--Spaces-->
	<div class="break"></div>

	<!-- pay form -->
	<section class="container">
		<div class="row justify-content-center">
			<div class="col-lg-4 col-md-4 col-10">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Pay Letter</h5>
						<table class="table">
							<tbody>
								<tr>
									<th scope="row">Letter Id:</th>
									<td>${letter.getId()}</td>
								</tr>
								<tr>
									<th scope="row">Greeting Card Id:</th>
									<td>${letter.getCardId() }</td>
								</tr>
								<tr>
									<th scope="row">Total Cost</th>
									<td>${letter.getTotalCost()}</td>

								</tr>
								<tr>
									<th scope="row">Recipient</th>
									<td>${letter.getRecipient()}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-5 col-10 border rounded p-4">
				<form class="container " action="Payment" method="post">

					<%
						if (request.getAttribute("validationMessage") == null) {
					%>

					<div class="alert alert-info " role="alert">Enter your
						shipping information.</div>
					<%
						} else {
					%>

					<div class="alert alert-danger " role="alert"></div>

					<%
						}
					%>

					<h5 class="p-lead">Shipping Address</h5>
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="line1">Line 1<span class="required-field">
									*</span></label> <input name="line1" type="text" class="form-control"
								id="line1" placeholder="70 The Pond Rd" required>
						</div>
						<div class="form-group col-md-12">
							<label for="line2">Line 2</label> <input name="line2" type="text"
								class="form-control" id="line2"
								placeholder="Apartment, studio, or floor">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-5 col-sm-5">
							<label for="city">City<span class="required-field">
									*</span></label> <input name="city" type="text" class="form-control" id="city"
								placeholder="Toronto" required>
						</div>
						<div class="form-group col-md-5 col-sm-5">
							<label for="state">State<span class="required-field">
									*</span></label> <input name="state" type="text" id="state"
								class="form-control" placeholder="Ontario" required>
						</div>
						<div class="form-group col-md-3 col-sm-4 col-xs-4 col-6">
							<label for="postal">Zip<span class="required-field">
									*</span></label> <input type="text" class="form-control" id="postal"
								name="postalcode" placeholder="A1A 1A1" required>
						</div>
					</div>

					<h5 class="p-lead">Payment Type</h5>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="payment"
							id="acount" value="account" checked> <label
							class="form-check-label" for="account"> Account Credit</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="payment"
							id="visa" value="visa"> <label class="form-check-label"
							for="visa"> Visa</label>
					</div>
					<div class="col-12 mt-5 p-1">
						<button type="submit" class="btn btn-primary">Pay</button>
					</div>
				</form>
			</div>
		</div>
	</section>
	<jsp:include page="footer.jsp" />