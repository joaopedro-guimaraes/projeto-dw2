package org.dw2Backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ProfessionalExperience {

    //<editor-fold desc="Anotation">
    ////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfessionalExperience;

    @Column
    private String company;

    @Column
    private String function;

    @Column
    private Date dateAdmission;

    @Column
    private Date dateDemission;

    @Column
    private String executeTasks;
    //</editor-fold>

    //<editor-fold desc="Builders">
    ////////////////////////////////
    public ProfessionalExperience(
                                    int idProfessionalExperience
                                    , String company
                                    , String function
                                    , Date dateAdmission
                                    , Date dateDemission
                                    , String executeTasks) {
        this.idProfessionalExperience = idProfessionalExperience;
        this.company = company;
        this.function = function;
        this.dateAdmission = dateAdmission;
        this.dateDemission = dateDemission;
        this.executeTasks = executeTasks;
    }

    public ProfessionalExperience() { }
    //</editor-fold>

    //<editor-fold desc="Properties">
    ////////////////////////////////
    public int getIdProfessionalExperience() {
        return idProfessionalExperience;
    }

    public void setIdProfessionalExperience(int idProfessionalExperience) {
        this.idProfessionalExperience = idProfessionalExperience;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Date getDateAdmission() {
        return dateAdmission;
    }

    public void setDateAdmission(Date dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    public Date getDateDemission() {
        return dateDemission;
    }

    public void setDateDemission(Date dateDemission) {
        this.dateDemission = dateDemission;
    }

    public String getExecuteTasks() {
        return executeTasks;
    }

    public void setExecuteTasks(String executeTasks) {
        this.executeTasks = executeTasks;
    }
    //</editor-fold>

    //<editor-fold desc="toStrings">
    ////////////////////////////////
    @Override
    public String toString() {
        return "ProfessionalExperience{" +
                "idProfessionalExperience=" + idProfessionalExperience +
                ", company='" + company + '\'' +
                ", function='" + function + '\'' +
                ", dateAdmission=" + dateAdmission +
                ", dateDemission=" + dateDemission +
                ", executeTasks='" + executeTasks + '\'' +
                '}';
    }
    //</editor-fold>
}
