package com.company;

import com.company.controllers.AllControllers;

import java.time.LocalDate;
import java.util.Scanner;

public class MyApplication {
    private final AllControllers controller;
    private final Scanner scanner;

    public MyApplication(AllControllers controller) {
        scanner = new Scanner(System.in);
        this.controller = controller;
    }

    public void start() {
        while (true) {
            System.err.println("\nAdmin:\n    Login: Aika\n    Password: Aika12345\n    Login: Maks\n    Password: Maks12345\n----------\nUser: \n    Login: usertest\n    Password: usertest123");
            System.out.println("");
            System.out.println("Welcome to my application");
            System.out.println("Select option: (1-2)");
            System.out.println("1. Registration");
            System.out.println("2. Login");
            int option = scanner.nextInt();
            if(option==1){
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("Enter surname: ");
                String surname = scanner.next();
                System.out.println("Create login: ");
                String login = scanner.next();
                System.out.println("Enter where you want to go: ");
                String wantTo = scanner.next();
                System.out.println("Enter date when you want to go: ");
                LocalDate atDate = LocalDate.parse(scanner.next());
                LocalDate regDate = LocalDate.now();
                isRegistered(name, surname, login, regDate, wantTo, atDate);
            }
            System.out.println("Enter login:");
            String login = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();
            if (hasUser(login, password) == true) {
                System.out.println("hasUser");
                //true == correct
                if (isAdmin(login, password) == true) {
                    //Admin functions
                    System.out.println("Admin");
                } else {
                    //User functions
                    System.out.println("not Admin");
                }
            } else if (hasUser(login, password) == false) {
                //false == isn't correct
                System.err.println("Error!");
                start();
            }
//            if (login.equals("admin") && password.equals("admin12345")) {
//                Director_start();
//            } else if (login.equals("dev") && password.equals("dev12345")) {
//                System.out.println("1. Front-end \n2. Back-end");
//                int choice = scanner.nextInt();
//                if (choice == 1) {
//                    Front_start();
//                } else if (choice == 2) {
//                    Back_start();
//                } else {
//                    System.out.println("Error");
//                }
//            } else {
//                System.out.println("Error");
//            }
        }
    }

    public boolean hasUser(String login , String password) {
        boolean response = controller.hasUser(login, password);
        return response;
    }
    public void isRegistered(String name, String surname, String login, LocalDate regDate, String wantTo, LocalDate atDate){
        String response = controller.isRegistered(name, surname, login, regDate, wantTo, atDate);
        System.out.println(response);
    }

    public boolean isAdmin(String login , String password) {
        boolean response = controller.isAdmin(login, password);
        return response;
    }

//    public void Director_start () {
//        while (true) {
//            System.out.println("Select option (0-7)");
//            System.out.println("0. Get All Developers");
//            System.out.println("1. Get Front-end Developers");
//            System.out.println("2. Get Back-end Developers");
//            System.out.println("");
//            System.out.println("3. Add Front-end Developer");
//            System.out.println("4. Add Back-end Developer");
//            System.out.println("");
//            System.out.println("5. Delete from Front-end by ID");
//            System.out.println("6. Delete from Back-end by ID");
//            System.out.println("");
//            System.out.println("7. Get all sum of Salary");
//            System.out.println("-1. Close account");
//            System.out.println("---------------------------");
//            Scanner scanner = new Scanner(System.in);
//            int option = scanner.nextInt();
//            if (option == 0) {
//                String response = controller.getAll();
//                System.out.println(response);
//            } else if (option == 1) {
//                String response = controller.getAllFront();
//                System.out.println(response);
//            } else if (option == 2) {
//                String response = controller.getAllBack();
//                System.out.println(response);
//            } else if (option == 3) {
//                System.out.println("Enter first name:");
//                String name = scanner.next();
//                System.out.println("Age:");
//                int age = scanner.nextInt();
//                System.out.println("Started working date:");
//                Date date = Date.valueOf(scanner.next());
//                System.out.println("Level:");
//                int lvl = scanner.nextInt();
//                System.out.println("Salary:");
//                int salary = scanner.nextInt();
//                boolean response = controller.addFront(name, age, date, lvl, salary);
//                System.out.println(response);
//            } else if (option == 4) {
//                System.out.println("Enter first name:");
//                String name = scanner.next();
//                System.out.println("Age:");
//                int age = scanner.nextInt();
//                System.out.println("Started working date:");
//                Date date = Date.valueOf(scanner.next());
//                System.out.println("Level:");
//                int lvl = scanner.nextInt();
//                System.out.println("Salary:");
//                int salary = scanner.nextInt();
//                boolean response = controller.addBack(name, age, date, lvl, salary);
//                System.out.println(response);
//            } else if (option == 5) {
//                System.out.println("Enter ID:");
//                int id = scanner.nextInt();
//                controller.deleteFront(id);
//            } else if (option == 6) {
//                System.out.println("Enter ID:");
//                int id = scanner.nextInt();
//                controller.deleteBack(id);
//            } else if (option == 7) {
//                int response = controller.getSalary();
//                System.err.println("\nSum of salary: " + response + '\n');
//            } else {
//                break;
//            }
//        }
//    }
//
//    public void Front_start() {
//        while (true) {
//            System.out.println("Select option (0-1)");
//            System.out.println("0. Get All Developers");
//            System.out.println("1. Get Front-end Developers");
//            System.out.println("-1. Close account");
//            System.out.println("---------------------------");
//            Scanner scanner = new Scanner(System.in);
//            int option = scanner.nextInt();
//            if (option == 0) {
//                String response = controller.getAll();
//                System.out.println(response);
//            } else if (option == 1) {
//                String response = controller.getAllFront();
//                System.out.println(response);
//            } else {
//                break;
//            }
//        }
//    }
//
//    public void Back_start () {
//        while (true) {
//            System.out.println("Select option (0-1)");
//            System.out.println("0. Get All Developers");
//            System.out.println("1. Get Back-end Developers");
//            System.out.println("-1. Close account");
//            System.out.println("---------------------------");
//            Scanner scanner = new Scanner(System.in);
//            int option = scanner.nextInt();
//            if (option == 0) {
//                String response = controller.getAll();
//                System.out.println(response);
//            } else if (option == 1) {
//                String response = controller.getAllBack();
//                System.out.println(response);
//            } else {
//                break;
//            }
//        }
//    }
}
