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
			System.out.println("Encheres : " + a.getDateFinEncheres());
			System.out.println("Now : " + LocalDate.now());
			if (a.getDateFinEncheres().isBefore(LocalDate.now())) {
				a.setEtatvente("termine");
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
		try {
			return dao.selectById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
