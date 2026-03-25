package project_brief.controller;

import project_brief.model.User;

import java.util.Scanner;

public class CustomerController {
    public static void showCustomerMenu(User currentUser){
        Scanner scanner = new Scanner(System.in);
        BookController bookController = new BookController();
        OrderController orderController = new OrderController();

        boolean flag = true;
        while(flag){
            System.out.println("==========Book Store=========");
            System.out.println("1. Display Book Store");
            System.out.println("2. Search Book");
            System.out.println("3. Order Book");
            System.out.println("4. Your Order");
            System.out.println("5. Cancel Your Order");
            System.out.println("6. Confirm Your Order");
            System.out.println("7. Exit");
            System.out.print("Your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    boolean displayFlag = true;
                    while (displayFlag){
                        System.out.println("Do you want sort by title or author name?");
                        System.out.println("1. Display all books");
                        System.out.println("2. Sort by title");
                        System.out.println("3. Sort by author name");
                        System.out.println("4. Exit");
                        System.out.print("Your choice: ");
                        int displayChoice = Integer.parseInt(scanner.nextLine());
                        switch (displayChoice){
                            case 1:
                                bookController.displayAllBooks();
                                break;
                            case 2:
                                bookController.displayByTitle();
                                break;
                            case 3:
                                bookController.displayByAuthorName();
                                break;
                            case 4:
                                displayFlag = false;
                                break;
                            default:
                                System.out.println("Wrong choice! Try again.");
                                break;
                        }
                    }
                    break;
                case 2:
                    bookController.searchBook();
                    break;
                case 3:
                    bookController.displayAllBooks();
                    orderController.addOrder(currentUser);
                    break;
                case 4:
                    orderController.displayOrderForCustomer(currentUser);
                    break;
                case 5:
                    orderController.displayOrderForCustomer(currentUser);
                    orderController.cancelOrder(currentUser);
                    break;
                case 6:
                    orderController.displayOrderForCustomer(currentUser);
                    orderController.confirmReceived(currentUser);
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                    System.out.println("Your choice is incorrect! Please try again.");
                    break;
            }
        }
    }
}
