<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Squirrel Parties For Dummies</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="heading"></div>
<h1>Squirrel Parties For Dummies!</h1>
<c:url var="bookCover" value="/img/forDummies.png"/>
<c:url var="star" value="/img/star.png"/>
<img src="${bookCover}" alt="Squirrel parties for dummies book cover"/>
</div>
<div id="copy">
    <h3>Get yours today!</h3>
    <p>Never again fail to have a perfect Squirrel Cigar Party with this incredible new book by Craig Castelaz. You will
        be a Squirrel Cigar Party expert in no time!</p>
</div>
<div id="newReviewLink">
    <c:url var="newReview" value="/submitReview"/>
    <button type="submit" id="submitReview" name="submitReview"><a href="${newReview}">Submit a Review</a></button>
</div>

<section id="allReviews">

    <table>
        <c:forEach var="review" items="${reviews}">
            <tr>
                <td>
                    <div id="reviewItem">
                        <p><strong>${review.title}</strong> by ${review.username}</p>
                        <p>${review.dateSubmitted}</p>
                        <p>
                            <c:choose>
                            <c:when test="${review.rating < 2}">
                            <img src="${star}" alt="star">
                            </c:when>
                            <c:when test="${review.rating < 3}">
                        <div class="ratingStars">
                            <img src="${star}" alt="star">
                            <img src="${star}" alt="star">
                        </div>
                        </c:when>
                        <c:when test="${review.rating < 4}">
                            <div class="ratingStars">
                                <img src="${star}" alt="star">
                                <img src="${star}" alt="star">
                                <img src="${star}" alt="star">
                            </div>
                        </c:when>
                        <c:when test="${review.rating < 5}">
                            <div class="ratingStars">
                                <img src="${star}" alt="star">
                                <img src="${star}" alt="star">
                                <img src="${star}" alt="star">
                                <img src="${star}" alt="star">
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="ratingStars">
                                <img src="${star}" alt="star">
                                <img src="${star}" alt="star">
                                <img src="${star}" alt="star">
                                <img src="${star}" alt="star">
                                <img src="${star}" alt="star">
                            </div>
                        </c:otherwise>
                        </c:choose>
                        </p>
                        <p>${review.text}</p>
                    </div>
                </td>
            </tr>
        </c:forEach>

    </table>
</section>

</body>
</html>
