package com.company.entities;

public class Travel_places {
    private int id;
    private String name;
    private String date;
    private int price;

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
        return "Travel_places{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                '}';
    }
}
