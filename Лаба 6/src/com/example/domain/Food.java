package com.example.domain;

import java.time.LocalDate;

public class Food extends Product {
    private LocalDate expirationDate;

    public Food() {}

    public Food(int id, String name, double price, LocalDate expirationDate) {
        super(id, name, price);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Продукт питания [" + super.toString() + ", срок годности=" + expirationDate + "]";
    }
}
