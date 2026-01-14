package week2.education.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    boolean add(T t);
    boolean delete(int id);
    boolean update(T t);

}
