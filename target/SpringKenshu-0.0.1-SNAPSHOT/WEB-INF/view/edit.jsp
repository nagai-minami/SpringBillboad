<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>EDIT</title>
	<link href="<c:url value="/resources/css/test.css" />" rel="stylesheet">
</head>
<body>


<div class="form-style-8">
<h2>Edit this account</h2>
	<form:form modelAttribute="settingForm">
		<p>
			LOGIN ID
			<form:input path="loginId" placeholder="LoginID" />
			<form:errors path="loginId" />
		</p>
		<p>
			NAME
			<form:input path="name" placeholder="Name" />
			<form:errors path="name" />
		</p>
		<p>
			PASSWORD
			<form:input path="password" placeholder="Password" />
			<form:errors path="password" />
		</p>
		<p>
			BRANCH
			<form:input path="branch" placeholder="Branch" />
		</p>
		<p>
			POSITION
			<form:input path="position" placeholder="Position" />
		</p>
		<input type="submit" value="submit">
	</form:form>
</div>

</body>
</html>