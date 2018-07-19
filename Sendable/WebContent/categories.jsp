
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="sendable.logic.dtos.CategoryDto"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<body class="container-fluid">

	<jsp:include page="navigationheader.jsp" />

	<!--spacer-->

	<div class="break"></div>

	<!--all category Section-->
	<section class="row justify-content-center">
		<div class="col-lg-6 col-md-6 col-sm-10 col-xs-12">
			<div class=" card allcategories shadow-lg">
				<div class="card-body">
					<div class="row justify-content-center">
						<div class="m-3 categories-card col-md col-sm">
							<ul class="list-group mx-auto pl-3 pr-3 text-center">
								<c:forEach items="${applicationScope['allcategories']}" var="category">
									<li class="list-group-item text-center">						
										<a class="btn btn-link" href="Cards?search=${category.getName()}">${category.getName()}
											<span class="badge badge-primary badge-pill">${category.getCards().size()}</span>
										</a>
									</li>
								</c:forEach>
							</ul>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 m-2 text-center">
							<img class="img img-fluid mb-3" src="images/postcard.png"
								alt="Post Card">
							<h4>Choose a Category</h4>
							<p>All our Cards our made by various art designers from all
								over the world. Help them get their name out by choosing their
								card.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="footer.jsp" />