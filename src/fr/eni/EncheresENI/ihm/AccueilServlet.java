
package fr.eni.EncheresENI.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.EncheresENI.bll.Article.ArticleManager;
import fr.eni.EncheresENI.bll.Article.ArticleManagerSingl;
import fr.eni.EncheresENI.bo.ArticleVendu;
import fr.eni.EncheresENI.bo.Utilisateur;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/Accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ArticleManager artManager = ArticleManagerSingl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ArticleVendu> lstAchats = artManager.getArticles();
		List<ArticleVendu> lstVentes = new ArrayList<>();
		if (request.getSession().getAttribute("user") != null) {
			Utilisateur u = (Utilisateur) request.getSession().getAttribute("user");
			//On vire les articles de la liste achat dont le vendeur est l'utilisateur connecté et on les ajoutes à une liste vente
			lstVentes = triVentes(lstAchats, u.getNoUtilisateur());
			lstAchats = triAchats(lstAchats, u.getNoUtilisateur());
		}
		request.getSession().setAttribute("Achats", lstAchats);
		request.getSession().setAttribute("Ventes", lstVentes);
		request.getRequestDispatcher("WEB-INF/Accueil.jsp").forward(request, response);
	}

	private List<ArticleVendu> triVentes(List<ArticleVendu> lstAchats, Integer idVendeur) {
		List<ArticleVendu> lstVentes = new ArrayList<>();
		for (int i = 0; i < lstAchats.size(); i++) {
			if (lstAchats.get(i).getVendeur().getNoUtilisateur() == idVendeur) {
				lstVentes.add(lstAchats.get(i));
			}
		}
		
		return lstVentes;
	}
	private List<ArticleVendu> triAchats(List<ArticleVendu> lstAchats, Integer idVendeur) {
		List<ArticleVendu> retour = new ArrayList<>(); 
		for (int i = 0; i < lstAchats.size(); i++) {
			if (lstAchats.get(i).getVendeur().getNoUtilisateur() != idVendeur) {
				retour.add(lstAchats.get(i));
			}
		}
		
		return retour;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

