package org.dw2Backend.entity;

import javax.persistence.*;

@Entity
public class User {

    //<editor-fold desc="Anotation">
    ////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userType;
    //</editor-fold>

    //<editor-fold desc="Builders">
    ////////////////////////////////
    public User(
                int idUser
                ,String username
                , String email
                , String password
                , String userType) {
        this.idUser = idUser;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public User(){ }
    //</editor-fold>

    //<editor-fold desc="Properties">
    ////////////////////////////////
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

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    //</editor-fold>

    //<editor-fold desc="toStrings">
    ////////////////////////////////

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    //</editor-fold>
}
