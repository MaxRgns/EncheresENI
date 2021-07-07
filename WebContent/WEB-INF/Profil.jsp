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
<h3>Profil de ${profil.utilisateur.pseudo}</h3> 
<label>Nom : </label> ${profil.utilisateur.nom}<br>
<label>Prénom : </label> ${profil.utilisateur.prenom}<br>
<label>E-mail : </label> ${profil.utilisateur.email}<br>
<label>Téléphone : </label> ${profil.utilisateur.telephone}<br>
<label>Adresse : </label><br> ${profil.utilisateur.rue}<br>
${profil.utilisateur.codepostal} ${profil.utilisateur.ville}<br>
</body>
</html>