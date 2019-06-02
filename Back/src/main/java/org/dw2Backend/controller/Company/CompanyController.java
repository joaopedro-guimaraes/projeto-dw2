package org.dw2Backend.controller.Company;

import org.dw2Backend.entity.Company;
import org.dw2Backend.entity.Internship;
import org.dw2Backend.service.CompanyService;

import org.dw2Backend.service.InternshipService;
import org.dw2Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RestController
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CompanyController {

    private CompanyService companyService;
    private UserService userService;
    private InternshipService internshipService;

    @Autowired
    public CompanyController(CompanyService companyService, UserService userService, InternshipService internshipService){
        this.companyService = companyService;
        this.userService = userService;
        this.internshipService = internshipService;
    }

    public CompanyController() {}

    @GetMapping(value = "/empresa")
    public ResponseEntity<List<Company>> SearchAll(){
        List<Company> companyList = companyService.SearchAll();

        if(companyList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        for (Company company: companyList) {
            company.setUserCompany(null);

            for (Internship internship: company.getInternshipList()) {
                internship.setCompany(null);
            }
        }

        return new ResponseEntity(companyList, HttpStatus.OK);
    }

    @GetMapping(value = "/empresa/{id}")
    public ResponseEntity<List<Company>> SearchById(@PathVariable int id){

        List<Company> companyList = companyService.SearchById(id);

        if(companyList == null || companyList.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        for (Company company: companyList) {
            company.setUserCompany(null);

            for (Internship internship: company.getInternshipList()) {
                internship.setCompany(null);
            }
        }

        return new ResponseEntity(companyList, HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "/empresa")
    public ResponseEntity Register(@RequestBody Company company){

        if((companyService.Save(company)) != null){
            return new ResponseEntity(company ,HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PutMapping(value = "/empresa")
    public ResponseEntity Update(@RequestBody Company company){

        if(companyService.Update(company)){
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @DeleteMapping(value = "/empresa")
    public ResponseEntity Delete(@RequestBody Company company){

        if(companyService.Delete(company)){
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
