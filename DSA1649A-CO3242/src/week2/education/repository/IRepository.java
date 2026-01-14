package week2.education.repository;

import week2.education.model.Student;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    boolean add(T t);
    boolean delete(int id);
    boolean update(T t);
}
