package fr.eni.EncheresENI.bll.Categorie;

import java.sql.SQLException;
import java.util.List;

import fr.eni.EncheresENI.bo.Categorie;
import fr.eni.EncheresENI.dal.dao.DAO;
import fr.eni.EncheresENI.dal.dao.DAOFact;

class CategorieManagerImpl implements CategorieManager {
	private DAO<Categorie> dao = DAOFact.getCategorieDAO();

	@Override
	public void add(Categorie c){
		
		dao.insert(c);
	}

	@Override
	public Categorie getById(Integer id) {
		try {
			return dao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Categorie> getCategories() {
		return dao.selectAll();
	}

	@Override
	public void updateCat(Categorie c) {
		dao.update(c);

	}

	@Override
	public void supprCat(Categorie c){
		dao.delete(c.getNoCategorie());
	}
}
