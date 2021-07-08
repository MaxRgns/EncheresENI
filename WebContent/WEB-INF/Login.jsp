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
                <h2>Connexion</h2>
                <form class="form-group" action="" method="post">

                    <div class="row g-12">
                        <div class="col-sm">
                            <input type="text" name="identifiant" class="form-control" placeholder="Pseudo ou mail" aria-label="Pseudo" required>
                        </div>
                    </div>
                    <div class="row g-12">
                        <div class="col-sm">
                            <input type="password" name="pass" class="form-control" placeholder="Mot de passe" aria-label="Pass" required>
                        </div>
                    </div>
                    <br>
                    <div class="row g-12">
                        <div class="col-sm d-flex justify-content-end">
                            <button class="btn btn-primary" type="submit" name="action" value="login">Se connecter</button>
                        </div>
                        <div class="col-sm">
                            <a href="/EncheresENI/AccueilServlet"><button class="btn btn-primary" type="button">Retour</button></a>
                        </div>
                    </div>
                   
                </form>
            </div>
        </div>
   
    </div>

</body>

</html>