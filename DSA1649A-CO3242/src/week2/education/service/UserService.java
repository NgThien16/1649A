package week2.education.service;

import week2.education.model.Teacher;
import week2.education.model.User;
import week2.education.repository.UserRepository;

import java.util.List;

public class UserService {
    UserRepository userRepository = new UserRepository();
    public void findAll(){
        List<User> users = userRepository.getAll();
        if (users.isEmpty()) {
            System.out.println("User list is empty!");
        } else {
            for (User user :users) {
                System.out.println(user);
            }
        }
    }

}
