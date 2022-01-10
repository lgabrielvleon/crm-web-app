package org.example.entity;

import java.util.Date;

public class SaleDetail {
    private int id;
    private Product objProduct;
    private int units;
    private double unitPrice;
    private double subTotal;
    private Date registerDateTime;
    private Date updateDateTime;

    public SaleDetail(){
        this(0, new Product(),0, 0.00, new Date(), new Date());
    }

    public SaleDetail(int id, Product objProduct,int units, double unitPrice, Date registerDateTime, Date updateDateTime) {
        this.id = id;
        this.objProduct = objProduct;
        this.units = units;
        this.unitPrice = unitPrice;
        this.registerDateTime = registerDateTime;
        this.updateDateTime = updateDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getObjProduct() {
        return objProduct;
    }

    public void setObjProduct(Product objProduct) {
        this.objProduct = objProduct;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(Date registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "SaleDetail{" +
                "id=" + id +
                ", objProduct=" + objProduct +
                ", units=" + units +
                ", unitPrice=" + unitPrice +
                ", registerDateTime=" + registerDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
