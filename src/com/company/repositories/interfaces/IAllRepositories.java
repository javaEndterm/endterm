package com.company.repositories.interfaces;

import com.company.entities.LogIn;
import com.company.entities.Order;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface IAllRepositories {
    boolean hasUser(String login, String password);
    boolean removeUser (int id);
    List<LogIn> getAllUsers();
    boolean isAdmin(String login, String password);
    boolean addUser(String name, String login, String password, LocalDate regDate);
    boolean addPlace(String name, Date starting_date, String reiteration, int price);
    boolean removePlace(int id);
    boolean isAddedOrder(String whereTo, String whereFrom, String login, int totalDay);
    int getIdByLogin(String login);
    List<Order> getAllOrders();
    List<Order> getOrdersForUserByLogin(String login);
    boolean isRemovedOrder(String login, String whereTo, String whereFrom);
}