<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI-Ench�res</title>
</head>
<body>
	<c:set var = "now" value = "<%= new java.util.Date()%>" />
	<form action="Vendre" method="post">
	<label>Article :</label><input type="text" name = "nom" required><br>
	<label>Description :</label><textarea rows="" cols="" name = "description"></textarea><br>
	<label>Cat�gorie :</label>
	<select name="categorie">
	<option>----</option>
	<c:forEach items="${categories}" var="categorie">
		<option value = "${categorie.noCategorie}">${categorie.libelle}</option>
	</c:forEach>
	</select><br>
	<label>Photo de l'article :</label><input type="file" name="img"><br>
	<label>Mise � prix :</label><input type="number" name = "prix" required><br>
	<label>D�but de l'ench�re :</label><input type="date" name = "dateD" value="${now}"><input type="time" name = "timeD" value="${now}"><br>
	<label>Fin de l'ench�re :</label><input type="date" name = "dateF" required><input type="time" name = "timeF" required><br>
	<fieldset>
		<legend>Retrait</legend>
		<label>Rue :</label><input type = "text" name="rue" value="${user.rue}" required><br>
		<label>Code postal :</label><input type = "text" name="cp" value="${user.codepostal}" required><br>
		<label>Ville :</label><input type = "text" name="ville" value="${user.ville}" required><br>
	</fieldset>
	<input type="submit" name="action" value="Enregistrer">	
	</form>
	<button><a href="Accueil">Annuler</a></button>
</body>
</html>