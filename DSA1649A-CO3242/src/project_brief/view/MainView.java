package project_brief.view;

import project_brief.controller.CustomerController;
import project_brief.controller.StaffController;
import project_brief.model.Role;
import project_brief.model.User;
import project_brief.repository.IUserRepository;
import project_brief.repository.UserRepository;
import project_brief.utils.CheckValidate;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        StaffController staffController = new StaffController();
        CustomerController customerController = new CustomerController();
        IUserRepository userRepository = new UserRepository();
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n========= BOOKSTORE SYSTEM =========");
            System.out.println("1. Login");
            System.out.println("2. Register (For Customers)");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleLogin(userRepository, staffController, customerController, scanner);
                    break;
                case "2":
                    handleRegister(userRepository, scanner);
                    break;
                case "3":
                    isRunning = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    private static void handleLogin(IUserRepository repo, StaffController staffCtrl, CustomerController custCtrl, Scanner sc) {
        System.out.println("\n--- Login ---");
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        User loggedInUser = repo.login(user, pass);

        if (loggedInUser != null) {
            System.out.println("Login Successfully! Hi " + loggedInUser.getName());
            if (loggedInUser.getRole() == Role.STAFF) {
                staffCtrl.showStaffMenu(loggedInUser);
            } else if (loggedInUser.getRole() == Role.CUSTOMER) {
                custCtrl.showCustomerMenu(loggedInUser);
            }
        } else {
            System.out.println("Wrong username or password!");
        }
    }


    private static void handleRegister(IUserRepository repo, Scanner sc) {
        System.out.println("\n--- Register New Account ---");

        int newId = repo.getUsers().size() + 1;
        String name, email, phone, address, username, password;


        do {
            System.out.print("Enter your full name (Ex: Nguyen Van A): ");
            name = sc.nextLine();
            if (!CheckValidate.checkName(name)) {
                System.out.println("Invalid name! (First letters must be capitalized, at least 2 words)");
            }
        } while (!CheckValidate.checkName(name));

        do {
            System.out.print("Enter your email: ");
            email = sc.nextLine();
            if (!CheckValidate.checkEmail(email)) {
                System.out.println("Invalid email format! (Ex: abc@gmail.com)");
            }
        } while (!CheckValidate.checkEmail(email));

        do {
            System.out.print("Enter your phone number (10 digits starting with 0): ");
            phone = sc.nextLine();
            if (!CheckValidate.checkPhoneNumber(phone)) {
                System.out.println("Invalid phone number!");
            }
        } while (!CheckValidate.checkPhoneNumber(phone));

        do {
            System.out.print("Enter your address (at least 5 characters): ");
            address = sc.nextLine();
            if (!CheckValidate.checkAddress(address)) {
                System.out.println("Address is too short!");
            }
        } while (!CheckValidate.checkAddress(address));

        do {
            System.out.print("Enter username: ");
            username = sc.nextLine();
            if (username.isEmpty()) {
                System.out.println("Username cannot be empty!");
            } else if (CheckValidate.isUsernameExists(username, repo.getUsers())) {
                System.out.println("Username already exists! Please choose another one.");
            } else {
                break;
            }
        } while (true);

        do {
            System.out.print("Enter password (at least 6 characters): ");
            password = sc.nextLine();
            if (!CheckValidate.checkPassword(password)) {
                System.out.println("Password too short! Must be at least 6 characters.");
            }
        } while (!CheckValidate.checkPassword(password));

        User newUser = new User(newId, name, email, "", "", username, password, Role.CUSTOMER);

        repo.addUser(newUser);
        System.out.println("Registration successful! You can login now.");
    }
}