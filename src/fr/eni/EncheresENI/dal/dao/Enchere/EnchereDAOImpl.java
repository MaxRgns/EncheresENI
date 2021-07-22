package fr.eni.EncheresENI.dal.dao.Enchere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.eni.EncheresENI.bo.Enchere;
import fr.eni.EncheresENI.dal.ConnectionProvider;

public class EnchereDAOImpl implements EnchereDAO {
	private static final String INSERT = "INSERT INTO ENCHERES VALUES (?,?,?,?)";
	private static final String SELECT_BY_ARTICLE = "SELECT * FROM ENCHERES WHERE no_article = ?";

	@Override
	public void insert(Enchere ench) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(INSERT);
			stmt.setInt(1, ench.getEncherisseur());
			stmt.setInt(2, ench.getArticle());
			stmt.setTimestamp(3, Timestamp.valueOf(ench.getDateEnchere()));
			stmt.setInt(4, ench.getMontant_enchere());
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Probleme d'accès à la base de données");
		}
	}
	
	@Override
	public List<Enchere> selectByArticle( Integer id) throws SQLException {
		List<Enchere> retour = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ARTICLE);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Enchere e = new Enchere();
				e.setDateEnchere(rs.getTimestamp("date_enchere").toLocalDateTime());
				e.setMontant_enchere(rs.getInt("montant_enchere"));
				e.setEncherisseur(rs.getInt("no_utilisateur"));
				e.setArticle(rs.getInt("no_article"));
				retour.add(e);
			}
			return retour;
		}
	}
}
