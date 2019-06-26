package org.dw2Backend.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ProfessionalExperience {

    //<editor-fold desc="Anotation">
    ////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfessionalExperience;

    @ManyToOne
    @JoinColumn(name = "idCurriculum")
    private Curriculum curriculum;

    @Column
    private String company;

    @Column
    private String function;

    @Type(type = "date")
    @Column
    private Date dateAdmission;

    @Type(type = "date")
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
                                    , String executeTasks
                                    , Curriculum curriculum) {
        this.idProfessionalExperience = idProfessionalExperience;
        this.company = company;
        this.function = function;
        this.dateAdmission = dateAdmission;
        this.dateDemission = dateDemission;
        this.executeTasks = executeTasks;
        this.curriculum = curriculum;
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

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
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
                ", curriculum='" + curriculum + '\'' +
                '}';
    }
    //</editor-fold>
}
