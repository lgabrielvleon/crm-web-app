package org.example.entity;

public class Persona {
    private int id;
    private String name;
    private String lastName;
    private String phone;
    private String documentNumber;

    public Persona(){this(0,"", "","","");}

    public Persona(int id, String name, String lastName, String phone, String documentNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.documentNumber = documentNumber;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                '}';
    }
}
