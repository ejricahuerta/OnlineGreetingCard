
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="sendable.logic.dtos.CardDto"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<body class="container-fluid">
	<jsp:include page="navigationheader.jsp" />
	<!--Navigation-->


	<!--spacer-->
	<div class="break"></div>

	<!--heading-->
	<section class="catchphrase row justify-content-center mt-3 mx-auto">
		<div class="col-lg-8 col-md-10 col-sm-12 ">
			<div class="card text-center shadow-sm">
				<div class="card-header lead">Filter</div>
				<div class="card-body">
					<form action="Cards" method="POST"
						class="form-inline justify-content-center">
						<div class="form-group mx-sm-3 mb-2">
							<label for="Search" class="sr-only">Search</label> 
							<input
								type="search" name="search" class="form-control" id="search"
								placeholder="Search">
						</div>
						<button type="submit" class="btn btn-primary mb-2">Go</button>
						<a href="cards.jsp" class="btn btn-link">Reset</a>
					</form>
				</div>
			</div>
		</div>
	</section>
	<section id="gallery">
		<div class="container">
			<div class="row">
				<c:forEach
					items="${requestScope['allcards'] == null? applicationScope['allcards']:requestScope['allcards']}"
					var="card">
					<div class="col-lg-4 col-md-6 col-xs-11 img-space">
						<div class="gallery">
							<a type="button" href="${card.getImageURL()}" data-toggle="modal"
								data-target="#${card.getId()}"> <img class="img-responsive"
								src="${card.getImageURL()}" style="width: 100%;" /> <span
								class="overlay2"> ${card.getName()} - $${card.getPrice()}
							</span>
							</a>
						</div>
					</div>

					<!--modal-->
					<div class="modal fade" id="${card.getId()}" tabindex="-1"
						role="dialog" aria-labelledby="modalcard" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-body">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<img class="img-fluid" src="${card.getImageURL()}"
										alt="${card.getName()}" style="width: 100%;" />
								</div>
								<div class="modal-footer">
									<p>${ card.getDescription() }<span class="d-flex">$${card.getPrice() }
										</span>
									</p>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>

	<!--Contact Us Section-->
	<jsp:include page="footer.jsp" />