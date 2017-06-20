<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1" import="by.htp.ahremenko.domain.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>main.jsp</title>
</head>
<body>
Hi, user: 
<%
/*
 User user = (User)request.getAttribute("user");
 out.println(user.getName());
everything ok.*/
%>
<h1>
 <c:out value="${requestScope.user.name}"/>
</h1>

</body>
</html>