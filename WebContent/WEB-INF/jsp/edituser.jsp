<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1" import="by.htp.ahremenko.bean.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add or edit user</title>
</head>
<body>
        <form action ="RentCarApp" method="POST">
        	<input type="hidden" name="command" value="editUser"/>
            <input type="hidden" name="userId" value="${user4Edit.getId()}"/>
            <table>
                <tr>
                    <td>Name:</td><td><input type="text" name="userName" value="${user4Edit.getName()}"/></td>
                </tr>
                <tr>
                    <td>Login:</td><td><input type="text" name="userLogin" value="${user4Edit.getLogin()}"/></td>
                </tr>
                <tr>
                    <td>Password:</td><td><input type="password" name="userPassword" value="${user4Edit.getPassword()}"/></td>
                </tr>
                <tr>
                    <td>Admin?</td>
                    <td>
                    <c:choose>
                        <c:when test="${user4Edit.getIsAdmin()==1}">
                            <input type="radio" name="isAdmin" value="1" checked>admin</input>
                            <input type="radio" name="isAdmin" value="0">user</input>
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="isAdmin" value="1">admin</input>
                            <input type="radio" name="isAdmin" value="0" checked>user</input>
                        </c:otherwise>
                    </c:choose>
                    </td>
                </tr>
             </table>
             <br>
            <table>
                <tr>
                    <td><input type="submit" value="OK" name="OK"/></td>
                    <td><input type="submit" value="Cancel" name="Cancel"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>