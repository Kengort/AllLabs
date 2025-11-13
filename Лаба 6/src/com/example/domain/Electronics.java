package com.example.domain;

public class Electronics extends Product {
    private int warrantyMonths;

    public Electronics() {}

    public Electronics(int id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Гарантия: " + this.warrantyMonths + " мес.");
    }

    @Override
    public String toString() {
        return "Электроника [" + super.toString() + ", гарантия=" + warrantyMonths + " мес.]";
    }


    }
}