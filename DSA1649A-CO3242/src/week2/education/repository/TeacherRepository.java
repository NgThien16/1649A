package week2.education.repository;

import week2.education.model.Teacher;
import week2.education.model.User;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository extends UserRepository
        implements IRepository<Teacher> {

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Teacher) {
                teachers.add((Teacher) user);
            }
        }
        return teachers;
    }

    @Override
    public boolean add(Teacher teacher) {
        return userList.add(teacher);
    }

    @Override
    public boolean delete(int id) {
        return userList.removeIf(
                u -> u instanceof Teacher && u.getId() == id
        );
    }

    @Override
    public boolean update(Teacher teacher) {
        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            if (u instanceof Teacher && u.getId() == teacher.getId()) {
                userList.set(i, teacher);
                return true;
            }
        }
        return false;
    }
}

