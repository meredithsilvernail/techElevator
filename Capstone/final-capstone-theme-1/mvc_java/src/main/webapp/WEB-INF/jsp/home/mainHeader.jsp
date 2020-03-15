<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Team 3 Capstone Columbus Tech Start">

    <title>Brewery Finder Home</title>

    <!-- Custom fonts for this template-->
    <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/16ab78ebe2.js" crossorigin="anonymous"></script>
    <!-- Custom styles for this project-->
    <link href="../../css/style.css" rel="stylesheet"/>

</head>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="mainNavBar">
    <a class="navbar-brand" href="#"><i class="fas fa-beer" id="beerLogo"></i>Brewery Finder</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active navLinks">
                <c:url var="homePageUrl" value="/"/>
                <a class="nav-link navLinks" href="${homePageUrl}">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown navLinks">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Get Started!
                </a>
                <div class="dropdown-menu navLinks" aria-labelledby="navbarDropdown">
                    <c:url var="breweriesUrl" value="/breweries"/>
                    <a class="dropdown-item" href="${breweriesUrl}">Breweries</a>
                    <a class="dropdown-item" href="#">Beers</a>
                    <div class="dropdown-divider"></div>
                    <c:url var="loginUrl" value="newLogin.jsp"/>
                    <a class="dropdown-item" href="${loginUrl}">Beer Lover Log-In</a>
                </div>
            </li>
            <li class="nav-item dropdown no-arrow navLinks">
                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Guest<i id="cheersLogo" class="fas fa-glass-cheers"></i></span>
                </a>
                <!-- Dropdown - User Information -->
                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown" id="profileMenu">
                    <a class="dropdown-item" href="#">
                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                        Profile
                    </a>
                    <a class="dropdown-item" href="#">
                        <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                        Settings
                    </a>
                    <a class="dropdown-item" href="#">
                        <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                        Activity Log
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                        Logout
                    </a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" method="GET" action="/home/newLogin">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log In</button>
        </form>
    </div>
</nav>
