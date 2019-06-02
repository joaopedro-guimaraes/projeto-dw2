package org.dw2Backend.entity;

import javax.persistence.*;
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

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "company", fetch=FetchType.EAGER)
    private List<Internship> internshipList;

    @Column
    private String CNPJ;

    @Column
    private String companyName;

    @Column
    private String address;

    @Column
    private int number;

    @Column
    private String city;

    @Column
    private String neighborhood;

    @Column
    private String state;

    @Column
    private String cep;

    @Column
    private String telephone;

    @Column
    private String responsible;
    //</editor-fold>

    //<editor-fold desc="Builders">
    ////////////////////////////////

    public Company(
                    int idCompany
                    ,User userCompany
                    ,List<Internship> internshipList
                    , String CNPJ
                    , String companyName
                    , String desirableRequirements
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
        this.internshipList = internshipList;
        this.CNPJ = CNPJ;
        this.companyName = companyName;
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
                ", internshipList=" + internshipList +
                ", CNPJ='" + CNPJ + '\'' +
                ", companyName='" + companyName + '\'' +
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