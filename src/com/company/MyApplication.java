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
        System.err.println("(Aika <-> Aika123, Maks <-> Maks123), usertest <-> usertest123");
        while (true) {
            System.out.println("< - - - New process... - - - >");
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
            } else if(option==2){
                System.out.println("Enter login:");
                String login = scanner.next();
                System.out.println("Enter password:");
                String password = scanner.next();
                if (hasUser(login, password) == true) {
                    if (isAdmin(login, password) == true) {
                        System.out.println("Welcome, admin!");
                        admin();
                    } else if (isAdmin(login, password) == false) {
                        ////////////////////////////////////////////////////////////
                        user();
                        ////////////////////////////////////////////////////////////
                    }
                } else if (hasUser(login, password) == false) {
                    System.err.println("Error!");
                    start();
                }
            } else {
                System.err.println("Error!");
                start();
            }
        }
    }

    public boolean hasUser(String login , String password) {
        boolean response = controller.hasUser(login, password);
        return response;
    }
    public boolean isAdmin(String login, String password){
        boolean response = controller.hasUser(login, password);
        return response;
    }
    public void admin(){
        while (true) {
            System.out.println("< - - - New process... - - - >");
            System.out.println("Select option: (1-6)");
            System.out.println("1. Get all users");
            System.out.println("2. Get all places");
            //////////////////////////////////////////////////////////////////////
//            GET ALL PlACES
            //////////////////////////////////////////////////////////////////////
            System.out.println("3. Add new user");
            System.out.println("4. Add new place");
            System.out.println("5. Remove user by ID");
            System.out.println("6. Remove place by ID");
            System.out.println("0. Exit from admin");
            int option = scanner.nextInt();
            if(option==1){
                getAllUsers();
            } else if(option==2){
                getAllPlaces();
            } else if(option==3){
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
            } else if(option==4){
                addPlace();
            } else if(option==5){
                removeUserById();
            } else if(option==6){
                removePlaceById();
            } else if(option==0){
                start();
            } else {
                System.err.println("This option isn't exists. Please, enter again:");
            }
        }
    }
    public void user(){
        while (true) {
            System.out.println("< - - - New process... - - - >");
            System.out.println("Select option: (1-4)");
            System.out.println("1. Get all orders");
            System.out.println("2. Get all places");
            //////////////////////////////////////////////////////////////////////
//            GET ALL PlACES
            //////////////////////////////////////////////////////////////////////
            System.out.println("3. Add new order");
            System.out.println("4. Remove order");
            System.out.println("0. Exit from user");
            int option = scanner.nextInt();
            if(option==1){
                getAllOrders();
            } else if(option==2){
                getAllPlaces();
            } else if(option==3){
                getAllOrders();
                addNewOrder();
            } else if(option==4){
                removeOrder();
            } else if(option==0){
                start();
            } else {
                System.err.println("This option isn't exists. Please, enter again:");
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
            System.err.println("Didn't registered!");
        }
    }
    public void removeUserById(){
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        String response = controller.removeUserById(id);
        System.out.println(response);
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
        if (response == true ) {
            System.out.println("Added!");
        } else {
            System.err.println("Didn't Add!");
        }
    }
    public void removePlaceById(){
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        String response = controller.removePlaceById(id);
        System.out.println(response);
    }
    public void getAllOrders(){
        String response = controller.getAllOrders();
        System.out.println(response);
    }
    public void addNewOrder(){
        System.out.println("Please, enter a place, where you want to go: ");
        String whereTo = scanner.next();
        System.out.println("Please, enter a place, from you are going: ");
        String whereFrom = scanner.next();
        System.out.println("Please, enter total amount of day: ");
        int totalDay = scanner.nextInt();
        System.out.println("Enter your login: ");
        String login = scanner.next();
        String response = controller.isAddedOrder(whereTo, whereFrom, login, totalDay);
        System.out.println(response);
    }
    public void removeOrder(){
        System.out.println("Enter your login: ");
        String login = scanner.next();
        System.out.println("Enter place where you wanted go: ");
        String whereTo = scanner.next();
        System.out.println("Enter place from where you wanted go: ");
        String whereFrom = scanner.next();
        String response = controller.isRemoved(login, whereTo, whereFrom);
        System.out.println(response);
    }
    public void getAllPlaces(){
        String response = controller.getAllPlaces();
        System.out.println(response);
    }

////////////////////////////////////////////////////////////////////
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
