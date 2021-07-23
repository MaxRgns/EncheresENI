package fr.eni.EncheresENI.bll.Utilisateur;

import java.sql.SQLException;
import java.util.List;

import fr.eni.EncheresENI.bll.BLLException;
import fr.eni.EncheresENI.bo.Utilisateur;

public interface UtilisateurManager {
	public void add(Utilisateur u) throws BLLException;
	public List<Utilisateur> getUsers();
	public Utilisateur getProfil(Integer id) throws BLLException, SQLException;
	public Utilisateur getConnection(String ident, String password);
	public void updateUser(Utilisateur u) throws BLLException; 
	public void suppr(Utilisateur u) throws BLLException;
}
