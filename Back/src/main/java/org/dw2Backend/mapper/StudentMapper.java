package org.dw2Backend.mapper;

import org.dw2Backend.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentMapper {

    @PersistenceContext
    private EntityManager manager;

    public StudentMapper(){}

    public List<Student> SearchAll() {
        List<Student> studentList = null;

        try {
            Query query = manager.createQuery("select s from Student s");
            studentList = query.getResultList();

            return studentList;
        } catch (NoResultException e){
            return studentList;
        }
    }

    public List<Student> SearchById(int id) {
        List<Student> studentList = null;
        Student student = manager.find(Student.class, id);

        try {
            if(student != null){
                studentList = new ArrayList<Student>();
                studentList.add(student);
            }

            return studentList;
        } catch (Exception e){
            return studentList;
        }
    }

    public Student Save(Student student) {
        try {
            manager.persist(student);
            return student;
        } catch (Exception e){
            student = null;
            return student;
        }
    }

    public boolean Update(Student company) {
        try {
            manager.merge(company);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean Delete(Student student) {
        Student studentDelete = manager.find(Student.class, student.getIdStudent());

        try {
            if(studentDelete != null){
                manager.remove(studentDelete);
                return true;
            }

            return false;
        } catch (Exception e){
            return false;
        }
    }
}
