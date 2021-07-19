package fr.eni.EncheresENI.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.EncheresENI.bll.BLLException;
import fr.eni.EncheresENI.bll.UtilisateurManager;
import fr.eni.EncheresENI.bll.UtilisateurManagerSingl;
import fr.eni.EncheresENI.bo.Utilisateur;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet(name = "Edit", urlPatterns = { "/Edit" })
public class EditServlet extends HttpServlet {
	UtilisateurManager manager = UtilisateurManagerSingl.getInstance();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("action") != null) {
			switch (request.getParameter("action")) {
			case "update":
				update(request, response);
				request.getRequestDispatcher("WEB-INF/Edit.jsp").forward(request, response);
				break;
			case "delete":
				delete(request, response);
				request.getRequestDispatcher("Accueil").forward(request, response);
				break;
			case "cancel":
				request.getRequestDispatcher("Accueil").forward(request, response);
				break;

			}
		}else {
			request.getRequestDispatcher("WEB-INF/Edit.jsp").forward(request, response);
		}
		

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		Utilisateur delete = (Utilisateur) request.getSession().getAttribute("user");
		try {
			manager.suppr(delete);
			request.getSession().setAttribute("user", null);
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		Utilisateur update = (Utilisateur) request.getSession().getAttribute("user");
		if ((request.getParameter("mdp").equals(request.getParameter("conf")))
				&& (request.getParameter("omdp").equals(update.getMotDePasse()))) {
			update.setPseudo(request.getParameter("pseudo"));
			update.setNom(request.getParameter("nom"));
			update.setPrenom(request.getParameter("prenom"));
			update.setEmail(request.getParameter("mail"));
			update.setTelephone(request.getParameter("tel"));
			update.setRue(request.getParameter("rue"));
			update.setCodepostal(request.getParameter("cp"));
			update.setVille(request.getParameter("ville"));
			update.setMotDePasse(request.getParameter("mdp"));
			try {
				manager.updateUser(update);
				request.getSession().setAttribute("user", update);
			} catch (BLLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Erreur mot de passe"); // TODO Faire deux messages d'erreurs (pas le bon ancien mot de passe && pas le bon en vérif)
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
