package com.example.shoes;

public abstract class Shoe {
    private String brand;
    private double size;

    public Shoe(String brand, double size) {
        this.brand = brand;
        this.size = size;
    }



    public abstract void wear();

    public void putOn() {
        System.out.println("Надеваю обувь бренда: " + brand);
    }

    public String getBrand() {
        return brand;
    }

    public double getSize() {
        return size;
    }
}