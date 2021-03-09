package com.company.controllers;


import com.company.entities.*;
import com.company.repositories.interfaces.IAllRepositories;

import java.sql.Date;
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

    public boolean isAdmin(String login, String password) {
        boolean isAdmin = repository.isAdmin(login, password);
        return isAdmin;
    }


    public String getAllUsers() {
        List<LogIn> users = repository.getAllUsers();
        return users == null ? "Fail!" : users.toString();
    }

    public String getAllOrders() {
        List<Order> orders = repository.getAllOrders();
        return orders == null ? "Not found!" : orders.toString();
    }

    public String getOrdersForUserByLogin(String login) {
        List<Order> orders = repository.getOrdersForUserByLogin(login);
        return orders == null ? "Not found!" : orders.toString();
    }


    public boolean addUser(String name, String login, String password, LocalDate regDate) {
        boolean isAdded = repository.addUser(name, login, password, regDate);
        return isAdded;
    }

    public boolean addPlace(String name, Date starting_date, String reiteration, int price) {
        boolean isAdded = repository.addPlace(name, starting_date, reiteration, price);
        return isAdded;
    }

    public String addOrder(String whereFrom, String whereTo, String login, int days) {

        Order order = new Order(whereFrom, whereTo, login, days);
        int price = order.calculatePrice(whereFrom, whereTo, days);

        boolean isAdded = repository.addOrder(whereFrom, whereTo, login, days, price);
        return isAdded == true ? "Order is added!" : "Order addition is failed!";
    }


    public String removeUserById(int id) {
        boolean isRemoved = repository.removeUser(id);
        return isRemoved == true ? "User is deleted!" : "User deletion is failed!";
    }

    public String removePlaceById(int id) {
        boolean isRemoved = repository.removePlace(id);
        return isRemoved == true ? "User is deleted!" : "User deletion is failed!";
    }

    public String removeOrder(String whereFrom, String whereTo, String login) {
        boolean isRemoved = repository.removeOrder(whereFrom, whereTo, login);
        return isRemoved == true ? "Order is deleted!" : "Order deletion is failed!";
    }


    public boolean isExistsOrder(String whereFrom, String whereTo, String login) {
        boolean isExists = repository.isExistsOrder(whereFrom, whereTo, login);
        return isExists;
    }
    public String getAllPlaces(){
        List<Travel_places> travelPlaces = repository.getAllPlaces();
        return travelPlaces == null ? "Not found!" : travelPlaces.toString();
    }
}