<jsp:include page="header.jsp"/>

<body class="container-fluid">
	<jsp:include page="navigationheader.jsp"/>
  <!--Navigation-->
  

  <!--spacer-->
  <div class="break"></div>

  <!--heading-->
  <section class="catchphrase row justify-content-center mt-3 mx-auto">
    <div class="col-md-8">

      <div class="card text-center shadow-sm">
        <div class="card-header lead">
          Search
        </div>
        <div class="card-body">
          <h5 class="card-title"></h5>
          <p class="card-text">Type anything like (e.g. birthday, 22, mom etc.)</p>
          <form class="form-inline justify-content-center">
            <div class="form-group mx-sm-3 mb-2">
              <label for="Search" class="sr-only">Search</label>
              <input type="search" class="form-control" id="search" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-primary mb-2">Go</button>
          </form>
        </div>
      </div>
    </div>
    </div>
  </section>
  <section class="container">
    <ul class="nav justify-content-center">
      <li class="nav-item">
        <a class="nav-link"></a>
      </li>
    </ul>
  </section>
  <!--top seller section-->
  <section class="mt-3 topseller ">
    <div class="topseller-heading text-center">
      <h3>All Top Sellers</h3>
    </div>
    <div class="row topseller justify-content-center">
      <a class="btn col-lg-2 col-md-4 col-sm-6 col-9 shadow-lg m-3">
        <img class="img-fluid mx-auto d-block" src="images/greetingcard1.jpg" alt="card1" />
      </a>
      <a class="btn col-lg-2 col-md-4 col-sm-6 col-9 shadow-lg m-3">
        <img class="img-fluid mx-auto d-block" src="images/greetingcard2.jpg" alt="card1" />
      </a>
      <a class="btn col-lg-2 col-md-4 col-sm-6 col-9 shadow-lg m-3">
        <img class="img-fluid mx-auto d-block" src="images/greetingcard1.jpg" alt="card1" />
      </a>
      <a class="btn col-lg-2 col-md-4 col-sm-6 col-9 shadow-lg m-3">
        <img class="img-fluid mx-auto d-block" src="images/greetingcard1.jpg" alt="card1" />
      </a>
    </div>
  </section>

  <!--Newly Added Section-->
  <section class="mt-3 newly-added">
    <div class="newly-added-heading text-center">
      <h3>New Cards on the Board</h3>
    </div>
    <div class="row newcards justify-content-center">
      <a class="btn col-lg-2 col-md-4 col-sm-6 col-9 shadow-lg m-3">
        <img class="img-fluid mx-auto d-block" src="images/greetingcard1.jpg" alt="card1" />
      </a>
      <a class="btn col-lg-2 col-md-4 col-sm-6 col-9 shadow-lg m-3">
        <img class="img-fluid mx-auto d-block" src="images/greetingcard2.jpg" alt="card1" />
      </a>
      <a class="btn col-lg-2 col-md-4 col-sm-6 col-9 shadow-lg m-3">
        <img class="img-fluid mx-auto d-block" src="images/greetingcard1.jpg" alt="card1" />
      </a>
      <a class="btn col-lg-2 col-md-4 col-sm-6 col-9 shadow-lg m-3">
        <img class="img-fluid mx-auto d-block" src="images/greetingcard1.jpg" alt="card1" />
      </a>
    </div>
  </section>
  <!--Contact Us Section-->
<jsp:include page="footer.jsp"/>