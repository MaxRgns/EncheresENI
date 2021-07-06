package fr.eni.EncheresENI.dal.dao;

import java.util.ArrayList;
import java.util.List;

import fr.eni.EncheresENI.bo.Utilisateur;

public class UtilisateurDAOMock implements DAO<Utilisateur> {
	private List<Utilisateur> lstUtilMock = new ArrayList<>();
	
	@Override
	public void insert(Utilisateur object) {
		lstUtilMock.add(object);
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
	public void update(Utilisateur object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utilisateur object) {
		// TODO Auto-generated method stub
		
	}

}
