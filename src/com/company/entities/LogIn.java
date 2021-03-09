package com.company.entities;

import java.sql.Date;

public class LogIn {
    private int id;
    private String name;
    private String login;
    private String password;
    private Date date_of_reg;

    public LogIn() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getDate_of_reg() {
        return date_of_reg;
    }
    public void setDate_of_reg(Date date_of_reg) {
        this.date_of_reg = date_of_reg;
    }

    public LogIn(int id, String name, String login, String password, Date date_of_reg) {
        setId(id);
        setName(name);
        setLogin(login);
        setPassword(password);
        setDate_of_reg(date_of_reg);
    }

    public LogIn(String name, String login, String password, Date date_of_reg) {
        setName(name);
        setLogin(login);
        setPassword(password);
        setDate_of_reg(date_of_reg);
    }

    public LogIn(String name, String login){
        setName(name);
        setLogin(login);
    }

    @Override
    public String toString() {
        return '\n' + "LogIn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", date_of_reg=" + date_of_reg +
                '}';
    }
}
