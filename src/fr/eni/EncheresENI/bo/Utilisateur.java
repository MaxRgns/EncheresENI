package fr.eni.EncheresENI.bo;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
	private Integer noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codepostal;
	private String ville;
	private String motDePasse;
	private Double credit;
	private boolean administrateur;
	private List<ArticleVendu> ventes = new ArrayList<>();
	private List<Enchere> lstEncheres = new ArrayList<>();

	public Utilisateur() {
	}
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codepostal, String ville, String motDePasse) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codepostal = codepostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = 100.0; // un crédit de base à la création du compte
		this.administrateur = false; // par défaut, un utilisateur n'est pas admin
	}

	public Utilisateur(Integer noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codepostal, String ville, String motDePasse) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codepostal = codepostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = 100.0; // un crédit de base à la création du compte
		this.administrateur = false; // par défaut, un utilisateur n'est pas admin
	}

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}
	
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public List<ArticleVendu> getVentes() {
		return ventes;
	}

	public List<Enchere> getLstEncheres() {
		return lstEncheres;
	}

	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codepostal="
				+ codepostal + ", ville=" + ville + ", motDePasse=" + motDePasse + ", credit=" + credit
				+ ", administrateur=" + administrateur + ", ventes=" + ventes + ", lstEncheres=" + lstEncheres + "]";
	}

}
