<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Details" />
</c:import>

<!-- Container for the Product -->
<!-- The current product is available using the `product` variable -->
<div id="product-detail">
	<img src="<c:url value="/images/product-images/${product.imageName}" />" />
	<div class="product-description">
		<h3>${product.name}</h3>

		<!-- .filled will make the star solid -->
		<div class="rating">
			<c:forEach begin="1" end="5" var="starCount">
				<span class="${starCount <= product.averageRating ? 'filled' : ''}">&#9734;</span>
			</c:forEach>
			<p class="alert-remaining">
				<c:if test="${product.remainingStock > 0 && product.remainingStock <= 5}">
					<span class="product-alert">Only ${product.remainingStock} left!</span>
				</c:if>
			</p>
			<p class="description">
				${product.description}
			</p>

			<p class="price">
				<fmt:formatNumber value="${product.price}" type="CURRENCY"/>
			</p>

			<c:choose>
				<c:when test="${product.remainingStock == 0}">
					<button disabled>Sold Out</button>
				</c:when>
				<c:otherwise>
					<button class="action">Add to Cart</button>
				</c:otherwise>

			</c:choose>

		</div>

	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />