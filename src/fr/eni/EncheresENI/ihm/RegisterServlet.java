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
 * Servlet implementation class RegiterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager manager = UtilisateurManagerSingl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProfilModel model = new ProfilModel();
		if (request.getParameter("register") == null) {
			request.getRequestDispatcher("WEB-INF/Register.jsp").forward(request, response);

			if (request.getParameter("register") != null) {
				if (request.getParameter("mdp").equals(request.getParameter("conf"))) {

					Utilisateur user = new Utilisateur();

					user.setPseudo(request.getParameter("pseudo"));
					user.setNom(request.getParameter("nom"));
					user.setPrenom(request.getParameter("prenom"));
					user.setEmail(request.getParameter("mail"));
					user.setTelephone(request.getParameter("tel"));
					user.setRue(request.getParameter("rue"));
					user.setCodepostal(request.getParameter("cp"));
					user.setVille(request.getParameter("ville"));
					user.setMotDePasse(request.getParameter("mdp"));
					user.setCredit(100.0);

					model.setUtilisateur(user);
					System.out.println(user);

					try {
						manager.add(user);
					} catch (BLLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("Mdp différents");
				}
			}
		}

		request.setAttribute("model", model);
		request.getRequestDispatcher("WEB-INF/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
