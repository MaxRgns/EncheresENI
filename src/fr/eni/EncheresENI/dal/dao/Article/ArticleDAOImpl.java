package fr.eni.EncheresENI.dal.dao.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.eni.EncheresENI.bo.ArticleVendu;
import fr.eni.EncheresENI.dal.ConnectionProvider;
import fr.eni.EncheresENI.dal.dao.DAO;

public class ArticleDAOImpl implements DAO<ArticleVendu> {
	private static final String INSERT_A = "INSERT INTO ARTICLES_VENDUS VALUES (?,?,?,?,?,?,?,?)";
	private static final String INSERT_R = "INSERT INTO RETRAITS VALUES (?,?,?,?)";
	private static final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
	private static final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";
	private static final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, "
			+ "date_fin_encheres=?, prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=? WHERE no_article = ?";
	private static final String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?";

	@Override
	public void insert(ArticleVendu a) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(INSERT_A, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, a.getNomArticle());
			stmt.setString(2, a.getDescription());
			stmt.setTimestamp(3, Timestamp.valueOf(a.getDateDebutEncheres()));
			stmt.setTimestamp(4, Timestamp.valueOf(a.getDateFinEncheres()));
			stmt.setInt(5, a.getMiseAPrix());
			stmt.setInt(6, a.getPrixVente());
			stmt.setInt(7, a.getVendeur());
			stmt.setInt(8, a.getCategorie());
			int nb = stmt.executeUpdate();
			if (nb > 0) { // Si la requete a bien recuperee une cle, on l'attribue au nouvel objet
				ResultSet rsk = stmt.getGeneratedKeys();
				if (rsk.next()) {
					a.setNoArticle(rsk.getInt(1));
				}
			}
			PreparedStatement stmt2 = connection.prepareStatement(INSERT_R);
			stmt2.setInt(1, a.getNoArticle());
			stmt2.setString(2, a.getLieuRetrait().getRue());
			stmt2.setString(3, a.getLieuRetrait().getCode_postal());
			stmt2.setString(4, a.getLieuRetrait().getVille());
			stmt2.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Probleme d'accès à la base de données");
		}
	}

	@Override
	public ArticleVendu selectById(Integer id) throws SQLException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next(); // Passage à la première (et dernière) ligne du résultat de requête
			ArticleVendu a = new ArticleVendu();
			a.setNoArticle(rs.getInt("no_article"));
			a.setNomArticle(rs.getString("nom_article"));
			a.setDescription(rs.getString("description"));
			a.setDateDebutEncheres(rs.getTimestamp("date_debut_encheres").toLocalDateTime());
			a.setDateFinEncheres(rs.getTimestamp("date_fin_encheres").toLocalDateTime());
			a.setMiseAPrix(rs.getInt("prix_initial"));
			a.setPrixVente(rs.getInt("prix_vente"));
			a.setVendeur(rs.getInt("no_utilisateur"));
			a.setCategorie(rs.getInt("no_categorie"));
			return a;
		} catch (SQLException e) {
			throw new SQLException("Probleme d'accès à la base de données");
		}
	}

	@Override
	public List<ArticleVendu> selectAll() {
		List<ArticleVendu> retour = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticleVendu a = new ArticleVendu();
				a.setNoArticle(rs.getInt("no_article"));
				a.setNomArticle(rs.getString("nom_article"));
				a.setDescription(rs.getString("description"));
				a.setDateDebutEncheres(rs.getTimestamp("date_debut_encheres").toLocalDateTime());
				a.setDateFinEncheres(rs.getTimestamp("date_fin_encheres").toLocalDateTime());
				a.setMiseAPrix(rs.getInt("prix_initial"));
				a.setPrixVente(rs.getInt("prix_vente"));
				a.setVendeur(rs.getInt("no_utilisateur"));
				a.setCategorie(rs.getInt("no_categorie"));
				retour.add(a);
			}
			return retour;
		} catch (SQLException e) {
			System.err.println("Probleme d'accès à la base de données");
		}

		return null;
	}

	@Override
	public void update(ArticleVendu a) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(UPDATE);
			stmt.setString(1, a.getNomArticle());
			stmt.setString(2, a.getDescription());
			stmt.setTimestamp(3, Timestamp.valueOf(a.getDateDebutEncheres()));
			stmt.setTimestamp(4, Timestamp.valueOf(a.getDateFinEncheres()));
			stmt.setInt(5, a.getMiseAPrix());
			stmt.setInt(6, a.getPrixVente());
			stmt.setInt(7, a.getVendeur());
			stmt.setInt(8, a.getCategorie());
			stmt.setInt(9, a.getNoArticle());
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
