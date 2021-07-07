package fr.eni.EncheresENI.ihm;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.EncheresENI.bll.UtilisateurManager;
import fr.eni.EncheresENI.bll.UtilisateurManagerSingl;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/ProfilServlet")
public class ProfilServlet extends HttpServlet {
	UtilisateurManager manager = UtilisateurManagerSingl.getInstance();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("idProfil") != null) {
			//Si un identifiant a permis d'accéder à cette page, on l'utilise pour accéder à des informations sur le profil recherché
			ProfilModel profil = new ProfilModel();
			profil.setUtilisateur(manager.getProfil(Integer.valueOf(request.getParameter("idProfil"))));
			request.setAttribute("profil", profil);
			request.setAttribute("locale", Locale.FRENCH);
			request.getRequestDispatcher("WEB-INF/Profil.jsp").forward(request, response);
		}else {
			//TODO Si un utilisateur tente d'accéder à cette page sans avoir suivi un formulaire, on le renvoie à l'accueil
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
