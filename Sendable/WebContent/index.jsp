<jsp:include page="header.jsp"/>

<body class="container-fluid">

	
 	<jsp:include page="navigationheader.jsp"/>
 	
  <!--spacer-->
  <div class="break"></div>

  <!--heading-->
  <section class="mt-3 catchphrase row mx-auto">
    <div class="col-md-12">
      <div class="jumbotron shadow-lg">
        <h1 class="display-4">Sendable</h1>
        <p class="lead">We aim to connect emotions via Cards</p>
        <hr class="my-4">
        <p>Browse our Quality Cards </p>
        <a class="btn btn-primary btn-lg" href="cards.jsp" role="button">Choose Card</a>
      </div>
    </div>
  </section>

  <section class="howto mx-auto mb-3 row border">
    <div class="col-md-12 mb-3 text-center">
      <h2 class="mt-3">How It Works</h2> 
    </div>
    <div class="col-md-4 mb-3">
      <div class="card bg-dark text-white shadow-lg">
        <div class="card-body">
          <h5 class="card-title">Choose A Card</h5>
          <p class="card-text">Select a Card from our various Categories</p>
          <a href="categories.jsp" class="btn btn-primary">Go To Categories</a>
        </div>
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <div class="card bg-danger text-white shadow-lg">
        <div class="card-body">
          <h5 class="card-title">Write your Personalized Message</h5>
          <p class="card-text">Choose font style you want.</p>
          <a href="fonts.jsp" class="btn btn-primary">See Styles</a>
        </div>
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <div class="card bg-light text-black shadow-lg">
        <div class="card-body">
          <h5 class="card-title">Send</h5>
          <p class="card-text">We print and send your personalized card.</p>
         
          <a href="${sessionScope['user']== null?'cards.jsp':'write.jsp'} " class="btn btn-primary">Write Now</a>
        </div>
      </div>
    </div>
  </section>
<jsp:include page="footer.jsp"/>