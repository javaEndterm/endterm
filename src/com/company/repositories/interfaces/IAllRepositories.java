package com.company.repositories.interfaces;

import com.company.entities.Users;

import java.time.LocalDate;
import java.util.List;

public interface IAllRepositories {
    boolean hasUser(String login, String password);
    boolean isRegistered(String name, String surname, String login, LocalDate regDate, String wantTo, LocalDate atDate);
    boolean removeUser (int id);
    List<Users> getAllUsers();
    boolean addOrder(String city1, String city2, int days);


//    List<Front> getAllFront();
//    List<Back> getAllBack();
//    boolean addFront(Front front);
//    boolean addBack(Back back);
//    boolean deleteFront(int id) throws PSQLException;
//    boolean deleteBack(int id) throws PSQLException;
//    int getSalary();
}