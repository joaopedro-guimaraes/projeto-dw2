package org.dw2Backend.controller.Curriculum;

import org.dw2Backend.entity.Curriculum;
import org.dw2Backend.entity.User;

import org.dw2Backend.service.CurriculumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CurriculumController {

    private CurriculumService curriculumService;

    @Autowired
    public CurriculumController(CurriculumService curriculumService){
        this.curriculumService = curriculumService;
    }

    public CurriculumController(){}

    @GetMapping(value = "/curriculum")
    public ResponseEntity<List<Curriculum>> SearchAll(){

        List<Curriculum> curriculumList = this.curriculumService.SearchAll();

        if(curriculumList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(curriculumList, HttpStatus.OK);
    }

    @GetMapping(value = "/curriculum/{id}")
    public ResponseEntity<List<Curriculum>> SearchById(@PathVariable int id){

        List<Curriculum> curriculumList = this.curriculumService.SearchById(id);

        if(curriculumList.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(curriculumList, HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "/usuario")
    public ResponseEntity Register(@RequestBody Curriculum curriculum, HttpSession session){

        if(curriculumService.Save(curriculum)){
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PutMapping(value = "/curriculum")
    public ResponseEntity Update(@RequestBody Curriculum curriculum, HttpSession session){

        if(curriculumService.Update(curriculum)){
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @DeleteMapping(value = "/curriculum")
    public ResponseEntity Delete(@RequestBody Curriculum curriculum){

        if(curriculumService.Delete(curriculum)){

            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
