package project_brief.repository;

import project_brief.library.ArrayListADT;
import project_brief.model.User;

public interface IUserRepository {
    ArrayListADT<User> getUsers();
    void addUser(User user);
    User login(String username, String password);
}
