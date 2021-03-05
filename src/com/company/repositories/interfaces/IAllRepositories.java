package com.company.repositories.interfaces;

import com.company.entities.Back;
import com.company.entities.Front;
import org.postgresql.util.PSQLException;

import java.util.List;

public interface IAllRepositories {
    List<Front> getAllFront();
    List<Back> getAllBack();
    boolean addFront(Front front);
    boolean addBack(Back back);
    boolean deleteFront(int id) throws PSQLException;
    boolean deleteBack(int id) throws PSQLException;
    int getSalary();
}