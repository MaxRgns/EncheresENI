package fr.eni.EncheresENI.dal.dao;

import java.util.List;

public interface DAO<T> {
	public void insert(T object);
	public T selectById(Integer id);
	public List<T> selectAll();
	public void update(T object);
	public void delete(T object);
}
