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
	private static final String UPDATE = "UPDATE UTILISATEURS SET nom=?, prenom=?, tel=? WHERE no_utilisateur = ?"; //TODO A adapter à la BDD
	private static final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	
	
	@Override
	public void insert(Utilisateur user) {
		try(Connection connection = ConnectionProvider.getConnection()){
			PreparedStatement stmt = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,user.getPseudo());
			stmt.setString(2,user.getNom());
			stmt.setString(3,user.getPrenom());
			stmt.setString(4,user.getEmail());
			stmt.setString(5,user.getTelephone());
			stmt.setString(6,user.getRue());
			stmt.setString(7,user.getCodepostal());
			stmt.setString(8,user.getVille());
			stmt.setString(9,user.getMotDePasse());
			stmt.setString(10,Double.toString(user.getCredit()));
			stmt.setString(11,Boolean.toString(user.isAdministrateur()));
			int nb = stmt.executeUpdate();
			if(nb>0) { //Si la requ�te a bien r�cup�r�e une cl�, on l'attribue au nouvel objet
				ResultSet rsk = stmt.getGeneratedKeys();
				if(rsk.next()) {
					user.setNoUtilisateur(rsk.getInt(1));
				}
			}
		}catch (SQLException e){
			System.err.println("Probleme d'acc�s�� la base de donn�es");
		}
	}

	@Override
	public Utilisateur selectById(Integer id) throws SQLException {
		try(Connection connection = ConnectionProvider.getConnection()){
			PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
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
			throw new SQLException("Probleme d'accès à la base de données");
		}
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
		try(Connection connection = ConnectionProvider.getConnection()){
			PreparedStatement stmt = connection.prepareStatement(UPDATE);
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
			
		}catch (SQLException e){
			System.err.println("Probleme d'accès à la base de données");
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utilisateur object) {
		// TODO Auto-generated method stub
		
	}

}
