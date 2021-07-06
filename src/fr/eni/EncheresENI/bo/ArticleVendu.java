package fr.eni.EncheresENI.bo;

import java.time.LocalDate;
import java.util.List;

public class ArticleVendu {
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private String categorie;
	private Double miseAPrix;
	private Double prixVente;
	private String etatvente;
	private Utilisateur vendeur;
	private List<Enchere> lstEncheres;
	private Retrait lieuRetrait;
	private Categorie categorieArticle;

	public ArticleVendu() {
	}

	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			String categorie, Double miseAPrix, Double prixVente, String etatvente, Utilisateur vendeur,
			List<Enchere> lstEncheres, Retrait lieuRetrait, Categorie categorieArticle) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.categorie = categorie;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatvente = etatvente;
		this.vendeur = vendeur;
		this.lstEncheres = lstEncheres;
		this.lieuRetrait = lieuRetrait;
		this.categorieArticle = categorieArticle;
	}

	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, String categorie, Double miseAPrix, Double prixVente, String etatvente,
			Utilisateur vendeur, List<Enchere> lstEncheres, Retrait lieuRetrait, Categorie categorieArticle) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.categorie = categorie;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatvente = etatvente;
		this.vendeur = vendeur;
		this.lstEncheres = lstEncheres;
		this.lieuRetrait = lieuRetrait;
		this.categorieArticle = categorieArticle;
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

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Double getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(Double miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public Double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Double prixVente) {
		this.prixVente = prixVente;
	}

	public String getEtatvente() {
		return etatvente;
	}

	public void setEtatvente(String etatvente) {
		this.etatvente = etatvente;
	}

	public Utilisateur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	public List<Enchere> getLstEncheres() {
		return lstEncheres;
	}

	public void setLstEncheres(List<Enchere> lstEncheres) {
		this.lstEncheres = lstEncheres;
	}

	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}

	public Categorie getCategorieArticle() {
		return categorieArticle;
	}

	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", categorie="
				+ categorie + ", miseAPrix=" + miseAPrix + ", prixVente=" + prixVente + ", etatvente=" + etatvente
				+ ", vendeur=" + vendeur + ", lstEncheres=" + lstEncheres + ", lieuRetrait=" + lieuRetrait
				+ ", categorieArticle=" + categorieArticle + "]";
		//TODO Vérifier si problème StackOverflow (boucle infinie)
	}

	
}
