<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Setting</title>
	<link href="<c:url value="/resources/css/test.css" />" rel="stylesheet">
</head>
<body>


<div class="form-style-8">
<h1>MANAGEMENT</h1>

	<a	href="${pageContext.request.contextPath}">HOME</a>
	<a	href="${pageContext.request.contextPath}/signup/">SIGN UP</a>



   <br>

    <table class="type10">
    		<thead>
			<tr>
				<th>LOGIN ID</th>
				<th>NAME</th>
				<th>PASSWORD</th>
				<th>BRANCH</th>
				<th>POSITION</th>
				<th>EDIT</th>
				<th>DELETE</th>
			</tr>

			<c:forEach items="${users}" var="user">

				<tr>
					<td><c:out value="${user.loginId}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.password}" /></td>
					<td><c:out value="${user.branch}" /></td>
					<td><c:out value="${user.position}" /></td>
					<td><a
						href="${pageContext.request.contextPath}/management/edit/${user.id}/">編集</a></td>
					<td><a
						href="${pageContext.request.contextPath}/management/delete/${user.id}/">削除</a></td>
				</tr>
			</c:forEach>
			</thead>
	</table>
</div>
</body>
</html>
