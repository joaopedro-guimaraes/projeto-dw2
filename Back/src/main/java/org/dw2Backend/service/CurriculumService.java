package org.dw2Backend.service;

import org.dw2Backend.entity.Curriculum;
import org.dw2Backend.mapper.CurriculumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumService {

    private CurriculumMapper curriculumMapper;

    @Autowired
    public CurriculumService(CurriculumMapper curriculumMapper){
        this.curriculumMapper = curriculumMapper;
    }

    public CurriculumService() {}

    public List<Curriculum> SearchAll() {
        return curriculumMapper.SearchAll();
    }

    public List<Curriculum> SearchById(int id) {
        return curriculumMapper.SearchById(id);
    }

    public boolean Save(Curriculum curriculum) {
        return curriculumMapper.Save(curriculum);
    }

    public boolean Update(Curriculum curriculum) {
        return curriculumMapper.Update(curriculum);
    }

    public boolean Delete(Curriculum curriculum) {
        return curriculumMapper.Delete(curriculum);
    }
}
