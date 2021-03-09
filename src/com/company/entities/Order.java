package com.company.entities;

public class Order{
    private int id;
    private String whereFrom;
    private String whereTo;
    private String from_login;
    private int totalDay;
    private int price;

    public Order(int id, String whereFrom, String whereTo, String from_login, int totalDay, int price){
        setId(id);
        setWhereFrom(whereFrom);
        setWhereTo(whereTo);
        setFrom_login(from_login);
        setTotalDay(totalDay);
        setPrice(price);
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

    public void setId(int id) {
        this.id = id;
    }
    public void setWhereFrom(String whereFrom) {
        this.whereFrom = whereFrom;
    }
    public void setWhereTo(String whereTo) {
        this.whereTo = whereTo;
    }
    public void setFrom_login(String from_login) {
        this.from_login = from_login;
    }
    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int calculatePrice(String city1, String city2, int totalDay){
        int price;
        int x_city1 = 0;
        int x_city2 = 0;
        int y_city1 = 0;
        int y_city2 = 0;

        String cityFrom = city1.toLowerCase();
        String cityTo = city2.toLowerCase();

        switch (cityFrom) {
            case "taraz" -> {
                Travel_places taraz = new Travel_places();
                x_city1 = taraz.getX_Taraz();
                y_city1 = taraz.getY_Taraz();
            }
            case "astana" -> {
                Travel_places astana = new Travel_places();
                x_city1 = astana.getX_Astana();
                y_city1 = astana.getY_Astana();
            }
            case "shymkent" -> {
                Travel_places shymkent = new Travel_places();
                x_city1 = shymkent.getX_Shymkent();
                y_city1 = shymkent.getY_Shymkent();
            }
        }

        switch (cityTo) {
            case "taraz" -> {
                Travel_places taraz = new Travel_places();
                x_city2 = taraz.getX_Taraz();
                y_city2 = taraz.getY_Taraz();
            }
            case "astana" -> {
                Travel_places astana = new Travel_places();
                x_city2 = astana.getX_Astana();
                y_city2 = astana.getY_Astana();
            }
            case "shymkent" -> {
                Travel_places shymkent = new Travel_places();
                x_city2 = shymkent.getX_Shymkent();
                y_city2 = shymkent.getY_Shymkent();
            }
        }

        int distance = (int) Math.sqrt(Math.pow(Math.abs((x_city2-x_city1)), 2) + Math.pow(Math.abs((y_city2-y_city1)), 2));
        price = (int) (distance * totalDay * 1.5);

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
