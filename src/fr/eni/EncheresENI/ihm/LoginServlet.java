package fr.eni.EncheresENI.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.EncheresENI.bll.UtilisateurManager;
import fr.eni.EncheresENI.bll.UtilisateurManagerSingl;
import fr.eni.EncheresENI.bo.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	UtilisateurManager manager = UtilisateurManagerSingl.getInstance();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("action") != null) { // Si une action a envoyé sur cette page
			switch (request.getParameter("action")) {
			case "Connexion":
				login(request, response);
				break;
			case "Se déconnecter":
				logout(request, response);
				break;
			case "Supprimer mon compte":
				delete(request, response);
				break;
			}
			// Dans tout les cas, il repart à l'accueil
			request.getRequestDispatcher("AccueilServlet").forward(request, response);
			
		} else { // S'il na pas renvoyé de formulaire, il va repartir à la page login
			request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) { // Si le visiteur n'est pas connecté à un compte
			// Vérification login
			Utilisateur user = manager.getConnection(request.getParameter("identifiant"), request.getParameter("pass"));
			request.getSession().setAttribute("user", user);
		}

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) { // Si le visiteur est connecté à un compte
			request.getSession().setAttribute("user", null);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession().getAttribute("user") != null) { // Si le visiteur est connecté à un compte
			manager.suppr((Utilisateur) request.getSession().getAttribute("user"));
			request.getSession().setAttribute("user", null);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
