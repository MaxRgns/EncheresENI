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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			if (request.getParameter("action") != null) {
				//Vérification login
				Utilisateur user = manager.getConnection(request.getParameter("identifiant"),request.getParameter("pass"));
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("AccueilServlet").forward(request, response);
				}
			//Si le visiteur n'est pas connecté à un compte utilisateur, il est renvoyé à la servlet login
			request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
		} else {
			//Sinon, il repart à l'accueil
			request.getRequestDispatcher("AccueilServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
