<%@ page language="java" contentType="text/html; charset=UTF-8"		pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="CSS/ex.css" />
</head>
<body>
<form method="post" action="Inscription">
	<fieldset>
		<legend>Connexion</legend>
		<p>Vous pouvez vous connecter via ce formulaire.</p>
		
   		<label for="login">Nom d'utilisateur</label>
        <input type="text" id="login" name="login" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['nom']}</span>
        <br />
        
        
   		<label for="mdp">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="mdp" name="mdp" value="" size="20" maxlength="20" />
        <span class="erreur">${form.erreurs['motdepasse']}</span>
        <br />
        
        
   		<input type="submit" value="Connexion" class="sansLabel" />
   		<br />
   		<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
   		
   		<%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son pseudo. --%>
                    <p class="succes">Vous êtes connecté(e) avec le pseudo : ${sessionScope.sessionUtilisateur.nom}</p>
        		</c:if>
                
	</fieldset>
</form>
<br />
<br />
<form method="post" action="bonjour">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                
                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['nom']}</span>
                <br />
                
                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['email']}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['confirmation']}</span>
                <br />

                
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
</body>
</html>