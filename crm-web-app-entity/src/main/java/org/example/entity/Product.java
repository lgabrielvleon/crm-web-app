package org.example.entity;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String description;
    private int stock;
    private double price;
    private Date registerDatetime;
    private Date updateDatetime;

    public Product(){
        this(0,"","",0,0.0,new Date(),new Date());
    };

    public Product(int id, String name, String description, int stock, double price, Date registerDatetime, Date updateDatetime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.registerDatetime = registerDatetime;
        this.updateDatetime = updateDatetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getRegisterDatetime() {
        return registerDatetime;
    }

    public void setRegisterDatetime(Date registerDatetime) {
        this.registerDatetime = registerDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", registerDatetime=" + registerDatetime +
                ", updateDatetime=" + updateDatetime +
                '}';
    }
}
