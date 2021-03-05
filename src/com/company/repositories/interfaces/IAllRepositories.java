package com.company.repositories.interfaces;

import com.company.entities.Users;
import com.company.entities.Travel_places;
import org.postgresql.util.PSQLException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IAllRepositories {
    boolean hasUser(String login, String password);
    boolean isRegistered(String name, String surname, String login, LocalDate regDate, String wantTo, LocalDate atDate);


//    List<Front> getAllFront();
//    List<Back> getAllBack();
//    boolean addFront(Front front);
//    boolean addBack(Back back);
//    boolean deleteFront(int id) throws PSQLException;
//    boolean deleteBack(int id) throws PSQLException;
//    int getSalary();
}