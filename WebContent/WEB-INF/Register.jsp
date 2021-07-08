<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
    <title>ENI-Enchères</title>
</head>

<body>
    <div class="container-fluid">
        <div class="row d-flex justify-content-center ">
            <h1>ENI-Enchères</h1>
            <div class="col-6">
                <h2>Mon compte</h2>
                <form class="form-group" action="" method="post">

                    <div class="row g-12">
                        <div class="col-sm">
                            <input type="text" class="form-control" placeholder="Pseudo" aria-label="Pseudo">
                        </div>
                        <div class="col-sm">
                            <input type="text" class="form-control" placeholder="Nom" aria-label="Nom">
                        </div>
                    </div>
                    <div class="row g-12">
                        <div class="col-sm">
                            <input type="text" class="form-control" placeholder="Prénom" aria-label="Prénom">
                        </div>
                        <div class="col-sm">
                            <input type="email" class="form-control" placeholder="Email" aria-label="Email">
                        </div>
                    </div>
                    <div class="row g-12">
                        <div class="col-sm">
                            <input type="tel" class="form-control" placeholder="Téléphone" aria-label="Téléphone">
                        </div>
                        <div class="col-sm">
                            <input type="text" class="form-control" placeholder="Rue" aria-label="Rue">
                        </div>
                    </div>
                    <div class="row g-12">
                        <div class="col-sm">
                            <input type="text" class="form-control" placeholder="Code postal" aria-label="Code postal">
                        </div>
                        <div class="col-sm">
                            <input type="text" class="form-control" placeholder="Ville" aria-label="Ville">
                        </div>
                    </div>
                    <div class="row g-12">
                        <div class="col-sm">
                            <input type="password" class="form-control" placeholder="Mot de passe"
                                aria-label="Mot de passe">
                        </div>
                        <div class="col-sm">
                            <input type="password" class="form-control" placeholder="Confirmation"
                                aria-label="Confirmation">
                        </div>
                    </div>
                    <br>
                    <div class="row g-12">
                        <div class="col-sm d-flex justify-content-end">
                            <input class="btn btn-primary" type="submit" value="Créer">
                        </div>
                        <div class="col-sm">
                            <a href="Accueil"><button class="btn btn-primary" type="button">Annuler</button></a>
                        </div>
                    </div>
                   
                </form>
            </div>
        </div>
   
    </div>

</body>

</html>