package com.digitalclick.finalproject.repository;

import com.digitalclick.finalproject.model.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findAllByRole(Integer role_id);

    User saveUserByRole(User entity, Integer role_id);
    //User updateUserByRole(User entity, Integer role_id);
}
