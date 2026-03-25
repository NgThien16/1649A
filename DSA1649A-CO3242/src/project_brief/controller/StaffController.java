package project_brief.controller;

import project_brief.model.User;

import java.util.Scanner;

public class StaffController {
    public static void showStaffMenu(User loggedInUser){
        Scanner scanner = new Scanner(System.in);
        BookController bookController = new BookController();
        OrderController orderController = new OrderController();

        boolean flag = true;
        while(flag){
            System.out.println("==========Book Store Management System==========");
            System.out.println("1. Book Management");
            System.out.println("2. Order Management System");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    boolean bookFlag = true;
                    while(bookFlag){
                        System.out.println("===========Book Management============");
                        System.out.println("1. Display All Book");
                        System.out.println("2. Add Book");
                        System.out.println("3. Search Book");
                        System.out.println("4. Delete Book");
                        System.out.println("5. Update Book");
                        System.out.println("6. Return main menu");
                        System.out.print("Your choice: ");
                        int bookChoice = Integer.parseInt(scanner.nextLine());
                        switch(bookChoice){
                            case 1:
                                bookController.displayAllBooks();
                                break;
                            case 2:
                                bookController.addBook();
                                break;
                            case 3:
                                bookController.searchBook();
                                break;
                            case 4:
                                bookController.deleteBook();
                                break;
                            case 5:
                                bookController.editBook();
                                break;
                            case 6:
                                bookFlag = false;
                                break;
                            default:
                                System.out.println("Your choice is incorrect! Please try again.");
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean orderFlag = true;
                    while(orderFlag){
                        System.out.println("===========Order Management============");
                        System.out.println("1. Display All Order");
                        System.out.println("2. Approve Order");
                        System.out.println("3. Return main menu");
                        System.out.print("Your choice: ");
                        int orderChoice = Integer.parseInt(scanner.nextLine());
                        switch(orderChoice){
                            case 1:
                                orderController.displayOrder();
                                break;
                            case 2:
                                orderController.approveOrder();
                                break;
                            case 3:
                                orderFlag = false;
                                break;
                            default:
                                System.out.println("Your choice is incorrect! Please try again.");
                                break;
                        }
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Your choice is incorrect! Please try again.");
                    break;
            }
        }
    }
}
