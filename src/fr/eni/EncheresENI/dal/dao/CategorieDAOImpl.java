package fr.eni.EncheresENI.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.EncheresENI.bo.Categorie;
import fr.eni.EncheresENI.dal.ConnectionProvider;

public class CategorieDAOImpl implements DAO<Categorie> {
	private static final String INSERT = "INSERT INTO CATEGORIES VALUES (?)";
	private static final String SELECT_ALL = "SELECT * FROM CATEGORIES";
	private static final String SELECT_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie = ?";
	private static final String UPDATE = "UPDATE CATEGORIES SET libelle=? WHERE no_categorie = ?";
	private static final String DELETE = "DELETE FROM CATEGORIES WHERE no_categorie = ?";

	@Override
	public void insert(Categorie c) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, c.getLibelle());
			int nb = stmt.executeUpdate();
			if (nb > 0) { // Si la requete a bien recuperee une cle, on l'attribue au nouvel objet
				ResultSet rsk = stmt.getGeneratedKeys();
				if (rsk.next()) {
					c.setNoCategorie(rsk.getInt(1));
				}
			}
		} catch (SQLException e) {
			System.err.println("Probleme d'accès à la base de données");
		}
		
	}

	@Override
	public Categorie selectById(Integer id) throws SQLException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next(); // Passage à la première (et dernière) ligne du résultat de requête
			Categorie c = new Categorie();
			c.setNoCategorie(rs.getInt("no_categorie"));
			c.setLibelle(rs.getString("libelle"));
			return c;
		} catch (SQLException e) {
			throw new SQLException("Probleme d'accès à la base de données");
		}
	}

	@Override
	public List<Categorie> selectAll() {
		List<Categorie> retour = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categorie c = new Categorie();
				c.setNoCategorie(rs.getInt("no_categorie"));
				c.setLibelle(rs.getString("libelle"));
				retour.add(c);
			}
			return retour;
		} catch (SQLException e) {
			System.err.println("Probleme d'accès à la base de données");
		}
		return null;
	}

	@Override
	public void update(Categorie c) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(UPDATE);
			stmt.setString(1, c.getLibelle());
			stmt.setInt(10, c.getNoCategorie());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Probleme d'accès à la base de données");
		}
		
	}

	@Override
	public void delete(Integer id) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(DELETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Probleme d'accès à la base de données");
		}
		
	}

}
