package org.dw2Backend.service;

import org.dw2Backend.entity.Student;
import org.dw2Backend.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentMapper studentMapper){
        this.studentMapper = studentMapper;
    }

    public StudentService() {}

    public List<Student> SearchAll() {
        return studentMapper.SearchAll();
    }

    public List<Student> SearchById(int id) {
        return studentMapper.SearchById(id);
    }

    public Student Save(Student student) {
        return studentMapper.Save(student);
    }

    public boolean Update(Student student) {
        return studentMapper.Update(student);
    }

    public boolean Delete(Student student) {
        return studentMapper.Delete(student);
    }
}
