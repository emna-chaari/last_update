package com.digitalclick.finalproject.controller;

import com.digitalclick.finalproject.dto.UserDto;
import com.digitalclick.finalproject.model.User;
import com.digitalclick.finalproject.repository.UserRepository;
import com.digitalclick.finalproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class UserController {
    private final UserService userService;
    private final UserRepository repo;

    public UserController(UserService userService, UserRepository repo) {
        this.userService = userService;
        this.repo = repo;
    }
    @GetMapping("/users")
    public List<User> fetchUserList()
    {
        return userService.fetchUserList();
    }
    @GetMapping("users/{role_id}")
    public List<User> fetchUserListByRole(@PathVariable("role_id") Integer role_id) {
        return userService.fetchUserListByRole(role_id);
    }
    @PostMapping({"users/{role_id}/add-new"})
    public ResponseEntity<Void> saveUserByRole(@RequestBody @Validated UserDto userDto, @PathVariable("role_id") Integer role_id) {
        userService.saveUserByRole(userDto, role_id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Integer id) {
        UserDto user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        UserDto userDto =Optional.ofNullable(userService.findById(id)).orElse( null);
        if (userDto==null){ return ResponseEntity.notFound().build();}
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<UserDto>> pageQuery(UserDto userDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<UserDto> userPage = userService.findByCondition(userDto, pageable);
        return ResponseEntity.ok(userPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated UserDto userDto, @PathVariable("id") Integer id) {
        userService.update(userDto, id);
        return ResponseEntity.ok().build();
    }

/*
    @PutMapping("/{role_id}/{id}")
    public ResponseEntity<Void> updateByRoleId( @PathVariable ("role_id") Integer role_id, @PathVariable("id") Integer id) {
        repo.updateByRoleId(role_id, id);
        return ResponseEntity.ok().build();
    }

*/
}