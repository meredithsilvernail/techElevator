<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title" value="Summary" />
</c:import>

<div><strong>Favorite Color:</strong> <c:out value="${ favoriteThings.favoriteColor }" /></div>
<div><strong>Favorite Food:</strong> <c:out value="${ favoriteThings.favoriteFood }" /></div>
<div><strong>Favorite Season:</strong> <c:out value="${ favoriteThings.favoriteSeason }" /></div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />