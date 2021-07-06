package fr.eni.EncheresENI.bll;

import java.util.List;

import fr.eni.EncheresENI.bo.Utilisateur;

public interface UtilisateurManager {
	public void add(Utilisateur u) throws BLLException;
	public List<Utilisateur> getUser();
}
