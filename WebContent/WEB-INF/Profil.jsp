<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="fr.eni.EncheresENI.bo.Utilisateur" %>
    <%@ page import="fr.eni.EncheresENI.ihm.ProfilModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enchères.org - ${profil.utilisateur.pseudo}</title>
</head>
<body>
<h3>Profil</h3> 
<label>Nom : </label> ${profil.utilisateur.nom}<br>
<label>Prénom : </label> ${profil.utilisateur.prenom}<br>
<label>Mail : </label> ${profil.utilisateur.email}<br>
</body>
</html>