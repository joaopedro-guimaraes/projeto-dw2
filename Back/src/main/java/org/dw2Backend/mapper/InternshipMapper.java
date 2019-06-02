package org.dw2Backend.mapper;

import org.dw2Backend.DTO.Internship.InternshipCompanyDTO;
import org.dw2Backend.entity.Company;
import org.dw2Backend.entity.Internship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InternshipMapper {

    @PersistenceContext
    private EntityManager manager;
    private CompanyMapper companyMapper;

    @Autowired
    public InternshipMapper(CompanyMapper companyMapper){
        this.companyMapper = companyMapper;
    }

    public InternshipMapper(){}

    public ArrayList<Internship> SearchAll() {
        List<Internship> internshipList = null;

        try {
            Query query = manager.createQuery("select c from Internship c");
            internshipList = query.getResultList();
            return (ArrayList<Internship>) internshipList;
        } catch (NoResultException e){
            return (ArrayList<Internship>) internshipList;
        }
    }

    public List<Internship> SearchById(int id) {
        List<Internship> internshipList = null;
        Internship user = manager.find(Internship.class, id);

        try {
            if(user != null){
                internshipList = new ArrayList<Internship>();
                internshipList.add(user);
            }

            return internshipList;
        } catch (NoResultException e) {
            return internshipList;
        }
    }

    public boolean Save(InternshipCompanyDTO objDTO) {
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
    }

    public boolean Update(Internship internship) {
        try {
            manager.merge(internship);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean Delete(Internship internship) {
        Internship internshipDelete = manager.find(Internship.class, internship.getIdInternship());

        try {
            if(internshipDelete != null){
                manager.remove(internshipDelete);
                return true;
            }

            return false;
        } catch (Exception e){
            return false;
        }
    }
}
