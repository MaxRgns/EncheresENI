package fr.eni.EncheresENI.ihm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.EncheresENI.bll.CategorieManager;
import fr.eni.EncheresENI.bll.CategorieManagerSingl;
import fr.eni.EncheresENI.bo.Categorie;

/**
 * Servlet implementation class VendreServlet
 */
@WebServlet(name = "Vendre", urlPatterns = { "/Vendre" })
public class VendreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategorieManager catManager = CategorieManagerSingl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendreServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("action") != null) {
			switch(request.getParameter("action")) {
			case "Enregistrer" :
				enregistrer(request, response);
				break;
			case "Retour" :
				request.getRequestDispatcher("Accueil").forward(request, response);
				break;
			}
		}
		List<Categorie> categories = catManager.getCategories();
		request.getSession().setAttribute("categories", categories);
		request.getRequestDispatcher("WEB-INF/Vendre.jsp").forward(request, response);
	}

	private void enregistrer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("nom"));
		System.out.println(request.getParameter("description"));
		System.out.println(request.getParameter("categorie"));
		System.out.println(request.getParameter("prix"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
