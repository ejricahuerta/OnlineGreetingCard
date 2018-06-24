<jsp:include page="header.jsp"/>

<!--Body-->
<body class="container-fluid">

<!-- nav header -->
	<jsp:include page="navigationheader.jsp"/>
    
    <!--Spaces-->
    <div class="break"></div>

    <!--Registration Form-->
    <div class="row justify-content-center mb-5">
        <div class="col-xl-6 col-lg-8 col-md-8 col-sm-11">
            <div class="card register-form shadow-lg">
                <div class="card-header lead">
                    Login
                </div>
                <div class="card-body">
           				<%if(request.getAttribute("validationMessage") == null) {%>
                    <div  class="alert alert-info shadow-sm" role="alert">
                    	Enter your Information.
                    </div>
                    <%}else{ %>
                    <div  class="alert alert-danger shadow-sm" role="alert">
                    	<%=request.getAttribute("validationMessage")%>
                    </div>
                    <%} %>
                    <form action="Authenticate" method="POST">
                        <div class="form-row">
                            <div class="form-group col-md-6 col-sm-6">
                                <label for="email">Email
                                    <span class="required-field"> *</span>
                                </label>
                                <input name="email" type="email" class="form-control" id="email" placeholder="johndoe@example.com">
                            </div>
                            <div class="form-group col-md-6 col-sm-6">
                                <label for="password">Password
                                    <span class="required-field"> *</span>
                                </label>
                                <input name="password" type="password" class="form-control" id="password" placeholder="Password">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Login</button>
                        <a class="btn btn-light" href="register.jsp" role="button">Register</a>
                    </form>
                </div>
            </div>
        </div>
    </div>


<jsp:include page="footer.jsp"/>