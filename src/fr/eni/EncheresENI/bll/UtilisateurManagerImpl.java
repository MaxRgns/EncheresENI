package fr.eni.EncheresENI.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.EncheresENI.bo.Utilisateur;
import fr.eni.EncheresENI.dal.dao.DAO;
import fr.eni.EncheresENI.dal.dao.DAOFact;

class UtilisateurManagerImpl implements UtilisateurManager {
	private DAO<Utilisateur> dao = DAOFact.getUtilisateurDAO();
	
	@Override
	public void add(Utilisateur u) throws BLLException {
		if (pseudoUnique(u.getPseudo())) {
			if (mailUnique(u.getEmail())) {
				if(u.getPseudo().matches("[A-Za-z0-9]+")) { //Si pseudo ne comprend que de l'alphanumérique (pas d'espace, de ' ,  etc)
					dao.insert(u); //Ajout en BDD
					System.out.println(u);
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
		List<Utilisateur> lstUser = dao.selectAll();
		for (Utilisateur utilisateur : lstUser) {
			if(utilisateur.getPseudo().equals(pseudo)){
				return false;
			}
		}
		return true; //Atteignable seulement s'il n'y a pas de doublons
	}
	
	private boolean mailUnique(String mail) {
		List<Utilisateur> lstUser = dao.selectAll();
		for (Utilisateur utilisateur : lstUser) {
			if(utilisateur.getEmail().equals(mail)){
				return false;
			}
		}
		return true; //Atteignable seulement s'il n'y a pas de doublons
	}
	
	@Override
	public Utilisateur getConnection(String ident, String password) {
		List<Utilisateur> lstUser = dao.selectAll();
		for (Utilisateur user : lstUser) {
			if ((user.getPseudo().equals(ident)) || (user.getEmail().equals(ident))) {
				//Si l'identifiant correspond au pseudo ou email de l'utilisateur
				if (user.getMotDePasse().equals(password)) {

					System.out.println("Connecté");
					//Si c'est le bon mot de passe
					return user;
				}else {
					System.out.println("Mauvais mot de passe");
				}
			}else {
				System.out.println("Utilisateur inexistant");
			}
		}
		return null;
	}

	@Override
	public List<Utilisateur> getUsers() {
		List<Utilisateur> lstUser = dao.selectAll();
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

	@Override
	public void suppr(Utilisateur u) throws BLLException {
		dao.delete(u.getNoUtilisateur());		
	}

	@Override
	public void updateUser(Utilisateur u) throws BLLException {
		dao.update(u);
	}

}
