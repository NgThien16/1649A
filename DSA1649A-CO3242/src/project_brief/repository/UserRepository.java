package project_brief.repository;

import project_brief.library.ArrayListADT;
import project_brief.model.Role;
import project_brief.model.User;



public class UserRepository implements IUserRepository {
    private static ArrayListADT<User> userList = new ArrayListADT<>();
    static{
        userList.add(new User(1, "Nguyen Nhu Thien", "thien@gmail.com", "0901234567",
                "Ho Chi Minh", "thien", "123456", Role.STAFF));

        userList.add(new User(2, "Tran Van A", "vana@gmail.com", "0912345678",
                "Ha Noi", "vana02", "123456", Role.CUSTOMER));

        userList.add(new User(3, "Le Thi B", "thib@gmail.com", "0987654321",
                "Da Nang", "thib03", "123456", Role.CUSTOMER));
    }
    @Override
    public ArrayListADT<User> getUsers() {
        return userList;
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public User login(String username, String password) {

        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
