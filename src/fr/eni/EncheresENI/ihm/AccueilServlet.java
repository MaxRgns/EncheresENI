
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
		String keyword = null;
		Integer catId = 0;
		if (request.getParameter("cat") != null) {
			catId = Integer.valueOf(request.getParameter("cat"));
		}

		List<Categorie> categories = catManager.getCategories();
		request.getSession().setAttribute("categories", categories);

		List<ArticleVendu> lstAchats = triCat(artManager.getArticles(), catId);
		if (request.getParameter("keyword") != null) {
			keyword = request.getParameter("keyword");
			lstAchats = triKey(lstAchats, keyword);
		}
		
		List<ArticleVendu> lstVentes = new ArrayList<>();
		if (request.getSession().getAttribute("user") != null) {
			Utilisateur u = (Utilisateur) request.getSession().getAttribute("user");
			// On vire les articles de la liste achat dont le vendeur est l'utilisateur
			// connecté et on les ajoutes à une liste vente
			lstVentes = triVentes(lstAchats, u.getNoUtilisateur());
			lstAchats = triAchats(lstAchats, u.getNoUtilisateur());
		}
		
		//split des listes achats et ventes et 6 listes
		List<ArticleVendu> achatsEnCours = recupAchatsEnCours(lstAchats);
		List<ArticleVendu> achatsMesEncheres = recupMesEncheres(lstAchats);
		List<ArticleVendu> achatsRemporte = recupAchatsRemporte(lstAchats);
		
		List<ArticleVendu> ventesEnCours = recupVentesEnCours(lstVentes);
		List<ArticleVendu> ventesCree = recupVenteCree(lstVentes);
		List<ArticleVendu> ventesFini = recupVentesFini(lstVentes);
		
		request.getSession().setAttribute("Achats", lstAchats);
		request.getSession().setAttribute("Ventes", lstVentes); //TODO a supprimer si les ventes s'affichent bien
		request.getSession().setAttribute("ventesEnCours", ventesEnCours);
		request.getSession().setAttribute("ventesCree", ventesCree);
		request.getSession().setAttribute("ventesFini", ventesFini);
		request.getSession().setAttribute("achatsEnCours", achatsEnCours);
		request.getSession().setAttribute("achatsMesEncheres", achatsMesEncheres);
		request.getSession().setAttribute("achatsRemporte", achatsRemporte);
		request.getRequestDispatcher("WEB-INF/Accueil.jsp").forward(request, response);
	}

	private List<ArticleVendu> recupAchatsEnCours(List<ArticleVendu> lstAchats) {
		List<ArticleVendu> retour = new ArrayList<>();
		for (ArticleVendu a : lstAchats) {
			if (a.getEtatvente().equals("enCours")) {
				retour.add(a);
			}
		}
		return retour;
	}
	
	private List<ArticleVendu> recupMesEncheres(List<ArticleVendu> lstAchats) {
		List<ArticleVendu> retour = new ArrayList<>();
//		for (ArticleVendu a : lstAchats) {
//			//TODO Ajouter une condition qui vérifie si l'utilisateur a encheri  
//		}
		return retour;
	}
	
	private List<ArticleVendu> recupAchatsRemporte(List<ArticleVendu> lstAchats) {
		List<ArticleVendu> retour = new ArrayList<>();
		for (ArticleVendu a : lstAchats) {
			if ((a.getEtatvente().equals("fini"))) {
				//TODO Ajouter une condition qui vérifie si l'utilisateur est le meilleur encherisseur 
				retour.add(a);
			}
		}
		return retour;
	}
	
	private List<ArticleVendu> recupVentesEnCours(List<ArticleVendu> ventes) {
		List<ArticleVendu> retour = new ArrayList<>();
		for (ArticleVendu a : ventes) {
			if (a.getEtatvente().equals("enCours")) {
				retour.add(a);
			}
		}
		return retour;
	}
	
	private List<ArticleVendu> recupVenteCree(List<ArticleVendu> ventes) {
		List<ArticleVendu> retour = new ArrayList<>();
		for (ArticleVendu a : ventes) {
			if (a.getEtatvente().equals("cree")) {
				retour.add(a);
			}
		}
		return retour;
	}
	
	private List<ArticleVendu> recupVentesFini(List<ArticleVendu> ventes) {
		List<ArticleVendu> retour = new ArrayList<>();
		for (ArticleVendu a : ventes) {
			if (a.getEtatvente().equals("fini")) {
				retour.add(a);
			}
		}
		return retour;
	}

	private List<ArticleVendu> triCat(List<ArticleVendu> lstAchats, Integer cat) {
		List<ArticleVendu> retour = new ArrayList<>();
		for (int i = 0; i < lstAchats.size(); i++) {
				if (cat > 0) { // Si un filtre de catégorie est actif
					if (lstAchats.get(i).getCategorie() == cat) {
						retour.add(lstAchats.get(i));
					}
				} else {
					retour.add(lstAchats.get(i));
				}
			}
		return retour;
	}
	
	private List<ArticleVendu> triKey(List<ArticleVendu> lstAchats, String keyword) {
		List<ArticleVendu> retour = new ArrayList<>();
		for (int i = 0; i < lstAchats.size(); i++) {
			if (lstAchats.get(i).getNomArticle().toUpperCase().contains(keyword.toUpperCase())) {
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
