package org.dw2Backend.mapper;

import org.dw2Backend.DTO.Curriculum.CurriculumStudentDTO;
import org.dw2Backend.entity.Curriculum;
import org.dw2Backend.entity.Student;
import org.dw2Backend.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CurriculumMapper {

    @PersistenceContext
    private EntityManager manager;
    private StudentMapper studentMapper;

    public CurriculumMapper(){}

    public List<Curriculum> SearchAll() {
        List<Curriculum> curriculum = null;

        try {
            Query query = manager.createQuery("select u from Curriculum u");
            curriculum = query.getResultList();
            return curriculum;
        } catch (NoResultException e){
            return curriculum;
        }
    }

    public List<Curriculum> SearchById(int id) {
        List<Curriculum> curriculum = null;

        String command = "select c from Curriculum c where c.idCurriculum=?1";
        Query query = manager.createQuery(command);

        query.setParameter(1, id);

        try {
            curriculum = query.getResultList();
            return curriculum;
        } catch (NoResultException e) {
            return curriculum;
        }
    }

    public boolean Save(CurriculumStudentDTO objDTO) {
        int idStudent = objDTO.getIdStudent();
        Curriculum curriculum = objDTO.getCurriculum();

        try {
            List<Student> studentList = studentMapper.SearchById(idStudent);
            Student student = studentList.get(0);

            if(!studentList.isEmpty()){
                student.setCurriculum(curriculum);
                manager.persist(curriculum);
                return true;
            }

        } catch (Exception e){
            return false;
        }

        return false;
    }

    /*public boolean Save(InternshipCompanyDTO objDTO) {
        int idCompany = objDTO.getIdCompany();
        Internship internship = new Internship();

        internship.setDescription(objDTO.getInternship().getDescription());
        internship.setDesirableRequirements(objDTO.getInternship().getDesirableRequirements());
        internship.setRequiredRequirements(objDTO.getInternship().getRequiredRequirements());

        try {
            List<Company> companyList = companyMapper.SearchById(idCompany);
            Company company = companyList.get(0);

            if(!companyList.isEmpty()){
                internship.setCompany(company);
                company.getInternshipList().add(internship);
                companyMapper.Update(company);
                return true;
            }
        } catch (Exception e){
            return false;
        }

        return false;
    }*/

    public boolean Update(Curriculum curriculum) {
        try {
            manager.merge(curriculum);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean Delete(Curriculum curriculum) {
        try {
            manager.remove(curriculum);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
