<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/home/mainHeader.jsp" />

<section class="jumbotron" id="heading">
    <div class="container headerText">
        <h1 class="display-4 headingText">Brewery Finder</h1>
        <p class="lead headingText">Welcome to the Brewery Finder! Here you can find your next brewery adventure!</p>

        <c:url var="breweriesUrl" value="/breweries"/>
        <a class="btn btn-primary btn-lg" href="${breweriesUrl}" role="button">View Breweries</a>
        <c:url  var="loginUrl" value="newLogin.jsp"/>
        <a class="btn btn-primary btn-lg" href="${loginUrl}" role="button">Beer Lover Log In</a>
    </div>
</section>

<c:import url="/WEB-INF/jsp/footer.jsp" />