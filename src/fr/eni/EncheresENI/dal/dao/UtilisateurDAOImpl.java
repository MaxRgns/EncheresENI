package fr.eni.EncheresENI.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.EncheresENI.bo.Utilisateur;
import fr.eni.EncheresENI.dal.ConnectionProvider;

public class UtilisateurDAOImpl implements DAO<Utilisateur> {
	private static final String INSERT = "INSERT INTO UTILISATEURS VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL = "SELECT * FROM UTILISATEURS";
	private static final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
	
	@Override
	public void insert(Utilisateur object) {
		try(Connection connection = ConnectionProvider.getConnection()){
			PreparedStatement stmt = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,object.getPseudo());
			stmt.setString(2,object.getNom());
			stmt.setString(3,object.getPrenom());
			stmt.setString(4,object.getEmail());
			stmt.setString(5,object.getTelephone());
			stmt.setString(6,object.getRue());
			stmt.setString(7,object.getCodepostal());
			stmt.setString(8,object.getVille());
			stmt.setString(9,object.getMotDePasse());
			stmt.setString(10,Double.toString(object.getCredit()));
			stmt.setString(11,Boolean.toString(object.isAdministrateur()));
			int nb = stmt.executeUpdate();
			if(nb>0) { //Si la requête a bien récupérée une clé, on l'attribue au nouvel objet
				ResultSet rsk = stmt.getGeneratedKeys();
				if(rsk.next()) {
					object.setNoUtilisateur(rsk.getInt(1));
				}
			}
		}catch (SQLException e){
			System.err.println("Probleme d'accès à la base de données");
		}
	}

	@Override
	public Utilisateur selectById(Integer id) {
		try(Connection connection = ConnectionProvider.getConnection()){
			PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID);
			ResultSet rs = stmt.executeQuery();
			rs.next(); //Passage à la première (et dernière) ligne du résultat de requête
			Utilisateur u = new Utilisateur();
			u.setNoUtilisateur(rs.getInt("no_utilisateur"));
			u.setPseudo(rs.getString("pseudo"));
			u.setNom(rs.getString("nom"));
			u.setPrenom(rs.getString("prenom"));
			u.setEmail(rs.getString("email"));
			u.setTelephone(rs.getString("telephone"));
			u.setRue(rs.getString("rue"));
			u.setCodepostal(rs.getString("code_postal"));
			u.setVille(rs.getString("ville"));
			u.setMotDePasse(rs.getString("mot_de_passe"));
			u.setCredit(rs.getDouble("credit"));
			u.setAdministrateur(rs.getBoolean("administrateur"));
			//TODO recupérer les ventes et enchères et les lier au compte
			return u;
		}catch (SQLException e){
			System.err.println("Probleme d'accès à la base de données");
		}
		
		return null;
	}

	@Override
	public List<Utilisateur> selectAll() {
		List<Utilisateur> retour = new ArrayList<>();
		try(Connection connection = ConnectionProvider.getConnection()){
			PreparedStatement stmt = connection.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Utilisateur u = new Utilisateur();
				u.setNoUtilisateur(rs.getInt("no_utilisateur"));
				u.setPseudo(rs.getString("pseudo"));
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setEmail(rs.getString("email"));
				u.setTelephone(rs.getString("telephone"));
				u.setRue(rs.getString("rue"));
				u.setCodepostal(rs.getString("code_postal"));
				u.setVille(rs.getString("ville"));
				u.setMotDePasse(rs.getString("mot_de_passe"));
				u.setCredit(rs.getDouble("credit"));
				u.setAdministrateur(rs.getBoolean("administrateur"));
				//TODO recupérer les ventes et enchères et les lier au compte
				retour.add(u);
			}
			return retour;
		}catch (SQLException e){
			System.err.println("Probleme d'accès à la base de données");
		}
		
		return null;
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
