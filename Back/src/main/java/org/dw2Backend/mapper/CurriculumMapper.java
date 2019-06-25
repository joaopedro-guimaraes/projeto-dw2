package org.dw2Backend.mapper;

import org.dw2Backend.DTO.Curriculum.CurriculumStudentDTO;
import org.dw2Backend.entity.AcademicFormation;
import org.dw2Backend.entity.Company;
import org.dw2Backend.entity.Curriculum;
import org.dw2Backend.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CurriculumMapper {

    @PersistenceContext
    private EntityManager manager;
    private StudentMapper studentMapper;

    public CurriculumMapper(){}

    @Autowired
    public CurriculumMapper(StudentMapper studentMapper){
        this.studentMapper = studentMapper;
    }

    public List<Curriculum> SearchAll() {
        List<Curriculum> curriculumList = null;

        try {
            Query query = manager.createQuery("select c from Curriculum c");
            curriculumList = query.getResultList();

            return curriculumList;
        } catch (NoResultException e){
            return curriculumList;
        }
    }

    public List<Curriculum> SearchById(int id) {
        List<Curriculum> curriculumList = null;
        Curriculum curriculum = manager.find(Curriculum.class, id);

        try {

            if(curriculum != null){
                curriculumList = new ArrayList<Curriculum>();
                curriculumList.add(curriculum);
            }

            for (Curriculum curr: curriculumList) {
                for (AcademicFormation academicFormation: curr.getAcademicFormationList()) {
                    academicFormation.setCurriculum(null);
                }
            }

            return curriculumList;
        } catch (Exception e){
            return curriculumList;
        }
    }

    public Curriculum Save(CurriculumStudentDTO objDTO) {
        Curriculum curriculum = objDTO.getCurriculum();
        Curriculum curriculumResponse = null;

        try {
            List<Student> studentList = studentMapper.SearchById(objDTO.getIdStudent());
            List<AcademicFormation> academicFormationList = objDTO.getCurriculum().getAcademicFormationList();

            if(!studentList.isEmpty()){

                if(academicFormationList != null && !academicFormationList.isEmpty()){

                    for (AcademicFormation academicFormation: academicFormationList) {
                        academicFormation.setCurriculum(curriculum);
                    }

                    curriculum.setAcademicFormationList(academicFormationList);
                }

                Student student = studentList.get(0);
                student.setCurriculum(curriculum);
                studentMapper.Update(student);

                curriculumResponse = manager.find(Curriculum.class, student.getCurriculum().getIdCurriculum());

                return curriculumResponse;
            }

        } catch (Exception e){
            return null;
        }

        return null;
    }

    public boolean Update(Curriculum curriculum) {
        try {
            manager.merge(curriculum);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean Delete(CurriculumStudentDTO objDTO) {

        try {
            Curriculum curriculum = manager.find(Curriculum.class, objDTO.getCurriculum().getIdCurriculum());
            List<Student> studentList = studentMapper.SearchById(objDTO.getIdStudent());

            if(!studentList.isEmpty()){
                Student student = studentList.get(0);
                student.setCurriculum(null);
                studentMapper.Update(student);
                manager.remove(curriculum);
                return true;
            }

        } catch (Exception e){
            return false;
        }

        return false;
    }
}
