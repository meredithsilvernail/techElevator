<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
    <c:param name="title" value="Favorite Color" />
</c:import>

<form method="POST" method="/page3">
    <label>What is your favorite season?</label>
    <div>
        <input type="radio" id="spring" name="season" value="spring">
        <label for="spring">Spring</label>
    </div>
    <div>
        <input type="radio" id="summer" name="season" value="summer">
        <label for="summer">Summer</label>
    </div>
    <div>
        <input type="radio" id="fall" name="season" value="fall">
        <label for="fall">Fall</label>
    </div>
    <div>
        <input type="radio" id="winter" name="season" value="winter">
        <label for="winter">Spring</label>
    </div>
    <button type="submit">Next >>></button>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
