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
//            System.err.println("\nAdmin:\n    Login: admin\n    Password: admin12345\n----------\nDeveloper: \n    Login: dev\n    Password: dev12345");
            System.out.println("");
            System.out.println("Welcome to my application");
            System.out.println("Select option: (1-3)");
            System.out.println("1. Registration");
            System.out.println("2. Login");
            int option = scanner.nextInt();
            if(option==1){
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("Create login: ");
                String login = scanner.next();
                System.out.println("Enter password");
                String password = scanner.next();
                if (hasUser(login, password) == true) {
                    System.err.println("This account already exists!");
                } else {
                    addNewUser(name, login, password);
                }
            }
            if(option==2){
                System.out.println("Enter login:");
                String login = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();
                if (hasUser(login, password) == true) {
                    if (isAdmin(login, password) == true) {
                        System.out.println("Welcome, admin!");
                        admin();
                    } else if (isAdmin(login, password) == false) {
                        ////////////////////////////////////////////////////////////
//                        user();
                        ////////////////////////////////////////////////////////////
                    }
                } else if (hasUser(login, password) == false) {
                    System.err.println("Error!");
                    start();
                }
            }
        }
    }

    public boolean hasUser(String login , String password) {
        boolean response = controller.hasUser(login, password);
        return response;
    }
//    public void isRegistered(String name, String login){
//        String response = controller.isRegistered(name, login);
//        System.out.println(response);
//    }
    public boolean isAdmin(String login, String password){
        boolean response = controller.hasUser(login, password);
        return response;
    }
    public void admin(){
        System.out.println("Select option: (1-3)");
        System.out.println("1. Get all users");
        System.out.println("2. Add new user");
        System.out.println("3. Remove user by ID");
        while (true) {
            int option = scanner.nextInt();
            if(option==1){
                getAllUsers();
            } else if(option==2){
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("Create login: ");
                String login = scanner.next();
                System.out.println("Enter password");
                String password = scanner.next();
                addNewUser(name, login, password);
            } else if(option==3){
                removeUserById();
            } else {
                System.out.println("This option isn't exists. Please, enter again:");
            }
        }
    }
    public void getAllUsers(){
        String response = controller.getAllUsers();
        System.out.println(response);
    }
    public void addNewUser(String name, String login, String password){
        LocalDate regDate = LocalDate.now();
        boolean response = controller.addUser(name, login, password, regDate);
        if (response == true ) {
            System.out.println("Registered!");
        } else {
            System.out.println("Didn't registered!");
        }
    }
    public void removeUserById(){
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        String response = controller.removeUserById(id);
        System.out.println(response);
    }

////////////////////////////////////////////////////////////////////
//    public boolean addPlaceTravel() {
//
//    }



//    public void user() {
//
//    }
////////////////////////////////////////////////////////////////////






//    public void addOrder() {
//        System.out.println("Enter where from: ");
//        String city1 = scanner.next();
//        System.out.println("Enter from to: ");
//        String city2 = scanner.next();
//        System.out.println("how many days: ");
//        int days = scanner.nextInt();
//        boolean response = controller.addOrder(city1, city2, days);
//        if (response == true) {
//            System.out.println("Added!");
//        } else {
//            System.out.println("Not added!");
//        }
////        System.out.println(response);
//    }


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
