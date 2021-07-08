package fr.eni.EncheresENI.dal.dao;

import java.util.ArrayList;
import java.util.List;

import fr.eni.EncheresENI.bo.Utilisateur;

public class UtilisateurDAOMock implements DAO<Utilisateur> {
	private List<Utilisateur> lstUtilMock = new ArrayList<>();
	
	@Override
	public void insert(Utilisateur u) {
		lstUtilMock.add(u);
	}

	@Override
	public Utilisateur selectById(Integer id) {
		for (Utilisateur u : lstUtilMock) {
			if (u.getNoUtilisateur() == id) {
				return u;
			}
		}
		return null; //S'il n'y a pas d'utilisateur corresondant à l'id 
	}

	@Override
	public List<Utilisateur> selectAll() {
		return lstUtilMock;
	}

	@Override
	public void update(Utilisateur user) {
		for (Utilisateur u : lstUtilMock) {
			if (u.getNoUtilisateur() == user.getNoUtilisateur()) {
				u = user;
			}
		}
	}

	@Override
	public void delete(Integer id) {
		int index = -1;
		for (int i = 0; i < lstUtilMock.size(); i++) {
			if (lstUtilMock.get(i).getNoUtilisateur() == id) {
				index = i;
			}
		}
		if (index > -1) {
			lstUtilMock.remove(index);
		}	
	}

}
