package com.company;

import com.company.controllers.AllControllers;

import java.sql.Date;
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
//            System.err.println("\nAdmin:\n    Login: admin\n    Password: admin12345\n----------\nDeveloper: \n    Login: dev\n    Password: dev12345");
            System.out.println("");
            System.out.println("Welcome to my application");
            System.out.println("Enter login:");
            String login = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();
            if (hasUser(login, password) == true) {
                System.out.println("hasUser");
                //true == correct
//                if (isAdmin(login, password) == true) {
//                    //Admin functions
//                } else {
//                    //User functions
//                }
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

//    public boolean isAdmin(String login , String password) {
//        boolean response = controller.isAdmin();
//        return response;
//    }

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
