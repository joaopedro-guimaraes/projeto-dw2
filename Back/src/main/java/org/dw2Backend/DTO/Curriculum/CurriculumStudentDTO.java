package org.dw2Backend.DTO.Curriculum;

import org.dw2Backend.entity.Curriculum;
import org.springframework.stereotype.Component;

@Component
public class CurriculumStudentDTO {

    private int idStudent;
    private Curriculum curriculum;

    public CurriculumStudentDTO() {
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }
}
