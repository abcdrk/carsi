package com.example.dilrubareyyan.carsi;

public class Item {

    private String header;
    private boolean hasPhoto;
    private String supplier;
    private int ID;
    private double price;

    public Item(String header, boolean hasPhoto, String supplier, double price) {
        super();
        this.header = header;
        this.hasPhoto = hasPhoto;
        this.supplier = supplier;
        this.price = price;
    }

    public Item(String header, boolean hasPhoto, double price) {
        super();
        this.header = header;
        this.hasPhoto = hasPhoto;
        this.price = price;
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

    // hasPhoto getter setter.
    public boolean getHasPhoto() {
        return hasPhoto;
    }

    public void setHasPhoto(boolean isSurplus) {
        this.hasPhoto = isSurplus;
    }

    // ID getter setter.
    public int getID() {
        return ID;
    }

    public void setID (int ID) { this.ID = ID; }

    // price getter setter.
    public double getPrice() {
        return price;
    }

    public void setPrice (double price) { this.price = price; }

}
