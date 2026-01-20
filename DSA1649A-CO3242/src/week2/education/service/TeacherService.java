package week2.education.service;

import week2.education.model.Teacher;
import week2.education.model.User;
import week2.education.repository.TeacherRepository;

import java.util.List;

public class TeacherService implements IService<Teacher>{
    TeacherRepository teacherRepository = new TeacherRepository();
    @Override
    public void findAll(){
        List<Teacher> teachers = teacherRepository.findAll();
        if (teachers.isEmpty()) {
            System.out.println("Teacher list is empty!");
        } else {
            for (Teacher teacher :teachers) {
                System.out.println(teacher);
            }
        }
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
