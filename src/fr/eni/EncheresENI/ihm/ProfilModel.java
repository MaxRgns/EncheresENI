package fr.eni.EncheresENI.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.EncheresENI.bo.Utilisateur;


public class ProfilModel {
	private Utilisateur current;
	private List<Utilisateur> lstUtilisateurs = new ArrayList<>();
	
	public ProfilModel() {
	}
	
	public ProfilModel(Utilisateur current) {
		super();
		this.current = current;
	}

	public Utilisateur getCurrent() {
		return current;
	}

	public void setCurrent(Utilisateur current) {
		this.current = current;
	}

	public List<Utilisateur> getLstUtilisateurs() {
		return lstUtilisateurs;
	}

	public void setLstParticipants(List<Utilisateur> lstParticipants) {
		this.lstUtilisateurs = lstParticipants;
	}

	@Override
	public String toString() {
		return "UtilisateurModel [current=" + current + ", lstUtilisateurs=" + lstUtilisateurs + "]";
	}
	
}
