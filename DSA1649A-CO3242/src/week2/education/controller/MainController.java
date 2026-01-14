package week2.education.controller;

import week2.education.model.Teacher;
import week2.education.service.TeacherService;
import week2.education.service.UserService;

import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void displayMenu(){
        UserService userService = new UserService();
        TeacherService  teacherService = new TeacherService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("---------Education System-----------");
            System.out.println("1. Add New User");
            System.out.println("2. View All Users");
            System.out.println("3. View User by Group");
            System.out.println("4. Edit User");
            System.out.println("5. Delete User");
            System.out.println("6. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    boolean addFlag = true;
                    while(addFlag){
                        System.out.println("Add New User");
                        System.out.println("1. Add Teacher");
                        System.out.println("2. Add Amin");
                        System.out.println("3. Add Student");
                        System.out.println("4. exit");
                        int add = Integer.parseInt(scanner.nextLine());
                        switch(add){
                            case 1:
                                System.out.println("input id");
                                int teacherId = Integer.parseInt(scanner.nextLine());
                                System.out.println("input name");
                                String name = scanner.nextLine();
                                System.out.println("input telephone");
                                String telephone = scanner.nextLine();
                                System.out.println("Input email");
                                String email = scanner.nextLine();
                                System.out.println("input salary");
                                double salary = Double.parseDouble(scanner.nextLine());
                                System.out.println("input subject 1");
                                String subject1 = scanner.nextLine();
                                System.out.println("input subject 2");
                                String subject2 = scanner.nextLine();
                                Teacher teacher = new Teacher(teacherId,name,telephone,email,salary,subject1,subject2);
                                teacherService.add(teacher);
                                break;
                            case 2:
                                // Add admin
                                break;

                            case 3:

                                break;
                            case 4:
                                addFlag =false;
                                break;
                            default:
                                System.out.println("Wrong input");
                                break;
                        }
                    }
                    break;
                case 2:
                    //list all
                    userService.findAll();
                    break;
                case 3:
                    //list by role
                    boolean listFlag = true;
                    while(listFlag){
                        System.out.println("Display Users by Group");
                        System.out.println("1. Display Teacher");
                        System.out.println("2. Display  Amin");
                        System.out.println("3. Display Student");
                        System.out.println("4. Exit");
                        int display = Integer.parseInt(scanner.nextLine());
                        switch(display){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                listFlag =false;
                                break;
                            default:
                                System.out.println("Wrong input");
                                break;
                        }
                    }
                    break;
                case 4:
                    //Edit
                    boolean editFlag = true;
                    while(editFlag){
                        System.out.println("Edit User");
                        System.out.println("1. Edit Teacher");
                        System.out.println("2. Edit Admin");
                        System.out.println("3. Edit Student");
                        System.out.println("4. Exit");
                        int edit = Integer.parseInt(scanner.nextLine());
                        switch(edit){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                editFlag =false;
                                break;
                            default:
                                System.out.println("Wrong input");
                                break;
                        }
                    }
                    break;
                case 5:
                    boolean deleteFlag = true;
                    while(deleteFlag){
                        System.out.println("Display Users by Group");
                        System.out.println("1. Display Teacher");
                        System.out.println("2. Display  Amin");
                        System.out.println("3. Display Student");
                        System.out.println("4. Exit");
                        int delete = Integer.parseInt(scanner.nextLine());
                        switch(delete){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                deleteFlag =false;
                                break;
                            default:
                                System.out.println("Wrong input");
                                break;
                        }
                    }
                    break;
                case 6:
                    flag = false;
                    System.out.println("Existing Sytems........");
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
}
