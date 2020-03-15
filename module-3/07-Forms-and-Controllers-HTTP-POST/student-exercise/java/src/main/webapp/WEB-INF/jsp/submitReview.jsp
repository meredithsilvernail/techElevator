<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Submit a Review</title>
</head>
<body>
<h2>Submit a Review</h2>

<section id="reviewInput">
    <c:url value="/submitReview" var="submitReviewURL"/>
    <form method="POST" action="${submitReviewURL}" modelAttribute="review">
        <p>
            <label for="username">Username</label>
            <input type="text" name="username" id="username" required/>
        </p>
        <p>
            <label for="rating">Rating</label>
            <input type="text" name="rating" id="rating" required/>
        </p>
        <p>
            <label for="title">Title</label>
            <input type="text" name="title" id="title" required/>
        </p>
        <p>
            <label for="text">Message</label>
            <textarea id="text" name="text"
                      rows="5" cols="33" required>
            </textarea>
        </p>
        <input type="submit" value="Submit"/>
    </form>
</section>


</body>
</html>
