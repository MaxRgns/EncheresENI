package fr.eni.EncheresENI.bo;

import java.util.List;

public class Categorie {
	private Integer noCategorie;
	private String libelle;
	private List<ArticleVendu> lstArticles; 
	
	public Categorie(String libelle) {
		this.libelle = libelle;
	}

	public Categorie(Integer noCategorie, String libelle) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	public Categorie() {
	}

	public Integer getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", lstArticles=" + lstArticles + "]";
	}
}
