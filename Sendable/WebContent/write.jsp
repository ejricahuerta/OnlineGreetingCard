<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans|Roboto" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Allura|Cedarville+Cursive|Homemade+Apple|Nothing+You+Could+Do|Sacramento" rel="stylesheet">

    <title>Sendable</title>
</head>


<body class="container-fluid">
   
   
   
   <!-- nav header -->
	<jsp:include page="navigationheader.jsp"/>
   
    <!--spacer-->
    <div class="break"></div>

    <div class="container">
        <!--content write-->
        <section class="row">
            <!--side-->
            <div class="col-lg-3 col-md-4">
                <div class="card p-4">
                    <img class="card-img-top rounded-circle" src="images/greetingcard1.jpg" alt="card 1">
                    <div class="card-body">
                        <h5 class="card-title">Selected Card</h5>
                        <p>some descriptive texts</p>
                        <a class="btn btn-info">Change Card</a>

                    </div>
                </div>
            </div>
            <!--textarea-->
            <div class="col-lg-9 col-md-8 mb-5">
                <div class="row m-1">
                    <div class="col-12 shadow-sm">
                        <ul class="nav justify-content-around">
                            <li class="nav-item nav-link disabled font1">Sacramento</li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="buton" aria-haspopup="true" aria aria-expanded="false">Choose Font</a>
                                <div class="dropdown-menu">
                                    <a href="#" class="dropdown-item font1">Sacramento</a>
                                    <a href="#" class="dropdown-item font2">Nothing You Could Do</a>
                                    <a href="#" class="dropdown-item font3">Homemade Apple</a>
                                    <a href="#" class="dropdown-item font4">Allura</a>
                                </div>
                            </li>

                        </ul>
                    </div>
                    <div class=" text-space col-12 shadow-lg mt-3">
                        <form class="mt-1" action="#" method="POST">
                            <div class="form-group">
                                <label for="personalizedmsg">Your Message</label>
                                <textarea class=" form-control font1" id="personalizedmsg" rows="8"></textarea>
                            </div>                            
                            <button type="button" class="btn btn-primary">Save</button>
                            <a class="btn" href="#">Clear</a>
                        
                        </form>

                    </div>
                </div>
            </div>
        </section>
    </div>
<jsp:include page="footer.jsp"/>