 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />

<body class="container-fluid">
	<!-- nav header -->
	<!--Navigation Bar-->
	<jsp:include page="navigationheader.jsp" />

	<!--spacer-->
	<div class="break"></div>

	<!-- Set var for card selected -->
	<c:set var="card" value="${requestScope['cardSelected']}" />
	<c:if test="${card ==null }">
		<c:redirect url="cards.jsp" />
	</c:if>

	<div class="container">
		<!--content write-->
		<section class="row">
			<!--side-->
			<div class="col-lg-3 col-md-4">
				<div class="card p-4">
					<img class="card-img-top rounded" src="${card.getImageURL()}"
						alt="card 1">
					<div class="card-body">
						<h5 class="card-title">${card.getName() }</h5>
						<p>${card.getDescription()}</p>
						<c:if test="${requestScope['letterId'] == null}">
						<a class="btn btn-info" href="Cards">Change Card</a>
						</c:if>
					</div>
				</div>
			</div>
			<!--textarea-->
			<div class="col-lg-9 col-md-8 mb-5">
				<form action="${resquestScope['type']}" method="POST" class="row m-1">
					<input type="hidden" name="cardId" value="${card.getId()}">
					<div class="col-12 shadow-sm">
						<ul class="nav justify-content-around">
							<li class="nav-item nav-link disabled font1">Gaegu</li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
								role="buton" aria-haspopup="true" aria-expanded="false">Choose
									Font</a>
								<div class="dropdown-menu">
									<a href="#" class="dropdown-item font1">Gaegu</a> <a href="#"
										class="dropdown-item font2">Gochi Hand</a> <a href="#"
										class="dropdown-item font3">Homemade Apple</a> <a href="#"
										class="dropdown-item font4">Marck Script</a> <a href="#"
										class="dropdown-item font4">NothingYou Could Do</a> <a
										href="#" class="dropdown-item font4">Permanent Marker</a> <a
										href="#" class="dropdown-item font4">Sacramento</a>
								</div></li>
						</ul>
					</div>
					
					<div class=" text-space col-12 shadow-lg mt-3">
						<%
							if (request.getAttribute("validationMessage") == null) {
						%>
						<div class="alert alert-info shadow-sm mt-2" role="alert">
							Start writing now.</div>
						<%
							} else {
						%>
						<div class="alert alert-danger shadow-sm mt-2" role="alert">
							<%=request.getAttribute("validationMessage")%>
						</div>
						<%
							}
						%>
						<input type="hidden" name="letterId" value="${requestScope['letterId']}" />
						<div class="form-group">
							<label class="font-italic" for="personalizedmsg ">Your
								Message</label>
							<textarea class=" form-control font1" id="personalizedmsg"
								name="message" rows="15" required>${requestScope['message']}</textarea>
						</div>
						<div class="form-group d-block">
							<label class="font-italic" for="cardfor">To:</label> <input
								type="text" class="form-control col-6 font1" id="cardfor"
								name="recipient" required value="${requestScope['recipient']}"/>
						</div>
						<div class="m-2 d-block">
							<input name="button" type="submit" class="btn btn-primary"
								value="Save"> <input name="button" type="submit"
								class="btn btn-primary" value="Pay Now" />
						</div>
					</div>
				</form>
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
	<script src="js/bootstrap.min.js"></script>

</body>

</html>