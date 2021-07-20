package fr.eni.EncheresENI.ihm;

import java.io.IOException;

import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.EncheresENI.bll.BLLException;
import fr.eni.EncheresENI.bll.Utilisateur.UtilisateurManager;
import fr.eni.EncheresENI.bll.Utilisateur.UtilisateurManagerSingl;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/Profil")
public class ProfilServlet extends HttpServlet {

	UtilisateurManager manager = UtilisateurManagerSingl.getInstance();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Note : ce servlet est supposé être appelé avec un idProfil correspondant à celui du profil que l'utilisateur veut consulter.
		// S'il n'y a pas d'identifiant de renseigné, l'utilisateur sera renvoyé en page d'accueil
		
		//TODO Vérifier la session avant de permettre l'accès aux infos
		//TODO tout passer en POST (supprimer le doGet et transférer le contenu dans la méthode doPost)
		if (request.getParameter("idProfil") != null) {
			
			//Si un identifiant a permis d'accéder à cette page, on l'utilise pour récupérer les informations sur le profil recherché
			ProfilModel profil = new ProfilModel();
			try {
				profil.setUtilisateur(manager.getProfil(Integer.valueOf(request.getParameter("idProfil"))));
				request.setAttribute("profil", profil);
			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
			} catch (BLLException e) {
				System.err.println(e.getMessage());
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		if (request.getAttribute("profil") != null ) { 
			//Si l'utilisateur a trouv� un profil correspondant à l'id, le servlet charge la page Profil
			System.out.println("ae "+request.getParameter("idProfil"));
			request.getRequestDispatcher("WEB-INF/Profil.jsp").forward(request, response);
		}else{
			//Si l'utilisateur n'a pas entré un identifiant valide, le servlet le renvoie à l'accueil
			request.getRequestDispatcher("WEB-INF/Accueil.jsp").forward(request, response);//TODO Vérifier lien vers Accueil
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
