package org.dw2Backend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Curriculum {

    //<editor-fold desc="Anotation">
    ////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurriculum;

    @Column
    private String identification;

    @OneToMany
    private List<AcademicFormation> academicFormationList;

    @OneToMany
    private List<ProfessionalExperience> professionalExperienceList;
    //</editor-fold>

    //<editor-fold desc="Builders">
    ////////////////////////////////
    public Curriculum(
                        int idCurriculum
                        , String identification
                        , List<AcademicFormation> academicFormationList
                        , List<ProfessionalExperience> professionalExperienceList) {
        this.idCurriculum = idCurriculum;
        this.identification = identification;
        this.academicFormationList = academicFormationList;
        this.professionalExperienceList = professionalExperienceList;
    }

    public Curriculum() { }
    //</editor-fold>

    //<editor-fold desc="Properties">
    ////////////////////////////////
    public int getIdCurriculum() {
        return idCurriculum;
    }

    public void setIdCurriculum(int idCurriculum) {
        this.idCurriculum = idCurriculum;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public List<AcademicFormation> getAcademicFormationList() {
        return academicFormationList;
    }

    public void setAcademicFormationList(List<AcademicFormation> academicFormationList) {
        this.academicFormationList = academicFormationList;
    }

    public List<ProfessionalExperience> getProfessionalExperienceList() {
        return professionalExperienceList;
    }

    public void setProfessionalExperienceList(List<ProfessionalExperience> professionalExperienceList) {
        this.professionalExperienceList = professionalExperienceList;
    }
    //</editor-fold>

    //<editor-fold desc="toStrings">
    ////////////////////////////////
    @Override
    public String toString() {
        return "Curriculum{" +
                "idCurriculum=" + idCurriculum +
                ", identification=" + identification +
                ", academicFormationList=" + academicFormationList +
                ", professionalExperienceList=" + professionalExperienceList +
                '}';
    }
    //</editor-fold>
}