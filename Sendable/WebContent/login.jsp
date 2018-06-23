<jsp:include page="header.jsp"/>
<!--Body-->

<body class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <a class="navbar-brand" href="#">SENDABLE</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#sendablenav" aria-controls="sendablenav"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="sendablenav">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item">
                    <a class="btn nav-link" href="index.html">Home
                    </a>
                </li>
                <li class="nav-item ">
                    <a class="btn nav-link" href="cards.html">Cards</a>
                </li>
                <li class="nav-item">
                    <a class="btn nav-link" href="categories.html">Categories</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="btn nav-link" href="login.html">Login</a>
                </li>
                <li class="nav-item">
                    <a class="btn nav-link " href="register.html">Register</a>
                    <span class="sr-only">(current)</span>
                </li>
            </ul>
        </div>
    </nav>

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
                    <div  class="alert alert-info shadow-sm" role="alert">
           				<%= request.getAttribute("validationMessage") %>
                    </div>
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
                        <a class="btn btn-light" href="register.html" role="button">Register</a>
                    </form>
                </div>
            </div>
        </div>
    </div>


<jsp:include page="footer.jsp"/>