package org.dw2Backend.mapper;

import org.dw2Backend.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserMapper {

    @PersistenceContext
    private EntityManager manager;

    public UserMapper(){}

    public List<User> SearchAll() {
        List<User> users = null;

        try {
            Query query = manager.createQuery("select u from User u");
            users = query.getResultList();
            return users;
        } catch (NoResultException e){
            return users;
        }
    }

    public List<User> SearchById(int id) {
        List<User> userList = null;
        User user = manager.find(User.class, id);

        try {
            userList = new ArrayList<User>();
            userList.add(user);
            return userList;
        } catch (NoResultException e) {
            return userList;
        }
    }

    public User Authenticate(User user) {
        String command = "select u from User u where u.email=?1 and u.password=?2";
        Query query = manager.createQuery(command);

        String email = user.getEmail();
        String password = user.getPassword();

        query.setParameter(1, email).setParameter(2, password);

        try {
            List<User> userList = query.getResultList();

            if(!userList.isEmpty()){
                User userResponse = userList.get(0);
                return userResponse;
            }

        } catch (Exception e) {
            return null;
        }

        return null;
    }

    public User Save(User user) {
        try {

            manager.persist(user);
            return user;
        } catch (Exception e){
            user = null;
            return user;
        }
    }

    public boolean Update(User user) {
        try {
            manager.merge(user);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean Delete(User user) {
        User userDelete = manager.find(User.class, user.getIdUser());

        try {
            if(userDelete != null){
                manager.remove(userDelete);
                return true;
            }

            return false;
        } catch (Exception e){
            return false;
        }
    }
}




