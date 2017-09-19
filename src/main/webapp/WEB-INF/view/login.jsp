<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ログイン</title>
	<link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="login">

	<h1>Login</h1>


     <form:form modelAttribute = "loginForm">
    	<p>
    	  <form:input path = "loginId"  placeholder ="LoginID" />
    	  <form:errors path="loginId" />
    	</p>

        <p>
          <form:input path= "password" placeholder= "Password"  />
		  <form:errors path ="password"  type = "password"/>
        </p>

        <input type="submit" value = "Login">
    </form:form>
</div>
</body>
</html>