<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/main.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans|Roboto"
	rel="stylesheet">

<title>Sendable</title>
</head>

	<body class="container-fluid">
    <!--Navigation Bar-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <a class="navbar-brand" href="index.html">SENDABLE</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#sendablenav" aria-controls="sendablenav"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="sendablenav">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="btn nav-link" href="#">Home
                    </a>
                </li>
                <li class="nav-item">
                    <a class="btn nav-link" href="cards.html">Cards</a>
                </li>
                <li class="nav-item">
                    <a class="btn nav-link" href="categories.html">Categories</a>
                </li>
            </ul>
            <ul class=" navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="btn nav-link" href="login.html">Logout</a>
                </li>
            </ul>
        </div>
    </nav>

    <!--spacer-->
    <div class="break"></div>
    <section class="container">
        <div class="alert alert-light text-right shadow-sm d-sm-block-none" role="alert">
            Welcome to your Page!
        </div>
        <!--left-side bar-->
        <div class="row sendable-myaccount">
            <div class="leftsidenav col-lg-3 col-md-3 col-sm-3 m-1">
                <nav class="nav flex-column text-center">
                    <a class="  nav-link shadow-sm" href="#">Profile</a>
                    <a class="  nav-link shadow-sm" href="#">My Cards</a>
                    <a class="  nav-link shadow-sm" href="#">Account</a>
                    <a class="  nav-link shadow-sm" href="#">Payments</a>
                    <a class="  nav-link shadow-sm" href="#">Security</a>
                </nav>
            </div>
            
            <!-- profile -->
            
            <div id="profile" class="sendable-main-content mt-2 col-lg-8 col-md-8 col-sm-8 border">
                <h3 class="text-center mt-2">Your Profile</h3>
                <form class="m-5">
                    <div class="form-row ">
                        <div class="form-group col-md-6">
                            <label for="firstname">First Name</label>
                            <input name="firstname" type="text" class="form-control bg-white border-light font-weight-bold" id="firstname" placeholder="First Name" value="${sessionScope['user'].getFullName().split(' ')[0]}	"disabled>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="lastname">Last Name</label>
                            <input name="lastname" type="text" class="form-control bg-white border-light font-weight-bold" id="lastname" placeholder="Last Name" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="line1">Line 1</label>
                        <input name="line2" type="text" class="form-control bg-white border-light font-weight-bold" id="line1" placeholder="Line 1" value="64 Hord Cres" disabled>
                    </div>
                    <div class="form-group">
                        <label for="line2">Line 2</label>
                        <input name="line2" type="text" class="form-control bg-white border-light font-weight-bold" id="line2" placeholder="Apartment, studio, or floor" value=" "
                            disabled>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="city">City</label>
                            <input name="city" type="text" class="form-control bg-white border-light font-weight-bold" id="city" value="Thornhill" disabled>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="state">State</label>
                            <input name="state" type="text" class="form-control bg-white border-light font-weight-bold" id="state" value="Ontario" disabled>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="postalcode">Postal Code</label>
                            <input name="postalcode" type="text" class="form-control bg-white border-light font-weight-bold" id="postalcode" value="L4J3A7" disabled>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary" disabled>Update</button>
                </form>
            </div>
        </div>
    </section>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>