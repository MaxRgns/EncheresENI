package fr.eni.EncheresENI.bo;

import java.time.LocalDate;

public class Enchere {
	private LocalDate dateEnchere;
	private Double montant_enchere;
	private Utilisateur encherisseur;
	private ArticleVendu article;

	public Enchere(LocalDate dateEnchere, Double montant_enchere, Utilisateur encherisseur, ArticleVendu article) {
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.encherisseur = encherisseur;
		this.article = article;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public Double getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Double montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Utilisateur getEncherisseur() {
		return encherisseur;
	}

	public ArticleVendu getArticle() {
		return article;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montant_enchere=" + montant_enchere + ", encherisseur="
				+ encherisseur + ", article=" + article + "]";
	}
}
