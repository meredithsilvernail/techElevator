<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="subTitle" value="Mortgage Calculator" />
</c:import>

<h2>Your Calculated Mortgage Payment</h2>

<div class='summaryBlock'>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>Loan Amount</span>: $
		<c:out value="${param.loanAmount}" />
	</div>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>Loan Term</span>:
		<c:out value="${param.loanTerm}" />
	</div>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>years Interest Rate</span>:
		<c:out value="${param.rate}" />
	</div>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>% Monthly Payment</span>:
		<c:out value="${estimate.monthlyPayment}" />
	</div>

</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />