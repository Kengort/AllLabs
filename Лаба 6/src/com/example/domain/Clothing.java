package com.example.domain;

public class Clothing extends Product {
    private String size;

    public Clothing() {}

    public Clothing(int id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Одежда [" + super.toString() + ", размер=" + size + "]";
    }
}
