package org.dw2Backend.mapper;

import org.dw2Backend.entity.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyMapper {

    @PersistenceContext
    private EntityManager manager;

    public CompanyMapper(){}

    public List<Company> SearchAll() {
        List<Company> companyList = null;

        try {
            Query query = manager.createQuery("select c from Company c");
            companyList = query.getResultList();

            return companyList;
        } catch (NoResultException e){
            return companyList;
        }
    }

    public List<Company> SearchById(int id) {
        List<Company> companyList = null;
        Company company = manager.find(Company.class, id);

        try {
            if(company != null){
                companyList = new ArrayList<Company>();
                companyList.add(company);
            }

            return companyList;
        } catch (Exception e){
            return companyList;
        }
    }

    public boolean Save(Company company) {
        try {
            manager.persist(company);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean Update(Company company) {
        try {
            manager.merge(company);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean Delete(Company company) {
        Company companyDelete = manager.find(Company.class, company.getIdCompany());

        try {
            if(companyDelete != null){
                manager.remove(companyDelete);
                return true;
            }

            return false;
        } catch (Exception e){
            return false;
        }
    }
}
