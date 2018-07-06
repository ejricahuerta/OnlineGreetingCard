
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
		<div class="col-md-8">
			<div class="card text-center shadow-sm">
				<div class="card-header lead">Search</div>
				<div class="card-body">
					<h5 class="card-title"></h5>
					<p class="card-text">Type anything like (e.g. birthday, 22, mom
						etc.)</p>
					<form action="/Cards" method="POST"
						class="form-inline justify-content-center">
						<div class="form-group mx-sm-3 mb-2">
							<label for="Search" class="sr-only">Search</label> <input
								type="search" name="search" class="form-control" id="search"
								placeholder="Search">
						</div>
						<button type="submit" class="btn btn-primary mb-2">Go</button>
					</form>
				</div>
			</div>
		</div>
	</section>
	<section class="container">
		<ul class="nav justify-content-center">
			<li class="nav-item"><a class="nav-link"></a></li>
		</ul>
	</section>
	<!--top seller section-->
	<section class="mt-3 topseller container ">
		<div class="topseller-heading text-center">
			<h3>All Cards</h3>
		</div>
		<div class="row container justify-content-center">
			<c:forEach items="${applicationScope['allcards']}" var="card">
				<div class="col-md-4 col-lg-4 col-sm-12 p-3 m-1 text-center">
					<div class="card justify-content-center" style="width: 18rem;">
						<img class="card-img-top shadow-lg " src="${card.getImageURL()} "
							alt="${card.getImageURL()}">
						<div class="card-body">
							<h5 class="card-title">${card.getName() }-
								${card.getPrice()}</h5>
							<p class="card-text">${card.getDescription() }</p>
							<a href="#" class="btn btn-primary">Proceed</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>


	<!--Contact Us Section-->
	<jsp:include page="footer.jsp" />