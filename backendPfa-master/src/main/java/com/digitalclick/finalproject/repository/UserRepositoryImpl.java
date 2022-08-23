package com.digitalclick.finalproject.repository;

import com.digitalclick.finalproject.model.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<User> findAllByRole(Integer role_id) {
        Query query = (Query) entityManager.createNativeQuery("SELECT u.* FROM users as u where u.role_id = ?",User.class);
        query.setParameter(1,role_id);
        return query.getResultList();
    }

@Override
    public User saveUserByRole(User entity, Integer role_id) {
        Query query = (Query) entityManager.createNativeQuery("INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?)");
        query.setParameter(1,entity.getId());
        query.setParameter(2, entity.getAdress());
        query.setParameter(3, entity.getEmail());
        query.setParameter(4, entity.getFirstName());
        query.setParameter(5, entity.getLastName());
        query.setParameter(6, entity.getPassword());
        query.setParameter(7, entity.getPhone_number());
        query.setParameter(8, role_id);
        query.executeUpdate();
    return entity;
}











}
