<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="common/header.jsp">
	<c:param name="title" value="Fibonacci"></c:param>
</c:import>

<nav id="page-options">
	<ul>
		<c:set var="numberOfItems" value="20" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>

		<c:set var="numberOfItems" value="50" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>

		<c:set var="numberOfItems" value="100" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>
	</ul>
</nav>

<ul id="fibonacci">
	<c:set var="firstNum" value="0" />
	<c:set var="secondNum" value="1" />
	<c:set var="sum" value="0"/>

	<c:forEach begin="1" end="${ param.max }">
		<c:if test="${sum < param.max}">
			<li><c:out value="${ firstNum }"/></li>
			<c:set var="sum" value="${firstNum + secondNum}"/>
			<c:set var="firstNum" value="${secondNum}"/>
			<c:set var="secondNum" value="${sum}"/>
		</c:if>
	</c:forEach>
	<li><c:out value="${ firstNum }"/></li>

</ul>

<c:import url="common/footer.jsp"></c:import>