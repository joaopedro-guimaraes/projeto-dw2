package org.dw2Backend.controller;

import org.dw2Backend.DTO.Curriculum.CurriculumStudentDTO;
import org.dw2Backend.entity.AcademicFormation;
import org.dw2Backend.entity.Curriculum;
import org.dw2Backend.service.CurriculumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CurriculumController {

    private CurriculumService curriculumService;

    @Autowired
    public CurriculumController(CurriculumService curriculumService){
        this.curriculumService = curriculumService;
    }

    public CurriculumController() {}

    @GetMapping(value = "/curriculo")
    public ResponseEntity<List<Curriculum>> SearchAll(){
        List<Curriculum> curriculumList = this.curriculumService.SearchAll();

        if(curriculumList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        for (Curriculum curriculum: curriculumList) {

            for (AcademicFormation academicFormation: curriculum.getAcademicFormationList()) {
                academicFormation.setCurriculum(null);
            }
        }

        return new ResponseEntity(curriculumList, HttpStatus.OK);
    }

    @GetMapping(value = "/curriculo/{id}")
    public ResponseEntity<List<Curriculum>> SearchById(@PathVariable int id){

        List<Curriculum> curriculumList = this.curriculumService.SearchById(id);

        if(curriculumList.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(curriculumList, HttpStatus.OK);
    }

    @PostMapping(value = "/curriculo")
    public ResponseEntity Register(@RequestBody CurriculumStudentDTO objDTO){
        Curriculum curriculumResponse = curriculumService.Save(objDTO);
        Curriculum curriculumResponseCopiado = new Curriculum();

        if(curriculumResponse != null){
            curriculumResponseCopiado = curriculumResponse;
            for (AcademicFormation academicFormation: curriculumResponseCopiado.getAcademicFormationList()) {
                academicFormation.setCurriculum(null);
            }

            return new ResponseEntity(curriculumResponse, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    /*public ResponseEntity<List<Company>> SearchAll(){
        List<Company> companyList = companyService.SearchAll();

        if(companyList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        for (Company company: companyList) {
            for (Internship internship: company.getInternshipList()) {
                internship.setCompany(null);
            }
        }

        return new ResponseEntity(companyList, HttpStatus.OK);
    }*/

    @Transactional
    @PutMapping(value = "/curriculo")
    public ResponseEntity Update(@RequestBody Curriculum curriculum){

        if(curriculumService.Update(curriculum)){
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @DeleteMapping(value = "/curriculo")
    public ResponseEntity Delete(@RequestBody CurriculumStudentDTO objDTO){

        if(curriculumService.Delete(objDTO)){
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
