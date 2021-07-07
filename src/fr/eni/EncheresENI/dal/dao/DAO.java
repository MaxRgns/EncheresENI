package fr.eni.EncheresENI.dal.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
	public void insert(T object);
	public T selectById(Integer id) throws SQLException;
	public List<T> selectAll();
	public void update(T object);
	public void delete(T object);
}
