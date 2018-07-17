<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<body class="container-fluid">
	<jsp:include page="navigationheader.jsp" />

	<section class="container">

		<form class="row" action="Payment" method="post">
			<div class="form-row">
				<div class="form-group col-md">
					<label for="line1">Line 1<span class="required-field">
							*</span></label> <input name="line1" type="text" class="form-control" id="line1"
						placeholder="70 The Pond Rd" required>
				</div>
				<div class="form-group col-sm">
					<label for="line2">Line 2</label> <input name="line2" type="text"
						class="form-control" id="line2"
						placeholder="Apartment, studio, or floor">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6 col-sm-6">
					<label for="city">City<span class="required-field">
							*</span></label> <input name="city" type="text" class="form-control" id="city"
						placeholder="Toronto" required>
				</div>
				<div class="form-group col-md-6 col-sm-4">
					<label for="state">State<span class="required-field">
							*</span></label> <input name="state" type="text" id="state" class="form-control"
						placeholder="Ontario" required>
				</div>
				<div class="form-group col-md-3 col-sm-4 col-xs-4 col-6">
					<label for="postal">Zip<span class="required-field">
							*</span></label> <input type="text" class="form-control" id="postal"
						name="postalcode" placeholder="A1A 1A1" required>
				</div>
			</div>
		</form>
	</section>
	<jsp:include page="footer.jsp" />