<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="subTitle">New Checking Account Application</c:param>
</c:import>

<h2>New Checking Account Application</h2>
<h3>Summary</h3>

<div class='summaryBlock'>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>First Name</span>:
		<c:out value="${customerApplication.firstName}" />
	</div>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>Last Name</span>:
		<c:out value="${customerApplication.lastName}" />
	</div>
	
	<div class='summaryElement'>
		<span class='summaryElementHeader'>Date of Birth</span>:
		<c:out value="${customerApplication.dateOfBirth}" />
	</div>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>State of Birth</span>:
		<c:out value="${customerApplication.stateOfBirth}" />
	</div>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>Email Address</span>:
		<c:out value="${customerApplication.emailAddress}" />
	</div>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>Phone Number</span>:
		<c:out value="${customerApplication.phoneNumber}" />
	</div>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>Street Address</span>:
		<c:out value="${customerApplication.addressStreet}" />
	</div>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>Apartment</span>:
		<c:out value="${customerApplication.addressApartment}" />
	</div>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>City</span>:
		<c:out value="${customerApplication.addressCity}" />
	</div>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>State</span>:
		<c:out value="${customerApplication.addressState}" />
	</div>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>ZIP</span>:
		<c:out value="${customerApplication.addressZip}" />
	</div>

	<form method="POST" action="completeApplication">
		<input type="submit" value="Submit Application" />
	</form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />