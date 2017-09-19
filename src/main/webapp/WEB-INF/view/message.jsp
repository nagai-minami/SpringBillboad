<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MESSAGE</title>
	<link href="<c:url value="/resources/css/test.css" />" rel="stylesheet">
</head>
<body>


<div class="form-style-8">
<h2>MESSAGE</h2>

    <form:form modelAttribute = "messageForm">
    	<p>
    	  <form:input path = "subject"  placeholder =""subject />
    	  <form:errors path="subject" />
    	</p>
        <p>
          <form:input path ="text"  placeholder="text" />
          <form:errors path="text" />
        </p>

    </form:form>
</div>

   <br>

</body>
</html>
