package fr.eni.EncheresENI.dal.dao.Enchere;

import java.sql.SQLException;
import java.util.List;

import fr.eni.EncheresENI.bo.Enchere;

public interface EnchereDAO {
	public void insert(Enchere ench);
	public List<Enchere> selectByArticle(Integer id) throws SQLException;
}
