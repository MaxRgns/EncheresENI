package fr.eni.EncheresENI.ihm;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class RegisterFilter
 */
//Renverra à la page login si l'utilisateur tente d'accéder à l'une des pages du WebFilter sans être connecté. 
//@WebFilter({"/UserServlet", "/ProfilServlet"})   //Décommenter le WebFilter pour activer le filtre.
public class RegisterFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RegisterFilter() {
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (((HttpServletRequest) request).getSession().getAttribute("user") == null) {
			//Si le visiteur n'est pas connecté à un compte utilisateur, il est renvoyé à la servlet login
			request.getRequestDispatcher("LoginServlet").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
