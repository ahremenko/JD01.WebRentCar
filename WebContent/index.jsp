<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1" import="by.htp.ahremenko.bean.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>RentCarApp</title>
</head>
<body>
	<form action ="RentCarApp" method="post">
		<input type="hidden" name="command" value="authorization"/>
		Login:<br/>
		<input type="text" name="userLogin" value=""/><br/>
		Password:<br/>
		<input type="password" name="userPassword" value=""/><br/>
		<input type="submit" value="Login"/>
	</form>
	
	<c:if test = "${not empty requestScope.errorMessage}">
		<c:out value="${requestScope.errorMessage}"/>
	</c:if>
	
</body>
</html>