<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
    <c:param name="pageTitle" value="Product List View"/>
</c:import>

<div id="card-page">
    <c:import url="/WEB-INF/jsp/common/filters.jsp">
        <%-- Modify the baseRoute to apply filters to the current route. --%>
        <c:param name="baseRoute" value="/products"/>
    </c:import>

    <div class="main-content">

        <!-- Container for Sorting Choices

         Each link should take the user to this current page and use any combination of the following
         querystring parameters to sort the page:
            - sortOrder (string) - PriceLowToHigh,PriceHighToLow,RatingHighToLow
        -->
        <div id="sorting-options">
            <h3>Sort By</h3>
            <ul>
                <li><a href="/products?sortOrder=PriceLowToHigh">Price - Low to High</a></li>
                <li><a href="/products?sortOrder=PriceHighToLow">Price - High to Low</a></li>
                <li><a href="/products?sortOrder=RatingHighToLow">Rating - High to Low</a></li>
            </ul>
        </div>

        <!-- Container for all of the Products -->
        <!-- The list of products is available using the `products` variable -->
        <div id="grid">
            <c:forEach var="product" items="${products}">
                <c:set var="tileClass" value=""/>
                <c:set var="isTopSeller" value="false"/>
                <c:set var="isSoldOut" value="false"/>
                <c:choose>
                    <c:when test="${product.topSeller}">
                        <c:set var="tileClass" value="top-seller"/>
                        <c:set var="isTopSeller" value="true"/>
                    </c:when>
                    <c:when test="${product.remainingStock == 0}">
                        <c:set var="tileClass" value="sold-out"/>
                        <c:set var="isSoldOut" value="true"/>
                    </c:when>
                </c:choose>

                <!--
                The following HTML shows different examples of what HTML could be rendered based on different rules.
                For purposes of demonstration we've written it out so you can see it when you load the page up.
                -->

                <!-- Standard Product -->
                <div class="tile ${tileClass}">
                    <!-- Link to the Detail page using the product id (e.g. products/detail?id=1) -->

                    <c:url var="productImageUrl" value="/images/product-images/${product.imageName}"/>
                    <c:url var="productDetailUrl" value="/products/detail">
                        <c:param name="id" value="${product.id}"/>
                    </c:url>
                    <a class="product-image" href="${productDetailUrl}">
                        <img src="${productImageUrl}"/>
                    </a>

                    <c:if test="${isSoldOut}">
                        <span class="banner">Sold Out</span>
                    </c:if>

                    <div class="details">
                        <p class="name">
                            <a href="#">${product.name}</a>
                        </p>

                        <!-- .filled will make the star solid -->
                        <div class="rating">
                            <c:forEach begin="1" end="5" var="starCount">
                                <span class="${starCount <= product.averageRating ? 'filled' : ''}">&#9734;</span>
                            </c:forEach>

                            <c:if test="${isTopSeller}">
                                <br/>
                                <p class="product-alert">Top Seller</p>
                            </c:if>

                            <c:if test="${product.remainingStock > 0 && product.remainingStock <= 5}">
                                <span class="product-alert">Only ${product.remainingStock} left!</span>
                            </c:if>

                        </div>

                        <p class="price">
                            <fmt:formatNumber value="${product.price}" type="CURRENCY"/>
                        </p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>