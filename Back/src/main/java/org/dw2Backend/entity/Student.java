package org.dw2Backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Student {

    //<editor-fold desc="Anotation">
    ////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStudent;

    @OneToOne
    private User userStudent;

    @OneToOne
    private Internship internship;

    @OneToOne
    private Curriculum curriculum;

    @Column(nullable = false)
    private String register;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private Date dataIngresso;
    //</editor-fold>

    //<editor-fold desc="Builders">
    ////////////////////////////////

    public Student(
                    int idStudent
                    ,User userStudent
                    , String register
                    , String name
                    , String address
                    , int number
                    , String city
                    , String neighborhood
                    , String state
                    , String cep
                    , String telephone
                    , String course
                    , Date dataIngresso) {
        this.idStudent = idStudent;
        this.userStudent = userStudent;
        this.register = register;
        this.name = name;
        this.address = address;
        this.number = number;
        this.city = city;
        this.neighborhood = neighborhood;
        this.state = state;
        this.cep = cep;
        this.telephone = telephone;
        this.course = course;
        this.dataIngresso = dataIngresso;
    }

    public Student() { }

    //</editor-fold>

    //<editor-fold desc="Properties">
    ////////////////////////////////
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public User getUserStudent() {
        return userStudent;
    }

    public void setUserStudent(User userStudent) {
        this.userStudent = userStudent;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
    //</editor-fold>

    //<editor-fold desc="toStrings">
    ////////////////////////////////
    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", userStudent=" + userStudent +
                ", register='" + register + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", state='" + state + '\'' +
                ", cep='" + cep + '\'' +
                ", telephone='" + telephone + '\'' +
                ", course='" + course + '\'' +
                ", dataIngresso=" + dataIngresso +
                '}';
    }
    //</editor-fold>
}
