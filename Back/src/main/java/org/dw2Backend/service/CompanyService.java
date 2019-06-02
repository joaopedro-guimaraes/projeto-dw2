package org.dw2Backend.service;

import org.dw2Backend.entity.Company;
import org.dw2Backend.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private CompanyMapper companyMapper;

    @Autowired
    public CompanyService(CompanyMapper companyMapper){
        this.companyMapper = companyMapper;
    }

    public CompanyService() {}

    public List<Company> SearchAll() {
        return companyMapper.SearchAll();
    }

    public List<Company> SearchById(int id) {
        return companyMapper.SearchById(id);
    }

    public Company Save(Company company) {
        return companyMapper.Save(company);
    }

    public boolean Update(Company company) {
        return companyMapper.Update(company);
    }

    public boolean Delete(Company company) {
        return companyMapper.Delete(company);
    }
}
