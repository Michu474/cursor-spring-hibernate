package com.example.cursorspringhibernate.repository;

import com.example.cursorspringhibernate.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class QueryRepository extends RepositoryBase {

    @Transactional
    public void createUser(User user){
        manager.persist(user);
    }

    @Transactional
    public List<User> getAllUsers(){
        Query selectAll = manager.createQuery("select u from User u");
        System.out.println(selectAll.getResultList().toString());
        return selectAll.getResultList();
    }
    @Transactional
    public User getUsersById(Long id){
        System.out.println(manager.find(User.class,id).toString());
        return manager.find(User.class,id);
    }

    @Transactional
    public List<User> getUsersByFirstName(String firstName){
        Query selectByFirst =manager.createQuery("select u from User u where u.firstName=:firstName");
        selectByFirst.setParameter("firstName",firstName);
        System.out.println(selectByFirst.getResultList().toString());
        return selectByFirst.getResultList();
    }
    @Transactional
    public List<User> getUsersByLastName(String lastName){
        Query selectByLast =manager.createQuery("select u from User u where u.lastName=:lastName");
        selectByLast.setParameter("lastName",lastName);
        System.out.println(selectByLast.getResultList().toString());
        return selectByLast.getResultList();
    }
    @Transactional
    public List<User> getUsersByAge(int age){
        Query selectByAge =manager.createQuery("select u from User u where u.age=:age");
        selectByAge.setParameter("age",age);
        System.out.println(selectByAge.getResultList().toString());
        return selectByAge.getResultList();
    }

    @Transactional
    public void  updateUser(User user){
        manager.merge(user);
    }

}
