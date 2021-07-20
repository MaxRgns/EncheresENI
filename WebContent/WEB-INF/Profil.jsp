<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.EncheresENI.bo.Utilisateur"%>
<%@ page import="fr.eni.EncheresENI.ihm.ProfilModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
<title>ENI-EnchÃ¨res</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="d-flex bd-highlight mb-3">
				<div class="me-auto p-2 bd-highlight">
					<a href="Accueil"><h1>ENI-Enchères</h1></a>
				</div>
				
				<div class="p-2 bd-highlight">
					<a href="">Vendre un article</a>
				</div>
				<div class="p-2 bd-highlight">
					<a href="Profil?idProfil=${user.noUtilisateur}" id="profil">Mon
						profil</a>
				</div>
				<div class="p-2 bd-highlight">
					<a href="Login" id="action">Déconnexion</a>
				</div>

			</div>
		
			<div class="row d-flex justify-content-center">
				
				<div class="col-12 col-sm-6">
				<h3>Profil de ${profil.utilisateur.pseudo}</h3><br>
					<label>Nom : ${profil.utilisateur.nom}</label> <br><br>
					<label>Prénom : ${profil.utilisateur.prenom}</label> <br>
					<br> <label>E-mail : ${profil.utilisateur.email}</label> <br>
					<br> <label>Téléphone : ${profil.utilisateur.telephone}</label> <br>
					<br> <label>Adresse : ${profil.utilisateur.rue}, 
						${profil.utilisateur.codepostal} à
						${profil.utilisateur.ville}</label> <br><br>
						<c:if
						test="${profil.utilisateur.noUtilisateur == user.noUtilisateur}">
						<label>Crédit : ${user.credit}</label><br><br><br>
						<div class="d-flex justify-content-between">
							<form action="Edit">
								<input class="btn btn-primary" type="submit" value="Modifier">
							</form>
						</div>
						
					</c:if>
				</div>	
			</div>
			
		</div>
	</div>

</body>
</html>