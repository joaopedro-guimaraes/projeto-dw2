package org.dw2Backend.controller;

import org.dw2Backend.entity.Student;
import org.dw2Backend.service.StudentService;

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
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    public StudentController() {}

    @GetMapping(value = "/aluno")
    public ResponseEntity<List<Student>> SearchAll(){
        List<Student> studentList = studentService.SearchAll();

        if(studentList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        for (Student student: studentList) {
            student.setUserStudent(null);
        }

        return new ResponseEntity(studentList, HttpStatus.OK);
    }

    @GetMapping(value = "/aluno/{id}")
    public ResponseEntity<List<Student>> SearchById(@PathVariable int id){

        List<Student> studentList = studentService.SearchById(id);

        if(studentList == null || studentList.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        for (Student student: studentList) {
            student.setUserStudent(null);
        }

        return new ResponseEntity(studentList, HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "/aluno")
    public ResponseEntity Register(@RequestBody Student student){

        if((studentService.Save(student)) != null){
            return new ResponseEntity(student ,HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PutMapping(value = "/aluno")
    public ResponseEntity Update(@RequestBody Student student){

        if(studentService.Update(student)){
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @DeleteMapping(value = "/aluno")
    public ResponseEntity Delete(@RequestBody Student student){

        if(studentService.Delete(student)){
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
