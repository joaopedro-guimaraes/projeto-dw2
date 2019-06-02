package org.dw2Backend.mapper;

import org.dw2Backend.entity.Curriculum;
import org.dw2Backend.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CurriculumMapper {

    @PersistenceContext
    private EntityManager manager;

    public CurriculumMapper(){}

    public List<Curriculum> SearchAll() {
        List<Curriculum> curriculum = null;

        try {
            Query query = manager.createQuery("select u from Curriculum u");
            curriculum = query.getResultList();
            return curriculum;
        } catch (NoResultException e){
            return curriculum;
        }
    }

    public List<Curriculum> SearchById(int id) {
        List<Curriculum> curriculum = null;

        String command = "select c from Curriculum c where c.idCurriculum=?1";
        Query query = manager.createQuery(command);

        query.setParameter(1, id);

        try {
            curriculum = query.getResultList();
            return curriculum;
        } catch (NoResultException e) {
            return curriculum;
        }
    }

    public boolean Save(Curriculum curriculum) {
        try {
            manager.persist(curriculum);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean Update(Curriculum curriculum) {
        try {
            manager.merge(curriculum);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean Delete(Curriculum curriculum) {
        try {
            manager.remove(curriculum);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
