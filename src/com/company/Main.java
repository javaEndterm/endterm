package com.company;

import com.company.controllers.AllControllers;
import com.company.data.DB;
import com.company.data.interfaces.IDB;
import com.company.repositories.AllRepositories;
import com.company.repositories.interfaces.IAllRepositories;

public class Main {
    public static void main(String[] args) {
        IDB database = new DB();
        IAllRepositories repositories = new AllRepositories(database);
        AllControllers controller = new AllControllers(repositories);
        MyApplication application = new MyApplication(controller);
        application.start();
        IDB database = new DB();
        IAllRepositories repositories = new AllRepositories(database);
        AllControllers controller = new AllControllers(repositories);
        MyApplication application = new MyApplication(controller);
        application.start();IDB database = new DB();
        IAllRepositories repositories = new AllRepositories(database);
        AllControllers controller = new AllControllers(repositories);
        MyApplication application = new MyApplication(controller);
        application.start();
        IDB database = new DB();
        IAllRepositories repositories = new AllRepositories(database);
        AllControllers controller = new AllControllers(repositories);
        MyApplication application = new MyApplication(controller);
        application.start();

    }
}
