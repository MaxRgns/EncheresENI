package fr.eni.EncheresENI.dal.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.EncheresENI.bo.Categorie;

public class CategorieDAOMock implements DAO<Categorie> {
	private List<Categorie> lstCatMock = new ArrayList<>();

	@Override
	public void insert(Categorie c) {
		lstCatMock.add(c);
		
	}

	@Override
	public Categorie selectById(Integer id) throws SQLException {
		for (Categorie c : lstCatMock) {
			if (c.getNoCategorie() == id) {
				return c;
			}
		}
		return null; //S'il n'y a pas d'utilisateur corresondant à l'id
	}

	@Override
	public List<Categorie> selectAll() {
		return lstCatMock;
	}

	@Override
	public void update(Categorie c) {
		for (Categorie cat : lstCatMock) {
			if (cat.getNoCategorie() == c.getNoCategorie()) {
				cat = c;
			}
		}
	}

	@Override
	public void delete(Integer id) {
		int index = -1;
		for (int i = 0; i < lstCatMock.size(); i++) {
			if (lstCatMock.get(i).getNoCategorie() == id) {
				index = i;
			}
		}
		if (index > -1) {
			lstCatMock.remove(index);
		}	
		
	}

}
