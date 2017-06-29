<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1" import="by.htp.ahremenko.bean.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>main.jsp</title>
</head>
<body>
<form action="<c:url value="/main"/>" method="POST">
<div class="page">
	<div class="userinfo">
		Hi, <c:out value="${requestScope.user.name}"/>.
		<% User user = (User)request.getAttribute("user");
   			if (user.getIsAdmin() == 1) {
	   			out.println("ADM.");
   			}
   			out.println("ID: " + user.getId());
		%>
	</div>
	<div class="menu">
		<a class="onemenu" onclick="showAllUsers()">List of users</a> |
		<a class="onemenu" onclick="showAllCars()">List of cars</a>
		<a class="onemenu" onclick="logout()">Logout</a>
	</div>
	<div class="tablemenu">
		<table>
                <tr>
                    <th> </th>
                    <th>Name</th>
                    <th>Login</th>
                    <th>Admin?</th>
                </tr>
                <c:forEach var="user" items="${users}">
                <tr>
                    <td><input type="radio" name="userId" value="${user.getId()}"></td>
                    <td><c:out value="${user.getName()}"/></td>
                    <td><c:out value="${user.getLogin()}"/></td>
                    <td><c:out value="${user.getIsAdmin()}"/></td>
                </tr>
                </c:forEach>
        </table>
                
        <table>
                <tr>
                    <td><input type="submit" value="Add" name="Add"/></td>
                    <td><input type="submit" value="Edit" name="Edit"/></td>
                    <td><input type="submit" value="Delete" name="Delete"/></td>
                </tr>
        </table>
	</div>
	<div class="data">
	</div>
</div>
</form>
</body>
</html>