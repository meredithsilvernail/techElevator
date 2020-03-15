<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf" %>

<c:url var="formAction" value="/searchCustomers"/>

<div id="actorForm">
    <form action="${formAction}" method="POST">

        <input type="text" name="searchName" id="searchName" placeholder="Search"/>
        <label for="sortOption">Sort:</label>
        <select name="sortOption" id="sortOption">
            <option value="last_name">Last Name</option>
            <option value="email">Email</option>
            <option value="activebool">Active</option>
        </select>

        <input type="submit" value="Submit"/>
    </form>
</div>


<table class="table">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Active</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <!-- What do we print here for each actor? -->
            <td>
                    ${customer.firstName} ${customer.lastName}
            </td>
            <td>
                    ${customer.email}
            </td>
            <td>
                <c:choose>
                    <c:when test="${customer.active}">
                        <p>Yes</p>
                    </c:when>
                    <c:otherwise>
                        <p>No</p>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>

<%@include file="common/footer.jspf" %>