package week2.education.repository;

import week2.education.model.Administrator;
import week2.education.model.Student;
import week2.education.model.Teacher;
import week2.education.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    protected static List<User> userList = new ArrayList<>();

    static {
        userList.add(new Teacher(1,"David","0987654321","david@gmail.com",100,"Math","English"));
        userList.add(new Administrator(2,"John","0987654321","john@gmail.com",100,true,10));
        userList.add(new Student(3,"Nathan","0987654321","nathan@gmail.com","Physic","Math","English"));
        // userList.add(new Student(...));
        // userList.add(new Admin(...));
    }
    public List<User> getAll(){
        return userList;
    }
}

