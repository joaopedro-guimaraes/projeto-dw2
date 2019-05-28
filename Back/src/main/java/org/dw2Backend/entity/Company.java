package org.dw2Backend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {

    //<editor-fold desc="Anotation">
    ////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompany;

    @OneToOne
    private User userCompany;

    @ManyToMany
    private List<Internship> internshipList = new ArrayList<Internship>();

    @Column(nullable = false)
    private String CNPJ;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String requisitosDesejaveis;

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
    private String responsible;
    //</editor-fold>

    //<editor-fold desc="Builders">
    ////////////////////////////////

    public Company(
                    int idCompany
                    ,User userCompany
                    , String CNPJ
                    , String companyName
                    , String requisitosDesejaveis
                    , String address
                    , int number
                    , String city
                    , String neighborhood
                    , String state
                    , String cep
                    , String telephone
                    , String responsible) {
        this.idCompany = idCompany;
        this.userCompany = userCompany;
        this.CNPJ = CNPJ;
        this.companyName = companyName;
        this.requisitosDesejaveis = requisitosDesejaveis;
        this.address = address;
        this.number = number;
        this.city = city;
        this.neighborhood = neighborhood;
        this.state = state;
        this.cep = cep;
        this.telephone = telephone;
        this.responsible = responsible;
    }

    public Company() { }

    //</editor-fold>

    //<editor-fold desc="Properties">
    ////////////////////////////////
    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public User getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(User userCompany) {
        this.userCompany = userCompany;
    }

    public List<Internship> getInternshipList() {
        return internshipList;
    }

    public void setInternshipList(List<Internship> internshipList) {
        this.internshipList = internshipList;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRequisitosDesejaveis() {
        return requisitosDesejaveis;
    }

    public void setRequisitosDesejaveis(String requisitosDesejaveis) {
        this.requisitosDesejaveis = requisitosDesejaveis;
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

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }
    //</editor-fold>

    //<editor-fold desc="toStrings">
    ////////////////////////////////
    @Override
    public String toString() {
        return "Company{" +
                "idCompany=" + idCompany +
                ", userCompany=" + userCompany +
                ", CNPJ='" + CNPJ + '\'' +
                ", companyName='" + companyName + '\'' +
                ", requisitosDesejaveis='" + requisitosDesejaveis + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", state='" + state + '\'' +
                ", cep='" + cep + '\'' +
                ", telephone='" + telephone + '\'' +
                ", responsible='" + responsible + '\'' +
                '}';
    }
    //</editor-fold>
}