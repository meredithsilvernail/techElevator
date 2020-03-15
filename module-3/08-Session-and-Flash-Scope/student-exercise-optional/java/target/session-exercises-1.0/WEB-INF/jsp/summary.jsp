<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
    <c:param name="title" value="Favorite Color" />
</c:import>

<div id="selections">
    <h2>Favorite Color: ${favorites.favoriteColor}</h2>
    <h2>Favorite Food: ${favorites.favoriteFood}</h2>
    <h2>Favorite Season: ${favorites.favoriteSeason}</h2>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
