<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<tr><th>Nom</th><th>Prénom</th><th>age</th></tr>
	<c:forEach var="utilisateur" items="${utilisateur}">
		<tr><td><c:out value="${utilisateur.prenom}"/></td>
		<td><c:out value="${utilisateur.nom}"/></td>
		<td><c:out value="${utilisateur.age}"/></td></tr>
		<br />
	</c:forEach>
</table>

<c:out value="${idc}"></c:out>
</body>
</html>