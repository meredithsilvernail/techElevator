<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jspf" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<c:url var="actorSearch" value="/searchActorForm"/>
<c:url var="filmSearch" value="/searchFilmForm"/>
<c:url var="customerSearch" value="/searchCustomers"/>

<button type="submit" class="homeButtons" id="actorSearch" name="actorSearch"><a href="${actorSearch}">Actor Search</a>  </button>
<button type="submit" class="homeButtons" id="filmSearch" name="filmSearch"><a href="${filmSearch}">Film Search</a></button>
<button type="submit" class="homeButtons" id="customerSearch" name="customerSearch"><a href="${customerSearch}">Customer Search</a></button>


</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jspf" />
