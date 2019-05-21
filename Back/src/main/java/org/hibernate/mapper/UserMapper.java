package org.hibernate.mapper;

import org.hibernate.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserMapper {

    public UserMapper(){}

    /*protected EntityManagerFactory factory = null;
    protected EntityManager manager = null;

    private void ManagerFactory(){
        if (!this.factory.isOpen() && !this.manager.isOpen()){
            factory = Persistence.createEntityManagerFactory("jpapu");
            manager = factory.createEntityManager();
        }
    }

    public void Insert(User user) {
        this.ManagerFactory();

        try {
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
        } catch (Exception e){
            manager.getTransaction().rollback();
        }   finally {
            manager.close();
            factory.close();
        }
    }*/

    public void Insert(User user) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpapu");
        EntityManager manager = factory.createEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
        } catch (Exception e){
            manager.getTransaction().rollback();
        }   finally {
            manager.close();
            factory.close();
        }
    }

    public List<User> List() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpapu");
        EntityManager manager = factory.createEntityManager();
        List<User> users = null;

        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select u from User u");
            users = query.getResultList();
            manager.getTransaction().commit();
            return users;
        } catch (Exception e){
            manager.getTransaction().rollback();
            return null;
        }   finally {
            manager.close();
            factory.close();
        }
    }
}




