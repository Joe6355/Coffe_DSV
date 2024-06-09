package com.example.coffe_dsv;

public class Item {
    private int id;
    private String name;
    private int imageResource;

    public Item(int id, String name, int imageResource) {
        this.id = id;
        this.name = name;
        this.imageResource = imageResource;
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
}
