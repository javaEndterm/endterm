package com.company.repositories.interfaces;

import com.company.entities.LogIn;
import com.company.entities.Order;
import com.company.entities.Travel_places;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface IAllRepositories {

    boolean hasUser(String login, String password);
    boolean hasLogin(String login);
    boolean isAdmin(String login, String password);
    boolean isExistsOrder(String whereTo, String whereFrom, String from_login);

    ///

    List<LogIn> getAllUsers();
    List<Order> getAllOrders();
    List<Order> getOrdersForUserByLogin(String login);
    List<Travel_places> getAllPlaces();

    ///

    boolean addUser(String name, String login, String password, LocalDate regDate);
    boolean addOrder(String whereFrom, String whereTo, String from_login, int days, int price);
    boolean addPlace(String name, Date starting_date, String reiteration, int price);

    ///

    boolean removeUser (int id);
    boolean removePlace(int id);
    boolean removeOrder(String whereFrom, String whereTo, String login);
}