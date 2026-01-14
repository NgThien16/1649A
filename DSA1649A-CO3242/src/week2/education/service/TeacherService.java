package week2.education.service;

import week2.education.model.Teacher;
import week2.education.repository.TeacherRepository;

import java.util.List;

public class TeacherService implements IService<Teacher>{
    TeacherRepository teacherRepository = new TeacherRepository();
    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public boolean add(Teacher teacher) {
        return teacherRepository.add(teacher);
    }

    @Override
    public boolean delete(int id) {
        return teacherRepository.delete(id);
    }

    @Override
    public boolean update(Teacher teacher) {
        return false;
    }
}
