package com.digitalclick.finalproject.service;

import com.digitalclick.finalproject.dto.UserDto;
import com.digitalclick.finalproject.mapper.UserMapper;
import com.digitalclick.finalproject.model.Role;
import com.digitalclick.finalproject.model.User;
import com.digitalclick.finalproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class UserService {
   @Autowired
    private final UserRepository repository;
   @Autowired
    private final UserMapper userMapper;

   EntityManager entityManager;

    public UserService(UserRepository repository, UserMapper userMapper, EntityManager entityManager) {
        this.repository = repository;
        this.userMapper = userMapper;
        this.entityManager = entityManager;
    }

    @Transactional
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }
    public List<User> fetchUserList()
    {
        return (List<User>)
                repository.findAll();
    }

    public UserDto save(UserDto userDto) {
        User entity = userMapper.toEntity(userDto);
        entity.setFirstName(userDto.getFirstName());
        entity.setLastName(userDto.getLastName());
        entity.setEmail(userDto.getEmail());
        entity.setAdress(userDto.getAdress());
        entity.setPassword(userDto.getPassword());
        entity.setPhone_number(userDto.getPhone_number());
        /*entity.setRole(userDto.getRole());*/


        return userMapper.toDto(repository.save(entity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public UserDto findById(Integer id) {

        User entity = repository.findById(id).orElse(null);
        UserDto userDto = userMapper.toDto(entity);
        userDto.setFirstName(entity.getFirstName());
        userDto.setLastName(entity.getLastName());
        userDto.setEmail(entity.getEmail());
        userDto.setAdress(entity.getAdress());
        userDto.setPassword(entity.getPassword());
        userDto.setPhone_number(entity.getPhone_number());
       // userDto.setRole(entity.getRole());


        return userDto;
    }

    public Page<UserDto> findByCondition(UserDto userDto, Pageable pageable) {
        Page<User> entityPage = repository.findAll(pageable);
        List<User> entities = entityPage.getContent();
        return new PageImpl<>(userMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public UserDto update(UserDto userDto, Integer id) {
        UserDto data = findById(id);
        User entity = userMapper.toEntity(userDto);

        return save(userMapper.toDto(entity));
    }


    public List<User> fetchUserListByRole(Integer role_id)
    {
        return (List<User>)
                repository.findAllByRole(role_id);
    }
    @Transactional
    public UserDto saveUserByRole(UserDto userDto, Integer role_id) {
        User entity = userMapper.toEntity(userDto);
        entity.setFirstName(userDto.getFirstName());
        entity.setLastName(userDto.getLastName());
        entity.setEmail(userDto.getEmail());
        entity.setAdress(userDto.getAdress());
        entity.setPassword(userDto.getPassword());
        entity.setPhone_number(userDto.getPhone_number());
        create(entity);
        Role role = new Role(role_id);
        entity.setRole(role);
        return userMapper.toDto(entity);

    }









    /*public List<UserDto> fetchUserListByRole(Integer role_id) {

        List<User> entities = repository.findByRoleId(role_id).orElse(null);
        List<UserDto> usersDto = new ArrayList<>();
        for (User entity:
            entities ) {

            UserDto userDto = userMapper.toDto(entity);
            userDto.setFirstName(entity.getFirstName());
            userDto.setLastName(entity.getLastName());
            userDto.setEmail(entity.getEmail());
            userDto.setAdress(entity.getAdress());
            userDto.setPassword(entity.getPassword());
            userDto.setPhone_number(entity.getPhone_number());
            userDto.setRole(entity.getRole());
            usersDto.add(userDto);
        }
       return usersDto;

    }*/
}