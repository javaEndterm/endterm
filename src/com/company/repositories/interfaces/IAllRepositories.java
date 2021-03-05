package com.company.repositories.interfaces;

import com.company.entities.Users;
import com.company.entities.Travel_places;
import org.postgresql.util.PSQLException;

import java.util.List;

public interface IAllRepositories {
    boolean hasUser(String login, String password);
    public boolean isAdmin(String login, String password);

}