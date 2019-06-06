package org.dw2Backend.entity;

import javax.persistence.*;

@Entity
public class AcademicFormation {

    //<editor-fold desc="Anotation">
    ////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAcademicFormation;

    @ManyToOne
    @JoinColumn(name = "idCurriculum")
    private Curriculum curriculum;

    @Column
    private String institution;

    @Column
    private String course;

    @Column
    private String level;

    @Column
    private String situation;
    //</editor-fold>

    //<editor-fold desc="Builders">
    ////////////////////////////////
    public AcademicFormation(
                                String institution
                                , String course
                                , String level
                                , String situation
                                , Curriculum curriculum) {
        this.institution = institution;
        this.course = course;
        this.level = level;
        this.situation = situation;
        this.curriculum = curriculum;
    }

    public AcademicFormation() { }
    //</editor-fold>

    //<editor-fold desc="Properties">
    ////////////////////////////////
    public int getIdAcademicFormation() {
        return idAcademicFormation;
    }

    public void setIdAcademicFormation(int idAcademicFormation) {
        this.idAcademicFormation = idAcademicFormation;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
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
        return "AcademicFormation{" +
                "idAcademicFormation=" + idAcademicFormation +
                ", institution=" + institution +
                ", course='" + course + '\'' +
                ", level='" + level + '\'' +
                ", situation='" + situation + '\'' +
                ", curriculum='" + curriculum + '\'' +
                '}';
    }
    //</editor-fold>
}
