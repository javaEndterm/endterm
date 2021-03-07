package com.company.entities;

import java.sql.Date;

public class Travel_places {
    private int id;
    private String name;
    private String date;
    private int price;
    private int x_Taraz = 1500;
    private int y_Taraz = 400;
    private int x_Shymkent = 100;
    private int y_Shymkent = 700;
    private int x_Astana = 1700;
    private int y_Astana = 1100;
    public Travel_places(){};

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
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getX_Taraz() {
        return x_Taraz;
    }
    public void setX_Taraz(int x_Taraz) {
        this.x_Taraz = x_Taraz;
    }
    public int getY_Taraz() {
        return y_Taraz;
    }
    public void setY_Taraz(int y_Taraz) {
        this.y_Taraz = y_Taraz;
    }

    public int getX_Shymkent() {
        return x_Shymkent;
    }
    public void setX_Shymkent(int x_Shymkent) {
        this.x_Shymkent = x_Shymkent;
    }
    public int getY_Shymkent() {
        return y_Shymkent;
    }
    public void setY_Shymkent(int y_Shymkent) {
        this.y_Shymkent = y_Shymkent;
    }
    public int getX_Astana() {
        return x_Astana;
    }
    public void setX_Astana(int x_Astana) {
        this.x_Astana = x_Astana;
    }
    public int getY_Astana() {
        return y_Astana;
    }
    public void setY_Astana(int y_Astana) {
        this.y_Astana = y_Astana;
    }

    public Travel_places(int id, String name, String date, int price) {
        setId(id);
        setName(name);
        setDate(date);
        setPrice(price);
    }

    public Travel_places(String name, String date, int price) {
        setName(name);
        setDate(date);
        setPrice(price);
    }

    @Override
    public String toString() {
        return '\n' + "Travel_places{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                '}';
    }
}
