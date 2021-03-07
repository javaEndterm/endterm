package com.company.entities;

import java.sql.Date;
import java.util.Locale;

public class Order extends LogIn{
    private int orderID;
    private String whereTo;
    private String whereFrom;
    private int totalDay;
    public Order(int id, String name, String login, String password, Date date_of_reg) {
        super(id, name, login, password, date_of_reg);
    }
    public Order(String name, String login, String password, Date date_of_reg) {
        super(name, login, password, date_of_reg);
    }
    public Order(int orderID, String whereTo, String whereFrom, int totalDay, String name, String login, int price){
        super(name, login);
        setOrderID(orderID);
        setWhereTo(whereTo);
        setWhereFrom(whereFrom);
        setTotalDay(totalDay);
        price = calculatePrice(whereTo, whereFrom, totalDay);
    }
    public Order(){};
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public String getWhereTo() {
        return whereTo;
    }
    public void setWhereTo(String whereTo) {
        this.whereTo = whereTo;
    }
    public String getWhereFrom() {
        return whereFrom;
    }
    public void setWhereFrom(String whereFrom) {
        this.whereFrom = whereFrom;
    }
    public int getTotalDay() {
        return totalDay;
    }
    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }
    public int calculatePrice(String city1, String city2, int totalDay){
        int price = 0;
        int x_city1 = 0;
        int x_city2 = 0;
        int y_city1 = 0;
        int y_city2 = 0;
        if(city1.toLowerCase() == "taraz") {
            Travel_places taraz = new Travel_places();
            x_city1 = taraz.getX_Taraz();
            y_city1 = taraz.getY_Taraz();
        }
        if(city1.toLowerCase() == "astana"){
            Travel_places astana = new Travel_places();
            x_city1 = astana.getX_Astana();
            y_city1 = astana.getY_Astana();
        }
        if(city1.toLowerCase() == "shymkent"){
            Travel_places shymkent = new Travel_places();
            x_city1 = shymkent.getX_Shymkent();
            y_city1 = shymkent.getY_Shymkent();
        }
        if(city2.toLowerCase() == "taraz") {
            Travel_places taraz = new Travel_places();
            x_city2 = taraz.getX_Taraz();
            y_city2 = taraz.getY_Taraz();
        }
        if(city2.toLowerCase() == "astana"){
            Travel_places astana = new Travel_places();
            x_city2 = astana.getX_Astana();
            y_city2 = astana.getY_Astana();
        }
        if(city2.toLowerCase() == "shymkent"){
            Travel_places shymkent = new Travel_places();
            x_city2 = shymkent.getX_Shymkent();
            y_city2 = shymkent.getY_Shymkent();
        }
        int distance = (int) Math.sqrt(Math.pow((x_city2-x_city1), 2) + Math.pow((y_city2-y_city1), 2));
        price = distance * totalDay * 5;
        return price;
    }
}
