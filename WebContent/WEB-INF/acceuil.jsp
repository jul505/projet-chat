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
<form method="post" action="Forum">
	<fieldset>
		<legend>Forum</legend>
		<p></p>
		
   		<table border=1>
		<tr><th>Pseudo</th><th>Message</th></tr>
		<c:forEach var="u" items="${ mesMessages }" >
			<tr><td><c:out value="${ u.pseudo }" /></td>
			<td><c:out value="${ u.text }" /></td>
			</tr>
		</c:forEach>
		</table>
		       
        <br />
        <br />
        <input type="text" id="texte" name="texte">
   		<input type="submit" value="Envoyer" class="sansLabel" />
   		
   		
   		
                
	</fieldset>
</form>
</body>
</html>