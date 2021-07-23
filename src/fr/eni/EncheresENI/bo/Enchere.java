package fr.eni.EncheresENI.bo;

import java.time.LocalDateTime;

public class Enchere {
	private LocalDateTime dateEnchere;
	private Integer montant_enchere;
	private Integer encherisseur;
	private Integer article;

	public Enchere(LocalDateTime dateEnchere, Integer montant_enchere, Integer encherisseur, Integer article) {
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.encherisseur = encherisseur;
		this.article = article;
	}

	public Enchere() {
	}

	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public Integer getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Integer getEncherisseur() {
		return encherisseur;
	}
	
	public void setEncherisseur(Integer id) {
		this.encherisseur = id;
	}

	public Integer getArticle() {
		return article;
	}
	
	public void setArticle(Integer id) {
		this.article = id;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montant_enchere=" + montant_enchere + ", encherisseur="
				+ encherisseur + ", article=" + article + "]";
	}
}
