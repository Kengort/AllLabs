package com.example.shoes;

public abstract class Boots extends Shoe {
    private int height;

    public Boots(String brand, double size, int height) {
        super(brand, size);
        this.height = height;
    }

    public abstract void printInfo();

    @Override
    public void wear() {
        System.out.println("Надеваю ботинки " + getBrand() + " высотой " + height + "см");
        System.out.println("Застегиваю молнию или шнурки");
    }

    public void walkInMud() {
        System.out.println("Иду по грязи в ботинках");
    }
}