package com.company.entities;

import java.sql.Date;

public class Travel_places {
    private int id;
    private String place1;
    private String place2;
    private Date date;
    private String reiteration;
    private int price_per_day;

    private final int x_Taraz = 42000;
    private final int y_Taraz = 71000;
    private final int x_Shymkent = 42000;
    private final int y_Shymkent = 69000;
    private final int x_Astana = 51000;
    private final int y_Astana = 71000;

    public Travel_places(){};

    public void setId(int id) {
        this.id = id;
    }
    public void setPlace1(String place1) {
        this.place1 = place1;
    }
    public void setPlace2(String place2) {
        this.place2 = place2;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setReiteration(String reiteration) {
        this.reiteration = reiteration;
    }
    public void setPrice_per_day(int price_per_day) {
        this.price_per_day = price_per_day;
    }

    public int getX_Taraz() {
        return x_Taraz;
    }
    public int getY_Taraz() {
        return y_Taraz;
    }

    public int getX_Shymkent() {
        return x_Shymkent;
    }
    public int getY_Shymkent() {
        return y_Shymkent;
    }

    public int getX_Astana() {
        return x_Astana;
    }
    public int getY_Astana() {
        return y_Astana;
    }

    public Travel_places(int id, String place1, String place2, Date date, String reiteration, int price_per_day) {
        setId(id);
        setPlace1(place1);
        setPlace2(place2);
        setDate(date);
        setReiteration(reiteration);
        setPrice_per_day(price_per_day);
    }

    public Travel_places(String place1, String place2, Date date, String reiteration, int price_per_day) {
        setPlace1(place1);
        setPlace2(place2);
        setDate(date);
        setReiteration(reiteration);
        setPrice_per_day(price_per_day);
    }

    @Override
    public String toString() {
        return '\n' + "Travel_places{" +
                "id=" + id +
                ", place1='" + place1 + '\'' +
                ", place2='" + place2 + '\'' +
                ", date=" + date +
                ", reiteration='" + reiteration + '\'' +
                ", price_per_day=" + price_per_day +
                '}';
    }
}
