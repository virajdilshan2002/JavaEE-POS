package dao;

import java.util.List;

public interface CrudDAO<T> {
    List<T> getAll();
    boolean add(T entity);
    boolean update(T entity);
    String generateNewID();
    boolean delete(String id);
}
