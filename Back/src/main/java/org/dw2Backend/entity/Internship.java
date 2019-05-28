package org.dw2Backend.entity;

import javax.persistence.*;

@Entity
public class Internship {

    //<editor-fold desc="Anotation">
    ////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInternship;

    @OneToOne
    private User userInternship;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String requiredRequirements;

    @Column(nullable = false)
    private String desirableRequirements;
    //</editor-fold>

    //<editor-fold desc="Builders">
    ////////////////////////////////
    public Internship(
                        int idInternship
                        , User userInternship
                        , String description
                        , String requiredRequirements
                        , String desirableRequirements) {
        this.idInternship = idInternship;
        this.userInternship = userInternship;
        this.description = description;
        this.requiredRequirements = requiredRequirements;
        this.desirableRequirements = desirableRequirements;
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

    public User getUserInternship() {
        return userInternship;
    }

    public void setUserInternship(User userInternship) {
        this.userInternship = userInternship;
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
    //</editor-fold>

    //<editor-fold desc="toStrings">
    ////////////////////////////////
    @Override
    public String toString() {
        return "Internship{" +
                "idInternship=" + idInternship +
                ", userInternship=" + userInternship +
                ", description='" + description + '\'' +
                ", requiredRequirements='" + requiredRequirements + '\'' +
                ", desirableRequirements='" + desirableRequirements + '\'' +
                '}';
    }
    //</editor-fold>
}
