<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ENI-Enchères</title>
</head>
<body>
	<form action="Vendre" method="post">
	<label>Article :</label><input type="text" name = "nom" required><br>
	<label>Description :</label><textarea rows="" cols="" name = "description"></textarea><br>
	<label>Catégorie :</label>
	<select name="categorie">
	<option>----</option>
	<c:forEach items="${categories}" var="categorie">
		<option value = "${categorie.noCategorie}">${categorie.libelle}</option>
	</c:forEach>
	</select><br>
	<label>Photo de l'article :</label><input type="file" name="img"><br>
	<label>Mise à prix :</label><input type="number" name = "prix" required><br>
	<label>Début de l'enchère :</label><input type="date" name = "dateD" required><br>
	<label>Fin de l'enchère :</label><input type="date" name = "dateF" required><br>
	<fieldset>
		<legend>Retrait</legend>
		<label>Rue :</label><input type = "text" name="rue" required><br>
		<label>Code postal :</label><input type = "text" name="cp" required><br>
		<label>Ville :</label><input type = "text" name="ville" required><br>
	</fieldset>
	<input type="submit" name="action" value="Enregistrer">
	<input type="submit" name="action" value="Annuler">
	
	</form>
</body>
</html>