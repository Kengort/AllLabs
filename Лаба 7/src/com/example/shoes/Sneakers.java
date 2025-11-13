package com.example.shoes;

public class Sneakers extends Shoe {
    private boolean hasLaces;

    public Sneakers(String brand, double size, boolean hasLaces) {
        super(brand, size);
        this.hasLaces = hasLaces;
    }

    @Override
    public void wear() {
        System.out.println("Ношу кроссовки " + getBrand() + " размера " + getSize());
        if (hasLaces) {
            System.out.println("Зашнуровываю кроссовки");
        } else {
            System.out.println("Кроссовки на липучках - просто надеваю");
        }
    }

    public void run() {
        System.out.println("Бегу в кроссовках!");
    }
}