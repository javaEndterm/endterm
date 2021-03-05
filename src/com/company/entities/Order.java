package com.company.entities;

import java.sql.Date;

public class Order extends Users{
    private int orderID;
    private String whereTo;
    private String whereFrom;
    private int totalDay;

    public Order(int id, String name, String surname, String login, Date date_of_reg, String want_to, Date at_date) {
        super(id, name, surname, login, date_of_reg, want_to, at_date);
    }

    public Order(String login, String name, String surname, Date date_of_reg, String want_to, Date at_date) {
        super(login, name, surname, date_of_reg, want_to, at_date);
    }
    public int calculatePrice(String whereFrom, String whereTo, int totalDay){
        int price = 0;
        //some formula
        return price;
    }


}
