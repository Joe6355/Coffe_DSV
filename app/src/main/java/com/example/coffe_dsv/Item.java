package com.example.coffe_dsv;

public class Item {
    private int id;
    private String name;
    private int imageResource;
    private double price; // Новое поле

    public Item(int id, String name, int imageResource, double price) {
        this.id = id;
        this.name = name;
        this.imageResource = imageResource;
        this.price = price; // Инициализация нового поля
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public double getPrice() {
        return price;
    }
}
