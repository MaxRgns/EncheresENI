package fr.eni.EncheresENI.dal.dao;

import fr.eni.EncheresENI.bo.Utilisateur;

public class DAOFact {
	public static DAO<Utilisateur> getUtilisateurDAO(){
//		return new UtilisateurDAOMock();
		return new UtilisateurDAOImpl();
	}
	
}
