package org.example.entity;

import java.util.ArrayList;
import java.util.Date;

public class Sale {
    private String idSale;
    private Persona objPerson;
    private Date registerDateTime;
    private double igv;
    private double total;
    private Boolean status;
    private ArrayList<SaleDetail> lstSaleDetails;

    public Sale(){
        this("",new Persona(), new Date(), 18.5, false, new ArrayList<SaleDetail>());
    }

    public Sale(String idSale, Persona objPerson, Date registerDateTime, double igv, Boolean status, ArrayList<SaleDetail> lstSaleDetails) {
        this.idSale = idSale;
        this.objPerson = objPerson;
        this.registerDateTime = registerDateTime;
        this.igv = igv;
        this.status = status;
        this.lstSaleDetails = lstSaleDetails;
    }

    public String getIdSale() {
        return idSale;
    }

    public void setIdSale(String idSale) {
        this.idSale = idSale;
    }

    public Persona getObjPerson() {
        return objPerson;
    }

    public void setObjPerson(Persona objPerson) {
        this.objPerson = objPerson;
    }

    public Date getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(Date registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public ArrayList<SaleDetail> getLstSaleDetails() {
        return lstSaleDetails;
    }

    public void setLstSaleDetails(ArrayList<SaleDetail> lstSaleDetails) {
        this.lstSaleDetails = lstSaleDetails;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "idSale=" + idSale +
                ", objPerson=" + objPerson +
                ", registerDateTime=" + registerDateTime +
                ", status=" + status +
                '}';
    }
}
