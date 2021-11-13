package org.example.entity;

import java.util.Date;

public class User {
    private int idUser;
    private String username;
    private String password;
    private Date timestampRegister;
    private Date timestampUpdate;

    public User (){this(0,"","", new Date(), new Date());}

    public User(int idUser, String username, String password, Date timestampRegister, Date timestampUpdate) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.timestampRegister = timestampRegister;
        this.timestampUpdate = timestampUpdate;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
