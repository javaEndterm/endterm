package com.company;

import com.company.controllers.AllControllers;
import java.sql.Date;
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
        System.err.println("(Aika <-> Aika123, Maks <-> Maks123), usertest <-> usertest123, test <-> test123");
        while (true) {
            System.out.println("< - - - New process... - - - >");
            System.out.println("Welcome to my application");
            System.out.println("Select option: (1-2)");
            System.out.println("1. Registration");
            System.out.println("2. Login");
            System.out.println("0. Close program");
            int option = scanner.nextInt();
            if (option == 1) {
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("Create login: ");
                String login = scanner.next();
                System.out.println("Enter password");
                String password = scanner.next();
                if (hasUser(login, password)) {
                    System.err.println("This account already exists!");
                } else {
                    addNewUser(name, login, password);
                }
            } else if (option == 2) {
                System.out.println("Enter login:");
                String login = scanner.next();
                System.out.println("Enter password:");
                String password = scanner.next();
                if (hasUser(login, password)) {
                    if (isAdmin(login, password)) {
                        System.out.println("Welcome, admin!");
                        admin();
                    } else if (!isAdmin(login, password)) {
                        user();
                    }
                } else if (!hasUser(login, password)) {
                    System.err.println("Error!");
                    start();
                }
            } else if (option == 0) {
                System.exit(0);
            } else {
                System.err.println("Error!");
                start();
            }
        }
    }



    public boolean hasUser(String login, String password) {
        return controller.hasUser(login, password);
    }

    public boolean isAdmin(String login, String password) {
        return controller.isAdmin(login, password);
    }

    ///

    public void admin() {
        while (true) {
            System.out.println("< - - - New process... - - - >");
            System.out.println("Select option: (1-9)");
            System.out.println("1. Get all users");
            System.out.println("2. Add new user");
            System.out.println("3. Add new place");
            System.out.println("4. Remove user by ID");
            System.out.println("5. Remove place by ID");
            System.out.println("6. Get all orders");
            System.out.println("7. Add new order");
            System.out.println("8. Remove order");
            System.out.println("9. Get all places");
            System.out.println("0. Exit from admin");
            int option = scanner.nextInt();
            if (option == 1) {
                getAllUsers();
            } else if (option == 2) {
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("Create login: ");
                String login = scanner.next();
                System.out.println("Enter password");
                String password = scanner.next();
                if (hasUser(login, password)) {
                    System.err.println("This account already exists!");
                } else {
                    addNewUser(name, login, password);
                }
            } else if (option == 3) {
                addPlace();
            } else if (option == 4) {
                removeUserById();
            } else if (option == 5) {
                removePlaceById();
            } else if (option == 6) {
                getAllOrders();
            } else if (option == 7) {
                addNewOrder();
            } else if (option == 8) {
                removeOrder();
            } else if (option == 9) {
                getAllPlaces();
            } else if (option == 0) {
                start();
            } else {
                System.err.println("This option isn't exists. Please, enter again:");
            }
        }
    }

    public void user() {
        while (true) {
            System.out.println("< - - - New process... - - - >");
            System.out.println("Select option: (1-4)");
            System.out.println("1. Get my orders");
            System.out.println("2. Get all places");
            System.out.println("3. Add new order");
            System.out.println("4. Remove order");
            System.out.println("0. Exit from user");
            int option = scanner.nextInt();
            if (option == 1) {
                System.out.println("Enter your login");
                String login = scanner.next();
                getOrdersForUserByLogin(login);
            } else if (option == 2) {
                getAllPlaces();
                addNewOrder();
            } else if (option == 3) {
                removeOrder();
            } else if (option == 0) {
                start();
            } else {
                System.err.println("This option isn't exists. Please, enter again:");
            }
        }
    }

    ///

    public void getAllUsers() {
        String response = controller.getAllUsers();
        System.out.println(response);
    }

    public void getAllOrders() {
        String response = controller.getAllOrders();
        System.out.println(response);
    }

    public void getOrdersForUserByLogin(String login) {
        String response = controller.getOrdersForUserByLogin(login);
        System.out.println(response);
    }

    public void getAllPlaces() {
        String response = controller.getAllPlaces();
        System.out.println(response);
    }

    ///

    public void addNewUser(String name, String login, String password) {
        LocalDate regDate = LocalDate.now();
        boolean response = controller.addUser(name, login, password, regDate);
        if (response) {
            System.out.println("Registered!");
        } else {
            System.err.println("Didn't registered!");
        }
    }

    public void addNewOrder() {
        System.out.println("Please, enter a place, from you are going: ");
        String whereFrom = scanner.next();
        System.out.println("Please, enter a place, where you want to go: ");
        String whereTo = scanner.next();
        System.out.println("Enter your login: ");
        String login = scanner.next();
        boolean hasLogin = controller.hasLogin(login);
        boolean response = controller.isExistsOrder(whereFrom, whereTo, login);
        String resp;
        if (!response && hasLogin) {
            System.out.println("For how many days?");
            int days = scanner.nextInt();
            resp = controller.addOrder(whereFrom, whereTo, login, days);
            System.out.println(resp);
        } else if (!hasLogin) {
            resp = "Error! Login mistake";
            System.err.println(resp);
        } else {
            resp = "Error! Order exists";
            System.err.println(resp);
        }
    }

    public void addPlace() {
        System.out.println("Name:");
        String name = scanner.next();
        System.out.println("Starting date: ");
        Date starting_date = Date.valueOf(scanner.next());
        System.out.println("Reiteration (every...)");
        String reiteration = scanner.next();
        System.out.println("Price per day");
        int price = scanner.nextInt();
        boolean response = controller.addPlace(name, starting_date, reiteration, price);
        if (response) {
            System.out.println("Added!");
        } else {
            System.err.println("Didn't Add!");
        }
    }

    ///

    public void removeUserById() {
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        String response = controller.removeUserById(id);
        System.out.println(response);
    }

    public void removeOrder() {
        System.out.println("Enter your login: ");
        String login = scanner.next();
        System.out.println("Enter place from where you wanted go: ");
        String whereFrom = scanner.next();
        System.out.println("Enter place where you wanted go: ");
        String whereTo = scanner.next();
        boolean response = controller.isExistsOrder(whereFrom, whereTo, login);
        String resp;
        if (!response) {
            resp = "There aren't any orders like this!";
            System.err.println(resp);
        } else {
            resp = controller.removeOrder(whereFrom, whereTo, login);
            System.out.println(resp);
        }
    }

//    public void removeOrderById() {
//        System.out.println("Enter your login: ");
//        String login = scanner.next();
//        System.out.println("Enter place from where you wanted go: ");
//        String whereFrom = scanner.next();
//        System.out.println("Enter place where you wanted go: ");
//        String whereTo = scanner.next();
//        boolean response = controller.isExistsOrder(whereFrom, whereTo, login);
//        String resp;
//        if (response == false) {
//            resp = "There aren't any orders like this!";
//            System.err.println(resp);
//        } else {
//            resp = controller.removeOrder(whereFrom, whereTo, login);
//            System.out.println(resp);
//        }
//    }

    public void removePlaceById() {
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        String response = controller.removePlaceById(id);
        System.out.println(response);
    }
}