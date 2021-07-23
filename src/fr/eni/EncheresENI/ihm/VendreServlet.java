package fr.eni.EncheresENI.ihm;

import java.io.IOException;
import java.time.LocalDate;
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
import fr.eni.EncheresENI.bo.Retrait;
import fr.eni.EncheresENI.bo.Utilisateur;

/**
 * Servlet implementation class VendreServlet
 */
@WebServlet(name = "Vendre", urlPatterns = { "/Vendre" })
public class VendreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategorieManager catManager = CategorieManagerSingl.getInstance();
	ArticleManager artManager = ArticleManagerSingl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VendreServlet() {
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
			case "Enregistrer":
				enregistrer(request, response);
				break;
			}
			request.getRequestDispatcher("Accueil").forward(request, response); //TODO bug de redirection
		}
		List<Categorie> categories = catManager.getCategories();
		request.getSession().setAttribute("categories", categories);
		request.getRequestDispatcher("WEB-INF/Vendre.jsp").forward(request, response);
		
	}

	private void enregistrer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleVendu a = new ArticleVendu();
		a.setNomArticle(request.getParameter("nom"));
		a.setDescription(request.getParameter("description"));
		a.setCategorie(catManager.getById(Integer.valueOf(request.getParameter("categorie"))));
		a.setMiseAPrix(Integer.valueOf(request.getParameter("prix")));
		a.setDateDebutEncheres(LocalDate.parse(request.getParameter("dateD")));
		a.setDateFinEncheres(LocalDate.parse(request.getParameter("dateF")));
		a.setVendeur((Utilisateur) request.getSession().getAttribute("user"));
		Retrait r = new Retrait();
		r.setRue(request.getParameter("rue"));
		r.setCode_postal(request.getParameter("cp"));
		r.setVille(request.getParameter("ville"));
		a.setLieuRetrait(r);
		a.setPrixVente(Integer.valueOf(request.getParameter("prix")));
		a.setEtatvente("Créée"); // TODO Si Débutvente est déjà passé (donc aujourd'hui), doit changer l'état
		artManager.add(a);
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
