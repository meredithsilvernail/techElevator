<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title" value="Favorite Season" />
</c:import>

<form method="POST">
	<label>What is your favorite season?</label>
	<div>
		<input type="radio" name="favoriteSeason" value="Spring" id="favoriteSeason_Spring"><label for="favoriteSeason_Spring">Spring</label>
		<input type="radio" name="favoriteSeason" value="Summer" id="favoriteSeason_Summer"><label for="favoriteSeason_Summer">Summer</label>
		<input type="radio" name="favoriteSeason" value="Fall" id="favoriteSeason_Fall"><label for="favoriteSeason_Fall">Fall</label>
		<input type="radio" name="favoriteSeason" value="Winter" id="favoriteSeason_Winter"><label for="favoriteSeason_Winter">Winter</label>
	</div>
	<button type="submit">Next >>></button>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />