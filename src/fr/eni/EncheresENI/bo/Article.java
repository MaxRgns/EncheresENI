package fr.eni.EncheresENI.bo;

import java.time.LocalDate;

public class Article {
	private Integer idArticle;
	private String name;
	private String description;
	private String categorie;
	private Double prixDeDepart;
	private LocalDate departEnchere;
	private LocalDate finEnchere;
	private String rue;
	private String cp;
	private String ville;
	private User vendeur;
	private User acheteur;
	
	public Article() {
	}

	public Article(String name, String description, String categorie, Double prixDeDepart, LocalDate departEnchere,
			LocalDate finEnchere, String rue, String cp, String ville, User vendeur, User acheteur) {
		super();
		this.name = name;
		this.description = description;
		this.categorie = categorie;
		this.prixDeDepart = prixDeDepart;
		this.departEnchere = departEnchere;
		this.finEnchere = finEnchere;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.vendeur = vendeur;
		this.acheteur = acheteur;
	}

	public Article(Integer idArticle, String name, String description, String categorie, Double prixDeDepart,
			LocalDate departEnchere, LocalDate finEnchere, String rue, String cp, String ville, User vendeur,
			User acheteur) {
		super();
		this.idArticle = idArticle;
		this.name = name;
		this.description = description;
		this.categorie = categorie;
		this.prixDeDepart = prixDeDepart;
		this.departEnchere = departEnchere;
		this.finEnchere = finEnchere;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.vendeur = vendeur;
		this.acheteur = acheteur;
	}

	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Double getPrixDeDepart() {
		return prixDeDepart;
	}

	public void setPrixDeDepart(Double prixDeDepart) {
		this.prixDeDepart = prixDeDepart;
	}

	public LocalDate getDepartEnchere() {
		return departEnchere;
	}

	public void setDepartEnchere(LocalDate departEnchere) {
		this.departEnchere = departEnchere;
	}

	public LocalDate getFinEnchere() {
		return finEnchere;
	}

	public void setFinEnchere(LocalDate finEnchere) {
		this.finEnchere = finEnchere;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public User getVendeur() {
		return vendeur;
	}

	public void setVendeur(User vendeur) {
		this.vendeur = vendeur;
	}

	public User getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(User acheteur) {
		this.acheteur = acheteur;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", name=" + name + ", description=" + description + ", categorie="
				+ categorie + ", prixDeDepart=" + prixDeDepart + ", departEnchere=" + departEnchere + ", finEnchere="
				+ finEnchere + ", rue=" + rue + ", cp=" + cp + ", ville=" + ville + ", vendeur=" + vendeur
				+ ", acheteur=" + acheteur + "]";
	}
	
	
	
}
