package fr.eni.EncheresENI.ihm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.EncheresENI.bll.BLLException;
import fr.eni.EncheresENI.bll.Article.ArticleManager;
import fr.eni.EncheresENI.bll.Article.ArticleManagerSingl;
import fr.eni.EncheresENI.bll.Utilisateur.UtilisateurManager;
import fr.eni.EncheresENI.bll.Utilisateur.UtilisateurManagerSingl;

/**
 * Servlet implementation class EnchereServlet
 */
@WebServlet("/Enchere")
public class EnchereServlet extends HttpServlet {
	ArticleManager manager = ArticleManagerSingl.getInstance();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnchereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("idArticle") != null) {
			
			//Si un identifiant a permis d'accéder à cette page, on l'utilise pour récupérer les informations sur l'article recherché
			EnchereModel detail = new EnchereModel();
			try {
				detail.setArt(manager.getById(Integer.valueOf(request.getParameter("idArticle"))));
				request.setAttribute("detail", detail);
			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
			
			}
		}
		if (request.getAttribute("detail") != null ) { 
			//Si l'utilisateur a trouv� un profil correspondant à l'id, le servlet charge la page Enchere
		
			request.getRequestDispatcher("WEB-INF/Enchere.jsp").forward(request, response);
		}else{
			//Si l'utilisateur n'a pas entré un identifiant valide, le servlet le renvoie à l'accueil
			request.getRequestDispatcher("Accueil").forward(request, response);//TODO Vérifier lien vers Accueil
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
