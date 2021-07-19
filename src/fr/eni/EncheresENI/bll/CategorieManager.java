package fr.eni.EncheresENI.bll;

import java.util.List;

import fr.eni.EncheresENI.bo.Categorie;

public interface CategorieManager {
	public void add(Categorie c);
	public List<Categorie> getCategories();
	public void updateCat(Categorie c); 
	public void supprCat(Categorie c);
}
