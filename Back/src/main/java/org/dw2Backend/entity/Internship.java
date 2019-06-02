package org.dw2Backend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Internship {

    //<editor-fold desc="Anotation">
    ////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInternship;

    @Column
    private String description;

    @Column
    private String requiredRequirements;

    @Column
    private String desirableRequirements;

    @ManyToOne
    @JoinColumn(name = "idCompany")
    private Company company;

    /*@ManyToMany(mappedBy = "internshipList")
    private List<Student> studentList;*/
    //</editor-fold>

    //<editor-fold desc="Builders">
    ////////////////////////////////
    public Internship(
                        int idInternship
                        , String description
                        , String requiredRequirements
                        , String desirableRequirements
                        , Company company) {
        this.idInternship = idInternship;
        this.description = description;
        this.requiredRequirements = requiredRequirements;
        this.desirableRequirements = desirableRequirements;
        this.company = company;
    }

    public Internship() { }
    //</editor-fold>

    //<editor-fold desc="Properties">
    ////////////////////////////////
    public int getIdInternship() {
        return idInternship;
    }

    public void setIdInternship(int idInternship) {
        this.idInternship = idInternship;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequiredRequirements() {
        return requiredRequirements;
    }

    public void setRequiredRequirements(String requiredRequirements) {
        this.requiredRequirements = requiredRequirements;
    }

    public String getDesirableRequirements() {
        return desirableRequirements;
    }

    public void setDesirableRequirements(String desirableRequirements) {
        this.desirableRequirements = desirableRequirements;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    //</editor-fold>

    //<editor-fold desc="toStrings">
    ////////////////////////////////
    @Override
    public String toString() {
        return "Internship{" +
                "idInternship=" + idInternship +
                ", description='" + description + '\'' +
                ", requiredRequirements='" + requiredRequirements + '\'' +
                ", desirableRequirements='" + desirableRequirements + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
    //</editor-fold>
}
