package fr.eni.EncheresENI.ihm;

import java.io.IOException;
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
@WebServlet("/ContactSrevletTest")
public class ContactSrevletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactSrevletTest() {
     
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println(ConnectionProvider.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
