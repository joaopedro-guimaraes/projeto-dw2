package org.dw2Backend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Institution {

    //<editor-fold desc="Anotation">
    ////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInstitution;

    @ManyToMany
    private List<Supervisor> supervisores = new ArrayList<Supervisor>();

    @Column
    private String name;
    //</editor-fold>

    //<editor-fold desc="Builders">
    ////////////////////////////////
    public Institution(
                        int idInstitution
                        , List<Supervisor> supervisores
                        , String name) {
        this.idInstitution = idInstitution;
        this.supervisores = supervisores;
        this.name = name;
    }

    public Institution() { }
    //</editor-fold>

    //<editor-fold desc="Properties">
    ////////////////////////////////
    public int getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(int idInstitution) {
        this.idInstitution = idInstitution;
    }

    public List<Supervisor> getSupervisores() {
        return supervisores;
    }

    public void setSupervisores(List<Supervisor> supervisores) {
        this.supervisores = supervisores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //</editor-fold>

    //<editor-fold desc="toStrings">
    ////////////////////////////////
    @Override
    public String toString() {
        return "Institution{" +
                "idInstitution=" + idInstitution +
                ", name='" + name + '\'' +
                '}';
    }
    //</editor-fold>
}
