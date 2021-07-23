<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="fr.eni.EncheresENI.bo.ArticleVendu"%>
<%@ page import="fr.eni.EncheresENI.ihm.EnchereModel"%>
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
			<c:if test="${sessionScope.user == null }">
				<div class="d-flex bd-highlight">
					<div class="me-auto p-2 bd-highlight">
						<h1>
							<a href="Accueil">ENI-Enchères</a>
						</h1>
					</div>
					<div class="p-2 bd-highlight">
						<button type="button" class="btn btn-primary"
							data-bs-toggle="modal" data-bs-target="#exampleModal">S'inscrire
							- Se connecter</button>
						<div class="modal fade" id="exampleModal" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Authentification</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<form action="Login">
											<div class="mb-3">
												<label for="exampleInputEmail1" class="form-label">Identifiant</label>
												<input type="text" class="form-control" name="identifiant"
													id="exampleInput">
											</div>
											<div class="mb-3">
												<label for="exampleInputPassword1" class="form-label">Mot
													de passe</label> <input type="password" class="form-control"
													name="pass" id="exampleInputPassword1">
											</div>
											<div class="mb-3 form-check">
												<input type="checkbox" class="form-check-input"
													id="exampleCheck1"> <label class="form-check-label"
													for="exampleCheck1">Se souvenir de moi</label> <br> <label
													for="exampleText" class="form-label"><a href="">Mot
														de passe oublié ?</a></label>
											</div>
											<div class="modal-footer">
												<a href="Register"><button type="button"
														class="btn btn-secondary" data-bs-dismiss="modal">S'inscrire</button></a>
												<button class="btn btn-primary" type="submit" name="action"
													value="login">Se connecter</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${sessionScope.user != null }">
				<div class="d-flex bd-highlight mb-3">
					<div class="me-auto p-2 bd-highlight">
						<a href="Accueil"><h1>ENI-Enchères</h1></a>
					</div>


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
		</div>
		<c:set var="now" value="<%=new java.util.Date()%>" />
		<div class="row offset-3 col-5 d-flex justify-content-center">
			<h3>Détails de l'article</h3>
			<input class="form-control" type="text" placeholder="${detail.art.nomArticle}" readonly>
			<textarea class="form-control" placeholder="${detail.art.description}" readonly></textarea>
			<input class="form-control" type="text" placeholder="${detail.art.categorie}" readonly> 
			<input class="form-control" type="number" placeholder="Meilleure offre : ${detail.art.miseAPrix} crédits" readonly>
			<input class="form-control" type="number" placeholder="Mise à prix : ${detail.art.miseAPrix} crédits" readonly> 
			<input class="form-control" type="text" placeholder="${detail.art.dateFinEncheres}" readonly>
			
			<fieldset>
				<legend>Retrait</legend>
					<input class="form-control" id="exampleFormControlInput1"
						type="text" name="rue" value="${detail.art.vendeur.rue}" readonly>
					<input class="form-control" id="exampleFormControlInput1"
						type="text" name="cp" value="${detail.art.vendeur.codepostal}" readonly>
					<input class="form-control" id="exampleFormControlInput1"
						type="text" name="ville" value="${detail.art.vendeur.ville}" readonly>
			</fieldset>
			
			<label class="form-label">Vendeur : <a href="Profil?idProfil=${detail.art.vendeur.noUtilisateur}">${detail.art.vendeur.pseudo}</a></label>
			<c:if test="${sessionScope.user != null }">
			<form action="" >
				<input class="form-control" type="number" placeholder="Votre offre">
				<input type="submit" value="Enchérir">
			</form>
			</c:if>
			
			
		</div>
		


	</div>

</body>
</html>