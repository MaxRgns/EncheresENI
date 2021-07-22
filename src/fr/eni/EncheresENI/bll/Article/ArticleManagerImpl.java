package fr.eni.EncheresENI.bll.Article;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.EncheresENI.bo.ArticleVendu;
import fr.eni.EncheresENI.dal.dao.DAO;
import fr.eni.EncheresENI.dal.dao.DAOFact;

public class ArticleManagerImpl implements ArticleManager {
	private DAO<ArticleVendu> dao = DAOFact.getArticleDAO();
	@Override
	public void add(ArticleVendu a) {
		dao.insert(a);
	}

	@Override
	public List<ArticleVendu> getArticles() {
		List<ArticleVendu> retour = dao.selectAll();
		for (ArticleVendu a : retour) {
			if (a.getDateFinEncheres().isBefore(LocalDate.now())) {
				a.setEtatvente("fini");
			}else if (a.getDateDebutEncheres().isAfter(LocalDate.now())) {
				a.setEtatvente("cree");
			}else {
				a.setEtatvente("enCours");
			} //TODO Manque le retrait effectué
		}
		
		return retour;
	}

	@Override
	public ArticleVendu getById(Integer id) {
		ArticleVendu retour = new ArticleVendu();
		try {
			
			retour=  dao.selectById(id);
			if (retour.getDateFinEncheres().isBefore(LocalDate.now())) {
				retour.setEtatvente("fini");
			}else if (retour.getDateDebutEncheres().isAfter(LocalDate.now())) {
				retour.setEtatvente("cree");
			}else {
				retour.setEtatvente("enCours");
			} //TODO Manque le retrait effectué
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retour;
	}

	@Override
	public void updateArticle(ArticleVendu a) {
		dao.update(a);
	}

	@Override
	public void removeArticle(ArticleVendu a) {
		dao.delete(a.getNoArticle());
	}

}
