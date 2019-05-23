package org.dw2Backend.mapper;

import org.dw2Backend.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserMapper {

    @PersistenceContext
    private EntityManager manager;

    public UserMapper(){}

    public boolean Insert(User user) {
        try {
            manager.persist(user);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public List<User> FindAll() {
        List<User> users = null;

        try {
            Query query = manager.createQuery("select u from User u");
            users = query.getResultList();
            return users;
        } catch (Exception e){
            return users;
        }
    }

    public boolean Authenticate(User user) {
        String command = "select u from User u where u.email=?1 and u.password=?2";
        Query query = manager.createQuery(command);

        String email = user.getEmail();
        String password = user.getPassword();

        query.setParameter(1, email).setParameter(2, password);
        /* OU --> query.setParameter(1, email);
                  query.setParameter(2, password); */

        try {
            query.getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }
}




