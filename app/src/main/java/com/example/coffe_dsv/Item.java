package com.example.coffe_dsv;

public class Item {
    private int id;
    private String name;
    private int imageResId;

    public Item(int id, String name, int imageResId) {
        this.id = id;
        this.name = name;
        this.imageResId = imageResId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
