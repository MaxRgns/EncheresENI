<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="fr">

<head>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
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
				<div class="me-auto p-2 bd-highlight"> <a href="Accueil">
       				 <h1>ENI-Enchères</h1></a>
       			</div>
       			<div class="p-2 bd-highlight">
					<button type="button" class="btn btn-primary" data-bs-toggle="modal"
						data-bs-target="#exampleModal">S'inscrire - Se connecter</button>
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Authentification</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
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
            				 <a href="Accueil"><h1>ENI-Enchères</h1></a></div>
            				 <p>${profil.utilisateur.noUtilisateur}</p>
						            <div class="p-2 bd-highlight"> <a href="">Vendre un article</a></div>
						            <div class="p-2 bd-highlight"> <a href="Profil?idProfil=${user.noUtilisateur}" id="profil">Mon profil</a></div>
						            <div class="p-2 bd-highlight"> <a href="Login" id="logout">Déconnexion</a></div>
        					</div>
					</c:if>
			</div>

		
		<div class="row offset-1">

            <p>Filtres :</p>

            <form class="d-flex">

                <div class="col-6">

                    <input class="form-control me-2" type="search" placeholder="Mot clé de l'article"

                        aria-label="Search">

                    <label for="">Catégorie :</label>

                    <div class="offset-3 col-8">

                        <select class="form-select" aria-label="Default select example">

                            <option selected>Toutes</option>

                            <option value="1">Informatique</option>

                            <option value="2">Ameublement</option>

                            <option value="3">Vêtement</option>

                            <option value="3">Sport&Loisirs</option>

                        </select>

                    </div>
                </div>
                <button class="btn btn-outline-success" type="submit">Search</button>

            </form>

        </div>

        <br>
		<c:if test="${sessionScope.user != null }">
        <div class="row">

            <div class="offset-1 col-3">

                <input type="radio" name="AchatVente" id="achat" value="achat" checked> Achats

                <div class="offset-1">

                    <div class="d-flex align-items-start flex-column bd-highlight mb-5" style="height: 100px;">

                        <div class="p-2 bd-highlight"> <input type="checkbox" name="typeAchat">

                            Enchères ouvertes</div>

                        <div class="p-2 bd-highlight"> <input type="checkbox" name="typeAchat">

                            Mes ouvertes</div>

                        <div class="p-2 bd-highlight"> <input type="checkbox" name="typeAchat">

                            Enchères remportées</div>

                    </div>

                </div>

            </div>

            <div class="col-3">

                <input type="radio" name="AchatVente" id="vente" value="vente"> Ventes

                <div class="offset-1">

                    <div class="d-flex align-items-start flex-column bd-highlight mb-5" style="height: 100px;">

                        <div class="p-2 bd-highlight"> <input type="checkbox" name="typeVente">

                            En cours</div>

                        <div class="p-2 bd-highlight"> <input type="checkbox" name="typeVente">

                            Non débutées</div>

                        <div class="p-2 bd-highlight"> <input type="checkbox" name="typeVente">

                            Terminées</div>

                    </div>

                </div>
<script> 
$("input[name='typeVente']").prop('disabled', true);
$("input[name='typeAchat']").prop('disabled', false);

$("input[value='achat']").change(function() {
	  $("input[name='typeVente']").prop('disabled', true);
	});

$("input[value='vente']").change(function() {
	  $("input[name='typeAchat']").prop('disabled', true);
	});

	// Enable checkbox
	$("input[value='vente']").change(function() {
	  $("input[name='typeVente']").prop('disabled', false);
	});
	$("input[value='achat']").change(function() {
		  $("input[name='typeAchat']").prop('disabled', false);
		});

</script>
            </div>
	
        </div>
		</c:if>
 

        <div class="row d-flex justify-content-around">

            <div class="card mb-3" style="max-width: 500px;">

                <div class="row g-0">

                    <div class="col-md-4">

                        <img src="https://via.placeholder.com/250" class="img-fluid rounded-start" alt="...">

                    </div>

                    <div class="col-md-8">

                        <div class="card-body">

                            <h5 class="card-title">Article 1</h5>

                            <p class="card-text">Prix</p>

                            <p class="card-text">Fin de l'enchère</p>

                            <p class="card-text"><small class="text-muted">Vendeur : <a href="">Vendeur X</a></small></p>

                        </div>

                    </div>

                </div>

            </div>

            <div class="card mb-3" style="max-width: 500px;">

                <div class="row g-0">

                    <div class="col-md-4">

                        <img src="https://via.placeholder.com/250" class="img-fluid rounded-start" alt="...">

                    </div>

                    <div class="col-md-8">

                        <div class="card-body">

                            <h5 class="card-title">Article 2</h5>

                            <p class="card-text">Prix</p>

                            <p class="card-text">Fin de l'enchère</p>

                            <p class="card-text"><small class="text-muted">Vendeur : <a href="">Vendeur Y</a></small></p>

                        </div>

                    </div>

                </div>

            </div>
        </div>
    </div>
</body>


</html>