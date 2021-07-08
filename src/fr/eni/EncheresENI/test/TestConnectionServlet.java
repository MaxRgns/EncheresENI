package fr.eni.EncheresENI.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.EncheresENI.dal.ConnectionProvider;

/**
 * Servlet implementation class ContactSrevletTest
 */
@WebServlet("/TestConnection")
public class TestConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestConnectionServlet() {
     
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Cette servlet sert pour tester si la connection à la base de données paramêtrée dans context.xml se fait.		
		try (Connection connect = ConnectionProvider.getConnection()){
			response.getWriter().append("Connexion à la base de données établie");
		} catch (SQLException e) {
			response.getWriter().append("Erreur de connexion à la base de données");
		}
	}



}
