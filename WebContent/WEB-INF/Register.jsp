<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

<head>
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
		<div class="row d-flex justify-content-center ">
			<a href="Accueil"><h1>ENI-Enchères</h1></a>
			<div class="col-5">
				<h2>Créer un compte</h2>
				<form class="form-group" action="Register" method="post">

					<div class="row g-12">
						<div class="col-sm">
							<input type="text" name="pseudo" class="form-control"
								placeholder="Pseudo" aria-label="Pseudo" required>
						</div>
						<div class="col-sm">
							<input type="text" name="nom" class="form-control"
								placeholder="Nom" aria-label="Nom" required>
						</div>
					</div>
					<div class="row g-12">
						<div class="col-sm">
							<input type="text" name="prenom" class="form-control"
								placeholder="Prénom" aria-label="Prénom" required>
						</div>
						<div class="col-sm">
							<input type="email" name="mail" class="form-control"
								placeholder="Email" aria-label="Email" required>
						</div>
					</div>
					<div class="row g-12">
						<div class="col-sm">
							<input type="tel" name="tel" class="form-control"
								placeholder="Téléphone" aria-label="Téléphone" required>
						</div>
						<div class="col-sm">
							<input type="text" name="rue" class="form-control"
								placeholder="Rue" aria-label="Rue" required>
						</div>
					</div>
					<div class="row g-12">
						<div class="col-sm">
							<input type="text" name="cp" class="form-control"
								placeholder="Code postal" aria-label="Code postal" required>
						</div>
						<div class="col-sm">
							<input type="text" name="ville" class="form-control"
								placeholder="Ville" aria-label="Ville" required>
						</div>
					</div>
					<div class="row g-12">
						<div class="col-sm">
							<input type="password" name="mdp" class="form-control"
								placeholder="Mot de passe" aria-label="Mot de passe" required>
						</div>
						<div class="col-sm">
							<input type="password" name="conf" class="form-control"
								placeholder="Confirmation" aria-label="Confirmation" required>
						</div>
					</div>
					<br>
					<div class="row g-12">
						<div class="col-sm d-flex justify-content-around">
							<input name="register" class="btn btn-primary" type="submit"
								value="Créer">
								<a href="Accueil"><button class="btn btn-primary"
									type="button">Annuler</button></a>
						</div>
					</div>

				</form>
			</div>
		</div>

	</div>

</body>

</html>