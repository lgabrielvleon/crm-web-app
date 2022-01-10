package org.example.dto;

import java.util.Date;

public class Orders {

    private String idOrder;
    private Date registerDateTime;
    private int quantity;
    private double subtotal;
    private double igv;
    private double total;

    public Orders(){
        this("", new Date(), 0, 0.00, 1.18, 0.00);
    }
    public Orders(String idOrder, Date registerDateTime, int quantity, double subtotal, double igv, double total) {
        this.idOrder = idOrder;
        this.registerDateTime = registerDateTime;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public Date getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(Date registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idOrder='" + idOrder + '\'' +
                ", registerDateTime=" + registerDateTime +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                ", igv=" + igv +
                ", total=" + total +
                '}';
    }
}
