package com.company.entities;

import java.sql.Date;

public class Users {
    private int id;
    private String login;
    private String name;
    private Date date_of_reg;
    private String want_to;
    private Date At_date;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDate_of_reg() {
        return date_of_reg;
    }
    public void setDate_of_reg(Date date_of_reg) {
        this.date_of_reg = date_of_reg;
    }
    public String getWant_to() {
        return want_to;
    }
    public void setWant_to(String want_to) {
        this.want_to = want_to;
    }
    public Date getAt_date() {
        return At_date;
    }
    public void setAt_date(Date at_date) {
        At_date = at_date;
    }

    public Users(int id, String login, String name, Date date_of_reg, String want_to, Date at_date) {
        setId(id);
        setLogin(login);
        setName(name);
        setDate_of_reg(date_of_reg);
        setWant_to(want_to);
        setAt_date(at_date);
    }

    public Users(String login, String name, Date date_of_reg, String want_to, Date at_date) {
        setLogin(login);
        setName(name);
        setDate_of_reg(date_of_reg);
        setWant_to(want_to);
        setAt_date(at_date);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", date_of_reg=" + date_of_reg +
                ", want_to='" + want_to + '\'' +
                ", At_date=" + At_date +
                '}';
    }
}
