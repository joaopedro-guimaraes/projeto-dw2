package org.dw2Backend.service;

import org.dw2Backend.DTO.Internship.InternshipCompanyDTO;
import org.dw2Backend.entity.Internship;
import org.dw2Backend.mapper.InternshipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InternshipService {

    private InternshipMapper internshipMapper;

    @Autowired
    public InternshipService(InternshipMapper internshipMapper){
        this.internshipMapper = internshipMapper;
    }

    public InternshipService() {}

    public ArrayList<Internship> SearchAll() {
        return internshipMapper.SearchAll();
    }

    public List<Internship> SearchById(int id) {
        return internshipMapper.SearchById(id);
    }

    public boolean Save(InternshipCompanyDTO objDTO) {

        return internshipMapper.Save(objDTO);
    }

    public boolean Update(Internship internship) {
        return internshipMapper.Update(internship);
    }

    public boolean Delete(Internship internship) {
        return internshipMapper.Delete(internship);
    }
}
