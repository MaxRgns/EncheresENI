<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date"%>
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
<title>ENI-Enchères</title>
</head>
<body>

	<div class="container-fluid">
		<div class="row">

			<c:if test="${sessionScope.user != null }">
				<div class="d-flex bd-highlight mb-3">
					<div class="me-auto p-2 bd-highlight">
						<a href="Accueil"><h1>ENI-Enchères</h1></a>
					</div>

					<p>${profil.utilisateur.noUtilisateur}</p>
					<div class="p-2 bd-highlight">
						<a href="Vendre">Vendre un article</a>
					</div>
					<div class="p-2 bd-highlight">
						<a href="Profil?idProfil=${user.noUtilisateur}" id="profil">Mon
							profil</a>
					</div>
					<div class="p-2 bd-highlight">
						<a href="Login?action=logout">Déconnexion</a>
					</div>

				</div>
			</c:if>
		</div>
		<c:set var="now" value="<%=new java.util.Date()%>" />
		<div class="row d-flex justify-content-center">
			<h3>Nouvelle vente</h3>
		</div>
		<div class="col-12 d-flex justify-content-center">	
		
			
			<form class="" action="Vendre" method="post">
				<div class="mb-3">
					<input type="text" class="form-control"
						id="exampleFormControlInput1" name="nom"
						placeholder="Nom de l'article" required>
				</div>
				<div class="mb-3">
					<textarea class="form-control" id="exampleFormControlTextarea1"
						rows="3" name="description" placeholder="Description"></textarea>
				</div>

				<select class="form-select" name="categorie">
					<option selected>-- Catégorie --</option>
					<c:forEach items="${categories}" var="categorie">
						<option value="${categorie.noCategorie}">${categorie.libelle}</option>
					</c:forEach>
				</select><br>
				<div>
					<input class="form-control form-control-lg" id="formFileLg"
						type="file"><br>
				</div>
				<div class="mb-3 col-3">
					<input type="number" class="form-control"
						id="exampleFormControlInput1" name="prix" required
						placeholder="Prix">
				</div>

				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Début
						de l'enchère :</label> <input type="date" class="form-control"
						min="${now}" id="exampleFormControlInput1" name="dateD" required>
					<label for="exampleFormControlInput1" class="form-label">Fin
						de l'enchère :</label> <input type="date" class="form-control"
						min="${now}" id="exampleFormControlInput1" name="dateF" required>
				</div>

				<fieldset>
					<legend>Retrait</legend>
					<input class="form-control" id="exampleFormControlInput1"
						type="text" name="rue" value="${user.rue}" required><br>
					<input class="form-control" id="exampleFormControlInput1"
						type="text" name="cp" value="${user.codepostal}" required><br>
					<input class="form-control" id="exampleFormControlInput1"
						type="text" name="ville" value="${user.ville}" required><br>
				</fieldset>
				<input class="btn btn-primary" type="submit" name="action"
					value="Enregistrer"> 
					<a href="Accueil"><input class="btn btn-warning" type="submit" value="Annuler" /></a>

			</form>


		</div>


	</div>
</body>
</html>