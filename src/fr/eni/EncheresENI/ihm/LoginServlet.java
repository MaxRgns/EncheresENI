package fr.eni.EncheresENI.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.EncheresENI.bll.Utilisateur.UtilisateurManager;
import fr.eni.EncheresENI.bll.Utilisateur.UtilisateurManagerSingl;
import fr.eni.EncheresENI.bo.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
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
			case "login":
				login(request, response);
				break;
			case "logout":
				logout(request, response);
				break;
			}
		} else { // S'il na pas renvoyé de formulaire
				request.getRequestDispatcher("Accueil").forward(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) { // Si le visiteur n'est pas connecté à un compte
			// Vérification login
			Utilisateur user = manager.getConnection(request.getParameter("identifiant"), request.getParameter("pass"));
			if (user == null) {
				request.getRequestDispatcher("WEB-INF/Accueil.jsp").forward(request, response);
				//TODO ajouter l'erreur dans la page
			}else {
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("Accueil").forward(request, response);
			}
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) { // Si le visiteur est connecté à un compte
			request.getSession().setAttribute("user", null);
		}
		request.getRequestDispatcher("Accueil").forward(request, response);
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
