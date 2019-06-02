package org.dw2Backend.DTO.Internship;

import org.dw2Backend.entity.Internship;
import org.springframework.stereotype.Component;

@Component
public class InternshipCompanyDTO {

    private int idCompany;

    private Internship internship;

    public InternshipCompanyDTO() { }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }
}
