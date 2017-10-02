package com.example.dilrubareyyan.carsi;

import android.content.Context;

public class Item {

    private String header;
    private String supplier;
    private String ID;
    private String price;
    private String location = "Ümraniye";
    private String subject = "Tekstil";

    public Item(String header, String supplier, String price) {
        super();
        this.header = header;
        this.supplier = supplier;
        this.price = price;
    }

    public Item(String header, String price) {
        super();
        this.header = header;
        this.price = price;
    }

    public Item(String header, String supplier, String price, String location, String subject) {
        super();
        this.header = header;
        this.supplier = supplier;
        this.price = price;
        this.location = location;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return header;
    }

    // Header getter setter.
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    // Suppler getter setter.
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }


    // ID getter setter.
    public String getID() {
        return ID;
    }

    public void setID (String ID) { this.ID = ID; }

    // price getter setter.
    public String getPrice() {
        return price;
    }

    public void setPrice (String price) { this.price = price; }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
