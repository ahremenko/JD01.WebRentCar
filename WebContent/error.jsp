<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1" import="by.htp.ahremenko.bean.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>RentCarApp Error</title>
</head>
<body>
<div class="errorMessage">
	<c:if test = "${not empty requestScope.errorMessage}">
		<c:out value="${requestScope.errorMessage}"/>
	</c:if>
</div>	
	<A HREF="index.jsp">Login</A>
</body>
</html>