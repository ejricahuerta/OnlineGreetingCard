
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="sendable.logic.dtos.CardDto"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
          <form action="/Cards" method="POST" class="form-inline justify-content-center">
            <div class="form-group mx-sm-3 mb-2">
              <label for="Search" class="sr-only">Search</label>
              <input type="search" name="search" class="form-control" id="search" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-primary mb-2">Go</button>
          </form>
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
      <h3>All Cards</h3>
    </div>
    <div class="row topseller justify-content-center">
    
    <c:forEach items="${applicationScope['allcards']}" var="card" >
    
      <a class="btn col-lg-2 col-md-4 col-sm-6 col-9 shadow-lg m-3">
        <img class="img-fluid mx-auto d-block" src="${card.getImageURL()}" alt="${card.getName()}"/>
        <span class="text-center">${card.getPrice()}</span>
      </a>
      
      </c:forEach>
      <a class="btn col-lg-2 col-md-4 col-sm-6 col-9 shadow-lg m-3">
        <img class="img-fluid mx-auto d-block" src="images/greetingcard2.jpg" alt="card1" />
      </a>
      <a class="btn col-lg-2 col-md-4 col-sm-6 col-9 shadow-lg m-3">
        <img class="img-fluid mx-auto d-block" src="images/greetingcard1.jpg" alt="card1" />
      </a>
      <a class="btn col-lg-2 col-md-4 col-sm-6 col-9 shadow-lg m-3">
        <img class="img-fluid mx-auto d-block" src="images/greetingcard1.jpg" alt="card1" />
      </a>
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