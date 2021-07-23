package fr.eni.EncheresENI.bll.Categorie;

import java.util.List;

import fr.eni.EncheresENI.bo.Categorie;

public interface CategorieManager {
	public void add(Categorie c);
	public Categorie getById(Integer id);
	public List<Categorie> getCategories();
	public void updateCat(Categorie c); 
	public void supprCat(Categorie c);
}
