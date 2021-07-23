package fr.eni.EncheresENI.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleVendu {
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer categorie;
	private Integer miseAPrix;
	private Integer prixVente;
	private String etatVente;
	private Utilisateur vendeur;
	private Retrait lieuRetrait;
	private List<Enchere> encheres = new ArrayList<>();
	

	public ArticleVendu() {
	}

	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer categorie, Integer miseAPrix, Integer prixVente, String etatvente, Utilisateur vendeur,
			Retrait lieuRetrait) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.categorie = categorie;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatvente;
		this.vendeur = vendeur;
		this.lieuRetrait = lieuRetrait;
	}

	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer categorie, Integer miseAPrix, Integer prixVente, String etatvente,
			Utilisateur vendeur, Retrait lieuRetrait) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.categorie = categorie;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatvente;
		this.vendeur = vendeur;
		this.lieuRetrait = lieuRetrait;
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public Integer getCategorie() {
		return categorie;
	}

	public void setCategorie(Integer categorie) {
		this.categorie = categorie;
	}

	public Integer getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public Integer getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	public String getEtatvente() {
		return etatVente;
	}

	public void setEtatvente(String etatvente) {
		this.etatVente = etatvente;
	}

	public Utilisateur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}
	
	public List<Enchere> getEncheres(){
		return encheres;
	}
	
	public void setEncheres(List<Enchere> lst) {
		this.encheres = lst;
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", categorie="
				+ categorie + ", miseAPrix=" + miseAPrix + ", prixVente=" + prixVente + ", etatvente=" + etatVente
				+ ", vendeur=" + vendeur + ", lieuRetrait=" + lieuRetrait
				+ "]";
		//TODO Vérifier si problème StackOverflow (boucle infinie)
	}

	
}
