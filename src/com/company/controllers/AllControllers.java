package com.company.controllers;


import com.company.entities.*;
import com.company.repositories.interfaces.IAllRepositories;

import java.time.LocalDate;
import java.util.List;

public class AllControllers {
    private final IAllRepositories repository;

    public AllControllers(IAllRepositories repository) {
        this.repository = repository;
    }

    public boolean hasUser(String login, String password) {
        boolean hasUser = repository.hasUser(login, password);
        return hasUser;
    }

//    public String isRegistered(String name, String surname, String login, LocalDate regDate, String wantTo, LocalDate atDate) {
//        boolean isRegistered = repository.isRegistered(name, surname, login, regDate, wantTo, atDate);
//        return isRegistered==true ? "You have registered!" : "Registration is failed!";
//    }

    public boolean addUser(String name, String login, String password, LocalDate regDate){
        boolean isAdded = repository.addUser(name, login, password, regDate);
        return isAdded;
    }
    public String removeUserById(int id){
        boolean isRemoved = repository.removeUser(id);
        return isRemoved==true ? "User is deleted!" : "User deletion is failed!";
    }
    public String getAllUsers(){
        List<LogIn> users = repository.getAllUsers();
        return users == null ? "Fail!" : users.toString();
    }

//    public boolean addOrder(String city1, String city2, int days) {
//        boolean added = repository.addOrder(city1, city2, days);
//        return added;
//    }

//    public String getAll() {
//        List<Front> fronts = repository.getAllFront();
//        List<Back> backs = repository.getAllBack();
//        List<String> allList = new LinkedList<>();
//        allList.add(fronts.toString());
//        allList.add(backs.toString());
//        return allList.toString();
//    }
//
//    public String getAllFront() {
//        List<Front> fronts = repository.getAllFront();
//        return fronts.toString();
//    }
//
//    public String getAllBack() {
//        List<Back> backs = repository.getAllBack();
//        return backs.toString();
//    }
//
//    public boolean addFront(String f_name, int age, Date started_working, int level, int salary) {
//        Front front = new Front(f_name, age, started_working, level, salary);
//        boolean created = repository.addFront(front);
//        return (created ? true : false);
//    }
//
//    public boolean addBack(String f_name, int age, Date started_working, int level, int salary) {
//        Back back = new Back(f_name, age, started_working, level, salary);
//        boolean created = repository.addBack(back);
//        return (created ? true : false);
//    }
//
//    public void deleteFront(int id) {
//        try {
//            if(repository.deleteFront(id)){
//                System.out.println("Deleted");
//            }else{
//                System.out.println("Failed");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void deleteBack(int id) {
//        try {
//            if(repository.deleteBack(id)){
//                System.out.println("Deleted");
//            }else{
//                System.out.println("Failed");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public int getSalary() {
//        int sumSalary = repository.getSalary();
//        return sumSalary;
//    }
}
