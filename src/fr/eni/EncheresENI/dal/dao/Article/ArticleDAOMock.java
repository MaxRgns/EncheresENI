package fr.eni.EncheresENI.dal.dao.Article;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.EncheresENI.bo.ArticleVendu;
import fr.eni.EncheresENI.dal.dao.DAO;

public class ArticleDAOMock implements DAO<ArticleVendu> {
	private List<ArticleVendu> lstArtMock = new ArrayList<>();

	@Override
	public void insert(ArticleVendu a) {
		lstArtMock.add(a);
	}

	@Override
	public ArticleVendu selectById(Integer id) throws SQLException {
		for (ArticleVendu a : lstArtMock) {
			if (a.getNoArticle() == id) {
				return a;
			}
		}
		return null;
	}

	@Override
	public List<ArticleVendu> selectAll() {
		return lstArtMock;
	}

	@Override
	public void update(ArticleVendu a) {
		for (ArticleVendu aV : lstArtMock) {
			if (aV.getNoArticle() == a.getNoArticle()) {
				aV = a;
			}
		}
	}

	@Override
	public void delete(Integer id) {
		for (ArticleVendu a : lstArtMock) {
			if (a.getNoArticle() == id) {
				lstArtMock.remove(a);
			}
		}
	}
}
