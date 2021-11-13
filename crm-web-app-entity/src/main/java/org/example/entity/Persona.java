package org.example.entity;

import java.util.Date;

public class Persona {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String documentNumber;
    private String birthday;
    private String email;
    private Date timestampRegister;
    private Date timestampUpdate;
    private User objUser;

    public Persona(){this(0,"", "","","","","",new Date(),new Date(),new User());}

    public Persona(int id, String firstName, String lastName, String phone, String documentNumber, String birthday, String email, Date timestampRegister, Date timestampUpdate, User objUser) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.documentNumber = documentNumber;
        this.birthday = birthday;
        this.email = email;
        this.timestampRegister = timestampRegister;
        this.timestampUpdate = timestampUpdate;
        this.objUser = objUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getTimestampRegister() {
        return timestampRegister;
    }

    public void setTimestampRegister(Date timestampRegister) {
        this.timestampRegister = timestampRegister;
    }

    public Date getTimestampUpdate() {
        return timestampUpdate;
    }

    public void setTimestampUpdate(Date timestampUpdate) {
        this.timestampUpdate = timestampUpdate;
    }

    public User getObjUser() {
        return objUser;
    }

    public void setObjUser(User objUser) {
        this.objUser = objUser;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", timestampRegister=" + timestampRegister +
                ", timestampUpdate=" + timestampUpdate +
                ", objUser=" + objUser.toString() +
                '}';
    }
}
