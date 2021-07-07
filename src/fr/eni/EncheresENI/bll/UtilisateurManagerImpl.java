package fr.eni.EncheresENI.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.EncheresENI.bo.Utilisateur;
import fr.eni.EncheresENI.dal.dao.DAO;
import fr.eni.EncheresENI.dal.dao.DAOFact;

class UtilisateurManagerImpl implements UtilisateurManager {
	private List<Utilisateur> lstUser = new ArrayList<>();
	private DAO<Utilisateur> dao = DAOFact.getUtilisateurDAO();
	
	@Override
	public void add(Utilisateur u) throws BLLException {
		if (pseudoUnique(u.getPseudo())) {
			if (mailUnique(u.getEmail())) {
				if(u.getPseudo().matches("[A-Za-z0-9]+")) { //Si pseudo ne comprend que de l'alphanumérique (pas d'espace, de ' ,  etc)
					lstUser.add(u); //ajout dans la liste de la BLL
					dao.insert(u); //Ajout en BDD
				}else {
					throw new BLLException("Le pseudo ne doit contenir que des caractères alphanumériques");
				}
			}else {
				throw new BLLException("Cette adresse e-mail est déjà associé à un compte");
			}
		}else {
			throw new BLLException("Ce pseudo n'est pas disponible");
		}		
	}

	private boolean pseudoUnique(String pseudo) {
		for (Utilisateur utilisateur : lstUser) {
			if(utilisateur.getPseudo().equals(pseudo)){
				return false;
			}
		}
		return true; //Atteignable seulement s'il n'y a pas de doublons
	}
	
	private boolean mailUnique(String mail) {
		for (Utilisateur utilisateur : lstUser) {
			if(utilisateur.getEmail().equals(mail)){
				return false;
			}
		}
		return true; //Atteignable seulement s'il n'y a pas de doublons
	}

	@Override
	public List<Utilisateur> getUsers() {
		if (lstUser == null) {
			lstUser = dao.selectAll();
		}
		return lstUser;
	}
	@Override
	public Utilisateur getProfil(Integer id) throws BLLException, SQLException {
		Utilisateur retour = null;
		retour = dao.selectById(id);
		//Passage de certains paramètres inutiles POUR LA COPIE à null
		retour.setMotDePasse(null); 
		retour.setCredit(null);
		retour.setAdministrateur(false);
		return retour;
	}

}
