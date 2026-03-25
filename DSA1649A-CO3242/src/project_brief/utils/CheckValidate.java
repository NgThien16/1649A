package project_brief.utils;

import project_brief.library.ArrayListADT;
import project_brief.model.User;

public class CheckValidate {
    //check title
    public static boolean checkTitle(String title) {
        String regexTitle = "^[A-Z][a-z]+(\s[A-Z][a-z]+)*$";
        return title.matches(regexTitle);
    }
    // check name
    public static boolean checkName(String name) {
        String regexName = "^[A-Z][a-z]+(\s[A-Z][a-z]+)+$";
        return name.matches(regexName);
    }
    //check author name
    public static boolean checkAuthor(String author) {
        String regexAuthor = "^[A-Z][a-z]+(\s[A-Z][a-z]+)+$";
        return author.matches(regexAuthor);
    }
    // 3. Email
    public static boolean checkEmail(String email) {
        String regexEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return email != null && email.matches(regexEmail);
    }

    // 4. Phone Number (Đầu số Việt Nam 10 chữ số)
    public static boolean checkPhoneNumber(String phone) {
        String regexPhone = "^0[0-9]{9}$";
        return phone != null && phone.matches(regexPhone);
    }

    // 5. Address (Cho phép chữ, số, dấu phẩy, gạch ngang và khoảng trắng)
    public static boolean checkAddress(String address) {
        return address != null && address.trim().length() >= 5;
    }

    // 6. Username (Check trùng lặp)
    public static boolean isUsernameExists(String username, ArrayListADT<User> userList) {
        if (username == null || username.isEmpty()) return true;

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkPassword(String password) {
        return password != null && password.length() >= 6;
    }


}
