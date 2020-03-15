<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>
<!-- Form goes here -->
<c:url var="formAction" value="/searchActors" />

<div id="actorForm">
    <form action="${formAction}" method="POST">

    <input type="text" name="lastName" id="lastName" placeholder="Search"/>

    <input type="submit" value="Submit" />
</form>
</div>


<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${actors}" var="actor">
<tr>
    <!-- What do we print here for each actor? -->
    <td>
    ${actor.firstName} ${actor.lastName}
    </td>
</tr>
</c:forEach>
</table>
<%@include file="common/footer.jspf"%>