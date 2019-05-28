package org.dw2Backend.entity;

import javax.persistence.*;

@Entity
public class Supervisor {

    //<editor-fold desc="Anotation">
    ////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSupervisor;

    @Column
    private String name;
    //</editor-fold>

    //<editor-fold desc="Builders">
    ////////////////////////////////
    public Supervisor(
                        int idSupervisor
                        , String name) {
        this.idSupervisor = idSupervisor;
        this.name = name;
    }

    public Supervisor() { }
    //</editor-fold>

    //<editor-fold desc="Properties">
    ////////////////////////////////
    public int getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //</editor-fold>

    //<editor-fold desc="Anotation">
    ////////////////////////////////
    @Override
    public String toString() {
        return "Supervisor{" +
                "idSupervisor=" + idSupervisor +
                ", name='" + name + '\'' +
                '}';
    }
    //</editor-fold>
}
