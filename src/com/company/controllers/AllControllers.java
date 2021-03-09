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
        return repository.hasUser(login, password);
    }

    public boolean hasLogin(String login) {
        return repository.hasLogin(login);
    }

    public boolean isAdmin(String login, String password) {
        return repository.isAdmin(login, password);
    }

    public boolean isExistsOrder(String whereFrom, String whereTo, String login) {
        return repository.isExistsOrder(whereFrom, whereTo, login);
    }

    ///

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

    public String getAllPlaces(){
        List<Travel_places> travelPlaces = repository.getAllPlaces();
        return travelPlaces == null ? "Not found!" : travelPlaces.toString();
    }

    ///


    public boolean addUser(String name, String login, String password, LocalDate regDate) {
        return repository.addUser(name, login, password, regDate);
    }

    public String addOrder(String whereFrom, String whereTo, String login, int days) {

        Order order = new Order(whereFrom, whereTo, login, days);
        int price = order.calculatePrice(whereFrom, whereTo, days);

        boolean isAdded = repository.addOrder(whereFrom, whereTo, login, days, price);
        return isAdded ? "Order is added!" : "Order addition is failed!";
    }

    public boolean addPlace(String name, Date starting_date, String reiteration, int price) {
        return repository.addPlace(name, starting_date, reiteration, price);
    }

    ///

    public String removeUserById(int id) {
        boolean isRemoved = repository.removeUser(id);
        return isRemoved ? "User is deleted!" : "User deletion is failed!";
    }

    public String removeOrder(String whereFrom, String whereTo, String login) {
        boolean isRemoved = repository.removeOrder(whereFrom, whereTo, login);
        return isRemoved ? "Order is deleted!" : "Order deletion is failed!";
    }

    public String removePlaceById(int id) {
        boolean isRemoved = repository.removePlace(id);
        return isRemoved ? "User is deleted!" : "User deletion is failed!";
    }
}