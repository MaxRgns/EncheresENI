package fr.eni.EncheresENI.bll.Article;

import java.util.List;

import fr.eni.EncheresENI.bo.ArticleVendu;

public interface ArticleManager {
	public void add(ArticleVendu a);
	public List<ArticleVendu> getArticles();
	public ArticleVendu getById(Integer id);
	public void updateArticle(ArticleVendu a); 
	public void removeArticle(ArticleVendu a);
}
