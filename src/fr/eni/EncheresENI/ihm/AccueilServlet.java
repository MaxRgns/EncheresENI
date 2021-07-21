
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
import fr.eni.EncheresENI.bll.Categorie.CategorieManager;
import fr.eni.EncheresENI.bll.Categorie.CategorieManagerSingl;
import fr.eni.EncheresENI.bo.ArticleVendu;
import fr.eni.EncheresENI.bo.Categorie;
import fr.eni.EncheresENI.bo.Utilisateur;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/Accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleManager artManager = ArticleManagerSingl.getInstance();
	CategorieManager catManager = CategorieManagerSingl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer catId = 0;
		if (request.getParameter("cat") != null) {
			catId = Integer.valueOf(request.getParameter("cat"));
		}

		List<Categorie> categories = catManager.getCategories();
		request.getSession().setAttribute("categories", categories);

		List<ArticleVendu> lstAchats = triCat(artManager.getArticles(), catId);
		List<ArticleVendu> lstVentes = new ArrayList<>();
		if (request.getSession().getAttribute("user") != null) {
			Utilisateur u = (Utilisateur) request.getSession().getAttribute("user");
			// On vire les articles de la liste achat dont le vendeur est l'utilisateur
			// connecté et on les ajoutes à une liste vente
			lstVentes = triVentes(lstAchats, u.getNoUtilisateur());
			lstAchats = triAchats(lstAchats, u.getNoUtilisateur());
		}
		request.getSession().setAttribute("Achats", lstAchats);
		request.getSession().setAttribute("Ventes", lstVentes);
		request.getRequestDispatcher("WEB-INF/Accueil.jsp").forward(request, response);
	}

	private List<ArticleVendu> triCat(List<ArticleVendu> lstAchats, Integer cat) {

		List<ArticleVendu> retour = new ArrayList<>();
		for (int i = 0; i < lstAchats.size(); i++) {
				if (cat != 0) { // Si un filtre de catégorie est actif
					if (lstAchats.get(i).getCategorie() == cat) {
						retour.add(lstAchats.get(i));
					}
				} else {
					retour.add(lstAchats.get(i));
				}
			}
		

		return retour;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
