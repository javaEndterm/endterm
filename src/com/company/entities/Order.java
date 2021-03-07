package com.company.entities;

import java.sql.Date;

public class Order{
    private int id;
    private String whereFrom;
    private String whereTo;
    private String from_login;
    private int totalDay;
    private int price;
//    public Order(int id, String whereFrom, String whereTo, String from_login, int totalDay, int price) {
//        super(id, name, login, password, date_of_reg);
//    }
//    public Order(String name, String login, String password, Date date_of_reg) {
//        super(name, login, password, date_of_reg);
//    }
    public Order(int id, String whereFrom, String whereTo, String from_login, int totalDay, int price){
        setId(id);
        setWhereFrom(whereFrom);
        setWhereTo(whereTo);
        setFrom_login(from_login);
        setTotalDay(totalDay);
        setPrice(price);
//        setOrderID(orderID);
//        setWhereTo(whereTo);
//        setWhereFrom(whereFrom);
//        setTotalDay(totalDay);
//        price = calculatePrice(whereTo, whereFrom, totalDay);
    }

    public Order(String whereFrom, String whereTo, String from_login, int totalDay, int price){
        setWhereFrom(whereFrom);
        setWhereTo(whereTo);
        setFrom_login(from_login);
        setTotalDay(totalDay);
        setPrice(price);
    }
    public Order(String whereFrom, String whereTo, String from_login, int totalDay){
        setWhereFrom(whereFrom);
        setWhereTo(whereTo);
        setFrom_login(from_login);
        setTotalDay(totalDay);
        price = calculatePrice(whereFrom, whereTo, totalDay);
        setPrice(price);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getWhereFrom() {
        return whereFrom;
    }
    public void setWhereFrom(String whereFrom) {
        this.whereFrom = whereFrom;
    }
    public String getWhereTo() {
        return whereTo;
    }
    public void setWhereTo(String whereTo) {
        this.whereTo = whereTo;
    }
    public String getFrom_login() {
        return from_login;
    }
    public void setFrom_login(String from_login) {
        this.from_login = from_login;
    }
    public int getTotalDay() {
        return totalDay;
    }
    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    //    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public int getOrderID() {
//        return orderID;
//    }
//    public void setOrderID(int orderID) {
//        this.orderID = orderID;
//    }
//    public String getWhereTo() {
//        return whereTo;
//    }
//    public void setWhereTo(String whereTo) {
//        this.whereTo = whereTo;
//    }
//    public String getWhereFrom() {
//        return whereFrom;
//    }
//    public void setWhereFrom(String whereFrom) {
//        this.whereFrom = whereFrom;
//    }
//    public int getTotalDay() {
//        return totalDay;
//    }
//    public void setTotalDay(int totalDay) {
//        this.totalDay = totalDay;
//    }

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
        } else if(city1.toLowerCase() == "astana"){
            Travel_places astana = new Travel_places();
            x_city1 = astana.getX_Astana();
            y_city1 = astana.getY_Astana();
        } else if(city1.toLowerCase() == "shymkent"){
            Travel_places shymkent = new Travel_places();
            x_city1 = shymkent.getX_Shymkent();
            y_city1 = shymkent.getY_Shymkent();
        } else if(city2.toLowerCase() == "taraz") {
            Travel_places taraz = new Travel_places();
            x_city2 = taraz.getX_Taraz();
            y_city2 = taraz.getY_Taraz();
        } else if(city2.toLowerCase() == "astana"){
            Travel_places astana = new Travel_places();
            x_city2 = astana.getX_Astana();
            y_city2 = astana.getY_Astana();
        } else if(city2.toLowerCase() == "shymkent"){
            Travel_places shymkent = new Travel_places();
            x_city2 = shymkent.getX_Shymkent();
            y_city2 = shymkent.getY_Shymkent();
        }
        int distance = (int) Math.sqrt(Math.pow((x_city2-x_city1), 2) + Math.pow((y_city2-y_city1), 2));
        price = distance * totalDay * 5;
        return price;
    }


    @Override
    public String toString() {
        return '\n' + "Order{" +
                "id=" + id +
                ", whereFrom='" + whereFrom + '\'' +
                ", whereTo='" + whereTo + '\'' +
                ", from_login='" + from_login + '\'' +
                ", totalDay=" + totalDay +
                ", price=" + price +
                '}';
    }
}
