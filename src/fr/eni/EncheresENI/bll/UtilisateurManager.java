package fr.eni.EncheresENI.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.EncheresENI.bo.Utilisateur;

public interface UtilisateurManager {
	public void add(Utilisateur u) throws BLLException;
	public List<Utilisateur> getUsers();
	public Utilisateur getProfil(Integer id) throws BLLException, SQLException;
}
