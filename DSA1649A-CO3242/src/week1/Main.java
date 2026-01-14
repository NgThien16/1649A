package week1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your birth year: ");
        int birthYear = Integer.parseInt(scanner.nextLine());
        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("Hello "+name+" "+(2026-birthYear)+" year old!");
        sayHello("Thien");
        sayHello("Thien", 10);


    }
    public static void sayHello(String name){
        System.out.println(name);
    }

    public static void sayHello(String name, int age){
        System.out.println("Hello "+name+" "+age+" year old!");
    }
}
