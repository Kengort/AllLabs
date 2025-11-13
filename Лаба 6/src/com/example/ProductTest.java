package com.example;

import com.example.domain.*;
import java.time.LocalDate;

public class ProductTest {
    public static void main(String[] args) {
        Electronics e = new Electronics(1, "Смартфон", 699.99, 24);
        Food f = new Food(2, "Сыр", 8.5, LocalDate.of(2025, 12, 1));
        Clothing c = new Clothing(3, "Футболка", 19.99, "M");
        Book b = new Book(4, "Эффективная Java", 45.0, "Джошуа Блох");

        System.out.println(e);
        System.out.println(f);
        System.out.println(c);
        System.out.println(b);

        System.out.println("\nВсе товары:");
        Product[] products = { e, f, c, b };
        for (Product p : products) {
            System.out.println(p.getName() + " — " + p.getPrice() + " руб.");
        }
    }
}