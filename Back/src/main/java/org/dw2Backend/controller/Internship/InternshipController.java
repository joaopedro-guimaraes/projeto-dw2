package org.dw2Backend.controller.Internship;

import org.dw2Backend.DTO.Internship.InternshipCompanyDTO;
import org.dw2Backend.entity.Company;
import org.dw2Backend.entity.Internship;
import org.dw2Backend.service.InternshipService;

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
public class InternshipController {

    private InternshipService internshipService;

    @Autowired
    public InternshipController(InternshipService internshipService){
        this.internshipService = internshipService;
    }

    public InternshipController() {}

    @GetMapping(value = "/estagio")
    public ResponseEntity<List<Internship>> SearchAll(){
        List<Internship> internshipList = internshipService.SearchAll();

        if(internshipList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        for (Internship internship: internshipList) {
            Company company = internship.getCompany();
            company.setInternshipList(null);
        }



        return new ResponseEntity(internshipList, HttpStatus.OK);
    }

    @GetMapping(value = "/estagio/{id}")
    public ResponseEntity<List<Internship>> SearchById(@PathVariable int id){

        List<Internship> internshipList = internshipService.SearchById(id);

        if(internshipList == null || internshipList.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        for (Internship internship: internshipList) {
            Company company = internship.getCompany();
            company.setInternshipList(null);
        }

        return new ResponseEntity(internshipList, HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "/estagio")
    public ResponseEntity Register(@RequestBody InternshipCompanyDTO objDTO){

        if(internshipService.Save(objDTO)){
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PutMapping(value = "/estagio")
    public ResponseEntity Update(@RequestBody Internship internship){

        if(internshipService.Update(internship)){
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @DeleteMapping(value = "/estagio")
    public ResponseEntity Delete(@RequestBody Internship internship){

        if(internshipService.Delete(internship)){
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
