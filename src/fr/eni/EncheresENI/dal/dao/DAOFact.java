package fr.eni.EncheresENI.dal.dao;

import fr.eni.EncheresENI.bo.ArticleVendu;
import fr.eni.EncheresENI.bo.Categorie;
import fr.eni.EncheresENI.bo.Utilisateur;
import fr.eni.EncheresENI.dal.dao.Article.ArticleDAOImpl;
import fr.eni.EncheresENI.dal.dao.Categorie.CategorieDAOImpl;
import fr.eni.EncheresENI.dal.dao.Enchere.EnchereDAO;
import fr.eni.EncheresENI.dal.dao.Enchere.EnchereDAOImpl;
import fr.eni.EncheresENI.dal.dao.Utilisateur.UtilisateurDAOImpl;

public class DAOFact {
	public static DAO<Utilisateur> getUtilisateurDAO(){
//		return new UtilisateurDAOMock();
		return new UtilisateurDAOImpl();
	}
	public static DAO<Categorie> getCategorieDAO(){
//		return new CategorieDAOMock();
		return new CategorieDAOImpl();
	}
	public static DAO<ArticleVendu> getArticleDAO(){
//		return new ArticleDAOMock();
		return new ArticleDAOImpl();
	}
	public static EnchereDAO getEnchereDAO() {
//		return new EnchereDAOMock();
		return new EnchereDAOImpl();
	}
	
}
